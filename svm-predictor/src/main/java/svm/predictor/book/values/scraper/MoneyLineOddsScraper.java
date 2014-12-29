package svm.predictor.book.values.scraper;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;

public class MoneyLineOddsScraper extends BookValueScraper {

	public MoneyLineOddsScraper(League league) {
		super(league);
	}

	@Override
	public String getSpecificUrlPart() {
		return "/money-line";
	}
	
	@Override
	public BookValuesDto getBookValues(String homeValue, String awayValue) {
		BookValuesDto result = null;
		Double homeOdds = parseOdds(homeValue);
		Double awayOdds = parseOdds(awayValue);
		
		if(homeOdds != null && awayOdds != null) {
			result = new BookValuesDto();
			result.setHomeStraightOdds(homeOdds);
			result.setAwayStraightOdds(awayOdds);
		}
		
		return result;
	}

	@Override
	public void setBookValues(GameInfoDto game, BookValuesDto bookValues, boolean foundReversed) {
		Double homeOdds = bookValues.getHomeStraightOdds();
		Double awayOdds = bookValues.getAwayStraightOdds();
		if( !foundReversed) {
			game.setHomeStraightOdds(homeOdds);
			game.setAwayStraightOdds(awayOdds);
		} else {
			game.setHomeStraightOdds(awayOdds);
			game.setAwayStraightOdds(homeOdds);
		}
	}
	
	private Double parseOdds(String odds) {
		Double result = null;
		if( !odds.equals("")) {
			result = parseValue(odds);
		}
		
		return result;
	}

}
