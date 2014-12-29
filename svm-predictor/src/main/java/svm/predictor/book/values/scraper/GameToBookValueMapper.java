package svm.predictor.book.values.scraper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;

@Service("gameToBookValueMapper")
public class GameToBookValueMapper {

	private static Logger logger = LoggerFactory.getLogger(GameToBookValueMapper.class);
	
	private Map<String, List<String>> nameOverrides;
	
	public GameToBookValueMapper() {	
		
	}
	
	public void setBookValues(List<GameInfoDto> games, List<GameBookValueDto> bookValues, Map<Integer, String> teamMap, BookValueScraper bookValueScraper) {
		nameOverrides = getNameOverrides(bookValueScraper.getLeague());
		for(GameInfoDto game : games) {
			int awayTeamId = game.getAwayTeamId();
			int homeTeamId = game.getHomeTeamId();
			String homeTeam = teamMap.get(homeTeamId);
			String awayTeam = teamMap.get(awayTeamId);
			boolean neutralField = game.isNeutralVenue();
			BookValueMappingResult mapping = getBookValue(homeTeam, awayTeam, bookValues, neutralField);
			if(mapping == null || mapping.bookValues == null) {
				logger.info("Book values not found for: " + awayTeam + " @ " + homeTeam);
			} else {
				bookValueScraper.setBookValues(game, mapping.bookValues, mapping.foundReversed);
			}
		}
	}
	
	private BookValueMappingResult getBookValue(String homeTeam, String awayTeam, List<GameBookValueDto> bookValues, boolean neutralField) {
		BookValueMappingResult result = null;
		for(GameBookValueDto gameBookValue : bookValues) {
			boolean found = checkMatch(homeTeam, awayTeam, gameBookValue);
			boolean foundReversed = false;
			if( !found && neutralField) {
				foundReversed = checkMatch(awayTeam, homeTeam, gameBookValue);
			}
			if(found || foundReversed) {
				result = new BookValueMappingResult();
				result.bookValues = gameBookValue.getBookValues();
				if(foundReversed) {
					result.foundReversed = foundReversed;
					logger.info("Found reversed for: " + awayTeam + " @ " + homeTeam + " bookValues: " + gameBookValue.getBookValues());
				}
				break;
			}
		}
		return result;
	}
	
	private boolean checkMatch(String homeTeam, String awayTeam, GameBookValueDto gameBookValue) {
		boolean gameMatched = teamMatches(homeTeam, gameBookValue.getHomeTeam()) &&
							  teamMatches(awayTeam, gameBookValue.getAwayTeam()) &&
							  (awayTeam != null || homeTeam != null);
		return gameMatched;
	}
	
	private boolean teamMatches(String statsTeam, String booksTeam) {
		boolean matches = statsTeam == null || statsTeam.equals(booksTeam);
		if( !matches) {
			List<String> overrides = nameOverrides.get(statsTeam);
			if(overrides != null) {
				matches = overrides.contains(booksTeam);
				if(matches) {
					logger.info("Matched with override " + statsTeam + " to " + booksTeam);
				}
			}
		}
		return matches;
	}
	
	private Map<String, List<String>> getNameOverrides(League league) {
		Map<String, List<String>> nameOverrides = new HashMap<String, List<String>>();
		if(league.equals(League.CFB)) {
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
		} else if(league.equals(League.NFL)) {
			nameOverrides.put("NY Jets", Arrays.asList("N.Y. Jets"));
			nameOverrides.put("NY Giants", Arrays.asList("N.Y. Giants"));
		}
		
		return nameOverrides;
	}
	
	private static class BookValueMappingResult {
		private BookValuesDto bookValues;
		private boolean foundReversed;
	}
}
