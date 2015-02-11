package svm.predictor.predictions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.weka.integration.BaseWekaInstanceBuilder;
import weka.core.Instances;

public abstract class BaseWekaClassifierBuilder<T extends BaseWekaInstanceBuilder> implements ClassifierBuilder {

	private static Logger logger = LoggerFactory.getLogger(BaseWekaClassifierBuilder.class);
	
	protected T wekaInstanceBuilder;
	
	protected Map<String, String> classifierTypeToClass;
	
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
		
		return createClassifier(classifier, wekaInstanceBuilder, instances);
	}
	
	protected abstract BaseWekaClassifier createClassifier(weka.classifiers.Classifier classifier, T wekaInstanceBuilder, 
			Instances trainingData);
	
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
