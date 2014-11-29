package svm.predictor.dto;

public class GameSpreadDto {

	private String homeTeam;
	private String awayTeam;
	private Double spread;
	
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
	public Double getSpread() {
		return spread;
	}
	public void setSpread(Double spread) {
		this.spread = spread;
	}
}
