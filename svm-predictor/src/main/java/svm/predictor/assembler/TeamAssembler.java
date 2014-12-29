package svm.predictor.assembler;

import svm.predictor.domain.Team;
import svm.predictor.dto.TeamDto;

public class TeamAssembler extends BaseAssembler<TeamDto, Team, Integer> {

	@Override
	public Team createEntity() {
		return new Team();
	}

	@Override
	public TeamDto createDto() {
		return new TeamDto();
	}

	@Override
	protected void doConvertToDto(Team entity, TeamDto dto) {
		dto.setName(entity.getName());
		dto.setStadiumLocation(entity.getStadiumLocation());
		dto.setLeague(entity.getLeague());
	}

	@Override
	protected void doConvertToEntity(TeamDto dto, Team entity) {
		entity.setName(dto.getName());
		entity.setStadiumLocation(dto.getStadiumLocation());
		entity.setLeague(dto.getLeague());
	}

}
