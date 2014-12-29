package svm.predictor.libsvm.data.retrieving;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public class PointTotalDataRetriever extends BaseDataRetriever {

	public PointTotalDataRetriever(SupportedFeaturesProvider supportedFeaturesProvider) {
		super(supportedFeaturesProvider);
	}
	
	@Override
	public Map<String, String> getSpecificParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("game.pointTotal:IS NOT", null);
		return params;
	}

	@Override
	public Integer getLabel(GameInfoDto game) {
		Integer label = ((game.getHomeTeamPoints() + game.getAwayTeamPoints()) <= 
				game.getPointTotal()) ? 1 : -1;
		return label;
	}
	
	@Override
	public void addSpecificFeatures(AggregatedGameStatsDto aggregatedGame, List<Number> features) {
		super.addSpecificFeatures(aggregatedGame, features);
		features.add(aggregatedGame.getGame().getPointTotal());
	}
	
	@Override
	public void addSimpleStats(TeamSimpleAggregatedStats stats, List<Number> features) {
		super.addSimpleStats(stats, features);
		features.add(stats.getUnderPct());
	}
	
	@Override
	public void addTeamAggregatedStats(TeamAggregatedGameStatsDto stats, List<Number> features) {
		super.addTeamAggregatedStats(stats, features);
		features.add(stats.getUnderPct());
	}
}
