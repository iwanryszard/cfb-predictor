package svm.predictor.libsvm.data.retrieving;

import java.util.List;
import java.util.Map;

import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public abstract class BaseDataRetriever {
	
	protected SupportedFeaturesProvider supportedFeaturesProvider;
	
	public BaseDataRetriever(SupportedFeaturesProvider supportedFeaturesProvider) {
		this.supportedFeaturesProvider = supportedFeaturesProvider;
	}

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
		supportedFeaturesProvider.addTeamAggregatedStats(stats, features);
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
	
	public League getLeague() {
		return supportedFeaturesProvider.getLeague();
	}
}
