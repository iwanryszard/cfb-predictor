package svm.predictor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import svm.predictor.dao.CalculatedDistanceDao;
import svm.predictor.domain.CalculatedDistance;
import svm.predictor.dto.CalculatedDistanceDto;
import svm.predictor.dto.League;
import svm.predictor.service.CalculatedDistanceService;

public class CalculatedDistanceServiceImpl extends BaseService<CalculatedDistanceDto, CalculatedDistanceDao, 
	CalculatedDistance, Integer> implements CalculatedDistanceService {

	@Override
	public void createCalculatedDistances(List<CalculatedDistanceDto> distances) {
		for(CalculatedDistanceDto distance : distances) {
			create(distance);
		}
	}
	
	@Override
	public List<CalculatedDistanceDto> getCalculatedDistances(League league) {
		Map<String, Object> params = getParams(league);
		return list(params, null);
	}
	
	private Map<String, Object> getParams(League league) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(league.equals(League.CFB)) {
			params.put("fromTeamId:<", 10000);
			params.put("toTeamId:<", 10000);
		} else if(league.equals(League.NFL)) {
			params.put("fromTeamId:>", 10000);
			params.put("toTeamId:>", 10000);
		}
		
		return params;
	}
}
