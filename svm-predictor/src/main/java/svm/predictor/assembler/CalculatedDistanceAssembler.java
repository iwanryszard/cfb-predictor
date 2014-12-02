package svm.predictor.assembler;

import svm.predictor.domain.CalculatedDistance;
import svm.predictor.dto.CalculatedDistanceDto;

public class CalculatedDistanceAssembler extends BaseAssembler<CalculatedDistanceDto, CalculatedDistance, Integer> {

	@Override
	public CalculatedDistance createEntity() {
		return new CalculatedDistance();
	}

	@Override
	public CalculatedDistanceDto createDto() {
		return new CalculatedDistanceDto();
	}

	@Override
	protected void doConvertToDto(CalculatedDistance entity, CalculatedDistanceDto dto) {
		dto.setFromTeamId(entity.getFromTeamId());
		dto.setToTeamId(entity.getToTeamId());
		dto.setDistanceKm(entity.getDistanceKm());
	}

	@Override
	protected void doConvertToEntity(CalculatedDistanceDto dto, CalculatedDistance entity) {
		entity.setFromTeamId(dto.getFromTeamId());
		entity.setToTeamId(dto.getToTeamId());
		entity.setDistanceKm(dto.getDistanceKm());
	}

}
