package svm.predictor.libsvm;

import java.util.List;

public class PredictionResultDto {

	private List<Double> predictions;
	private List<double[]> probabilityEstimates;
	
	public List<Double> getPredictions() {
		return predictions;
	}
	public void setPredictions(List<Double> predictions) {
		this.predictions = predictions;
	}
	public List<double[]> getProbabilityEstimates() {
		return probabilityEstimates;
	}
	public void setProbabilityEstimates(List<double[]> probabilityEstimates) {
		this.probabilityEstimates = probabilityEstimates;
	}
}
