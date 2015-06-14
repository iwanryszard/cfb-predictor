package svm.predictor.predictions;

import libsvm.svm_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.libsvm.SvmPredictor;
import svm.predictor.libsvm.SvmTrainer;

@Service("libSvmClassifierBuilder")
public class LibSvmClassifierBuilder implements ClassifierBuilder {

	@Autowired
	private SvmTrainer svmTrainer;
	
	@Autowired
	private SvmPredictor svmPredictor;
	
	@Override
	public Classifier buildClassifier(GameDataDto gamesData, String classifierType, String attributeSelection, Double cost) {
		svm_model model = svmTrainer.trainModel(gamesData.getLabels(), gamesData.getInstances());
		return new LibSvmClassifier(model, svmPredictor);
	}

}
