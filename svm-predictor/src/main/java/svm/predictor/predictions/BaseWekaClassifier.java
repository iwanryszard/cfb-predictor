package svm.predictor.predictions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.weka.integration.BaseWekaInstanceBuilder;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;

public abstract class BaseWekaClassifier implements Classifier {

	private static Logger logger = LoggerFactory.getLogger(BaseWekaClassifier.class);
	
	private weka.classifiers.Classifier classifier;
	private BaseWekaInstanceBuilder wekaInstanceBuilder;
	private Instances trainingData;
	
	public BaseWekaClassifier(weka.classifiers.Classifier classifier, BaseWekaInstanceBuilder wekaInstanceBuilder, Instances trainingData) {
		this.classifier = classifier;
		this.wekaInstanceBuilder = wekaInstanceBuilder;
		this.trainingData = trainingData;
	}
	
	@Override
	public EvaluationResultDto evaluate(GameDataDto gamesData) {
		Instances testingData = wekaInstanceBuilder.buildInstances(gamesData);
		try {
			Evaluation evaluation = new Evaluation(trainingData);
			double[] predictions = evaluation.evaluateModel(classifier, testingData);
			EvaluationResultDto result = new EvaluationResultDto();
			result.setPredictions(getPredictions(predictions));
			processEvaluationResult(result, evaluation);
			return result;
		} catch (Exception e) {
			logger.error("Failed to evaluate classifier", e);
			throw new RuntimeException("Failed to evaluate classifier", e);
		}	
	}

	private List<Double> getPredictions(double[] predictions) {
		List<Double> result = new ArrayList<Double>(predictions.length);
		for(double prediction : predictions) {
			Double value = getPredictionValue(prediction);
			result.add(value);
		}
		return result;
	}
	
	protected abstract Double getPredictionValue(double value);
	
	protected void processEvaluationResult(EvaluationResultDto result, Evaluation evaluation) {
		result.setCorrect((int)evaluation.correct());
		result.setMeanAbsoluteError(evaluation.meanAbsoluteError());
		result.setRootMeanSquaredError(evaluation.rootMeanSquaredError());
	}
}
