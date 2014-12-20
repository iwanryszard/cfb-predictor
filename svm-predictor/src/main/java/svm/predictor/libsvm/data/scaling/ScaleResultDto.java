package svm.predictor.libsvm.data.scaling;

import java.util.List;

public class ScaleResultDto {
	
	private List<Double> labels;
	private List<List<IndexValuePair>> features;
	private ScaleRestoreDto scaleRestoreDto;
	
	public List<Double> getLabels() {
		return labels;
	}
	public void setLabels(List<Double> labels) {
		this.labels = labels;
	}
	public List<List<IndexValuePair>> getFeatures() {
		return features;
	}
	public void setFeatures(List<List<IndexValuePair>> features) {
		this.features = features;
	}
	public ScaleRestoreDto getScaleRestoreDto() {
		return scaleRestoreDto;
	}
	public void setScaleRestoreDto(ScaleRestoreDto scaleRestoreDto) {
		this.scaleRestoreDto = scaleRestoreDto;
	}
}
