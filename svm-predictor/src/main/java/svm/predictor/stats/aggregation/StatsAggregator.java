package svm.predictor.stats.aggregation;

import java.util.ArrayList;
import java.util.Calendar;
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
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;
import svm.predictor.service.AggregatedGameStatsService;
import svm.predictor.service.GameInfoService;

@Service("statsAggregator")
public class StatsAggregator {

	private static Logger logger = LoggerFactory.getLogger(StatsAggregator.class);
	
	private static Calendar calendar = Calendar.getInstance();
	
	@Autowired
	private GameInfoService gameInfoService;
	
	@Autowired
	private AggregatedGameStatsService aggregatedGameStatsService;
	
	public void aggregateGamesForSeasons(int startSeason, int endSeason) {
		for(int season = startSeason; season <= endSeason; ++season) {
			aggregateGamesForSeason(season);
		}
	}
	
	private void aggregateGamesForSeason(int season) {
		logger.info("Starting aggregation for season: {}", season);
		
		Date seasonStart = getSeasonStartDate(season);
		Date seasonEnd = getSeasonEndDate(season);
		
		Date lastSeasonStart = getSeasonStartDate(season - 1);
		Date lastSeasonEnd = getSeasonEndDate(season - 1);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("homeTeamId:<>", -1);
		params.put("awayTeamId:<>", -1);
		params.put("pointSpread:IS NOT", null);
		params.put("gameDate:>", seasonStart);
		params.put("gameDate:<", seasonEnd);
		
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
	
	private Date getSeasonStartDate(int season) {
		calendar.set(season, Calendar.AUGUST, 15);
		Date seasonStart = calendar.getTime();
		return seasonStart;
	}
	
	private Date getSeasonEndDate(int season) {
		calendar.set(season + 1, Calendar.JANUARY, 20);
		Date seasonEnd = calendar.getTime();
		return seasonEnd;
	}
}
