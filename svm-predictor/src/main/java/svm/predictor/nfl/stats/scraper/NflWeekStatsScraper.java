package svm.predictor.nfl.stats.scraper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.dto.TeamGameStatsDto;
import svm.predictor.service.impl.DocumentGetter;

@Service("nflWeekStatsScraper")
public class NflWeekStatsScraper {

	private static Logger logger = LoggerFactory.getLogger(NflWeekStatsScraper.class);
	
	@Autowired
	private DocumentGetter documentGetter;
	
	@Value("${espn.stats.root.url}")
	private String espnStatsRootURL;
	
	private DateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
	
	public List<GameInfoDto> getGamesForWeek(int year, int week, int seasonType, Map<String, Integer> teamMap) {
		String url = espnStatsRootURL + "_/year/" + year + "/seasontype/" + seasonType + "/week/" + week;
		Document doc = documentGetter.getDocument(url);
		
		Elements tableRows = doc.select("table.tablehead > tbody > *");
		Element headerRow = tableRows.get(0);
		String headerText = headerRow.text();
		boolean playoffs = headerText.contains("Playoffs");
		//remove the row that lists the teams with a bye
		boolean byeRow = isByeRow(tableRows.get(tableRows.size() - 1));
		if(byeRow) {
			tableRows.remove(tableRows.size() - 1);
		}
		//remove header row
		tableRows.remove(0);
		List<GameInfoDto> result = new ArrayList<GameInfoDto>();
		for(Element row : tableRows) {
			if( !row.className().equals("colhead") && !row.className().equals("stathead")) {
				GameInfoDto currentGame = null;
			
				Elements rowCells = row.select("td");
				Elements gameLink = rowCells.get(0).select("a[href]");
				Element tvTickets = rowCells.get(2);
				String link = "";
				if( !gameLink.isEmpty() && !"Postponed".equals(tvTickets.text())) {
					link = gameLink.attr("abs:href");
					currentGame = getGameInfo(link, teamMap);
					currentGame.setLeague(League.NFL);
					result.add(currentGame);
				}
			}
		}
		
		if(playoffs) {
			GameInfoDto superbowl = result.get(result.size() - 1);
			superbowl.setNeutralVenue(true);
			logger.info("Superbowl {} set neutral field", year);
		}
		
		return result;
	}
	
	private GameInfoDto getGameInfo(String link, Map<String, Integer> teamMap) {
		GameInfoDto result = new GameInfoDto();
		
		Document doc = documentGetter.getDocument(link);
		
		Elements dateLocation = doc.select("div.game-time-location > *");
		String date = dateLocation.get(0).text();
		date = removeTimeFromDate(date);
		Date gameDate = null;
		try {
			gameDate = formatter.parse(date);
		} catch (ParseException e) {
			logger.error("Error parsing date", e);
			throw new RuntimeException("Error parsing game date");
		}
		result.setGameDate(gameDate);
		String location = dateLocation.get(1).text();
		boolean neutralVenue = isNeutralVenue(location);
		result.setNeutralVenue(neutralVenue);
		
		Elements tables = doc.select("table.mod-data");
		tables.remove(0);
		
		Element awayPassing = tables.get(1);
		String awayName = getTeamName(awayPassing);
		int awayTeamId = teamMap.get(awayName);
		result.setAwayTeamId(awayTeamId);
		Element homePassing = tables.get(2);
		String homeName = getTeamName(homePassing);
		int homeTeamId = teamMap.get(homeName);
		result.setHomeTeamId(homeTeamId);
		
		TeamGameStatsDto homeStats = new TeamGameStatsDto();
		TeamGameStatsDto awayStats = new TeamGameStatsDto();
		setBaseStats(homeStats, awayStats, tables.get(0));
		
		Element awayTable = findTableByName(tables, awayName, "Passing");
		Element homeTable = findTableByName(tables, homeName, "Passing");
		setPassingStats(awayStats, awayTable);
		setPassingStats(homeStats, homeTable);
		swapSacks(homeStats, awayStats);
		
		awayTable = findTableByName(tables, awayName, "Rushing");
		homeTable = findTableByName(tables, homeName, "Rushing");
		setRushingStats(awayStats, awayTable);
		setRushingStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Receiving");
		homeTable = findTableByName(tables, homeName, "Receiving");
		setReceivingStats(awayStats, awayTable);
		setReceivingStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Fumbles");
		homeTable = findTableByName(tables, homeName, "Fumbles");
		setFumbleStats(awayStats, awayTable);
		setFumbleStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Interceptions");
		homeTable = findTableByName(tables, homeName, "Interceptions");
		setInterceptionStats(awayStats, awayTable);
		setInterceptionStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Defensive");
		homeTable = findTableByName(tables, homeName, "Defensive");
		setDefensiveStats(awayStats, awayTable);
		setDefensiveStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Kick Returns");
		homeTable = findTableByName(tables, homeName, "Kick Returns");
		setKickReturnStats(awayStats, awayTable);
		setKickReturnStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Punt Returns");
		homeTable = findTableByName(tables, homeName, "Punt Returns");
		setPuntReturnStats(awayStats, awayTable);
		setPuntReturnStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Kicking");
		homeTable = findTableByName(tables, homeName, "Kicking");
		setKickingStats(awayStats, awayTable);
		setKickingStats(homeStats, homeTable);
		
		awayTable = findTableByName(tables, awayName, "Punting");
		homeTable = findTableByName(tables, homeName, "Punting");
		setPuntingStats(awayStats, awayTable);
		setPuntingStats(homeStats, homeTable);
		
		int awayPoints = getTeamPoints(doc, false);
		result.setAwayTeamPoints(awayPoints);
		awayStats.setScoringOffPoints(awayPoints);
		int homePoints = getTeamPoints(doc, true);
		result.setHomeTeamPoints(homePoints);
		homeStats.setScoringOffPoints(homePoints);
		
		int attendance = getAttendance(doc);
		result.setAttendance(attendance);
		
		result.setHomeTeamStats(homeStats);
		result.setAwayTeamStats(awayStats);
		return result;
	}
	
	private void setBaseStats(TeamGameStatsDto homeStats, TeamGameStatsDto awayStats, Element table) {
		Elements tableRows = table.select("tbody > *");
		
		HomeAwayValue values = getValuesFromRow(tableRows.get(0));
		homeStats.setFirstDownOffTotal(Integer.valueOf(values.homeValue));
		awayStats.setFirstDownOffTotal(Integer.valueOf(values.awayValue));
		
		values = getValuesFromRow(tableRows.get(1));
		homeStats.setFirstDownOffPass(Integer.valueOf(values.homeValue));
		awayStats.setFirstDownOffPass(Integer.valueOf(values.awayValue));
		
		values = getValuesFromRow(tableRows.get(2));
		homeStats.setFirstDownOffRush(Integer.valueOf(values.homeValue));
		awayStats.setFirstDownOffRush(Integer.valueOf(values.awayValue));
		
		values = getValuesFromRow(tableRows.get(3));
		homeStats.setFirstDownOffPenalty(Integer.valueOf(values.homeValue));
		awayStats.setFirstDownOffPenalty(Integer.valueOf(values.awayValue));
		
		values = getValuesFromRow(tableRows.get(4));
		setThirdDownStats(homeStats, values.homeValue);
		setThirdDownStats(awayStats, values.awayValue);
		
		values = getValuesFromRow(tableRows.get(5));
		setFourthDownStats(homeStats, values.homeValue);
		setFourthDownStats(awayStats, values.awayValue);

		values = getValuesFromRow(tableRows.get(6));
		homeStats.setTotalOffPlays(Integer.valueOf(values.homeValue));
		awayStats.setTotalOffPlays(Integer.valueOf(values.awayValue));
		
		values = getValuesFromRow(tableRows.get(7));
		homeStats.setTotalOffYards(Integer.valueOf(values.homeValue));
		awayStats.setTotalOffYards(Integer.valueOf(values.awayValue));
		
		values = getValuesFromRow(tableRows.get(8));
		homeStats.setTotalOffYPP(Double.valueOf(values.homeValue));
		awayStats.setTotalOffYPP(Double.valueOf(values.awayValue));
		
		values = getValuesFromRow(tableRows.get(18));
		setRedZoneStats(homeStats, values.homeValue);
		setRedZoneStats(awayStats, values.awayValue);
		
		values = getValuesFromRow(tableRows.get(19));
		setPenaltyStats(homeStats, values.homeValue);
		setPenaltyStats(awayStats, values.awayValue);
		
		values = getValuesFromRow(tableRows.get(20));
		int homeTurnovers = Integer.valueOf(values.homeValue);
		int awayTurnovers = Integer.valueOf(values.awayValue);
		homeStats.setTurnoverMargin(awayTurnovers - homeTurnovers);
		awayStats.setTurnoverMargin(homeTurnovers - awayTurnovers);
	}
	
	private void setThirdDownStats(TeamGameStatsDto teamStats, String value) {
		String[] split = value.split("-");
		int thirdDownAtt = Integer.valueOf(split[1]);
		int thirdDownConv = Integer.valueOf(split[0]);
		teamStats.setThirdDownOffAtt(thirdDownAtt);
		teamStats.setThirdDownOffConv(thirdDownConv);
		teamStats.setThirdDownOffConvPct(getPercent(thirdDownConv, thirdDownAtt));
	}
	
	private void setFourthDownStats(TeamGameStatsDto teamStats, String value) {
		String[] split = value.split("-");
		int fourthDownAtt = Integer.valueOf(split[1]);
		int fourthDownConv = Integer.valueOf(split[0]);
		teamStats.setFourthDownOffAtt(fourthDownAtt);
		teamStats.setFourthDownOffConv(fourthDownConv);
		teamStats.setFourthDownOffConvPct(getPercent(fourthDownConv, fourthDownAtt));
	}
	
	private void setRedZoneStats(TeamGameStatsDto teamStats, String value) {
		String[] split = value.split("-");
		int tds = Integer.valueOf(split[0]);
		int atts = Integer.valueOf(split[1]);
		teamStats.setOffRedZoneAtt(atts);
		teamStats.setOffRedZoneTDs(tds);
		teamStats.setOffRedZoneTDPct(getPercent(tds, atts));
	}
	
	private void setPenaltyStats(TeamGameStatsDto teamStats, String value) {
		String[] split = value.split("-");
		teamStats.setPenalties(Integer.valueOf(split[0]));
		teamStats.setPenaltyYards(Integer.valueOf(split[1]));
	}
	
	private String getTeamName(Element passingTable) {
		String namePassing = getTableName(passingTable);
		int passingIndex = namePassing.indexOf(" Passing");
		String name = namePassing.substring(0, passingIndex);
		return name;
	}
	
	private String getTableName(Element table) {
		Elements headers = table.select("th");
		String name = headers.get(0).text();
		return name;
	}
	
	private Element findTableByName(Elements tables, String teamName, String componentName) {
		Element result = null;
		for(Element table : tables) {
			String tableName = getTableName(table);
			if(tableName.equals(teamName + " " + componentName)) {
				result = table;
				break;
			}
		}
		
		return result;
	}
	
	private void setPassingStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String compAtt = footerCells.get(1).text();
			String[] split = compAtt.split("/");
			int comp = Integer.valueOf(split[0]);
			int att = Integer.valueOf(split[1]);
			Double compPct = getPercent(comp, att);
			teamStats.setPassOffAtt(att);
			teamStats.setPassOffComp(comp);
			teamStats.setPassOffCompPct(compPct);
			String yards = footerCells.get(2).text();
			teamStats.setPassOffYards(Integer.valueOf(yards));
			String ypa = footerCells.get(3).text();
			teamStats.setPassOffYPA(Double.valueOf(ypa));
			String tds = footerCells.get(4).text();
			teamStats.setPassOffTDs(Integer.valueOf(tds));
			String ints = footerCells.get(5).text();
			teamStats.setPassOffINTs(Integer.valueOf(ints));
			String sacks = footerCells.get(6).text();
			split = sacks.split("-");
			teamStats.setSacks(Integer.valueOf(split[0]));
			teamStats.setSackYards(Integer.valueOf(split[1]));
		}
	}
	
	private void setRushingStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String att = footerCells.get(1).text();
			teamStats.setRushOffAtt(Integer.valueOf(att));
			String yards = footerCells.get(2).text();
			teamStats.setRushOffYards(Integer.valueOf(yards));
			String ypa = footerCells.get(3).text();
			teamStats.setRushOffYPA(Double.valueOf(ypa));
			String tds = footerCells.get(4).text();
			teamStats.setRushOffTDs(Integer.valueOf(tds));
		}
	}
	
	private void setReceivingStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String ypr = footerCells.get(3).text();
			teamStats.setPassOffYPR(Double.valueOf(ypr));
		}
	}
	
	private void setFumbleStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String lost = footerCells.get(2).text();
			teamStats.setFubmleLost(Integer.valueOf(lost));
			String recovered = footerCells.get(3).text();
			teamStats.setFumbleGain(Integer.valueOf(recovered));
		}
	}
	
	private void setInterceptionStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String ints = footerCells.get(1).text();
			teamStats.setPassDefInts(Integer.valueOf(ints));
			String yards = footerCells.get(2).text();
			teamStats.setPassDefIntYards(Integer.valueOf(yards));
			String tds = footerCells.get(3).text();
			teamStats.setPassDefIntTDs(Integer.valueOf(tds));
		}
	}
	
	private void setDefensiveStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String totalTackles = footerCells.get(1).text();
			teamStats.setTotalTackles(Integer.valueOf(totalTackles));
			String tfls = footerCells.get(4).text();
			teamStats.setTFLs(Integer.valueOf(tfls));
			String passesDefended = footerCells.get(5).text();
			teamStats.setPassesBrokenUp(Integer.valueOf(passesDefended));
			String qbHits = footerCells.get(6).text();
			teamStats.setQBHurries(Integer.valueOf(qbHits));
		}
	}
	
	private void setKickReturnStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String number = footerCells.get(1).text();
			teamStats.setKickoffReturns(Integer.valueOf(number));
			String yards = footerCells.get(2).text();
			teamStats.setKickoffReturnYards(Integer.valueOf(yards));
			String avg = footerCells.get(3).text();
			teamStats.setKickoffReturnAverage(Double.valueOf(avg));
			String tds = footerCells.get(5).text();
			teamStats.setKickoffReturnTDs(Integer.valueOf(tds));
		}
	}
	
	private void setPuntReturnStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String number = footerCells.get(1).text();
			teamStats.setPuntReturns(Integer.valueOf(number));
			String yards = footerCells.get(2).text();
			teamStats.setPuntReturnYards(Integer.valueOf(yards));
			String avg = footerCells.get(3).text();
			teamStats.setPuntReturnAverage(Double.valueOf(avg));
			String tds = footerCells.get(5).text();
			teamStats.setPuntReturnTDs(Integer.valueOf(tds));
		}
	}
	
	private void setKickingStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String fieldGoals = footerCells.get(1).text();
			String[] split = fieldGoals.split("/");
			teamStats.setFGOffMade(Integer.valueOf(split[0]));
			teamStats.setFGOffAtt(Integer.valueOf(split[1]));
			String pct = footerCells.get(2).text(); 
			teamStats.setFGOffPct(Double.valueOf(pct));
		}
	}
	
	private void setPuntingStats(TeamGameStatsDto teamStats, Element table) {
		Elements footerCells = getTeamFooter(table);
		if(footerCells != null) {
			String number = footerCells.get(1).text();
			teamStats.setPunts(Integer.valueOf(number));
			String yards = footerCells.get(2).text();
			teamStats.setPuntYards(Integer.valueOf(yards));
			String avg = footerCells.get(3).text();
			teamStats.setPuntAverage(Double.valueOf(avg));
		}
	}
	
	private Elements getTeamFooter(Element table) {
		Elements result = null;
		if(table != null) {
			Elements headers = table.select("thead > *");
			Element teamFooter = headers.get(headers.size() - 1);
			Elements cells = teamFooter.select("th");
			String firstCellText = cells.get(0).text();
			if(firstCellText.equals("Team")) {
				result = cells;
			}
		}
		
		return result;
	}
	
	private Double getPercent(int partValue, int wholeValue) {
		return wholeValue > 0 ? (((double)partValue) / wholeValue) * 100 : null;
	}
	
	private void swapSacks(TeamGameStatsDto homeTeamStats, TeamGameStatsDto awayTeamStats) {
		int homeSacks = awayTeamStats.getSacks();
		int homeSackYards = awayTeamStats.getSackYards();
		awayTeamStats.setSacks(homeTeamStats.getSacks());
		awayTeamStats.setSackYards(homeTeamStats.getSackYards());
		homeTeamStats.setSacks(homeSacks);
		homeTeamStats.setSackYards(homeSackYards);
	}
	
	private String removeTimeFromDate(String date) {
		int dateInd = date.indexOf(",");
		if(dateInd > -1) {
			date = date.substring(dateInd + 2);
		}
		
		return date;
	}
	
	private int getTeamPoints(Document document, boolean isHome) {
		String homeAway = isHome ? "home" : "away"; 
		Elements teamDiv = document.select("div.team." + homeAway);
		Elements spans = teamDiv.select("span");
		String points = spans.get(0).text();
		return Integer.valueOf(points);
	}
	
	private int getAttendance(Document document) {
		int result = 0;
		Elements spans = document.select("span.bi");
		for(Element span : spans) {
			if(span.text().equals("Attendance:")) {
				String attendanceText = span.parent().text();
				String[] split = attendanceText.split(" ");
				String attendance = split[1].replace(",", "");
				if( !attendance.equals("NA")) {
					result = Integer.valueOf(attendance);
				} else {
					logger.info("Attendance not available");
				}
				
				break;
			}
		}
		
		return result;
	}
	
	private boolean isNeutralVenue(String location) {
		//except Superbowl, consider only games played in London or Toronto as neutral,
		//other neutral venues are very rare, and occur mainly due to bad weather
		return location.contains("London") || location.contains("Toronto");
	}
	
	private boolean isByeRow(Element tableRow) {
		String rowText = tableRow.text();
		return rowText.contains("Bye:");
	}
	
	private HomeAwayValue getValuesFromRow(Element tableRow) {
		Elements rowCells = tableRow.select("td");
		HomeAwayValue values = new HomeAwayValue();
		values.awayValue = rowCells.get(1).text();
		values.homeValue = rowCells.get(2).text();
		
		return values;
	}
	
	private static class HomeAwayValue {
		private String homeValue;
		private String awayValue;
	}
}
