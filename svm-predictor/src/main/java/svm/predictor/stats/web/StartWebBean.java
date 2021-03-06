package svm.predictor.stats.web;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.book.values.scraper.BookValuesSetter;
import svm.predictor.book.values.scraper.MoneyLineOddsScraper;
import svm.predictor.book.values.scraper.PointSpreadScraper;
import svm.predictor.book.values.scraper.PointTotalScraper;
import svm.predictor.distance.calculation.GamesDistanceSetter;
import svm.predictor.dto.League;
import svm.predictor.nfl.stats.scraper.NflStatsScraper;
import svm.predictor.nfl.teams.NflTeamsCreator;
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
	private BookValuesSetter bookValuesSetter;
	
	@Autowired
	private TeamsStadiumLocationsSetter teamsStadiumLocationsSetter;
	
	@Autowired
	private GamesDistanceSetter gamesDistanceSetter;
	
	@Autowired
	private StatsAggregator statsAggregator;
	
	@Autowired
	private NflTeamsCreator nflTeamsCreator;
	
	@Autowired
	private NflStatsScraper nflStatsScraper;
	
	private int leagueValue;
	
	private int startYear;
	private int endYear;
	
	public void getStats() {
		try {
			League league = getLeague();
			if(league.equals(League.CFB)) {
				seasonGamesStatsScraper.createAllSeasonStats(startYear, endYear);
			} else if(league.equals(League.NFL)) {
				nflStatsScraper.createAllSeasonStats(startYear, endYear);
			}
		} catch(Exception e) {
			logger.info("Exception while getting game stats", e);
		}
	}
	
	public void getSpreads() {
		try {
			League league = getLeague();
			bookValuesSetter.setAllGamesBookValues(new PointSpreadScraper(league), startYear);
		} catch(Exception e) {
			logger.info("Exception while setting spreads", e);
		}
	}
	
	public void getPointTotals() {
		try {
			League league = getLeague();
			bookValuesSetter.setAllGamesBookValues(new PointTotalScraper(league), startYear);
		} catch(Exception e) {
			logger.info("Exception while setting point totals", e);
		}
	}
	
	public void getMoneyLineOdds() {
		try {
			League league = getLeague();
			bookValuesSetter.setAllGamesBookValues(new MoneyLineOddsScraper(league), startYear);
		} catch(Exception e) {
			logger.info("Exception while setting money lines", e);
		}
	}
	
	public void getTeams() {
		try {
			League league = getLeague();
			if(league.equals(League.CFB)) {
				teamsStadiumLocationsSetter.createAllTeams();
			} else if(league.equals(League.NFL)) {
				nflTeamsCreator.createAllNflTeams();
			}
		} catch(Exception e) {
			logger.info("Exception while getting teams", e);
		}
	}
	
	public void getDistances() {
		try {
			League league = getLeague();
			gamesDistanceSetter.setAllGamesDistances(league);
		} catch(Exception e) {
			logger.info("Exception while setting distances", e);
		}
	}
	
	public void aggregateGameStats() {
		try {
			League league = getLeague();
			statsAggregator.aggregateGamesForSeasons(startYear, endYear, league);
		} catch(Exception e) {
			logger.info("Exception while aggregating stats", e);
		}
	}

	public int getLeagueValue() {
		return leagueValue;
	}

	public void setLeagueValue(int leagueValue) {
		this.leagueValue = leagueValue;
	}
	
	private League getLeague() {
		if(leagueValue == 0) {
			return League.CFB;
		} else {
			return League.NFL;
		}
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
}
