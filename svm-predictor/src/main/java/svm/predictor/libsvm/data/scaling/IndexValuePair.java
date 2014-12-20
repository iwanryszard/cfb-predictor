package svm.predictor.libsvm.data.scaling;

public class IndexValuePair {

	private Integer index;
	private Double value;
	
	public IndexValuePair() {
		
	}
	
	public IndexValuePair(Integer index, Double value) {
		this.index = index;
		this.value = value;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
