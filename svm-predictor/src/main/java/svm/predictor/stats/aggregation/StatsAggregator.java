package svm.predictor.stats.aggregation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
	
	public void createSVMFile(int startSeason, int endSeason, String fileName) {
		Date seasonStart = getSeasonStartDate(startSeason);
		Date seasonEnd = getSeasonEndDate(endSeason);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("game.gameDate:>", seasonStart);
		params.put("game.gameDate:<", seasonEnd);
		params.put("homeGamesPlayed:>", BigInteger.valueOf(1));
		params.put("awayGamesPlayed:>", BigInteger.valueOf(1));
		List<AggregatedGameStatsDto> aggregatedGames = aggregatedGameStatsService.list(params, null);
		logger.info("Fetched {} game aggregations from {} to {}", aggregatedGames.size(), startSeason, endSeason);
		
		List<Integer> labels = new ArrayList<Integer>(aggregatedGames.size());
		List<List<Number>> features = new ArrayList<List<Number>>(aggregatedGames.size());
		for(AggregatedGameStatsDto aggregatedGame : aggregatedGames) {
			GameInfoDto currentGame = aggregatedGame.getGame();
			Integer currentLabel = ((currentGame.getHomeTeamPoints() + currentGame.getPointSpread()) >= 
					currentGame.getAwayTeamPoints()) ? 1 : -1;
			labels.add(currentLabel);
			
			List<Number> currentFeatures = new ArrayList<Number>();
			currentFeatures.add(currentGame.getDistanceBetweenTeamsKm());
			currentFeatures.add(currentGame.getPointSpread());
			
			addTeamAggregatedStats(aggregatedGame.getHomeTeamStats(), currentFeatures);
			addSimpleStats(aggregatedGame.getHomeTeamLastFive(), currentFeatures);
			addSimpleStats(aggregatedGame.getHomeTeamLastSeason(), currentFeatures);
			
			addTeamAggregatedStats(aggregatedGame.getAwayTeamStats(), currentFeatures);
			addSimpleStats(aggregatedGame.getAwayTeamLastFive(), currentFeatures);
			addSimpleStats(aggregatedGame.getAwayTeamLastSeason(), currentFeatures);
			
			convertNullsToZeros(currentFeatures);
			features.add(currentFeatures);
		}
		
		logger.info("Labels size: {}", labels.size());
		logger.info("Feature row size: {}", features.get(0).size());
		
		writeToFile(fileName, labels, features);
	}
	
	private void writeToFile(String fileName, List<Integer> labels, List<List<Number>> features) {
		String path = "D:\\libsvm-320\\windows\\";
		BufferedWriter writer = null;
		try {
			File file = new File(path + fileName);
			writer = new BufferedWriter(new FileWriter(file));
			
			for(int i = 0; i < labels.size(); ++i) {
				Integer label = labels.get(i);
				List<Number> currentFeatures = features.get(i);
				StringBuilder line = getLine(label, currentFeatures);
				writer.append(line);
			}
		} catch(Exception e) {
			logger.error("Error writing to file", e);
		} finally {
			try {
                writer.close();
            } catch (Exception e) {
            	logger.error("Error closing writer", e);
            }
		}
	}
	
	private StringBuilder getLine(Integer label, List<Number> features ) {
		StringBuilder line = new StringBuilder();
		line.append(label + " ");
		for(int i = 0; i < features.size(); ++i) {
			line.append((i + 1) + ":" + features.get(i) + " ");
		}
		line.append("\n");
		
		return line;
	}
	
	private void convertNullsToZeros(List<Number> features) {
		for(int i = 0; i < features.size(); ++i) {
			if(features.get(i) == null) {
				features.set(i, 0);
			}
		}
	}
	private void addSimpleStats(TeamSimpleAggregatedStats stats, List<Number> features) {
		features.add(stats.getPassDefYardsAvg());
		features.add(stats.getPassOffYardsAvg());
		features.add(stats.getRushDefYardsAvg());
		features.add(stats.getRushOffYardsAvg());
		features.add(stats.getScoringDefPointsAvg());
		features.add(stats.getScoringOffPointsAvg());
		features.add(stats.getWinATSPct());
		features.add(stats.getWinPct());
	}
	
	private void addTeamAggregatedStats(TeamAggregatedGameStatsDto stats, List<Number> features) {
		Number value = null;
		value = stats.getDefRedZoneAttAvg();
		features.add(value);
		
		value = stats.getDefRedZoneFGPct();
		features.add(value);
		
		value = stats.getDefRedZoneScorePct();
		features.add(value);
		
		value = stats.getDefRedZoneTDPct();
		features.add(value);
		
		value = stats.getFgDefAttAvg();
		features.add(value);
		
		value = stats.getFGDefPct();
		features.add(value);
		
		value = stats.getFgOffAttAvg();
		features.add(value);
		
		value = stats.getFGOffPct();
		features.add(value);
		
		value = stats.getFirstDownDefPassAvg();
		features.add(value);
		
		value = stats.getFirstDownDefPenaltyAvg();
		features.add(value);
		
		value = stats.getFirstDownDefRushAvg();
		features.add(value);
		
		value = stats.getFirstDownDefTotalAvg();
		features.add(value);
		
		value = stats.getFirstDownOffPassAvg();
		features.add(value);
		
		value = stats.getFirstDownOffPenaltyAvg();
		features.add(value);
		
		value = stats.getFirstDownOffRushAvg();
		features.add(value);
		
		value = stats.getFirstDownOffTotalAvg();
		features.add(value);
		
		value = stats.getFourthDownDefAttAvg();
		features.add(value);
		
		value = stats.getFourthDownDefConvPct();
		features.add(value);
		
		value = stats.getFourthDownOffAttAvg();
		features.add(value);
		
		value = stats.getFourthDownOffConvPct();
		features.add(value);
		
		value = stats.getGamesPlayed();
		features.add(value);
		
		value = stats.getKickoffAverage();
		features.add(value);
		
		value = stats.getKickoffReturnAverage();
		features.add(value);
		
		value = stats.getKickoffReturnAverageDef();
		features.add(value);
		
		value = stats.getKickoffReturnTDsAvg();
		features.add(value);
		
		value = stats.getKickoffReturnTDsDefAvg();
		features.add(value);
		
		value = stats.getKickoffTouchbackPct();
		features.add(value);
		
		value = stats.getOffRedZoneAttAvg();
		features.add(value);
		
		value = stats.getOffRedZoneFGPct();
		features.add(value);
		
		value = stats.getOffRedZoneScorePct();
		features.add(value);
		
		value = stats.getOffRedZoneTDPct();
		features.add(value);
		
		value = stats.getPassDefAttAvg();
		features.add(value);
		
		value = stats.getPassDefCompPct();
		features.add(value);
		
		value = stats.getPassDefINTsAvg();
		features.add(value);
		
		value = stats.getPassDefIntTDsAvg();
		features.add(value);
		
		value = stats.getPassDefIntYardsAvg();
		features.add(value);
		
		value = stats.getPassDefRatingAvg();
		features.add(value);
		
		value = stats.getPassDefTDsAvg();
		features.add(value);
		
		value = stats.getPassDefYardsAvg();
		features.add(value);
		
		value = stats.getPassDefYPA();
		features.add(value);
		
		value = stats.getPassDefYPR();
		features.add(value);
		
		value = stats.getPassOffAttAvg();
		features.add(value);
		
		value = stats.getPassOffCompPct();
		features.add(value);
		
		value = stats.getPassOffINTsAvg();
		features.add(value);
		
		value = stats.getPassOffRatingAvg();
		features.add(value);
		
		value = stats.getPassOffTDsAvg();
		features.add(value);
		
		value = stats.getPassOffYardsAvg();
		features.add(value);
		
		value = stats.getPassOffYPA();
		features.add(value);
		
		value = stats.getPassOffYPR();
		features.add(value);
		
		value = stats.getPassesBrokenUpAvg();
		features.add(value);
		
		value = stats.getPenaltiesAvg();
		features.add(value);
		
		value = stats.getPenaltyYardsAvg();
		features.add(value);
		
		value = stats.getPuntAverage();
		features.add(value);
		
		value = stats.getPuntReturnAverage();
		features.add(value);
		
		value = stats.getPuntReturnAverageDef();
		features.add(value);
		
		value = stats.getPuntsAvg();
		features.add(value);
		
		value = stats.getPuntReturnsAvg();
		features.add(value);
		
		value = stats.getPuntReturnTDsAvg();
		features.add(value);
		
		value = stats.getPuntReturnTDsDefAvg();
		features.add(value);
		
		value = stats.getQBHurriesAllowedAvg();
		features.add(value);
		
		value = stats.getQBHurriesAvg();
		features.add(value);
		
		value = stats.getRushDefAttAvg();
		features.add(value);
		
		value = stats.getRushDefTDsAvg();
		features.add(value);
		
		value = stats.getRushDefYardsAvg();
		features.add(value);
		
		value = stats.getRushDefYPA();
		features.add(value);
		
		value = stats.getRushOffAttAvg();
		features.add(value);
		
		value = stats.getRushOffTDsAvg();
		features.add(value);
		
		value = stats.getRushOffYardsAvg();
		features.add(value);
		
		value = stats.getRushOffYPA();
		features.add(value);
		
		value = stats.getSacksAllowedAvg();
		features.add(value);
		
		value = stats.getSacksAvg();
		features.add(value);
		
		value = stats.getSackYardsAllowedAvg();
		features.add(value);
		
		value = stats.getSackYardsAvg();
		features.add(value);
		
		value = stats.getScoringDefPointsAvg();
		features.add(value);
		
		value = stats.getScoringDefTDsAvg();
		features.add(value);
		
		value = stats.getScoringOffPointsAvg();
		features.add(value);
		
		value = stats.getScoringOffTDsAvg();
		features.add(value);
		
		value = stats.getTFLsAvg();
		features.add(value);
		
		value = stats.getTFLYardsAvg();
		features.add(value);
		
		value = stats.getThirdDownDefAttAvg();
		features.add(value);
		
		value = stats.getThirdDownDefConvPct();
		features.add(value);
		
		value = stats.getThirdDownOffAttAvg();
		features.add(value);
		
		value = stats.getThirdDownOffConvPct();
		features.add(value);
		
		value = stats.getTotalDefPlaysAvg();
		features.add(value);
		
		value = stats.getTotalDefYPP();
		features.add(value);
		
		value = stats.getTotalOffPlaysAvg();
		features.add(value);
		
		value = stats.getTotalOffYPP();
		features.add(value);
		
		value = stats.getTotalTacklesAvg();
		features.add(value);
		
		value = stats.getTurnoverMarginAvg();
		features.add(value);
		
		value = stats.getWinATSPct();
		features.add(value);
		
		value = stats.getWinPct();
		features.add(value);
	}
}
