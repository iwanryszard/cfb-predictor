package svm.predictor.dto;

public class TeamDto extends BaseDto<Integer> {

	private String name;
	private String stadiumLocation;
	private League league;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStadiumLocation() {
		return stadiumLocation;
	}
	
	public void setStadiumLocation(String stadiumLocation) {
		this.stadiumLocation = stadiumLocation;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
}
