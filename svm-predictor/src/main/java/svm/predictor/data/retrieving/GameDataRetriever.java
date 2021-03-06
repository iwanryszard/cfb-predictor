package svm.predictor.data.retrieving;

import java.math.BigInteger;
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
import svm.predictor.service.AggregatedGameStatsService;
import svm.predictor.service.TeamService;
import svm.predictor.utils.SeasonBoundariesProvider;

@Service("svmDataRetriever")
public class GameDataRetriever {

	private static Logger logger = LoggerFactory.getLogger(GameDataRetriever.class);
	
	@Autowired
	private AggregatedGameStatsService aggregatedGameStatsService;
	
	@Autowired
	private SeasonBoundariesProvider seasonBoundariesProvider;
	
	@Autowired
	private TeamService teamService;
	
	public GameDataDto getGameData(int startSeason, int endSeason, Integer minimumGamesPlayed, BaseDataRetriever dataRetriever) {
		Date seasonStart = seasonBoundariesProvider.getSeasonStartDate(startSeason);
		Date seasonEnd = seasonBoundariesProvider.getSeasonEndDate(endSeason);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("game.gameDate:>", seasonStart);
		params.put("game.gameDate:<", seasonEnd);
		params.put("game.league", dataRetriever.getLeague());
		if(minimumGamesPlayed != null) {
			params.put("homeGamesPlayed:>=", BigInteger.valueOf(minimumGamesPlayed));
			params.put("awayGamesPlayed:>=", BigInteger.valueOf(minimumGamesPlayed));
		}
		params.putAll(dataRetriever.getSpecificParams());
		List<AggregatedGameStatsDto> aggregatedGames = aggregatedGameStatsService.list(params, null);
		logger.info("Fetched {} game aggregations from {} to {}", aggregatedGames.size(), startSeason, endSeason);
		
		Map<Integer, String> teamNames = teamService.getTeamNamesMap(dataRetriever.getLeague());
		
		List<Double> labels = new ArrayList<Double>(aggregatedGames.size());
		List<Instance> instances = new ArrayList<Instance>(aggregatedGames.size());
		List<GameOddsDto> gamesOdds = new ArrayList<GameOddsDto>();
		List<String> attributeNames = dataRetriever.getAttributeNames();
		for(AggregatedGameStatsDto aggregatedGame : aggregatedGames) {
			GameInfoDto currentGame = aggregatedGame.getGame();
			Double currentLabel = dataRetriever.getLabel(currentGame);
			labels.add(currentLabel);
			
			Instance instance = dataRetriever.getInstance(aggregatedGame);
			instances.add(instance);
			
			GameOddsDto odds = dataRetriever.addGameOdds(currentGame, gamesOdds);
			String homeTeam = teamNames.get(currentGame.getHomeTeamId());
			odds.setHomeTeam(homeTeam);
			String awayTeam = teamNames.get(currentGame.getAwayTeamId());
			odds.setAwayTeam(awayTeam);
			odds.setHomeTeamPoints(currentGame.getHomeTeamPoints());
			odds.setAwayTeamPoints(currentGame.getAwayTeamPoints());
			odds.setPointSpread(currentGame.getPointSpread());
			odds.setPointTotal(currentGame.getPointTotal());
		}
		
		logger.info("Labels size: {}", labels.size());
		logger.info("Attributes per instance: {}", instances.get(0).getAttributes().size());
		
		GameDataDto result = new GameDataDto();
		result.setLabels(labels);
		result.setInstances(instances);
		result.setGamesOdds(gamesOdds);
		result.setAttributeNames(attributeNames);
		
		return result;
	}
}
