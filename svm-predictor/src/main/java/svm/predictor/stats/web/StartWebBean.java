package svm.predictor.stats.web;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.distance.calculation.GamesDistanceSetter;
import svm.predictor.libsvm.data.retrieving.SvmFileCreator;
import svm.predictor.spreads.scraper.MoneyLineOddsScraper;
import svm.predictor.spreads.scraper.PointSpreadScraper;
import svm.predictor.spreads.scraper.PointSpreadsSetter;
import svm.predictor.spreads.scraper.PointTotalScraper;
import svm.predictor.stats.aggregation.StatsAggregator;
import svm.predictor.stats.scraper.SeasonGamesStatsScraper;
import svm.predictor.teams.scraper.TeamsStadiumLocationsSetter;

@Component("startWebBean")
@Scope("view")
public class StartWebBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4908658319328161071L;

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
	private StatsAggregator statsAggregator;
	
	@Autowired
	private SvmFileCreator svmFileCreator;
	
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
			pointSpreadsSetter.setAllGamesBookValues(new PointSpreadScraper());
		} catch(Exception e) {
			logger.info("Exception while setting spreads", e);
		}
	}
	
	public void getPointTotals() {
		try {
			pointSpreadsSetter.setAllGamesBookValues(new PointTotalScraper());
		} catch(Exception e) {
			logger.info("Exception while setting point totals", e);
		}
	}
	
	public void getMoneyLineOdds() {
		try {
			pointSpreadsSetter.setAllGamesBookValues(new MoneyLineOddsScraper());
		} catch(Exception e) {
			logger.info("Exception while setting money lines", e);
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
			statsAggregator.aggregateGamesForSeasons(2010, 2013);
		} catch(Exception e) {
			logger.info("Exception while aggregating stats", e);
		}
	}
	
	public void createSVMFiles() {
		try {
			svmFileCreator.createSVMFile(2010, 2011, "cfb", 3);
			svmFileCreator.createSVMFile(2013, 2013, "cfb.t", 3);
		} catch(Exception e) {
			logger.info("Exception while creating SVM files", e);
		}
	}
}
