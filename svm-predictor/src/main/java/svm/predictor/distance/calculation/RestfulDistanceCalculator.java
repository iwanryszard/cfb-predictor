package svm.predictor.distance.calculation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service("restfulDistanceCalculator")
public class RestfulDistanceCalculator implements DistanceCalculator {

	private static final Logger logger = LoggerFactory.getLogger(RestfulDistanceCalculator.class);
	
	private static final String statusOK = "OK";
	
	@Value("${distance.matrix.url}")
	private String distanceMatrixURL;
	
	@Value("${google.api.key}")
	private String apiKey;
	
	@Override
	public List<Integer> calculateDistances(String origin, List<String> destinations) {
		logger.info("Calculating distances");
		LocationOverrides overrides = new LocationOverrides();
		String url = buildURL(origin, destinations, overrides);
		logger.info("url: {}", url);
		RestTemplate restTemplate = new RestTemplate();
		DistanceResponse response = null;
		try {
			response = restTemplate.getForObject(url, DistanceResponse.class);
		} catch(RestClientException e) {
			logger.error("Could not connect to url:" + url);
			throw new RuntimeException("Could not connect to url:" + url, e);
		}

		List<Integer> result = buildResult(response, destinations, overrides);
		return result;
	}
	
	private String buildURL(String origin, List<String> destinations, LocationOverrides overrides) {
		StringBuilder result = new StringBuilder();
		result.append(distanceMatrixURL);
		String originsPart = getOriginsPart(origin, overrides);
		result.append(originsPart);
		result.append("&");
		String destinationsPart = getDestinationsPart(destinations, overrides);
		result.append(destinationsPart);
		result.append("&");
		result.append("key=" + apiKey);
		
		return result.toString();
	}
	
	private String getOriginsPart(String origin, LocationOverrides overrides) {
		return "origins=" + overrides.getOrigin(origin);
	}
	
	private String getDestinationsPart(List<String> destinations, LocationOverrides overrides) {
		StringBuilder result = new StringBuilder();
		result.append("destinations=");
		for(int ind = 0; ind < destinations.size(); ++ind) {
			String destination = destinations.get(ind);
			if(ind > 0) {
				result.append("|");
			}
			String overridden = overrides.getDestination(destination);
			result.append(overridden);
		}
		
		return result.toString();
	}
	
	private List<Integer> buildResult(DistanceResponse response, List<String> destinations, LocationOverrides overrides) {
		List<Integer> result = new ArrayList<Integer>();
		if( !statusOK.equals(response.getStatus())) {
			logger.error("Main status is: " + response.getStatus());
			throw new RuntimeException("Main status is: " + response.getStatus());
		}
		
		if(response.getRows().size() != 1) {
			throw new RuntimeException("Expected 1 row in response");
		}
		
		Row row = response.getRows().get(0);
		List<Element> elements = row.getElements();
		logger.info("Elements size: {}", elements.size());
		for(int ind = 0; ind < elements.size(); ++ind) {
			Element currentElement = elements.get(ind);
			if( !statusOK.equals(currentElement.getStatus())) {
				logger.error("Element status is: " + response.getStatus());
				throw new RuntimeException("Element status is: " + response.getStatus());
			}
			Integer meterDistance = currentElement.getDistance().getValue();
			Integer kmDistance = meterDistance / 1000;
			String destination = destinations.get(ind);
			Integer trueDistance = overrides.getDistance(destination, kmDistance);
			result.add(trueDistance);
		}
		
		return result;
	}
	
	private static class LocationOverrides {
		
		private final static String HAWAII = "Honolulu, Hawai'i";
		private final static String LA = "Los Angeles, California";
		private final static Integer addedDistance = 3700;
		
		private boolean originOverridden;

		public String getOrigin(String origin) {
			if(HAWAII.equals(origin)) {
				origin = LA;
				originOverridden = true;
				logger.info("origin overridden");
			}
			
			return origin;
		}
		
		public String getDestination(String destination) {
			if(HAWAII.equals(destination)) {
				destination = LA;
				logger.info("destination overridden");
			}
			
			return destination;
		}
		
		public Integer getDistance(String destination, Integer distance) {
			if(originOverridden || HAWAII.equals(destination)) {
				distance += addedDistance;
				logger.info("addedDistance: {}", addedDistance);
			}
			
			return distance;
		}
	}

}
