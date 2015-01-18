package svm.predictor.libsvm.data.retrieving;

import java.math.BigInteger;
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
import svm.predictor.service.AggregatedGameStatsService;
import svm.predictor.weka.dto.Instance;

@Service("svmDataRetriever")
public class SvmDataRetriever {

	private static Logger logger = LoggerFactory.getLogger(SvmDataRetriever.class);
	
	@Autowired
	private AggregatedGameStatsService aggregatedGameStatsService;
	
	private static Calendar calendar = Calendar.getInstance();
	
	private Date getSeasonStartDate(int season) {
		calendar.set(season, Calendar.AUGUST, 15);
		Date seasonStart = calendar.getTime();
		return seasonStart;
	}
	
	private Date getSeasonEndDate(int season) {
		calendar.set(season + 1, Calendar.FEBRUARY, 20);
		Date seasonEnd = calendar.getTime();
		return seasonEnd;
	}
	
	public SvmDataDto getGamesAsSvmData(int startSeason, int endSeason, Integer minimumGamesPlayed, BaseDataRetriever dataRetriever) {
		Date seasonStart = getSeasonStartDate(startSeason);
		Date seasonEnd = getSeasonEndDate(endSeason);
		
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
		
		List<Double> labels = new ArrayList<Double>(aggregatedGames.size());
		List<Instance> instances = new ArrayList<Instance>(aggregatedGames.size());
		List<GameOddsDto> gamesOdds = new ArrayList<GameOddsDto>();
		List<String> attributeNames = dataRetriever.getAttributeNames();
		for(AggregatedGameStatsDto aggregatedGame : aggregatedGames) {
			GameInfoDto currentGame = aggregatedGame.getGame();
			Integer currentLabel = dataRetriever.getLabel(currentGame);
			labels.add(currentLabel.doubleValue());
			
			Instance instance = dataRetriever.getInstance(aggregatedGame);
			instances.add(instance);
			
			dataRetriever.addGameOdds(currentGame, gamesOdds);
		}
		
		logger.info("Labels size: {}", labels.size());
		logger.info("Attributes per instance: {}", instances.get(0).getAttributes().size());
		
		SvmDataDto result = new SvmDataDto();
		result.setLabels(labels);
		result.setInstances(instances);
		result.setGamesOdds(gamesOdds);
		result.setAttributeNames(attributeNames);
		
		return result;
	}
}
