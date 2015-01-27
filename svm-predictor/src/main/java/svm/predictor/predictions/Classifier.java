package svm.predictor.predictions;

import java.util.List;

import svm.predictor.data.retrieving.GameDataDto;

public interface Classifier {

	List<Double> evaluate(GameDataDto gamesData); 
}
