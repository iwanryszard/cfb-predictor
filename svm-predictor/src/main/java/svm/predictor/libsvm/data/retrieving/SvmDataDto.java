package svm.predictor.libsvm.data.retrieving;

import java.util.List;

public class SvmDataDto {

	private List<Integer> labels;
	private List<List<Number>> features;
	private List<GameOddsDto> gamesOdds;
	
	public List<Integer> getLabels() {
		return labels;
	}
	public void setLabels(List<Integer> labels) {
		this.labels = labels;
	}
	public List<List<Number>> getFeatures() {
		return features;
	}
	public void setFeatures(List<List<Number>> features) {
		this.features = features;
	}
	public List<GameOddsDto> getGamesOdds() {
		return gamesOdds;
	}
	public void setGamesOdds(List<GameOddsDto> gamesOdds) {
		this.gamesOdds = gamesOdds;
	}
}
