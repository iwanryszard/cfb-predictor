package svm.predictor.libsvm.data.retrieving;

import java.util.List;

import svm.predictor.dto.League;

public interface SupportedFeaturesProvider {
	
	List<String> getStatNames();
	League getLeague();

}
