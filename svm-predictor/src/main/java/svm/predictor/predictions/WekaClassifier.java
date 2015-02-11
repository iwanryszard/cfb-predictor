package svm.predictor.predictions;

import svm.predictor.weka.integration.BaseWekaInstanceBuilder;
import weka.classifiers.Classifier;
import weka.core.Instances;

public class WekaClassifier extends BaseWekaClassifier {
	
	public WekaClassifier(Classifier classifier, BaseWekaInstanceBuilder wekaInstanceBuilder, Instances trainingData) {
		super(classifier, wekaInstanceBuilder, trainingData);
	}

	@Override
	protected Double getPredictionValue(double value) {
		return value == 0.0 ? 1.0 : -1.0;
	}
}
