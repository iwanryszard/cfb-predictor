package svm.predictor.dto;

public class CalculatedDistanceDto extends BaseDto<Integer> {
	
	private Integer fromTeamId;
	private Integer toTeamId;
	private Integer distanceKm;
	
	public Integer getFromTeamId() {
		return fromTeamId;
	}
	
	public void setFromTeamId(Integer fromTeamId) {
		this.fromTeamId = fromTeamId;
	}
	
	public Integer getToTeamId() {
		return toTeamId;
	}
	
	public void setToTeamId(Integer toTeamId) {
		this.toTeamId = toTeamId;
	}
	
	public Integer getDistanceKm() {
		return distanceKm;
	}
	
	public void setDistanceKm(Integer distanceKm) {
		this.distanceKm = distanceKm;
	}
}
