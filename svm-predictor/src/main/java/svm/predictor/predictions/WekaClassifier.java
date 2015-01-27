package svm.predictor.predictions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.weka.integration.WekaInstanceBuilder;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;

public class WekaClassifier implements Classifier {

	private static Logger logger = LoggerFactory.getLogger(WekaClassifier.class);
	
	private weka.classifiers.Classifier classifier;
	private WekaInstanceBuilder wekaInstanceBuilder;
	private Instances trainingData;
	
	public WekaClassifier(weka.classifiers.Classifier classifier, WekaInstanceBuilder wekaInstanceBuilder, Instances trainingData) {
		this.classifier = classifier;
		this.wekaInstanceBuilder = wekaInstanceBuilder;
		this.trainingData = trainingData;
	}
	
	@Override
	public List<Double> evaluate(GameDataDto gamesData) {
		Instances testingData = wekaInstanceBuilder.buildInstances(gamesData);
		try {
			Evaluation evaluation = new Evaluation(trainingData);
			double[] predictions = evaluation.evaluateModel(classifier, testingData);
			List<Double> result = new ArrayList<Double>(predictions.length);
			for(double prediction : predictions) {
				result.add(prediction == 0.0 ? 1.0 : -1.0);
			}
			return result;
		} catch (Exception e) {
			logger.error("Failed to evaluate classifier", e);
			throw new RuntimeException("Failed to evaluate classifier", e);
		}
		
	}

}
