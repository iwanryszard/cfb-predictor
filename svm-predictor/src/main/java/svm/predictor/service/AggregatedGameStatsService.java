package svm.predictor.service;

import java.util.List;

import svm.predictor.dto.AggregatedGameStatsDto;

public interface AggregatedGameStatsService extends Service<AggregatedGameStatsDto, Integer> {

	void createAggregations(List<AggregatedGameStatsDto> aggregations);

}
