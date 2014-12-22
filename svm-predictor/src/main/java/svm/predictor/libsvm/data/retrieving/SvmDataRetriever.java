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
		calendar.set(season + 1, Calendar.JANUARY, 20);
		Date seasonEnd = calendar.getTime();
		return seasonEnd;
	}
	
	public SvmDataDto getGamesAsSvmData(int startSeason, int endSeason, Integer minimumGamesPlayed, BaseDataRetriever dataRetriever) {
		Date seasonStart = getSeasonStartDate(startSeason);
		Date seasonEnd = getSeasonEndDate(endSeason);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("game.gameDate:>", seasonStart);
		params.put("game.gameDate:<", seasonEnd);
		if(minimumGamesPlayed != null) {
			params.put("homeGamesPlayed:>=", BigInteger.valueOf(minimumGamesPlayed));
			params.put("awayGamesPlayed:>=", BigInteger.valueOf(minimumGamesPlayed));
		}
		params.putAll(dataRetriever.getSpecificParams());
		List<AggregatedGameStatsDto> aggregatedGames = aggregatedGameStatsService.list(params, null);
		logger.info("Fetched {} game aggregations from {} to {}", aggregatedGames.size(), startSeason, endSeason);
		
		List<Integer> labels = new ArrayList<Integer>(aggregatedGames.size());
		List<List<Number>> features = new ArrayList<List<Number>>(aggregatedGames.size());
		for(AggregatedGameStatsDto aggregatedGame : aggregatedGames) {
			GameInfoDto currentGame = aggregatedGame.getGame();
			Integer currentLabel = dataRetriever.getLabel(currentGame);
			labels.add(currentLabel);
			
			List<Number> currentFeatures = new ArrayList<Number>();
			currentFeatures.add(currentGame.getDistanceBetweenTeamsKm());
			currentFeatures.add(currentGame.getPointSpread());
			dataRetriever.addSpecificFeatures(aggregatedGame, currentFeatures);
			
			dataRetriever.addTeamAggregatedStats(aggregatedGame.getHomeTeamStats(), currentFeatures);
			dataRetriever.addSimpleStats(aggregatedGame.getHomeTeamLastFive(), currentFeatures);
			dataRetriever.addSimpleStats(aggregatedGame.getHomeTeamLastSeason(), currentFeatures);
			
			dataRetriever.addTeamAggregatedStats(aggregatedGame.getAwayTeamStats(), currentFeatures);
			dataRetriever.addSimpleStats(aggregatedGame.getAwayTeamLastFive(), currentFeatures);
			dataRetriever.addSimpleStats(aggregatedGame.getAwayTeamLastSeason(), currentFeatures);
			
			convertNullsToZeros(currentFeatures);
			features.add(currentFeatures);
		}
		
		logger.info("Labels size: {}", labels.size());
		logger.info("Feature row size: {}", features.get(0).size());
		
		SvmDataDto result = new SvmDataDto();
		result.setLabels(labels);
		result.setFeatures(features);
		
		return result;
	}
	
	private void convertNullsToZeros(List<Number> features) {
		for(int i = 0; i < features.size(); ++i) {
			if(features.get(i) == null) {
				features.set(i, 0);
			}
		}
	}
}
