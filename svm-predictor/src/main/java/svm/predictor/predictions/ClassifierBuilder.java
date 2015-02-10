package svm.predictor.predictions;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.dto.LearningCategory;

public interface ClassifierBuilder {

	Classifier buildClassifier(GameDataDto gamesData, String classifierType, LearningCategory learningCategory);
}
