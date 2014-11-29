package svm.predictor.stats.scraper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.constants.CFBStatsURLConts;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamGameStatsDto;
import svm.predictor.service.impl.DocumentGetter;
import svm.predictor.service.impl.TeamIdExtractor;

public class TeamSeasonGamesStatsScraper {

	private static Logger logger = LoggerFactory.getLogger(TeamSeasonGamesStatsScraper.class);
	
	private int teamId;
	private int year;
	private List<TeamGameStatsDto> teamStats;
	private List<TeamGameStatsDto> opponentsStats;
	private Map<Integer, String> defenseOpponentToDateMap;
	private ComponentStatsSettersHolder componentStatsSettersHolder;
	private SeasonProcessedGamesHolder seasonProcessedGamesHolder;
	private DocumentGetter documentGetter;
	
	private TeamIdExtractor teamIdExtractor = new TeamIdExtractor();
	
	public TeamSeasonGamesStatsScraper(int teamId, int year, ComponentStatsSettersHolder componentStatsSettersHolder, SeasonProcessedGamesHolder seasonProcessedGamesHolder,
			DocumentGetter documentGetter) {
		this.teamId = teamId;
		this.year = year;
		this.componentStatsSettersHolder = componentStatsSettersHolder;
		this.seasonProcessedGamesHolder = seasonProcessedGamesHolder;
		this.documentGetter = documentGetter;
		teamStats = new ArrayList<TeamGameStatsDto>();
		opponentsStats = new ArrayList<TeamGameStatsDto>();
		defenseOpponentToDateMap = new LinkedHashMap<Integer, String>();
	}
	
	public List<GameInfoDto> getTeamSeasonGameStats() {
		List<GameInfoDto> gameStats = getTeamSchedule(teamId, year);
		
		TeamStatsGetter teamStatsGetter = new TeamStatsGetter() {
			
			public TeamGameStatsDto getTeamStats(int gameInd) {
				return teamStats.get(gameInd);
			}
		};
		TeamStatsGetter opponentStatsGetter = new TeamStatsGetter() {
			
			public TeamGameStatsDto getTeamStats(int gameInd) {
				return opponentsStats.get(gameInd);
			}
		};
		
		Map<String, ComponentStatsSetter> offensiveComponentSettersMap = componentStatsSettersHolder.getOffensiveComponentSettersMap();
		for(Map.Entry<String, ComponentStatsSetter> entry : offensiveComponentSettersMap.entrySet()) {
			String component = entry.getKey();
			ComponentStatsSetter componentSetter = entry.getValue();
			setTeamComponentStats(teamId, year, component, componentSetter, "offense", teamStatsGetter);
			setTeamComponentStats(teamId, year, component, componentSetter, "defense", opponentStatsGetter);
		}
		
		Map<String, ComponentStatsSetter> defensiveComponentSettersMap = componentStatsSettersHolder.getDefensiveComponentSettersMap();
		for(Map.Entry<String, ComponentStatsSetter> entry : defensiveComponentSettersMap.entrySet()) {
			String component = entry.getKey();
			ComponentStatsSetter componentSetter = entry.getValue();
			setTeamComponentStats(teamId, year, component, componentSetter, null, teamStatsGetter);
			Elements opponentsRows = getOpponentsDefenseTableRows(teamId, year, component);
			setOpponentsDefenseStats(opponentsRows, componentSetter);
		}
		
		//remove already processed games which were skipped and stored as nulls
		gameStats.removeAll(Collections.singleton(null));
		return gameStats;
	}
	
	private List<GameInfoDto> getTeamSchedule(int teamId, int year) {
		List<GameInfoDto> result = new ArrayList<GameInfoDto>();
		
		String url = CFBStatsURLConts.rootURL + year +"/team/" + teamId + "/index.html";
		Document doc = documentGetter.getDocument(url);
		
		Elements tableRows = doc.select("table.team-schedule > tbody > *");
		//remove header row
		tableRows.remove(0);
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		for(Element row : tableRows) {
			GameInfoDto currentGame = null;
			
			Elements rowCells = row.select("td");
			
			String dateStr = rowCells.get(0).text();
			
			String opponent = rowCells.get(1).text();
			Elements opponentLink = rowCells.get(1).select("a[href]");
			int opponentId = teamIdExtractor.extractTeamId(opponentLink);
			defenseOpponentToDateMap.put(opponentId, dateStr);
			if( !seasonProcessedGamesHolder.isGameProcessed(teamId, opponentId, dateStr)) {
				currentGame = new GameInfoDto();
			
				Date gameDate = null;
				try {
					gameDate = formatter.parse(dateStr);
				} catch (ParseException e) {
					logger.error("Error parsing game date", e);
				}
				currentGame.setGameDate(gameDate);
			
				boolean homeTeam = isHomeTeam(currentGame, opponent);
				setTeamIds(currentGame, teamId, homeTeam, opponentId);
			
				setTeamStats(currentGame, homeTeam);
			
				String scoreRaw = rowCells.get(2).text();
				setScore(currentGame, scoreRaw, homeTeam);
			
				String attendanceStr = rowCells.get(4).text();
				int attendance = getAttendance(attendanceStr);
				currentGame.setAttendance(attendance);
			
				seasonProcessedGamesHolder.setGameProcessed(teamId, opponentId, dateStr);
			} else {
				//add nulls to skip already processed games
				teamStats.add(null);
				opponentsStats.add(null);
			}
			
			result.add(currentGame);
		}
		
		return result;
	}
	
	private boolean isHomeTeam(GameInfoDto currentGame, String opponent) {
		boolean homeTeam = false;
		if(opponent.startsWith("@")) {
			//away game
		} else if( !opponent.startsWith("+")) {
			//home game
			homeTeam = true;
		} else {
			//neutral venue
			homeTeam = true;
			currentGame.setNeutralVenue(true);
		}
		
		return homeTeam;
	}
	
	private void setTeamIds(GameInfoDto currentGame, int teamId, boolean homeTeam, int opponentId) {
		if(homeTeam) {
			currentGame.setHomeTeamId(teamId);
			currentGame.setAwayTeamId(opponentId);
		} else {
			currentGame.setHomeTeamId(opponentId);
			currentGame.setAwayTeamId(teamId);
		}
	}
	
	private void setTeamStats(GameInfoDto currentGame, boolean homeTeam) {
		TeamGameStatsDto homeTeamStats = new TeamGameStatsDto();
		currentGame.setHomeTeamStats(homeTeamStats);
		TeamGameStatsDto awayTeamStats = new TeamGameStatsDto();
		currentGame.setAwayTeamStats(awayTeamStats);
		if(homeTeam) {
			teamStats.add(homeTeamStats);
			opponentsStats.add(awayTeamStats);
		} else {
			teamStats.add(awayTeamStats);
			opponentsStats.add(homeTeamStats);
		}
	}
	
	private void setScore(GameInfoDto currentGame, String scoreRaw, boolean homeTeam) {
		String points = scoreRaw.substring(2);
		String[] pointsArray = points.split("-");
		
		int teamPoints = Integer.valueOf(pointsArray[0]);
		int opponentPoints = Integer.valueOf(pointsArray[1]);
		if(homeTeam) {
			currentGame.setHomeTeamPoints(teamPoints);
			currentGame.setAwayTeamPoints(opponentPoints);
		} else {
			currentGame.setHomeTeamPoints(opponentPoints);
			currentGame.setAwayTeamPoints(teamPoints);
		}
	}
	
	private int getAttendance(String attendanceStr) {
		attendanceStr = attendanceStr.replace(",", "");
		return Integer.valueOf(attendanceStr);
	}
	
	private String buildComponentGamelogURL(int teamId, int year, String component, String teamMarker) {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(CFBStatsURLConts.rootURL);
		urlBuilder.append(year);
		urlBuilder.append("/team/" + teamId);
		urlBuilder.append("/" + component);
		if(teamMarker != null && !teamMarker.isEmpty()) {
			urlBuilder.append("/" + teamMarker);
		}
		urlBuilder.append("/gamelog.html");
		
		return urlBuilder.toString();
	}
	
	private Elements getTableRows(int teamId, int year, String component, String teamMarker) {
		String url = buildComponentGamelogURL(teamId, year, component, teamMarker);
		Document doc = documentGetter.getDocument(url);
		
		Elements tableRows = doc.select("tbody > *");
		removeHeadersAndFooters(tableRows);
		
		return tableRows;
	}
	
	private void removeHeadersAndFooters(Elements tableRows) {
		tableRows.remove(tableRows.size() - 1);
		boolean allHeadersRemoved = false;
		do {
			Element currentRow = tableRows.get(0);
			Elements headers = currentRow.select("th");
			if( !headers.isEmpty()) {
				tableRows.remove(0);
			} else {
				allHeadersRemoved = true;
			}
		} while( !allHeadersRemoved);
	}
	
	private Elements getOpponentsDefenseTableRows(int teamId, int year, String component) {
		Elements result = new Elements();
		int gameInd = 0;
		for(Map.Entry<Integer, String> entry : defenseOpponentToDateMap.entrySet()) {
			Element currentOpponentStats = null;
			Integer opponentId = entry.getKey();
			String date = entry.getValue();
			TeamGameStatsDto teamStats = opponentsStats.get(gameInd);
			if(opponentId != -1 && teamStats != null) {
				String url = buildComponentGamelogURL(opponentId, year, component, null);
				Document doc = documentGetter.getDocument(url);

				Elements tableRows = doc.select("tbody > *");
				removeHeadersAndFooters(tableRows);
				currentOpponentStats = getSpecificGameRow(tableRows, date, teamId);
			}
			result.add(currentOpponentStats);
			
			++gameInd;
		}
		
		return result;
	}
	
	private Element getSpecificGameRow(Elements tableRows, String date, int teamId) {
		Element result = null;
		for(Element row : tableRows) {
			Elements rowCells = row.select("td");
			String currentDate = rowCells.get(0).text();
			if(date.equals(currentDate)) {
				Elements opponentLink = rowCells.get(1).select("a[href]");
				int opponentId = teamIdExtractor.extractTeamId(opponentLink);
				if(teamId != opponentId) {
					throw new RuntimeException("Game on the same date against a different team");
				}
				
				result = row;
			}
		}
		
		return result;
	}
	
	private void setTeamComponentStats(int teamId, int year, String component, ComponentStatsSetter componentSetter, 
			String teamMarker, TeamStatsGetter statsGetter) {
		Elements tableRows = getTableRows(teamId, year, component, teamMarker);
		int gameInd = 0;
		for(Element row : tableRows) {
			TeamGameStatsDto teamStats = statsGetter.getTeamStats(gameInd);
			if(teamStats != null) {
				Elements rowCells = row.select("td");
				componentSetter.setTeamComponentStats(rowCells, teamStats);
			}
			
			++gameInd;
		}
	}
	
	private void setOpponentsDefenseStats(Elements tableRows, ComponentStatsSetter componentSetter) {
		int gameInd = 0;
		for(Element row : tableRows) {
			if(row != null) {
				TeamGameStatsDto teamStats = opponentsStats.get(gameInd);
				if(teamStats != null) {
					Elements rowCells = row.select("td");
					componentSetter.setTeamComponentStats(rowCells, teamStats);
				} else {
					throw new RuntimeException("Row is not null, but teamStats for opponent is null");
				}
			}
			
			++gameInd;
		}
	}
}
