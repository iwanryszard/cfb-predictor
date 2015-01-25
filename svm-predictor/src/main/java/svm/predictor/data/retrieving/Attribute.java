package svm.predictor.data.retrieving;

public class Attribute {

	private Integer index;
	private Number value;
	
	public Attribute() {
		
	}
	
	public Attribute(Number value, Integer index) {
		this.value = value;
		this.index = index;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Number getValue() {
		return value;
	}
	public void setValue(Number value) {
		this.value = value;
	}
}
