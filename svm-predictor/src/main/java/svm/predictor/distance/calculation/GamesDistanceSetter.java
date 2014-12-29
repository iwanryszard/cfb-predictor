package svm.predictor.distance.calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.dto.CalculatedDistanceDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.service.CalculatedDistanceService;
import svm.predictor.service.GameInfoService;
import svm.predictor.service.TeamService;

@Service("gamesDistanceSetter")
public class GamesDistanceSetter {

	private static final Logger logger = LoggerFactory.getLogger(GamesDistanceSetter.class);
	
	@Autowired
	private CalculatedDistanceService calculatedDistanceService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private GameInfoService gameInfoService;
	
	@Autowired
	private DistanceCalculator distanceCalculator;
	
	private Map<Integer, Integer> teamIdToOrderIndex;
	
	public void setAllGamesDistances(League league) {
		Map<Integer, String> teamLocationsMap = teamService.getTeamLocationsMap(league);
		int numberOfTeams = teamLocationsMap.size();
		teamIdToOrderIndex = getTeamIdToOrderMap(teamLocationsMap);
		
		Integer[][] calculatedDistances = new Integer[numberOfTeams][numberOfTeams];
		List<CalculatedDistanceDto> calculated = calculatedDistanceService.getCalculatedDistances(league);
		populateCalculatedDistances(calculatedDistances, calculated);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("awayTeamId:<>", -1);
		params.put("distanceBetweenTeamsKm:IS", null);
		for(Integer teamId : teamLocationsMap.keySet()) {
			logger.info("Started setting distances for home team: {}", teamId);
			params.put("homeTeamId", teamId);
			List<GameInfoDto> teamHomeGames = gameInfoService.list(params, null);
			List<GameInfoDto> gamesWithNoDistance = new ArrayList<GameInfoDto>();
			for(GameInfoDto game : teamHomeGames) {
				Integer distance = null;
				if( !game.isNeutralVenue()) {
					Integer calculatedDistance = getCalculatedDistance(calculatedDistances, teamId, game.getAwayTeamId());
					if(calculatedDistance != null) {
						distance = calculatedDistance;
					} else {
						gamesWithNoDistance.add(game);
					}
				} else {
					distance = 0;
				}
				
				game.setDistanceBetweenTeamsKm(distance);
			}
			
			if( !gamesWithNoDistance.isEmpty()) {
				String homeTeamLocation = teamLocationsMap.get(teamId);
				List<String> awayTeamLocations = getAwayTeamLocations(gamesWithNoDistance, teamLocationsMap);
				logger.info("away team locations: {}", awayTeamLocations);
				List<Integer> distances = distanceCalculator.calculateDistances(homeTeamLocation, awayTeamLocations);
				logger.info("distances: {}", distances);
				
				List<CalculatedDistanceDto> distanceDtos = new ArrayList<CalculatedDistanceDto>(distances.size());
				int distanceInd = 0;
				for(GameInfoDto currentGame : gamesWithNoDistance) {
					Integer calculatedDistance = getCalculatedDistance(calculatedDistances, teamId, currentGame.getAwayTeamId());
					if(calculatedDistance == null) {
						calculatedDistance = distances.get(distanceInd);
					
						setCalculatedDistance(calculatedDistances, teamId, currentGame.getAwayTeamId(), calculatedDistance);
					
						CalculatedDistanceDto calculatedDistanceDto = new CalculatedDistanceDto();
						calculatedDistanceDto.setFromTeamId(teamId);
						calculatedDistanceDto.setToTeamId(currentGame.getAwayTeamId());
						calculatedDistanceDto.setDistanceKm(calculatedDistance);
						distanceDtos.add(calculatedDistanceDto);
						
						++distanceInd;
					}
					
					currentGame.setDistanceBetweenTeamsKm(calculatedDistance);
				}
				
				if(distanceInd != distances.size()) {
					logger.error("Not all distances processed, distanceInd: " + distanceInd);
					throw new RuntimeException("Not all distances processed, distanceInd: " + distanceInd);
				}
				
				calculatedDistanceService.createCalculatedDistances(distanceDtos);
				logger.info("Persisted calculated distances, size: {}", distanceDtos.size());
			}
			
			gameInfoService.updateGameInfos(teamHomeGames);
			logger.info("Persisted games");
			logger.info("Finished setting distances for home team: {}", teamId);
		}
	}
	
	private Map<Integer, Integer> getTeamIdToOrderMap(Map<Integer, String> teamMap) {
		Map<Integer, Integer> teamIdToOrderIndex = new HashMap<Integer, Integer>(teamMap.size());
		int orderIndex = 0;
		for(Integer teamId : teamMap.keySet()) {
			teamIdToOrderIndex.put(teamId, orderIndex);
			++orderIndex;
		}
		
		return teamIdToOrderIndex;
	}
	
	private void populateCalculatedDistances(Integer[][] calculatedDistances, List<CalculatedDistanceDto> calculated) {
		for(CalculatedDistanceDto dto : calculated) {
			int fromTeamId = dto.getFromTeamId();
			int toTeamId = dto.getToTeamId();
			int distance = dto.getDistanceKm();
			setCalculatedDistance(calculatedDistances, fromTeamId, toTeamId, distance);
		}
	}
	
	private Integer getCalculatedDistance(Integer[][] calculatedDistances, Integer fromTeamId, Integer toTeamId) {
		Integer fromTeamOrder = teamIdToOrderIndex.get(fromTeamId);
		Integer toTeamOrder = teamIdToOrderIndex.get(toTeamId);
		Integer result = calculatedDistances[fromTeamOrder][toTeamOrder];
		return result;
	}
	
	private void setCalculatedDistance(Integer[][] calculatedDistances, Integer fromTeamId, Integer toTeamId, Integer distance) {
		Integer fromTeamOrder = teamIdToOrderIndex.get(fromTeamId);
		Integer toTeamOrder = teamIdToOrderIndex.get(toTeamId);
		calculatedDistances[fromTeamOrder][toTeamOrder] = distance;
		calculatedDistances[toTeamOrder][fromTeamOrder] = distance;
	}
	
	private List<String> getAwayTeamLocations(List<GameInfoDto> games, Map<Integer, String> teamLocationsMap) {
		Set<Integer> distinctAwayTeams = new LinkedHashSet<Integer>();
		for(GameInfoDto game : games) {
			distinctAwayTeams.add(game.getAwayTeamId());
		}
		
		List<String> result = new ArrayList<String>();
		for(Integer awayTeamId : distinctAwayTeams) {
			String currentLocation = teamLocationsMap.get(awayTeamId);
			result.add(currentLocation);
		}
		return result;
	}
}
