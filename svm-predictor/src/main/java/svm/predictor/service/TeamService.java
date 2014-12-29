package svm.predictor.service;

import java.util.List;
import java.util.Map;

import svm.predictor.dto.League;
import svm.predictor.dto.TeamDto;

public interface TeamService extends Service<TeamDto, Integer> {
	void createTeams(List<TeamDto> teams);
	Map<Integer, String> getTeamNamesMap(League league);
	Map<Integer, String> getTeamLocationsMap(League league);
	Map<String, Integer> getNameToIdMap(League league);
}
