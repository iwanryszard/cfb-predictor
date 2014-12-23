package svm.predictor.libsvm.data.retrieving;

import java.util.List;
import java.util.Map;

import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public abstract class BaseDataRetriever {

	public abstract Map<String, String> getSpecificParams();
	
	public abstract Integer getLabel(GameInfoDto game);
	
	public void addSimpleStats(TeamSimpleAggregatedStats stats, List<Number> features) {
		features.add(stats.getPassDefYardsAvg());
		features.add(stats.getPassOffYardsAvg());
		features.add(stats.getRushDefYardsAvg());
		features.add(stats.getRushOffYardsAvg());
		features.add(stats.getScoringDefPointsAvg());
		features.add(stats.getScoringOffPointsAvg());
		features.add(stats.getWinPct());
	}
	
	public void addTeamAggregatedStats(TeamAggregatedGameStatsDto stats, List<Number> features) {
		Number value = null;
		value = stats.getDefRedZoneAttAvg();
		features.add(value);
		
//		value = stats.getDefRedZoneFGPct();
//		features.add(value);
		
		value = stats.getDefRedZoneScorePct();
		features.add(value);
		
		value = stats.getDefRedZoneTDPct();
		features.add(value);
		
//		value = stats.getFgDefAttAvg();
//		features.add(value);
		
		value = stats.getFGDefPct();
		features.add(value);
		
//		value = stats.getFgOffAttAvg();
//		features.add(value);
		
		value = stats.getFGOffPct();
		features.add(value);
		
//		value = stats.getFirstDownDefPassAvg();
//		features.add(value);
//		
//		value = stats.getFirstDownDefPenaltyAvg();
//		features.add(value);
//		
//		value = stats.getFirstDownDefRushAvg();
//		features.add(value);
		
		value = stats.getFirstDownDefTotalAvg();
		features.add(value);
		
//		value = stats.getFirstDownOffPassAvg();
//		features.add(value);
//		
//		value = stats.getFirstDownOffPenaltyAvg();
//		features.add(value);
//		
//		value = stats.getFirstDownOffRushAvg();
//		features.add(value);
		
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
		
//		value = stats.getOffRedZoneFGPct();
//		features.add(value);
		
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
		
		value = stats.getWinPct();
		features.add(value);
	}
	
	public void addSpecificFeatures(AggregatedGameStatsDto aggregatedGame, List<Number> features) {
		
	}
	
	public void addGameOdds(GameInfoDto game, List<GameOddsDto> gamesOdds) {
		//default implementation for point spread and point total lines - standard odds are 1.91
		GameOddsDto odds = new GameOddsDto();
		odds.setAwayOdds(1.91);
		odds.setHomeOdds(1.91);
		gamesOdds.add(odds);
	}
}
