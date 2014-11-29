package svm.predictor.service;

import java.util.List;
import java.util.Map;

import svm.predictor.dto.TeamDto;

public interface TeamService extends Service<TeamDto, Integer> {
	void createTeams(List<TeamDto> teams);
	Map<Integer, String> getTeamsMap();
}
