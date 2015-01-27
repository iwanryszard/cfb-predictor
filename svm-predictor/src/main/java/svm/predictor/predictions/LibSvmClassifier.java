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
	public List<Double> evaluate(GameDataDto gamesData) {
		PredictionResultDto predictionResult = svmPredictor.predict(gamesData.getInstances(), model, null);
		return predictionResult.getPredictions();
	}

}
