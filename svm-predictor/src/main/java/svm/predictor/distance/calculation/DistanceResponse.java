package svm.predictor.distance.calculation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DistanceResponse {
	private String status;
	private List<String> origins;
	private List<String> destinations;
	private List<Row> rows;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("origin_addresses")
	public List<String> getOrigins() {
		return origins;
	}
	
	public void setOrigins(List<String> origins) {
		this.origins = origins;
	}
	
	@JsonProperty("destination_addresses")
	public List<String> getDestinations() {
		return destinations;
	}
	
	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}
	
	public List<Row> getRows() {
		return rows;
	}
	
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
}