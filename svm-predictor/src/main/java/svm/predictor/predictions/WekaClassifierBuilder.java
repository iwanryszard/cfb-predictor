package svm.predictor.predictions;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.weka.integration.WekaClassifierInstanceBuilder;
import weka.classifiers.Classifier;
import weka.core.Instances;

@Service("wekaClassifierBuilder")
public class WekaClassifierBuilder extends BaseWekaClassifierBuilder<WekaClassifierInstanceBuilder> {
	
	public WekaClassifierBuilder() {
		classifierTypeToClass = new HashMap<String, String>();
		classifierTypeToClass.put("wekaLibSVM", "weka.classifiers.functions.LibSVM");
		classifierTypeToClass.put("wekaSMO", "weka.classifiers.functions.SMO");
		classifierTypeToClass.put("wekaVotedPerceptron", "weka.classifiers.functions.VotedPerceptron");
		classifierTypeToClass.put("wekaNaiveBayes", "weka.classifiers.bayes.NaiveBayes");
		classifierTypeToClass.put("wekaJ48", "weka.classifiers.trees.J48");
	}

	@Override
	protected BaseWekaClassifier createClassifier(Classifier classifier, WekaClassifierInstanceBuilder wekaInstanceBuilder,
			Instances instances) {
		return new WekaClassifier(classifier, wekaInstanceBuilder, instances);
	}
	
	@Autowired
	protected void setWekaInstanceBuilder(WekaClassifierInstanceBuilder instanceBuilder) {
		this.wekaInstanceBuilder = instanceBuilder;
	}

}
