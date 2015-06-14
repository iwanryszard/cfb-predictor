package svm.predictor.predictions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.weka.integration.BaseWekaInstanceBuilder;
import svm.predictor.weka.integration.SymmetricGreedyStepwise;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.CorrelationAttributeEval;
import weka.attributeSelection.GreedyStepwise;
import weka.attributeSelection.Ranker;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.core.Instances;

public abstract class BaseWekaClassifierBuilder<T extends BaseWekaInstanceBuilder> implements ClassifierBuilder {

	private static Logger logger = LoggerFactory.getLogger(BaseWekaClassifierBuilder.class);
	
	protected T wekaInstanceBuilder;
	
	protected Map<String, String> classifierTypeToClass;
	
	@Override
	public Classifier buildClassifier(GameDataDto gamesData, String classifierType, String attributeSelection, Double cost) {
		weka.classifiers.Classifier classifier = getClassifierForType(classifierType);
		Instances instances = wekaInstanceBuilder.buildInstances(gamesData);
		try {
			classifier = configureClassifier(classifier, attributeSelection, cost);
			classifier.buildClassifier(instances);
		} catch (Exception e) {
			logger.error("Could not build classifier", e);
			throw new RuntimeException("Could not build classifier", e);
		}
		
		return createClassifier(classifier, wekaInstanceBuilder, instances);
	}
	
	protected abstract BaseWekaClassifier createClassifier(weka.classifiers.Classifier classifier, T wekaInstanceBuilder, 
			Instances trainingData);
	
	private weka.classifiers.Classifier getClassifierForType(String classifierType) {
		String className = classifierTypeToClass.get(classifierType);
		try {
			Object classifier = Class.forName(className).newInstance();
			return (weka.classifiers.Classifier)classifier;
		} catch (Exception e) {
			logger.error("Could not instantiate classifier", e);
			throw new RuntimeException("Could not instantiate classifier", e);
		} 
	}
	
	private weka.classifiers.Classifier configureClassifier(weka.classifiers.Classifier classifier, 
			String attributeSelection, Double cost) {
		if(classifier instanceof LibSVM) {
			((LibSVM)classifier).setCost(cost);
		}
		
		AttributeSelectedClassifier attributeSelected = null;
		if(attributeSelection != null && !attributeSelection.isEmpty()) {
			attributeSelected = new AttributeSelectedClassifier();
			attributeSelected.setClassifier(classifier);
		}
		
		if(attributeSelection.equals("Ranker")) {
			attributeSelected.setEvaluator(new CorrelationAttributeEval());
			Ranker ranker = new Ranker();
			ranker.setNumToSelect(20);
			attributeSelected.setSearch(ranker);
		} else if(attributeSelection.equals("Cfs")) {
			attributeSelected.setEvaluator(new CfsSubsetEval());
			GreedyStepwise greedyStepwise = new GreedyStepwise();
			greedyStepwise.setSearchBackwards(true);
			attributeSelected.setSearch(greedyStepwise);
		} else if(attributeSelection.equals("Symmetric")) {
			attributeSelected.setEvaluator(new CfsSubsetEval());
			SymmetricGreedyStepwise symmetricGreedyStepwise = new SymmetricGreedyStepwise();
			symmetricGreedyStepwise.setSearchBackwards(true);
			attributeSelected.setSearch(symmetricGreedyStepwise);
		}
		
		return attributeSelected != null ? attributeSelected : classifier;
	}

}
