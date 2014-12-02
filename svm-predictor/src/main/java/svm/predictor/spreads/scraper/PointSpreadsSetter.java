package svm.predictor.spreads.scraper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.GameSpreadDto;
import svm.predictor.service.GameInfoService;
import svm.predictor.service.TeamService;
import svm.predictor.service.impl.DocumentGetter;

@Service("pointSpreadsSetter")
public class PointSpreadsSetter {

	private static Logger logger = LoggerFactory.getLogger(PointSpreadsSetter.class);
	
	@Autowired
	private GameInfoService gameInfoService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private DatePointSpreadsScraper datePointSpreadsScraper;
	
	@Autowired
	private GameToPointSpreadMapper gameToPointSpreadMapper;
	
	@Autowired
	private DocumentGetter documentGetter;
	
	public void setAllGamesPointSpreads() {
		List<Date> gameDates = gameInfoService.getAllGameDates();
		Map<Integer, String> teamMap = teamService.getTeamNamesMap();
		
		for(Date gameDate : gameDates) {
			logger.info("Setting spreads for date: " + gameDate);
			List<GameSpreadDto> spreads = datePointSpreadsScraper.getSpreads(gameDate);
			logger.info("Fetched " + spreads.size() + " spreads");
			if( !spreads.isEmpty()) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("gameDate", gameDate);
				List<GameInfoDto> games = gameInfoService.list(params, null);
				logger.info("Found " + games.size() + " games");
				
				gameToPointSpreadMapper.setPointSpreads(games, spreads, teamMap);
			
				gameInfoService.updateGameInfos(games);
				logger.info("Spreads persisted");
			} else {
				logger.info("No spreads found for date: " + gameDate);
			}
			logger.info("Finished setting spreads for date: " + gameDate);
		}
	}
}
