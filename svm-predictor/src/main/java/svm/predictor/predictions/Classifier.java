package svm.predictor.predictions;

import svm.predictor.data.retrieving.GameDataDto;

public interface Classifier {

	EvaluationResultDto evaluate(GameDataDto gamesData); 
}
