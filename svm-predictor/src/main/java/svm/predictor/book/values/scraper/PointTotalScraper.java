package svm.predictor.book.values.scraper;

import svm.predictor.dto.GameInfoDto;

public class PointTotalScraper extends BookValueScraper {

	@Override
	public String getSpecificUrlPart() {
		return "/totals";
	}
	
	@Override
	public BookValuesDto getBookValues(String homeValue, String awayValue) {
		BookValuesDto result = null;
		Double total = parseTotal(homeValue);
		if(total == null) {
			total = parseTotal(awayValue);
		}
		
		if(total != null) {
			result = new BookValuesDto();
			result.setPointTotal(total);
		}
		
		return result;
	}

	@Override
	public void setBookValues(GameInfoDto game, BookValuesDto bookValues, boolean foundReversed) {
		Double pointTotal = bookValues.getPointTotal();
		game.setPointTotal(pointTotal);
	}
	
	private Double parseTotal(String total) {
		Double result = null;
		if( !total.equals("")) {
			int separatorIndex = total.indexOf(lineOddSeparator);
			if (separatorIndex > 0) {
				String extractedTotal = total.substring(0, separatorIndex);
				result = parseValue(extractedTotal);
			}
		}
		
		return result;
	}

}
