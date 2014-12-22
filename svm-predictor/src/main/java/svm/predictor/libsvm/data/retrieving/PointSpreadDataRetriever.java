package svm.predictor.libsvm.data.retrieving;

import java.util.HashMap;
import java.util.Map;

import svm.predictor.dto.GameInfoDto;

public class PointSpreadDataRetriever extends BaseDataRetriever {

	@Override
	public Map<String, String> getSpecificParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("game.pointSpread:IS NOT", null);
		return params;
	}

	@Override
	public Integer getLabel(GameInfoDto game) {
		Integer label = ((game.getHomeTeamPoints() + game.getPointSpread()) >= 
				game.getAwayTeamPoints()) ? 1 : -1;
		return label;
	}
}
