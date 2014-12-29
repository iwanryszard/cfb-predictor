package svm.predictor.libsvm.data.retrieving;

import java.util.List;

import svm.predictor.dto.League;
import svm.predictor.dto.TeamAggregatedGameStatsDto;

public interface SupportedFeaturesProvider {

	void addTeamAggregatedStats(TeamAggregatedGameStatsDto stats, List<Number> features);
	League getLeague();

}
