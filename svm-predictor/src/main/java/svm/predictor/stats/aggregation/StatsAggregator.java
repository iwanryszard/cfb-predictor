package svm.predictor.stats.aggregation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;
import svm.predictor.service.AggregatedGameStatsService;
import svm.predictor.service.GameInfoService;
import svm.predictor.utils.SeasonBoundariesProvider;

@Service("statsAggregator")
public class StatsAggregator {

	private static Logger logger = LoggerFactory.getLogger(StatsAggregator.class);
	
	@Autowired
	private GameInfoService gameInfoService;
	
	@Autowired
	private AggregatedGameStatsService aggregatedGameStatsService;
	
	@Autowired
	private SeasonBoundariesProvider seasonBoundariesProvider;
	
	public void aggregateGamesForSeasons(int startSeason, int endSeason, League league) {
		for(int season = startSeason; season <= endSeason; ++season) {
			aggregateGamesForSeason(season, league);
		}
	}
	
	private void aggregateGamesForSeason(int season, League league) {
		logger.info("Starting aggregation for season: {}", season);
		
		Date seasonStart = seasonBoundariesProvider.getSeasonStartDate(season);
		Date seasonEnd = seasonBoundariesProvider.getSeasonEndDate(season);
		
		Date lastSeasonStart = seasonBoundariesProvider.getSeasonStartDate(season - 1);
		Date lastSeasonEnd = seasonBoundariesProvider.getSeasonEndDate(season - 1);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("homeTeamId:<>", -1);
		params.put("awayTeamId:<>", -1);
		params.put("pointSpread:IS NOT", null);
		params.put("gameDate:>", seasonStart);
		params.put("gameDate:<", seasonEnd);
		params.put("league", league);
		
		List<GameInfoDto> seasonGames = gameInfoService.list(params, null);
		logger.info("Fetched {} games", seasonGames.size());
		
		List<AggregatedGameStatsDto> aggregatedStats = new ArrayList<AggregatedGameStatsDto>(seasonGames.size());
		for(GameInfoDto game : seasonGames) {
			logger.info("Aggregating gameId: {}", game.getId());
			AggregatedGameStatsDto currentGameStats = new AggregatedGameStatsDto(); 
			currentGameStats.setGame(game);
			
			TeamAggregatedGameStatsDto homeStats = gameInfoService
					.getTeamAggregatedStats(game.getHomeTeamId(), seasonStart,
							game.getGameDate());
			currentGameStats.setHomeTeamStats(homeStats);
			
			TeamSimpleAggregatedStats homeLast5Games = gameInfoService
					.getPreviousNGamesStats(game.getHomeTeamId(), 5,
							game.getGameDate());
			currentGameStats.setHomeTeamLastFive(homeLast5Games);
			
			TeamSimpleAggregatedStats homeLastSeason = gameInfoService
					.getSimpleSeasonStats(game.getHomeTeamId(), lastSeasonStart,
							lastSeasonEnd);
			currentGameStats.setHomeTeamLastSeason(homeLastSeason);
			
			//away
			TeamAggregatedGameStatsDto awayStats = gameInfoService
					.getTeamAggregatedStats(game.getAwayTeamId(), seasonStart,
							game.getGameDate());
			currentGameStats.setAwayTeamStats(awayStats);
			
			TeamSimpleAggregatedStats awayLast5Games = gameInfoService
					.getPreviousNGamesStats(game.getAwayTeamId(), 5,
							game.getGameDate());
			currentGameStats.setAwayTeamLastFive(awayLast5Games);
			
			TeamSimpleAggregatedStats awayLastSeason = gameInfoService
					.getSimpleSeasonStats(game.getAwayTeamId(), lastSeasonStart,
							lastSeasonEnd);
			currentGameStats.setAwayTeamLastSeason(awayLastSeason);
			
			aggregatedStats.add(currentGameStats);
		}
		
		aggregatedGameStatsService.createAggregations(aggregatedStats);
		logger.info("Persisted aggregations for season: {}", season);
	}
}
