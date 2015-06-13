package svm.predictor.data.retrieving;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public abstract class BaseDataRetriever {
	
	private static Logger logger = LoggerFactory.getLogger(BaseDataRetriever.class);
	
	protected SupportedFeaturesProvider supportedFeaturesProvider;
	
	public BaseDataRetriever(SupportedFeaturesProvider supportedFeaturesProvider) {
		this.supportedFeaturesProvider = supportedFeaturesProvider;
	}

	public abstract Map<String, String> getSpecificParams();
	
	public abstract Double getLabel(GameInfoDto game);
	
	private void addStats(Object stats, List<String> statNames, List<Attribute> attributes) {
		Class<?> statsClass = stats.getClass();
		List<Method> methods = getStatMethods(statNames, statsClass);
		int index = attributes.size() + 1;
		for(Method method : methods) {
			try {
				Object value = method.invoke(stats);
				attributes.add(new Attribute((Number)value, index++));
			}  catch (Exception e) {
				logger.error("Error invoking method", e);
				throw new RuntimeException("Error invoking method", e);
			}
		}
	}
	
	private List<Method> getStatMethods(List<String> statNames, Class<?> statsClass) {
		List<Method> methods = new ArrayList<Method>(statNames.size());
		for(String statName : statNames) {
			Method currentMethod = null;
			try {
				currentMethod = statsClass.getMethod("get" + statName);
			} catch (Exception e) {
				logger.error("Error getting method", e);
				throw new RuntimeException("Error getting method", e);
			}
			
			methods.add(currentMethod);
		}
		
		return methods;
	}
	
	protected void addSimpleStats(TeamSimpleAggregatedStats stats, List<Attribute> attributes) {
		List<String> statNames = getSimpleStatNames();
		addStats(stats, statNames, attributes);
	}
	
	protected List<String> getSimpleStatNames() {
		List<String> names = new ArrayList<String>();
		
		names.add("PassDefYardsAvg");
		names.add("PassOffYardsAvg");
		names.add("RushDefYardsAvg");
		names.add("RushOffYardsAvg");
		names.add("ScoringDefPointsAvg");
		names.add("ScoringOffPointsAvg");
		names.add("WinPct");
		
		return names;
	}
	
	protected void addTeamAggregatedStats(TeamAggregatedGameStatsDto stats, List<Attribute> attributes) {
		List<String> statNames = getAggregatedStatNames();
		addStats(stats, statNames, attributes);
	}
	
	protected List<String> getAggregatedStatNames() {
		return supportedFeaturesProvider.getStatNames();
	}
	
	protected void addSpecificAttributes(AggregatedGameStatsDto aggregatedGame, List<Attribute> attributes) {
		List<String> statNames = getSpecificAttributesNames();
		addStats(aggregatedGame.getGame(), statNames, attributes);
	}
	
	protected List<String> getSpecificAttributesNames() {
		List<String> names = new ArrayList<String>();
		
		names.add("DistanceBetweenTeamsKm");
		
		return names;
	}
	
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		List<String> specific = getSpecificAttributesNames();
		names.addAll(specific);
		
		addWithTeamPeriodToName(names, getAggregatedStatNames(), "home", null);
		addWithTeamPeriodToName(names, getSimpleStatNames(), "home", "Last5");
		addWithTeamPeriodToName(names, getSimpleStatNames(), "home", "LastSeason");
		
		addWithTeamPeriodToName(names, getAggregatedStatNames(), "away", null);
		addWithTeamPeriodToName(names, getSimpleStatNames(), "away", "Last5");
		addWithTeamPeriodToName(names, getSimpleStatNames(), "away", "LastSeason");
		
		return names;
	}
	
	private void addWithTeamPeriodToName(List<String> addTo, List<String> statNames, String homeAway, String period) {
		String prefix = homeAway;
		if(period != null) {
			prefix += period;
		}
		
		for(String statName : statNames) {
			addTo.add(prefix + statName);
		}
	}
	
	public Instance getInstance(AggregatedGameStatsDto aggregatedGame) {
		Instance instance = new Instance();
		List<Attribute> attributes = new ArrayList<Attribute>();
		
		addSpecificAttributes(aggregatedGame, attributes);
		
		addTeamAggregatedStats(aggregatedGame.getHomeTeamStats(), attributes);
		addSimpleStats(aggregatedGame.getHomeTeamLastFive(), attributes);
		addSimpleStats(aggregatedGame.getHomeTeamLastSeason(), attributes);
		
		addTeamAggregatedStats(aggregatedGame.getAwayTeamStats(), attributes);
		addSimpleStats(aggregatedGame.getAwayTeamLastFive(), attributes);
		addSimpleStats(aggregatedGame.getAwayTeamLastSeason(), attributes);
		
		convertNullsToZeros(attributes);
		instance.setAttributes(attributes);
		
		return instance;
	}
	
	public GameOddsDto addGameOdds(GameInfoDto game, List<GameOddsDto> gamesOdds) {
		//default implementation for point spread and point total lines - standard odds are 1.91
		GameOddsDto odds = new GameOddsDto();
		odds.setAwayOdds(1.91);
		odds.setHomeOdds(1.91);
		gamesOdds.add(odds);
		return odds;
	}
	
	public String getPrediction(Double prediction, GameOddsDto gameOdds) {
		String result = "";
		if(prediction.equals(1.0)) {
			result = gameOdds.getHomeTeam();
		} else {
			result = gameOdds.getAwayTeam();
		}
		
		return result;
	}
	
	public League getLeague() {
		return supportedFeaturesProvider.getLeague();
	}
	
	private void convertNullsToZeros(List<Attribute> attributes) {
		for(int i = 0; i < attributes.size(); ++i) {
			if(attributes.get(i).getValue() == null) {
				attributes.get(i).setValue(0);
			}
		}
	}
}
