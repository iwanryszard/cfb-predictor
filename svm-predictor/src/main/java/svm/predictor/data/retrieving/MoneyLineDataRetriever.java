package svm.predictor.data.retrieving;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import svm.predictor.dto.GameInfoDto;

public class MoneyLineDataRetriever extends BaseDataRetriever {

	public MoneyLineDataRetriever(SupportedFeaturesProvider supportedFeaturesProvider) {
		super(supportedFeaturesProvider);
	}

	@Override
	public Map<String, String> getSpecificParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("game.homeStraightOdds:IS NOT", null);
		params.put("game.awayStraightOdds:IS NOT", null);
		return params;
	}

	@Override
	public Double getLabel(GameInfoDto game) {
		Double label = (game.getHomeTeamPoints() >= game.getAwayTeamPoints()) ? 1.0 : -1.0;
		return label;
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
	
	@Override
	public GameOddsDto addGameOdds(GameInfoDto game, List<GameOddsDto> gamesOdds) {
		GameOddsDto odds = new GameOddsDto();
		odds.setAwayOdds(game.getAwayStraightOdds());
		odds.setHomeOdds(game.getHomeStraightOdds());
		gamesOdds.add(odds);
		return odds;
	}
}
