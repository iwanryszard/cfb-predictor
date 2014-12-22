package svm.predictor.spreads.scraper;

public class GameBookValueDto {

	private String homeTeam;
	private String awayTeam;
	private BookValuesDto bookValues;
	
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public BookValuesDto getBookValues() {
		return bookValues;
	}
	public void setBookValues(BookValuesDto bookValues) {
		this.bookValues = bookValues;
	}

}
