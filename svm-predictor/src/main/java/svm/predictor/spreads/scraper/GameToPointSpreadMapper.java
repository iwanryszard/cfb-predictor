package svm.predictor.spreads.scraper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.GameSpreadDto;

@Service("gameToPointSpreadMapper")
public class GameToPointSpreadMapper {

	private static Logger logger = LoggerFactory.getLogger(GameToPointSpreadMapper.class);
	
	private Map<String, List<String>> nameOverrides;
	
	public GameToPointSpreadMapper() {	
		nameOverrides = new HashMap<String, List<String>>();
		nameOverrides.put("SMU", Arrays.asList("Southern Methodist"));
		nameOverrides.put("UCF", Arrays.asList("Central Florida"));
		nameOverrides.put("Miami (Florida)", Arrays.asList("Miami", "Miami (FL)"));
		nameOverrides.put("Miami (Ohio)", Arrays.asList("Miami (OH)"));
		nameOverrides.put("North Carolina State", Arrays.asList("NC State"));
		nameOverrides.put("TCU", Arrays.asList("Texas Christian"));
		nameOverrides.put("UAB", Arrays.asList("Alabama-Birmingham"));
		nameOverrides.put("UTEP", Arrays.asList("Texas El Paso"));
		nameOverrides.put("UTSA", Arrays.asList("Texas-San Antonio"));
		nameOverrides.put("BYU", Arrays.asList("Brigham Young"));
		nameOverrides.put("Hawai'i", Arrays.asList("Hawaii"));
		nameOverrides.put("USC", Arrays.asList("Southern California"));
		nameOverrides.put("LSU", Arrays.asList("Louisiana State"));
		nameOverrides.put("Louisiana-Lafayette", Arrays.asList("UL Lafayette"));
		nameOverrides.put("Louisiana-Monroe", Arrays.asList("UL Monroe"));
		nameOverrides.put("Mississippi", Arrays.asList("Ole Miss"));
		nameOverrides.put("Southern Mississippi", Arrays.asList("Southern Miss"));
	}
	
	public void setPointSpreads(List<GameInfoDto> games, List<GameSpreadDto> spreads, Map<Integer, String> teamMap) {
		for(GameInfoDto game : games) {
			int awayTeamId = game.getAwayTeamId();
			int homeTeamId = game.getHomeTeamId();
			String homeTeam = teamMap.get(homeTeamId);
			String awayTeam = teamMap.get(awayTeamId);
			boolean neutralField = game.isNeutralVenue();
			Double spread = getSpread(homeTeam, awayTeam, spreads, neutralField);
			if(spread == null) {
				logger.info("Spread not found for: " + awayTeam + " @ " + homeTeam);
			}
			game.setPointSpread(spread);
		}
	}
	
	private Double getSpread(String homeTeam, String awayTeam, List<GameSpreadDto> spreads, boolean neutralField) {
		Double result = null;
		for(GameSpreadDto gameSpread : spreads) {
			boolean found = checkMatch(homeTeam, awayTeam, gameSpread);
			boolean foundReversed = false;
			if( !found && neutralField) {
				foundReversed = checkMatch(awayTeam, homeTeam, gameSpread);
			}
			if(found || foundReversed) {
				result = gameSpread.getSpread();
				if(foundReversed && result != null) {
					result *= -1;
					logger.info("Found reversed for: " + awayTeam + " @ " + homeTeam + " spread: " + result);
				}
				break;
			}
		}
		return result;
	}
	
	private boolean checkMatch(String homeTeam, String awayTeam, GameSpreadDto gameSpread) {
		boolean gameMatched = teamMatches(homeTeam, gameSpread.getHomeTeam()) &&
							  teamMatches(awayTeam, gameSpread.getAwayTeam()) &&
							  (awayTeam != null || homeTeam != null);
		return gameMatched;
	}
	
	private boolean teamMatches(String statsTeam, String spreadsTeam) {
		boolean matches = statsTeam == null || statsTeam.equals(spreadsTeam);
		if( !matches) {
			List<String> overrides = nameOverrides.get(statsTeam);
			if(overrides != null) {
				matches = overrides.contains(spreadsTeam);
				if(matches) {
					logger.info("Matched with override " + statsTeam + " to " + spreadsTeam);
				}
			}
		}
		return matches;
	}
}
