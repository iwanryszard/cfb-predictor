package svm.predictor.weka.dto;

import java.util.List;

public class Instance {

	private List<Attribute> attributes;

	public Instance() {
		
	}
	
	public Instance(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}
