package svm.predictor.libsvm;

public class CrossValidationResultDto {

	private Double accuracy;
	private Double meanSquaredError;
	private Double squaredCorrelCoef;
	
	public Double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}
	public Double getMeanSquaredError() {
		return meanSquaredError;
	}
	public void setMeanSquaredError(Double meanSquaredError) {
		this.meanSquaredError = meanSquaredError;
	}
	public Double getSquaredCorrelCoef() {
		return squaredCorrelCoef;
	}
	public void setSquaredCorrelCoef(Double squaredCorrelCoef) {
		this.squaredCorrelCoef = squaredCorrelCoef;
	}
}
