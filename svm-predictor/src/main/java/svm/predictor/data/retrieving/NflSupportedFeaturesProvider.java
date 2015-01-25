package svm.predictor.data.retrieving;

import java.util.ArrayList;
import java.util.List;

import svm.predictor.dto.League;

public class NflSupportedFeaturesProvider implements SupportedFeaturesProvider {
	
	@Override
	public List<String> getStatNames() {
		List<String> names = new ArrayList<String>();
		
		names.add("DefRedZoneAttAvg");
		names.add("DefRedZoneTDPct");
		names.add("FGDefPct");
		names.add("FGOffPct");
		names.add("FirstDownDefPassAvg");
		names.add("FirstDownDefPenaltyAvg");
		names.add("FirstDownDefRushAvg");
		names.add("FirstDownDefTotalAvg");
		names.add("FirstDownOffPassAvg");
		names.add("FirstDownOffPenaltyAvg");
		names.add("FirstDownOffRushAvg");
		names.add("FirstDownOffTotalAvg");
		names.add("FourthDownDefAttAvg");
		names.add("FourthDownDefConvPct");
		names.add("FourthDownOffAttAvg");
		names.add("FourthDownOffConvPct");
		names.add("GamesPlayed");
		names.add("KickoffReturnAverage");
		names.add("KickoffReturnAverageDef");
		names.add("KickoffReturnTDsAvg");
		names.add("KickoffReturnTDsDefAvg");
		names.add("OffRedZoneAttAvg");
		names.add("OffRedZoneTDPct");
		names.add("PassDefAttAvg");
		names.add("PassDefCompPct");
		names.add("PassDefINTsAvg");
		names.add("PassDefIntTDsAvg");
		names.add("PassDefIntYardsAvg");
		names.add("PassDefTDsAvg");
		names.add("PassDefYardsAvg");
		names.add("PassDefYPA");
		names.add("PassDefYPR");
		names.add("PassOffAttAvg");
		names.add("PassOffCompPct");
		names.add("PassOffINTsAvg");
		names.add("PassOffTDsAvg");
		names.add("PassOffYardsAvg");
		names.add("PassOffYPA");
		names.add("PassOffYPR");
		names.add("PassesBrokenUpAvg");
		names.add("PenaltiesAvg");
		names.add("PenaltyYardsAvg");
		names.add("PuntAverage");
		names.add("PuntReturnAverage");
		names.add("PuntReturnAverageDef");
		names.add("PuntsAvg");
		names.add("PuntReturnsAvg");
		names.add("PuntReturnTDsAvg");
		names.add("PuntReturnTDsDefAvg");
		names.add("QBHurriesAllowedAvg");
		names.add("QBHurriesAvg");
		names.add("RushDefAttAvg");
		names.add("RushDefTDsAvg");
		names.add("RushDefYardsAvg");
		names.add("RushDefYPA");
		names.add("RushOffAttAvg");
		names.add("RushOffTDsAvg");
		names.add("RushOffYardsAvg");
		names.add("RushOffYPA");
		names.add("SacksAllowedAvg");
		names.add("SacksAvg");
		names.add("SackYardsAllowedAvg");
		names.add("SackYardsAvg");
		names.add("ScoringDefPointsAvg");
		names.add("ScoringOffPointsAvg");
		names.add("TFLsAvg");
		names.add("ThirdDownDefAttAvg");
		names.add("ThirdDownDefConvPct");
		names.add("ThirdDownOffAttAvg");
		names.add("ThirdDownOffConvPct");
		names.add("TotalDefPlaysAvg");
		names.add("TotalDefYPP");
		names.add("TotalOffPlaysAvg");
		names.add("TotalOffYPP");
		names.add("TotalTacklesAvg");
		names.add("TurnoverMarginAvg");
		names.add("FubmleLostAvg");
		names.add("FumbleGainAvg");
		names.add("WinPct");
		
		return names;
	}

	@Override
	public League getLeague() {
		return League.NFL;
	}

}
