package svm.predictor.libsvm.data.scaling;

import java.util.List;

import svm.predictor.weka.dto.Instance;

public class ScaleResultDto {
	
	private List<Double> labels;
	private List<Instance> instances;
	private ScaleRestoreDto scaleRestoreDto;
	
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
	public ScaleRestoreDto getScaleRestoreDto() {
		return scaleRestoreDto;
	}
	public void setScaleRestoreDto(ScaleRestoreDto scaleRestoreDto) {
		this.scaleRestoreDto = scaleRestoreDto;
	}
}
