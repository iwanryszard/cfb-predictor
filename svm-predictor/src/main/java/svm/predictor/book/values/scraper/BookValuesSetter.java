package svm.predictor.book.values.scraper;

import java.util.Date;
import java.util.HashMap;
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
import svm.predictor.service.impl.DocumentGetter;
import svm.predictor.utils.SeasonBoundariesProvider;

@Service("bookValuesSetter")
public class BookValuesSetter {

	private static Logger logger = LoggerFactory.getLogger(BookValuesSetter.class);
	
	@Autowired
	private GameInfoService gameInfoService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private DateBookValuesScraper dateBookValuesScraper;
	
	@Autowired
	private GameToBookValueMapper gameToBookValueMapper;
	
	@Autowired
	private DocumentGetter documentGetter;
	
	@Autowired
	private SeasonBoundariesProvider seasonBoundariesProvider;
	
	public void setAllGamesBookValues(BookValueScraper bookValueScraper, int startYear) {
		League league = bookValueScraper.getLeague();
		Date startDate = seasonBoundariesProvider.getSeasonStartDate(startYear);
		List<Date> gameDates = gameInfoService.getAllGameDates(league, startDate);
		Map<Integer, String> teamMap = teamService.getTeamNamesMap(league);
		
		for(Date gameDate : gameDates) {
			logger.info("Setting book values for date: " + gameDate);
			List<GameBookValueDto> bookValues = dateBookValuesScraper.getBookValues(gameDate, bookValueScraper);
			logger.info("Fetched " + bookValues.size() + " book values");
			if( !bookValues.isEmpty()) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("gameDate", gameDate);
				params.put("league", league);
				List<GameInfoDto> games = gameInfoService.list(params, null);
				logger.info("Found " + games.size() + " games");
				
				gameToBookValueMapper.setBookValues(games, bookValues, teamMap, bookValueScraper);
			
				gameInfoService.updateGameInfos(games);
				logger.info("Book values persisted");
			} else {
				logger.info("No book values found for date: " + gameDate);
			}
			logger.info("Finished setting book values for date: " + gameDate);
		}
	}
}
