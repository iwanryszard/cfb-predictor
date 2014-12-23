package svm.predictor.libsvm.data.retrieving;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public class PointSpreadDataRetriever extends BaseDataRetriever {

	@Override
	public Map<String, String> getSpecificParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("game.pointSpread:IS NOT", null);
		return params;
	}

	@Override
	public Integer getLabel(GameInfoDto game) {
		Integer label = ((game.getHomeTeamPoints() + game.getPointSpread()) >= 
				game.getAwayTeamPoints()) ? 1 : -1;
		return label;
	}
	
	@Override
	public void addSpecificFeatures(AggregatedGameStatsDto aggregatedGame, List<Number> features) {
		super.addSpecificFeatures(aggregatedGame, features);
		features.add(aggregatedGame.getGame().getPointSpread());
	}
	
	@Override
	public void addSimpleStats(TeamSimpleAggregatedStats stats, List<Number> features) {
		super.addSimpleStats(stats, features);
		features.add(stats.getWinATSPct());
	}
	
	@Override
	public void addTeamAggregatedStats(TeamAggregatedGameStatsDto stats, List<Number> features) {
		super.addTeamAggregatedStats(stats, features);
		features.add(stats.getWinATSPct());
	}
}
