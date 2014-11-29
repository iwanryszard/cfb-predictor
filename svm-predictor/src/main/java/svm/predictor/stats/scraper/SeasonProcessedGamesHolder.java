package svm.predictor.stats.scraper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeasonProcessedGamesHolder {

	private Object[][] processedGames;
	private Map<Integer, Integer> teamIdToOrderIndex;
	
	/**
	 * @param teamMap - a tree Map, so the teams are sorted by IDs in ascending order
	 */
	public SeasonProcessedGamesHolder(Map<Integer, String> teamMap) {
		int numberOfTeams = teamMap.size();
		teamIdToOrderIndex = new HashMap<Integer, Integer>(numberOfTeams);
		int orderIndex = 0;
		for(Integer teamId : teamMap.keySet()) {
			teamIdToOrderIndex.put(teamId, orderIndex);
			++orderIndex;
		}
		
		processedGames = new Object[numberOfTeams][numberOfTeams];
		
		for(int row = 0; row < processedGames.length; ++row) {
			for(int col = 0; col < row; ++col) {
				Set<String> matchDates = new HashSet<String>();
				processedGames[row][col] = matchDates;
				processedGames[col][row] = matchDates;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean isGameProcessed(int teamId, int opponentId, String gameDate) {
		boolean processed = false;
		if(opponentId != -1) {
			int teamIndex = teamIdToOrderIndex.get(teamId);
			int opponentIndex = teamIdToOrderIndex.get(opponentId);
			Set<String> matchDatesSet = (Set<String>)processedGames[teamIndex][opponentIndex];
			processed = matchDatesSet.contains(gameDate);
		}
		
		return processed;
	}
	
	@SuppressWarnings("unchecked")
	public void setGameProcessed(int teamId, int opponentId, String gameDate) {
		if(opponentId != -1) {
			int teamIndex = teamIdToOrderIndex.get(teamId);
			int opponentIndex = teamIdToOrderIndex.get(opponentId);
			Set<String> matchDatesSet = (Set<String>)processedGames[teamIndex][opponentIndex];
			matchDatesSet.add(gameDate);
		}
	}
	
}
