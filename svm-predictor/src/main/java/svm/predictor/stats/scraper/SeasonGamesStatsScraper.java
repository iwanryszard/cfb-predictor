package svm.predictor.stats.scraper;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.service.GameInfoService;
import svm.predictor.service.TeamService;
import svm.predictor.service.impl.DocumentGetter;

@Service("seasonGamesStatsScraper")
public class SeasonGamesStatsScraper {

	private static Logger logger = LoggerFactory.getLogger(SeasonGamesStatsScraper.class);
	
	@Autowired
	private DocumentGetter documentGetter;
	
	@Autowired
	private GameInfoService gameInfoService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private ComponentStatsSettersHolder componentStatsSettersHolder;
	
	@Value("${cfb.stats.root.url}")
	private String cfbStatsRootURL;
	
	public void createAllSeasonStats(int startYear, int endYear) {
		
		Map<Integer, String> teamMap = teamService.getTeamNamesMap(League.CFB);
		
		for(int year = startYear; year <= endYear; ++year) {
			logger.info("Starting with games for year: " + year);
			SeasonProcessedGamesHolder seasonProcessedGamesHolder = new SeasonProcessedGamesHolder(teamMap);
			for(Integer teamId : teamMap.keySet()) {
				logger.info("Starting with games for teamId: " + teamId);
				TeamSeasonGamesStatsScraper teamStatsScraper = new TeamSeasonGamesStatsScraper(teamId, year,
						componentStatsSettersHolder, seasonProcessedGamesHolder, documentGetter, cfbStatsRootURL);
				List<GameInfoDto> gameStats = teamStatsScraper.getTeamSeasonGameStats();
				logger.info("Scraped games for teamId: " + teamId);
				gameInfoService.createGameInfos(gameStats);
				logger.info("Persisted games for teamId: " + teamId);
			}
			logger.info("Finished with games for year: " + year);
		}
	}
}
