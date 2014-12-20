package svm.predictor.libsvm.data.scaling;

public class ScaleRestoreDto {
	private double lower = -1.0;
	private double upper = 1.0;
	private double y_lower = 0.0;
	private double y_upper = 0.0;
	private boolean y_scaling = false;
	private double[] feature_max;
	private double[] feature_min;
	private double y_max = 0.0;;
	private double y_min = 0.0;
	
	public double getLower() {
		return lower;
	}
	public void setLower(double lower) {
		this.lower = lower;
	}
	public double getUpper() {
		return upper;
	}
	public void setUpper(double upper) {
		this.upper = upper;
	}
	public double getY_lower() {
		return y_lower;
	}
	public void setY_lower(double y_lower) {
		this.y_lower = y_lower;
	}
	public double getY_upper() {
		return y_upper;
	}
	public void setY_upper(double y_upper) {
		this.y_upper = y_upper;
	}
	public boolean isY_scaling() {
		return y_scaling;
	}
	public void setY_scaling(boolean y_scaling) {
		this.y_scaling = y_scaling;
	}
	public double[] getFeature_max() {
		return feature_max;
	}
	public void setFeature_max(double[] feature_max) {
		this.feature_max = feature_max;
	}
	public double[] getFeature_min() {
		return feature_min;
	}
	public void setFeature_min(double[] feature_min) {
		this.feature_min = feature_min;
	}
	public double getY_max() {
		return y_max;
	}
	public void setY_max(double y_max) {
		this.y_max = y_max;
	}
	public double getY_min() {
		return y_min;
	}
	public void setY_min(double y_min) {
		this.y_min = y_min;
	}
}
