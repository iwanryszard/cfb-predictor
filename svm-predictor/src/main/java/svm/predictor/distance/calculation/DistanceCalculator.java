package svm.predictor.distance.calculation;

import java.util.List;

public interface DistanceCalculator {

	List<Integer> calculateDistances(String origin, List<String> destinations);
}
