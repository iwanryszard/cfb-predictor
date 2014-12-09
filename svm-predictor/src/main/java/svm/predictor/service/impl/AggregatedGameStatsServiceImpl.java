package svm.predictor.service.impl;

import java.util.List;

import svm.predictor.dao.AggregatedGameStatsDao;
import svm.predictor.domain.AggregatedGameStats;
import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.service.AggregatedGameStatsService;

public class AggregatedGameStatsServiceImpl extends BaseService<AggregatedGameStatsDto, AggregatedGameStatsDao, AggregatedGameStats, Integer> implements AggregatedGameStatsService {

	@Override
	public void createAggregations(List<AggregatedGameStatsDto> aggregations) {
		for(AggregatedGameStatsDto aggregation : aggregations) {
			create(aggregation);
		}
	}
}
