package svm.predictor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CFBStatsScraper {

	private static Logger logger = LoggerFactory.getLogger(CFBStatsScraper.class);
	
	public static void main(String[] args) {
		RestTemplate rest = new RestTemplate();
		DistanceResponse response = rest.getForObject("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Akron, Ohio&destinations=Tuscaloosa, Alabama", DistanceResponse.class);
		response.toString();
	}
	
	static class DistanceResponse {
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
	
	static class Row {
		private List<Element> elements;

		public List<Element> getElements() {
			return elements;
		}

		public void setElements(List<Element> elements) {
			this.elements = elements;
		}
	}
	
	static class Element {
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
	
	static class ValueTextHolder {
		private int value;
		private String text;
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
		
		public String getText() {
			return text;
		}
		
		public void setText(String text) {
			this.text = text;
		}
	}
}
