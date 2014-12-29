package svm.predictor.service;

import java.util.List;

import svm.predictor.dto.CalculatedDistanceDto;
import svm.predictor.dto.League;

public interface CalculatedDistanceService extends Service<CalculatedDistanceDto, Integer> {
	void createCalculatedDistances(List<CalculatedDistanceDto> distances);
	List<CalculatedDistanceDto> getCalculatedDistances(League league);
}
