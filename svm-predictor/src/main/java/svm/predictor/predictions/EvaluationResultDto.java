package svm.predictor.predictions;

import java.util.List;

public class EvaluationResultDto {
	private List<Double> predictions;
	private int correct;
	private Double correlationCoef;
	private Double meanAbsoluteError;
	private Double rootMeanSquaredError;
	
	public List<Double> getPredictions() {
		return predictions;
	}
	public void setPredictions(List<Double> predictions) {
		this.predictions = predictions;
	}
	
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	public Double getCorrelationCoef() {
		return correlationCoef;
	}
	public void setCorrelationCoef(Double correlationCoef) {
		this.correlationCoef = correlationCoef;
	}
	
	public Double getMeanAbsoluteError() {
		return meanAbsoluteError;
	}
	public void setMeanAbsoluteError(Double meanAbsoluteError) {
		this.meanAbsoluteError = meanAbsoluteError;
	}
	
	public Double getRootMeanSquaredError() {
		return rootMeanSquaredError;
	}
	public void setRootMeanSquaredError(Double rootMeanSquaredError) {
		this.rootMeanSquaredError = rootMeanSquaredError;
	}
}
