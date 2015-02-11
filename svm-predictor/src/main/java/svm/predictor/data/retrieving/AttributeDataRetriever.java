package svm.predictor.data.retrieving;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamGameStatsDto;

public class AttributeDataRetriever extends BaseDataRetriever {

	private static Logger logger = LoggerFactory.getLogger(AttributeDataRetriever.class);
	
	private Method method;
	private boolean home;
	
	public AttributeDataRetriever(SupportedFeaturesProvider supportedFeaturesProvider, String attributeName) {
		super(supportedFeaturesProvider);
		if(attributeName.startsWith("home")) {
			home = true;
		} else if( !attributeName.startsWith("away")) {
			throw new RuntimeException("Expected 'home' or 'away at the beginning of the attribute name");
		}
		//remove home/away prefix
		attributeName = attributeName.substring(4);
		//capitalise first letter
		attributeName = Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1);
		try {
			method = TeamGameStatsDto.class.getDeclaredMethod("get" + attributeName);
		} catch (Exception e) {
			logger.error("Error getting method", e);
			throw new RuntimeException("Error getting method", e);
		}
	}

	@Override
	public Map<String, String> getSpecificParams() {
		return new HashMap<String, String>();
	}

	@Override
	public Double getLabel(GameInfoDto game) {
		TeamGameStatsDto teamStats = null;
		if(home) {
			teamStats = game.getHomeTeamStats();
		} else {
			teamStats = game.getAwayTeamStats();
		}
		
		try {
			Object value = method.invoke(teamStats);
			return value != null ? ((Number)value).doubleValue() : 0.0;
		} catch (Exception e) {
			logger.error("Error invoking method", e);
			throw new RuntimeException("Error invoking method", e);
		}
	}
	
	@Override
	protected List<String> getSimpleStatNames() {
		List<String> result = super.getSimpleStatNames();
		result.add("WinATSPct");
		return result;
	}
	
	@Override
	protected List<String> getAggregatedStatNames() {
		List<String> result = super.getAggregatedStatNames();
		result.add("WinATSPct");
		return result;
	}
	
	@Override
	protected List<String> getSpecificAttributesNames() {
		List<String> result = super.getSpecificAttributesNames();
		result.add("PointSpread");
		return result;
	}

}
