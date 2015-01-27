package svm.predictor.predictions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.weka.integration.WekaInstanceBuilder;
import weka.core.Instances;

@Service("wekaClassifierBuilder")
public class WekaClassifierBuilder implements ClassifierBuilder {

	private static Logger logger = LoggerFactory.getLogger(WekaClassifierBuilder.class);
	
	@Autowired
	private WekaInstanceBuilder wekaInstanceBuilder;
	
	private Map<String, String> classifierTypeToClass;
	
	public WekaClassifierBuilder() {
		classifierTypeToClass = new HashMap<String, String>();
		classifierTypeToClass.put("wekaLibSVM", "weka.classifiers.functions.LibSVM");
		classifierTypeToClass.put("wekaSMO", "weka.classifiers.functions.SMO");
		classifierTypeToClass.put("wekaVotedPerceptron", "weka.classifiers.functions.VotedPerceptron");
	}
	
	@Override
	public Classifier buildClassifier(GameDataDto gamesData, String classifierType) {
		weka.classifiers.Classifier classifier = getClassifierForType(classifierType);
		Instances instances = wekaInstanceBuilder.buildInstances(gamesData);
		try {
			classifier.buildClassifier(instances);
		} catch (Exception e) {
			logger.error("Could not build classifier", e);
			throw new RuntimeException("Could not build classifier", e);
		}
		
		return new WekaClassifier(classifier, wekaInstanceBuilder, instances);
	}
	
	private weka.classifiers.Classifier getClassifierForType(String classifierType) {
		String className = classifierTypeToClass.get(classifierType);
		try {
			Object classifier = Class.forName(className).newInstance();
			return (weka.classifiers.Classifier)classifier;
		} catch (Exception e) {
			logger.error("Could not instantiate classifier", e);
			throw new RuntimeException("Could not instantiate classifier", e);
		} 
	}

}
