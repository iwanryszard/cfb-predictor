package svm.predictor.weka.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.data.retrieving.Instance;
import svm.predictor.dto.LearningCategory;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.SparseInstance;

@Service("wekaInstanceBuilder")
public class WekaInstanceBuilder {

	public Instances buildInstances(GameDataDto gamesData, LearningCategory learningCategory) {
		ArrayList<Attribute> attributes = getWekaAttributes(gamesData.getAttributeNames(), learningCategory);
		List<Instance> instances = gamesData.getInstances();
		Instances wekaInstances = new Instances("CFB", attributes, instances.size());
		wekaInstances.setClassIndex(attributes.size() - 1);
		List<Double> classes = gamesData.getLabels();
		for(int i = 0; i < gamesData.getInstances().size(); ++i) {
			Instance instance = gamesData.getInstances().get(i);
			double classValue = classes.get(i);
			weka.core.Instance wekaInstance = getWekaInstance(instance, attributes, classValue, learningCategory);
			wekaInstances.add(wekaInstance);
		}
		
		return wekaInstances;
	}
	
	private ArrayList<Attribute> getWekaAttributes(List<String> attributeNames, LearningCategory learningCategory) {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>(attributeNames.size() + 1);
		for(String attributeName : attributeNames) {
			Attribute attribute = new Attribute(attributeName);
			attributes.add(attribute);
		}
		
		Attribute classAttribute = getClassAttribute(learningCategory);
		attributes.add(classAttribute);
		return attributes;
	}
	
	private Attribute getClassAttribute(LearningCategory learningCategory) {
		Attribute classAttribute = null;
		if(LearningCategory.CLASSIFICATION.equals(learningCategory)) {
			classAttribute = new Attribute("class", Arrays.asList("1", "-1"));
		} else if (LearningCategory.REGRESSION.equals(learningCategory)){
			classAttribute = new Attribute("class");
		}
		
		return classAttribute;
	}
	
	private weka.core.Instance getWekaInstance(Instance instance, List<Attribute> wekaAttributes, double classValue, 
			LearningCategory learningCategory) {
//		weka.core.Instance wekaInstance = new SparseInstance(wekaAttributes.size());
//		for(svm.predictor.data.retrieving.Attribute attribute : instance.getAttributes()) {
//			Attribute wekaAttribute = wekaAttributes.get(attribute.getIndex() - 1);
//			wekaInstance.setValue(wekaAttribute, attribute.getValue().doubleValue());
//		}
//		Attribute classAttribute = wekaAttributes.get(wekaAttributes.size() - 1);
//		wekaInstance.setValue(classAttribute, classValue == 1.0 ? "1" : "-1");
//		
//		return wekaInstance;
		double[] values = new double[instance.getAttributes().size() + 1];
		int[] indices = new int[instance.getAttributes().size() + 1];
		for(int i = 0; i < instance.getAttributes().size(); ++i) {
			svm.predictor.data.retrieving.Attribute attribute = instance.getAttributes().get(i);
			indices[i] = attribute.getIndex() - 1;
			values[i] = attribute.getValue().doubleValue();
		}
		indices[instance.getAttributes().size()] = wekaAttributes.size() - 1;
		values[instance.getAttributes().size()] = getClassValue(classValue, learningCategory);
		weka.core.Instance wekaInstance = new SparseInstance(1.0, values, indices, wekaAttributes.size());
		
		return wekaInstance;
	}
	
	private Double getClassValue(double classValue, LearningCategory learningCategory) {
		Double result = null;
		if(LearningCategory.CLASSIFICATION.equals(learningCategory)) {
			result = classValue == 1.0 ? 0.0 : 1.0;
		} else if (LearningCategory.REGRESSION.equals(learningCategory)){
			result = classValue;
		}
		
		return result;
	}
}
