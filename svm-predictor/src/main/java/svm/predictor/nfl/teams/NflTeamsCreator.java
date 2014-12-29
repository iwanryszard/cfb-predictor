package svm.predictor.nfl.teams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.dto.League;
import svm.predictor.dto.TeamDto;
import svm.predictor.service.TeamService;

@Service("nflTeamsCreator")
public class NflTeamsCreator {

	private static Logger logger = LoggerFactory.getLogger(NflTeamsCreator.class);
	
	@Autowired
	private TeamService teamService;
	
	public void createAllNflTeams() {
		List<TeamDto> teams = getNflTeamsList();
		teamService.createTeams(teams);
		logger.info("Persisted NFL teams");
	}
	
	private List<TeamDto> getNflTeamsList() {
		List<String> teamNames = Arrays.asList("Atlanta", "Detroit", "Green Bay", "Tennessee", 
				"Kansas City", "NY Jets", "Philadelphia", "Washington", "Jacksonville", 
				"Buffalo", "San Francisco", "Chicago", "Denver", "San Diego", "Dallas", 
				"Miami", "Pittsburgh", "Cincinnati", "Cleveland", "Indianapolis", "New Orleans",
				"Tampa Bay", "Carolina", "Baltimore", "Houston", "NY Giants", "Arizona",
				"Seattle", "New England", "Oakland", "St. Louis", "Minnesota");
		List<String> stadiumLocations = Arrays.asList("Atlanta, GA", "Detroit, MI", "Green Bay, WI", "Nashville, TN", 
				"Kansas City, MO", "East Rutherford, NJ", "Philadelphia, PA", "Landover, MD", "Jacksonville, FL",
				"Buffalo, NY", "San Francisco, CA", "Chicago, IL", "Denver, CO", "San Diego, CA", "Arlington, TX",
				"Miami, FL", "Pittsburgh, PA", "Cincinnati, OH", "Cleveland, OH", "Indianapolis, IN", "New Orleans, LA",
				"Tampa, FL", "Charlotte, NC", "Baltimore, MD", "Houston, TX", "East Rutherford, NJ", "Glendale, AZ",
				"Seattle, WA", "Foxboro, MA", "Oakland, CA", "Saint Louis, MO", "Minneapolis, MN");
		
		List<TeamDto> result = new ArrayList<TeamDto>(teamNames.size());
		int startId = 10001;
		for(int i = 0; i < teamNames.size(); ++i) {
			TeamDto teamDto = new TeamDto();
			teamDto.setId(startId + i);
			teamDto.setName(teamNames.get(i));
			teamDto.setStadiumLocation(stadiumLocations.get(i));
			teamDto.setLeague(League.NFL);
			result.add(teamDto);
		}
		
		return result;
	}
}
