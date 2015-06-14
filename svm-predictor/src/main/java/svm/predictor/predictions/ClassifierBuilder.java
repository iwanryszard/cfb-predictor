package svm.predictor.predictions;

import svm.predictor.data.retrieving.GameDataDto;

public interface ClassifierBuilder {

	Classifier buildClassifier(GameDataDto gamesData, String classifierType, String attributeSelection, Double cost);
}
