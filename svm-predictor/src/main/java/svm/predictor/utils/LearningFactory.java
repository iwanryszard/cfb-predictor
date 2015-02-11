package svm.predictor.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.dto.LearningCategory;
import svm.predictor.files.creator.BaseFileCreator;
import svm.predictor.predictions.ClassifierBuilder;

@Service("learningFactory")
public class LearningFactory {

	@Autowired
	private ClassifierBuilder libSvmClassifierBuilder;
	
	@Autowired
	private ClassifierBuilder wekaClassifierBuilder;
	
	@Autowired
	private ClassifierBuilder wekaRegressionBuilder;
	
	@Autowired
	private BaseFileCreator wekaClassificationFileCreator;
	
	@Autowired
	private BaseFileCreator wekaRegressionFileCreator;
	
	@Autowired
	private BaseFileCreator libSvmFileCreator;
	
	public ClassifierBuilder getClassifierBuilder(String classifierType, LearningCategory learningCategory) {
		if(classifierType.startsWith("weka")) {
			if(LearningCategory.CLASSIFICATION.equals(learningCategory)) { 
				return wekaClassifierBuilder;
			} else {
				return wekaRegressionBuilder;
			}
		} else {
			return libSvmClassifierBuilder;
		}
	}
	
	public BaseFileCreator getFileCreator(String fileType, LearningCategory learningCategory) {
		if("Weka".equals(fileType)) {
			if(LearningCategory.CLASSIFICATION.equals(learningCategory)) { 
				return wekaClassificationFileCreator;
			} else {
				return wekaRegressionFileCreator;
			}
		} else if("libsvm".equals(fileType)) {
			return libSvmFileCreator;
		}
		
		return wekaClassificationFileCreator;
	}
}
