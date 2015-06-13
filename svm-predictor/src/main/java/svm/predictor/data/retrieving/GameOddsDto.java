package svm.predictor.data.retrieving;

public class GameOddsDto {

	private Double homeOdds;
	private Double awayOdds;
	private String homeTeam;
	private String awayTeam;
	private int homeTeamPoints;
	private int awayTeamPoints;
	private String prediction;
	private boolean correct;
	
	public Double getHomeOdds() {
		return homeOdds;
	}
	public void setHomeOdds(Double homeOdds) {
		this.homeOdds = homeOdds;
	}
	public Double getAwayOdds() {
		return awayOdds;
	}
	public void setAwayOdds(Double awayOdds) {
		this.awayOdds = awayOdds;
	}
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
	public int getHomeTeamPoints() {
		return homeTeamPoints;
	}
	public void setHomeTeamPoints(int homeTeamPoints) {
		this.homeTeamPoints = homeTeamPoints;
	}
	public int getAwayTeamPoints() {
		return awayTeamPoints;
	}
	public void setAwayTeamPoints(int awayTeamPoints) {
		this.awayTeamPoints = awayTeamPoints;
	}
	public String getPrediction() {
		return prediction;
	}
	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
}
