package svm.predictor.predictions;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.weka.integration.WekaRegressionInstanceBuilder;
import weka.classifiers.Classifier;
import weka.core.Instances;

@Service("wekaRegressionBuilder")
public class WekaRegressionBuilder extends BaseWekaClassifierBuilder<WekaRegressionInstanceBuilder> {

	public WekaRegressionBuilder() {
		classifierTypeToClass = new HashMap<String, String>();
		classifierTypeToClass.put("wekaLinearRegression", "weka.classifiers.functions.LinearRegression");
	}
	
	@Override
	protected BaseWekaClassifier createClassifier(Classifier classifier, WekaRegressionInstanceBuilder wekaInstanceBuilder,
			Instances instances) {
		return new WekaRegression(classifier, wekaInstanceBuilder, instances);
	}
	
	@Autowired
	protected void setWekaInstanceBuilder(WekaRegressionInstanceBuilder instanceBuilder) {
		this.wekaInstanceBuilder = instanceBuilder;
	}
}
