package svm.predictor.dto;

import java.util.Date;

public class GameInfoDto extends BaseDto<Integer>{
	
	private int homeTeamId;
	private int awayTeamId;
	private Date gameDate;
	private Integer distanceBetweenTeamsKm;
	private boolean isNeutralVenue;
	private int homeTeamPoints;
	private int awayTeamPoints;
	private Double pointSpread;
	private int attendance;
	
	private TeamGameStatsDto homeTeamStats;
	private TeamGameStatsDto awayTeamStats;
	
	public int getHomeTeamId() {
		return homeTeamId;
	}
	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}
	public int getAwayTeamId() {
		return awayTeamId;
	}
	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	public Integer getDistanceBetweenTeamsKm() {
		return distanceBetweenTeamsKm;
	}
	public void setDistanceBetweenTeamsKm(Integer distanceBetweenTeamsKm) {
		this.distanceBetweenTeamsKm = distanceBetweenTeamsKm;
	}
	public boolean isNeutralVenue() {
		return isNeutralVenue;
	}
	public void setNeutralVenue(boolean isNeutralVenue) {
		this.isNeutralVenue = isNeutralVenue;
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
	public Double getPointSpread() {
		return pointSpread;
	}
	public void setPointSpread(Double pointSpread) {
		this.pointSpread = pointSpread;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public TeamGameStatsDto getHomeTeamStats() {
		return homeTeamStats;
	}
	public void setHomeTeamStats(TeamGameStatsDto homeTeamStats) {
		this.homeTeamStats = homeTeamStats;
	}
	public TeamGameStatsDto getAwayTeamStats() {
		return awayTeamStats;
	}
	public void setAwayTeamStats(TeamGameStatsDto awayTeamStats) {
		this.awayTeamStats = awayTeamStats;
	}
	
}
