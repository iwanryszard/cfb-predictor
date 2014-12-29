package svm.predictor.book.values.scraper;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;

public abstract class BookValueScraper {
	
	protected static String HALF = "½";
	protected static String lineOddSeparator = Character.toString((char)160);
	
	protected String sportUrlPart;
	protected League league;
	
	public BookValueScraper(League league) {
		this.league = league;
		if(league.equals(League.CFB)) {
			this.sportUrlPart = "college-football";
		} else if(league.equals(League.NFL)) {
			this.sportUrlPart = "nfl-football";
		}
	}

	public String getSpecificUrlPart() {
		return "";
	}
	
	public abstract BookValuesDto getBookValues(String homeValue, String awayValue);
	
	public abstract void setBookValues(GameInfoDto game, BookValuesDto bookValues, boolean foundReversed);
	
	protected Double parseValue(String value) {
		Double result = null;
		int halfIndex = value.indexOf(HALF);
		double halfAdd = 0.0d;
		if(halfIndex != -1) {
			value = value.substring(0, halfIndex);
			halfAdd = 0.5d;
		}
		Double decimalPart;
		try {
			decimalPart = Double.valueOf(value);
		} catch(NumberFormatException e) {
			throw new RuntimeException("Cannot parse value: " + value, e);
		}
		result = decimalPart + halfAdd;
		return result;
	}

	public String getSportUrlPart() {
		return sportUrlPart;
	}

	public void setSportUrlPart(String sportUrlPart) {
		this.sportUrlPart = sportUrlPart;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
}
