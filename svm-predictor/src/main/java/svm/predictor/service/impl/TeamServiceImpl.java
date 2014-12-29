package svm.predictor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import svm.predictor.dao.TeamDao;
import svm.predictor.domain.Team;
import svm.predictor.dto.League;
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
	public Map<Integer, String> getTeamNamesMap(League league) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("league", league);
		Map<Integer, String> teamsMap = new TreeMap<Integer, String>();
		List<TeamDto> teams = list(params, null);
		for(TeamDto team : teams) {
			teamsMap.put(team.getId(), team.getName());
		}
		
		return teamsMap;
	}

	@Override
	public Map<Integer, String> getTeamLocationsMap(League league) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("league", league);
		Map<Integer, String> teamsMap = new TreeMap<Integer, String>();
		List<TeamDto> teams = list(params, null);
		for(TeamDto team : teams) {
			teamsMap.put(team.getId(), team.getStadiumLocation());
		}
		
		return teamsMap;
	}
	
	@Override
	public Map<String, Integer> getNameToIdMap(League league) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("league", league);
		Map<String, Integer> teamsMap = new HashMap<String, Integer>();
		List<TeamDto> teams = list(params, null);
		for(TeamDto team : teams) {
			teamsMap.put(team.getName(), team.getId());
		}
		
		return teamsMap;
	}

}
