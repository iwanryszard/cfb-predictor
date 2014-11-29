package svm.predictor.service.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import svm.predictor.dao.TeamDao;
import svm.predictor.domain.Team;
import svm.predictor.dto.TeamDto;
import svm.predictor.service.TeamService;

public class TeamServiceImpl extends BaseService<TeamDto, TeamDao, Team, Integer> implements TeamService {

	@Override
	public void createTeams(List<TeamDto> teams) {
		for(TeamDto team : teams) {
			create(team);
		}
	}

	@Override
	public Map<Integer, String> getTeamsMap() {
		Map<Integer, String> teamsMap = new TreeMap<Integer, String>();
		List<TeamDto> teams = list();
		for(TeamDto team : teams) {
			teamsMap.put(team.getId(), team.getName());
		}
		
		return teamsMap;
	}

}
