package svm.predictor.weka.integration;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import weka.core.Attribute;

@Service("wekaClassifierInstanceBuilder")
public class WekaClassifierInstanceBuilder extends BaseWekaInstanceBuilder {
	
	@Override
	protected Attribute getClassAttribute() {
		return new Attribute("class", Arrays.asList("1", "-1"));
	}
	
	@Override
	protected Double getClassValue(double classValue) {
		return classValue == 1.0 ? 0.0 : 1.0;
	}
}
