package svm.predictor.service;

import java.util.List;

import svm.predictor.dto.CalculatedDistanceDto;

public interface CalculatedDistanceService extends Service<CalculatedDistanceDto, Integer> {
	void createCalculatedDistances(List<CalculatedDistanceDto> distances);
}
