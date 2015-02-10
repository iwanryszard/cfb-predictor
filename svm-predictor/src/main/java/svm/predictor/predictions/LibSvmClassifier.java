package svm.predictor.predictions;

import java.util.List;

import libsvm.svm_model;
import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.libsvm.PredictionResultDto;
import svm.predictor.libsvm.SvmPredictor;

public class LibSvmClassifier implements Classifier {

	private svm_model model;
	private SvmPredictor svmPredictor;
	
	public LibSvmClassifier(svm_model model, SvmPredictor svmPredictor) {
		this.model = model;
		this.svmPredictor = svmPredictor;
	}
	
	@Override
	public EvaluationResultDto evaluate(GameDataDto gamesData) {
		PredictionResultDto predictionResult = svmPredictor.predict(gamesData.getInstances(), model, null);
		EvaluationResultDto result = new EvaluationResultDto();
		List<Double> predictions = predictionResult.getPredictions();
		List<Double> expectedResult = gamesData.getLabels();
		int correct = 0;
		for (int i = 0; i < predictions.size(); ++i) {
			double v = predictions.get(i);
			double target = expectedResult.get(i);
			if (v == target) {
				++correct;
			}
		}
		result.setPredictions(predictionResult.getPredictions());
		result.setCorrect(correct);
		return result;
	}

}
