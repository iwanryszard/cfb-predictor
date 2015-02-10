package svm.predictor.predictions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.dto.LearningCategory;
import svm.predictor.weka.integration.WekaInstanceBuilder;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;

public class WekaClassifier implements Classifier {

	private static Logger logger = LoggerFactory.getLogger(WekaClassifier.class);
	
	private weka.classifiers.Classifier classifier;
	private WekaInstanceBuilder wekaInstanceBuilder;
	private Instances trainingData;
	private LearningCategory learningCategory;
	
	public WekaClassifier(weka.classifiers.Classifier classifier, WekaInstanceBuilder wekaInstanceBuilder, Instances trainingData, 
			LearningCategory learningCategory) {
		this.classifier = classifier;
		this.wekaInstanceBuilder = wekaInstanceBuilder;
		this.trainingData = trainingData;
		this.learningCategory = learningCategory;
	}
	
	@Override
	public EvaluationResultDto evaluate(GameDataDto gamesData) {
		Instances testingData = wekaInstanceBuilder.buildInstances(gamesData, learningCategory);
		try {
			Evaluation evaluation = new Evaluation(trainingData);
			double[] predictions = evaluation.evaluateModel(classifier, testingData);
			EvaluationResultDto result = new EvaluationResultDto();
			result.setPredictions(getPredictions(predictions));
			result.setCorrect((int)evaluation.correct());
			if(LearningCategory.REGRESSION.equals(learningCategory)) { 
				result.setCorrelationCoef(evaluation.correlationCoefficient());
			}
			result.setMeanAbsoluteError(evaluation.meanAbsoluteError());
			result.setRootMeanSquaredError(evaluation.rootMeanSquaredError());
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
	
	private Double getPredictionValue(double value) {
		Double prediction = null;
		if(LearningCategory.CLASSIFICATION.equals(learningCategory)) {
			prediction = value == 0.0 ? 1.0 : -1.0;
		} else if(LearningCategory.REGRESSION.equals(learningCategory)) {
			prediction = value;
		}
		
		return prediction;
	}
}
