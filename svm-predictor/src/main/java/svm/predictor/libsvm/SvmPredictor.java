package svm.predictor.libsvm;

import java.util.ArrayList;
import java.util.List;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import svm.predictor.libsvm.data.scaling.IndexValuePair;

@Service("svmPredictor")
public class SvmPredictor {

	private static final Logger logger = LoggerFactory.getLogger(SvmPredictor.class);
	
	public List<Double> predict(List<Double> labels, List<List<IndexValuePair>> features, svm_model model, Boolean probability) {
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
		
		int correct = 0;
		int total = 0;
		double error = 0;
		double sumv = 0, sumy = 0, sumvv = 0, sumyy = 0, sumvy = 0;
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
		for(int i = 0; i < features.size(); ++i) {
			List<IndexValuePair> currentFeatures = features.get(i);
			int currFeatSize = currentFeatures.size();
			
			double target = labels.get(i);
			svm_node[] x = new svm_node[currFeatSize];
			for(int j = 0; j < currFeatSize; ++j) {
				IndexValuePair feature = currentFeatures.get(j);
				x[j] = new svm_node();
				x[j].index = feature.getIndex();
				x[j].value = feature.getValue();
			}
			
			double v;
			if (Boolean.TRUE.equals(probability) && (svm_type == svm_parameter.C_SVC || svm_type == svm_parameter.NU_SVC)) {
				v = svm.svm_predict_probability(model, x, prob_estimates);
			} else {
				v = svm.svm_predict(model, x);
			}
			predictions.add(v);
			
			if (v == target) {
				++correct;
			}
			error += (v - target) * (v - target);
			sumv += v;
			sumy += target;
			sumvv += v * v;
			sumyy += target * target;
			sumvy += v * target;
			++total;
		}
		
		if (svm_type == svm_parameter.EPSILON_SVR || svm_type == svm_parameter.NU_SVR) {
			logger.info("Mean squared error = " + error / total + " (regression)\n");
			logger.info("Squared correlation coefficient = "
					+ ((total * sumvy - sumv * sumy) * (total * sumvy - sumv * sumy))
					/ ((total * sumvv - sumv * sumv) * (total * sumyy - sumy * sumy)) + " (regression)\n");
		} else {
			logger.info("Accuracy = " + (double) correct / total * 100 + "% (" + correct + "/" + total + ") (classification)\n");
		}
		
		return predictions;
	}
}
