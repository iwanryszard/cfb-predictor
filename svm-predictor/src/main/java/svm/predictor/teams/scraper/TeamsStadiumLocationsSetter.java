package svm.predictor.teams.scraper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.dto.TeamDto;
import svm.predictor.service.TeamService;

@Service("teamsStadiumLocationsSetter")
public class TeamsStadiumLocationsSetter {

	private static Logger logger = LoggerFactory.getLogger(TeamsStadiumLocationsSetter.class);
	
	@Autowired
	private TeamsScraper teamsScraper;
	
	@Autowired
	private StadiumLocationsScraper stadiumLocationsScraper;
	
	@Autowired
	private TeamService teamService;
	
	public void createAllTeams() {
		Map<Integer, String> teamsMap = teamsScraper.getAllTeamsMap();
		logger.info("Number of teams fetched: " + teamsMap.size());
		Map<Integer, String> locationsMap = stadiumLocationsScraper.getStadiumLocationsMap();
		logger.info("Number of locations fetched: " + locationsMap.size());
		//Adding hardcoded new teams for 2014, Appalachian State, Georgia Southern and Old Dominion
		//because they are not present on the stadiums page
		//Appalachian State
		locationsMap.put(27, "Boone, North Carolina");
		//Georgia Southern
		locationsMap.put(253, "Statesboro, Georgia");
		//Old Dominion
		locationsMap.put(523, "Norfolk, Virginia");
		logger.info("Number of locations after manually added: " + locationsMap.size());
		
		List<TeamDto> teams = new ArrayList<TeamDto>();
		for(Map.Entry<Integer, String> teamEntry : teamsMap.entrySet()) {
			int teamId = teamEntry.getKey();
			String stadiumLocation = locationsMap.get(teamId);
			if(stadiumLocation != null) {
				TeamDto team = new TeamDto();
				team.setId(teamId);
				team.setName(teamEntry.getValue());
				team.setStadiumLocation(stadiumLocation);
				teams.add(team);
			}
			 
		}
		
		teamService.createTeams(teams);
		logger.info("Persisted teams");
	}
}
