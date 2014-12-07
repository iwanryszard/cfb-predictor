package svm.predictor.stats.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.distance.calculation.GamesDistanceSetter;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;
import svm.predictor.service.GameInfoService;
import svm.predictor.spreads.scraper.PointSpreadsSetter;
import svm.predictor.stats.scraper.SeasonGamesStatsScraper;
import svm.predictor.teams.scraper.TeamsStadiumLocationsSetter;

@Component("startWebBean")
@Scope("view")
public class StartWebBean implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(StartWebBean.class);
	
	@Autowired
	private SeasonGamesStatsScraper seasonGamesStatsScraper;
	
	@Autowired
	private PointSpreadsSetter pointSpreadsSetter;
	
	@Autowired
	private TeamsStadiumLocationsSetter teamsStadiumLocationsSetter;
	
	@Autowired
	private GamesDistanceSetter gamesDistanceSetter;
	
	@Autowired
	private GameInfoService gameInfoService;
	
	public String getStartMessage() {
		logger.info("getStartMessage called...");
		return "Current time in millis: " + System.currentTimeMillis();
	}
	
	public void getStats() {
		try {
			seasonGamesStatsScraper.createAllSeasonStats();
		} catch(Exception e) {
			logger.info("Exception while getting game stats", e);
		}
	}
	
	public void getSpreads() {
		try {
			pointSpreadsSetter.setAllGamesPointSpreads();
		} catch(Exception e) {
			logger.info("Exception while setting spreads", e);
		}
	}
	
	public void getTeams() {
		try {
			teamsStadiumLocationsSetter.createAllTeams();
		} catch(Exception e) {
			logger.info("Exception while getting teams", e);
		}
	}
	
	public void getDistances() {
		try {
			gamesDistanceSetter.setAllGamesDistances();
		} catch(Exception e) {
			logger.info("Exception while setting distances", e);
		}
	}
	
	public void aggregateGameStats() {
		try {
			Calendar cal = Calendar.getInstance();
			cal.set(2013, Calendar.AUGUST, 15);
			Date seasonStart = cal.getTime();
			cal.set(2014, Calendar.JANUARY, 20);
			Date currentGame = cal.getTime();
			TeamAggregatedGameStatsDto stats = gameInfoService.getTeamAggregatedStats(472, seasonStart, currentGame);
			stats.toString();
			TeamSimpleAggregatedStats last5Games = gameInfoService.getPreviousNGamesStats(472, 5, currentGame);
			last5Games.toString();
			TeamSimpleAggregatedStats lastSeason = gameInfoService.getSimpleSeasonStats(472, seasonStart, currentGame);
			lastSeason.toString();
		} catch(Exception e) {
			logger.info("Exception while aggregating stats", e);
		}
	}
}
