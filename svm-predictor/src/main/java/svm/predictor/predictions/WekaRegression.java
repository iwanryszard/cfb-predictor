package svm.predictor.predictions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.weka.integration.BaseWekaInstanceBuilder;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;

public class WekaRegression extends BaseWekaClassifier {

	private static Logger logger = LoggerFactory.getLogger(WekaRegression.class);
	
	public WekaRegression(Classifier classifier, BaseWekaInstanceBuilder wekaInstanceBuilder, Instances trainingData) {
		super(classifier, wekaInstanceBuilder, trainingData);
	}

	@Override
	protected Double getPredictionValue(double value) {
		return value;
	}
	
	@Override
	protected void processEvaluationResult(EvaluationResultDto result, Evaluation evaluation) {
		super.processEvaluationResult(result, evaluation);
		try {
			result.setCorrelationCoef(evaluation.correlationCoefficient());
		} catch (Exception e) {
			logger.error("Failed to set correlationCoefficient", e);
			throw new RuntimeException("Failed to set correlationCoefficient", e);
		}
	}

}
