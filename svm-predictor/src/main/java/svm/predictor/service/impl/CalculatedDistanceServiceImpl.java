package svm.predictor.service.impl;

import java.util.List;

import svm.predictor.dao.CalculatedDistanceDao;
import svm.predictor.domain.CalculatedDistance;
import svm.predictor.dto.CalculatedDistanceDto;
import svm.predictor.dto.TeamDto;
import svm.predictor.service.CalculatedDistanceService;

public class CalculatedDistanceServiceImpl extends BaseService<CalculatedDistanceDto, CalculatedDistanceDao, 
	CalculatedDistance, Integer> implements CalculatedDistanceService {

	@Override
	public void createCalculatedDistances(List<CalculatedDistanceDto> distances) {
		for(CalculatedDistanceDto distance : distances) {
			create(distance);
		}
	}
}
