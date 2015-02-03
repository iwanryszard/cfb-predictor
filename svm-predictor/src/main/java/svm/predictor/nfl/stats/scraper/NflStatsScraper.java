package svm.predictor.nfl.stats.scraper;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.service.GameInfoService;
import svm.predictor.service.TeamService;

@Service("nflStatsScraper")
public class NflStatsScraper {

	private static Logger logger = LoggerFactory.getLogger(NflStatsScraper.class);
	
	@Autowired
	private NflWeekStatsScraper nflWeekStatsScraper;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private GameInfoService gameInfoService;
	
	public void createAllSeasonStats(int startYear, int endYear) {
		
		Map<String, Integer> teamMap = teamService.getNameToIdMap(League.NFL);
		List<GameInfoDto> gamesForWeek = null;
		
		for(int year = startYear; year <= endYear; ++year) {
			logger.info("Starting with games for year: " + year);
			int startWeek = 1;
			int endWeek = 17;
			int seasonType = 2;
			for(int week = startWeek; week <= endWeek; ++week) {
				gamesForWeek = nflWeekStatsScraper.getGamesForWeek(year, week, seasonType, teamMap);
				logger.info("Fetched {} games for year: {} week: {}", gamesForWeek.size(), year, week);
				gameInfoService.createGameInfos(gamesForWeek);
				logger.info("Games persisted");
			}
			//get postseason games
			seasonType = 3;
			gamesForWeek = nflWeekStatsScraper.getGamesForWeek(year, startWeek, seasonType, teamMap);
			logger.info("Fetched {} games for year: {} postseason", gamesForWeek.size(), year);
			gameInfoService.createGameInfos(gamesForWeek);
			logger.info("Games persisted");
		}
	}
}
