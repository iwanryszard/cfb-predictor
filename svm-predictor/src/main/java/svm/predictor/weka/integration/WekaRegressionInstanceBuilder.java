package svm.predictor.weka.integration;

import org.springframework.stereotype.Service;

import weka.core.Attribute;

@Service("wekaRegressionInstanceBuilder")
public class WekaRegressionInstanceBuilder extends BaseWekaInstanceBuilder {

	@Override
	protected Attribute getClassAttribute() {
		return new Attribute("class");
	}
	
	@Override
	protected Double getClassValue(double classValue) {
		return classValue;
	}

}
