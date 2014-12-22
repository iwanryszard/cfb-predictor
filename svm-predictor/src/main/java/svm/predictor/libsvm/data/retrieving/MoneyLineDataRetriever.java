package svm.predictor.libsvm.data.retrieving;

import java.util.HashMap;
import java.util.Map;

import svm.predictor.dto.GameInfoDto;

public class MoneyLineDataRetriever extends BaseDataRetriever {

	@Override
	public Map<String, String> getSpecificParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("game.homeStraightOdds:IS NOT", null);
		params.put("game.awayStraightOdds:IS NOT", null);
		return params;
	}

	@Override
	public Integer getLabel(GameInfoDto game) {
		Integer label = (game.getHomeTeamPoints() >= game.getAwayTeamPoints()) ? 1 : -1;
		return label;
	}
}
