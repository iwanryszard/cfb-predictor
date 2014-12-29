package svm.predictor.book.values.scraper;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;

public class PointSpreadScraper extends BookValueScraper {

	public PointSpreadScraper(League league) {
		super(league);
	}

	@Override
	public BookValuesDto getBookValues(String homeValue, String awayValue) {
		BookValuesDto result = null;
		Double spread = parseSpread(homeValue);
		if(spread == null) {
			spread = parseSpread(awayValue);
			if(spread != null) {
				spread *= -1;
			}
		}
		
		if(spread != null) {
			result = new BookValuesDto();
			result.setPointSpread(spread);
		}
		
		return result;
	}

	@Override
	public void setBookValues(GameInfoDto game, BookValuesDto bookValues, boolean foundReversed) {
		Double spread = bookValues.getPointSpread();
		if(foundReversed && spread != null) {
			spread *= -1;
		}
		game.setPointSpread(spread);
	}
	
	private Double parseSpread(String spread) {
		Double result = null;
		if( !spread.equals("")) {
			if(spread.startsWith("PK")) {
				result = 0.0d;
			} else if(spread.startsWith("+") || spread.startsWith("-")) {
				int multiplier = 1;
				if(spread.startsWith("-")) {
					multiplier = -1;
				}

				int separatorIndex = spread.indexOf(lineOddSeparator);
				if(separatorIndex != -1) {
					String extractedSpread = spread.substring(1, separatorIndex);
					result = parseValue(extractedSpread);
					result *= multiplier;
				}
			}
		}
		
		return result;
	}

}
