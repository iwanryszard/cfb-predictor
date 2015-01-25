package svm.predictor.data.retrieving;

import java.util.List;


public class GameDataDto {

	private List<Double> labels;
	private List<Instance> instances;
	private List<GameOddsDto> gamesOdds;
	private List<String> attributeNames;
	
	public List<Double> getLabels() {
		return labels;
	}
	public void setLabels(List<Double> labels) {
		this.labels = labels;
	}
	public List<Instance> getInstances() {
		return instances;
	}
	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}
	public List<GameOddsDto> getGamesOdds() {
		return gamesOdds;
	}
	public void setGamesOdds(List<GameOddsDto> gamesOdds) {
		this.gamesOdds = gamesOdds;
	}
	public List<String> getAttributeNames() {
		return attributeNames;
	}
	public void setAttributeNames(List<String> attributeNames) {
		this.attributeNames = attributeNames;
	}
}
