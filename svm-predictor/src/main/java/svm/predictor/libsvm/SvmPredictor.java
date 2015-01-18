package svm.predictor.libsvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import svm.predictor.weka.dto.Attribute;
import svm.predictor.weka.dto.Instance;

@Service("svmPredictor")
public class SvmPredictor {

	private static final Logger logger = LoggerFactory.getLogger(SvmPredictor.class);
	
	public PredictionResultDto predict(List<Instance> instances, svm_model model, Boolean probability) {
		if (Boolean.TRUE.equals(probability)) {
			if (svm.svm_check_probability_model(model) == 0) {
				logger.error("Model does not support probabiliy estimates\n");
				throw new RuntimeException("Model does not support probabiliy estimates\n");
			}
		} else {
			if (svm.svm_check_probability_model(model) != 0) {
				logger.info("Model supports probability estimates, but disabled in prediction.\n");
			}
		}
		
		int svm_type=svm.svm_get_svm_type(model);
		int nr_class=svm.svm_get_nr_class(model);
		double[] prob_estimates=null;
		
		if (Boolean.TRUE.equals(probability)) {
			if (svm_type == svm_parameter.EPSILON_SVR || svm_type == svm_parameter.NU_SVR) {
				logger.info("Prob. model for test data: target value = predicted value + z,\nz: Laplace distribution e^(-|z|/sigma)/(2sigma),sigma="
								+ svm.svm_get_svr_probability(model) + "\n");
			} else {
				int[] labelClasses = new int[nr_class];
				svm.svm_get_labels(model, labelClasses);
				prob_estimates = new double[nr_class];
			}
		}
		
		List<Double> predictions = new ArrayList<Double>();
		List<double[]> probabilityEstimates = new ArrayList<double[]>();
		for(int i = 0; i < instances.size(); ++i) {
			Instance currentInstance = instances.get(i);
			int currInstanceSize = currentInstance.getAttributes().size();
			
			svm_node[] x = new svm_node[currInstanceSize];
			for(int j = 0; j < currInstanceSize; ++j) {
				Attribute attribute = currentInstance.getAttributes().get(j);
				x[j] = new svm_node();
				x[j].index = attribute.getIndex();
				x[j].value = attribute.getValue().doubleValue();
			}
			
			double v;
			if (Boolean.TRUE.equals(probability) && (svm_type == svm_parameter.C_SVC || svm_type == svm_parameter.NU_SVC)) {
				v = svm.svm_predict_probability(model, x, prob_estimates);
				probabilityEstimates.add(Arrays.copyOf(prob_estimates, prob_estimates.length));
			} else {
				v = svm.svm_predict(model, x);
			}
			predictions.add(v);
		}
		
		PredictionResultDto result = new PredictionResultDto();
		result.setPredictions(predictions);
		result.setProbabilityEstimates(probabilityEstimates);
		return result;
	}
}
