package svm.predictor.libsvm;

import java.util.List;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;
import libsvm.svm_print_interface;
import libsvm.svm_problem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import svm.predictor.data.retrieving.Attribute;
import svm.predictor.data.retrieving.Instance;

@Service("svmTrainer")
public class SvmTrainer {
	
	private static final Logger logger = LoggerFactory.getLogger(SvmTrainer.class);
	
	private svm_print_interface print_func = new svm_print_interface() {
		
		@Override
		public void print(String arg0) {
			logger.info(arg0);
		}
	};
	
	public svm_model trainModel(List<Double> labels, List<Instance> instances) {
		svm_parameter param = getParameters(null, null, null, null, null);
		svm.svm_set_print_string_function(print_func);
		
		svm_problem prob = buildProblem(labels, instances, param);
		
		String errorMsg = svm.svm_check_parameter(prob, param);
		if (errorMsg != null) {
			logger.error(errorMsg);
			throw new RuntimeException(errorMsg);
		}
		
		svm_model model = svm.svm_train(prob, param);
		return model;
	}
	
	public CrossValidationResultDto crossValidation(List<Double> labels, List<Instance> instances, int foldNumber) {
		svm_parameter param = getParameters(null, null, null, null, null);
		svm.svm_set_print_string_function(print_func);
		
		svm_problem prob = buildProblem(labels, instances, param);
		
		String errorMsg = svm.svm_check_parameter(prob, param);
		if (errorMsg != null) {
			logger.error(errorMsg);
			throw new RuntimeException(errorMsg);
		}
		
		int i;
		int total_correct = 0;
		double total_error = 0;
		double sumv = 0, sumy = 0, sumvv = 0, sumyy = 0, sumvy = 0;
		double[] target = new double[prob.l];
		
		svm.svm_cross_validation(prob, param, foldNumber, target);
		
		CrossValidationResultDto result = new CrossValidationResultDto();
		if (param.svm_type == svm_parameter.EPSILON_SVR || param.svm_type == svm_parameter.NU_SVR) {
			for (i = 0; i < prob.l; i++) {
				double y = prob.y[i];
				double v = target[i];
				total_error += (v - y) * (v - y);
				sumv += v;
				sumy += y;
				sumvv += v * v;
				sumyy += y * y;
				sumvy += v * y;
			}
			double meanSquaredError = total_error / prob.l;
			result.setMeanSquaredError(meanSquaredError);
			logger.info("Cross Validation Mean squared error = " + meanSquaredError + "\n");
			double squaredCorrelCoef = ((prob.l * sumvy - sumv * sumy) * (prob.l * sumvy - sumv * sumy))
					/ ((prob.l * sumvv - sumv * sumv) * (prob.l * sumyy - sumy * sumy));
			result.setSquaredCorrelCoef(squaredCorrelCoef);
			logger.info("Cross Validation Squared correlation coefficient = " + squaredCorrelCoef + "\n");
		} else {
			for (i = 0; i < prob.l; i++) {
				if (target[i] == prob.y[i]) {
					++total_correct;
				}
			}
			double accuracy = 100.0 * total_correct / prob.l;
			result.setAccuracy(accuracy);
			logger.info("Cross Validation Accuracy = " + accuracy + "%\n");
		}
		
		return result;
	}
	
	private svm_parameter getParameters(Integer kernelType, Integer degree, Double c, Double gamma, Boolean probability) {
		svm_parameter param = new svm_parameter();
		// default values
		param.svm_type = svm_parameter.C_SVC;
		param.kernel_type = svm_parameter.RBF;
		param.degree = 3;
		param.gamma = 0; // 1/num_features
		param.coef0 = 0;
		param.nu = 0.5;
		param.cache_size = 100;
		param.C = 1;
		param.eps = 1e-3;
		param.p = 0.1;
		param.shrinking = 1;
		param.probability = 0;
		param.nr_weight = 0;
		param.weight_label = new int[0];
		param.weight = new double[0];
		
		if(kernelType != null) {
			param.kernel_type = kernelType;
		}
		
		if(degree != null) {
			param.degree = degree;
		}
		
		if(c != null) {
			param.C = c;
		}
		
		if(gamma != null) {
			param.gamma = gamma;
		}
		
		if(probability != null) {
			param.probability = probability ? 1 : 0;
		}
		
		return param;
	}
	
	private svm_problem buildProblem(List<Double> labels, List<Instance> instances, svm_parameter param) {
		svm_problem prob = new svm_problem();
		prob.l = labels.size();
		prob.x = new svm_node[prob.l][];
		prob.y = new double[prob.l];
		
		int max_index = 0;
		
		for(int i=0;i<prob.l;i++) {
			prob.y[i] = labels.get(i);
			
			Instance currentInstance = instances.get(i);
			int currInstanceSize = currentInstance.getAttributes().size();
			prob.x[i] = new svm_node[currInstanceSize];
			for(int j = 0; j < currInstanceSize; ++j) {
				Attribute attribute = currentInstance.getAttributes().get(j);
				prob.x[i][j] = new svm_node();
				prob.x[i][j].index = attribute.getIndex();
				prob.x[i][j].value = attribute.getValue().doubleValue();
			}
			
			if(currInstanceSize > 0) {
				max_index = Math.max(max_index, prob.x[i][currInstanceSize - 1].index);
			}
		}
		
		if(param.gamma == 0 && max_index > 0) {
			param.gamma = 1.0/max_index;
		}
		
		if (param.kernel_type == svm_parameter.PRECOMPUTED) {
			for (int i = 0; i < prob.l; i++) {
				if (prob.x[i][0].index != 0) {
					logger.error("Wrong kernel matrix: first column must be 0:sample_serial_number\n");
					throw new RuntimeException("Wrong kernel matrix: first column must be 0:sample_serial_number\n");
				}
				if ((int) prob.x[i][0].value <= 0
						|| (int) prob.x[i][0].value > max_index) {
					logger.error("Wrong input format: sample_serial_number out of range\n");
					throw new RuntimeException("Wrong input format: sample_serial_number out of range\n");
				}
			}
		}
		
		return prob;
	}
}
