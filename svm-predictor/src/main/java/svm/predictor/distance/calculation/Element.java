package svm.predictor.distance.calculation;

public class Element {
	private String status;
	private ValueTextHolder duration;
	private ValueTextHolder distance;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ValueTextHolder getDuration() {
		return duration;
	}
	
	public void setDuration(ValueTextHolder duration) {
		this.duration = duration;
	}
	
	public ValueTextHolder getDistance() {
		return distance;
	}
	
	public void setDistance(ValueTextHolder distance) {
		this.distance = distance;
	}
}
