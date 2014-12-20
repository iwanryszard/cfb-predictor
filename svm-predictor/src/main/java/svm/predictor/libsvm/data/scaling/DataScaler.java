package svm.predictor.libsvm.data.scaling;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("dataScaler")
public class DataScaler {

	private static final Logger logger = LoggerFactory.getLogger(DataScaler.class);
	
	public ScaleResultDto getScaledData(List<Integer> labels, List<List<Number>> features, Double xLower, 
			Double xUpper, Double yLower, Double yUpper, ScaleRestoreDto scaleRestore) {
		double lower = -1.0;
		double upper = 1.0;
		double y_lower = 0.0;
		double y_upper = 0.0;
		boolean y_scaling = false;
		double[] feature_max;
		double[] feature_min;
		double y_max = -Double.MAX_VALUE;
		double y_min = Double.MAX_VALUE;
		int max_index = 0;
		
		if(xLower != null) {
			lower = xLower;
		}
		
		if(xUpper != null) {
			upper = xUpper;
		}
		
		if(yLower != null && yUpper != null) {
			y_lower = yLower;
			y_upper = yUpper;
			y_scaling = true;
		}
		
		if(!(upper > lower) || (y_scaling && !(y_upper > y_lower)))
		{
			logger.error("inconsistent lower/upper specification");
			throw new RuntimeException("inconsistent lower/upper specification");
		}
		
		//in our case all examples will have equal number of features
		max_index = features.get(0).size();
		
		feature_max = new double[(max_index+1)];
		feature_min = new double[(max_index+1)];
		
		for(int i=0;i<=max_index;i++)
		{
			feature_max[i] = -Double.MAX_VALUE;
			feature_min[i] = Double.MAX_VALUE;
		}
		
		for(int i = 0; i < labels.size(); ++i) {
			int label = labels.get(i);
			y_max = Math.max(y_max, label);
			y_min = Math.min(y_min, label);
			
			List<Number> currentFeatures = features.get(i);
			for(int j = 0; j < currentFeatures.size(); ++j) {
				//indexes are 1 based
				int index = j + 1;
				Double value = currentFeatures.get(j).doubleValue();
				
				feature_max[index] = Math.max(feature_max[index], value);
				feature_min[index] = Math.min(feature_min[index], value);
			}
		}
		
		if(scaleRestore != null) {
			if(scaleRestore.isY_scaling()) {
				y_lower = scaleRestore.getY_lower();
				y_upper = scaleRestore.getY_upper();
				y_min = scaleRestore.getY_min();
				y_max = scaleRestore.getY_max();
				y_scaling = true;
			}
			
			lower = scaleRestore.getLower();
			upper = scaleRestore.getUpper();
			feature_min = scaleRestore.getFeature_min();
			feature_max = scaleRestore.getFeature_max();
		} else {
			scaleRestore = new ScaleRestoreDto();
			if(y_scaling)
			{
				scaleRestore.setY_lower(y_lower);
				scaleRestore.setY_upper(y_upper);
				scaleRestore.setY_min(y_min);
				scaleRestore.setY_max(y_max);
				scaleRestore.setY_scaling(y_scaling);
			}
			
			scaleRestore.setLower(lower);
			scaleRestore.setUpper(upper);
			scaleRestore.setFeature_min(feature_min);
			scaleRestore.setFeature_max(feature_max);
		}
		
		ScaleResultDto result = new ScaleResultDto();
		result.setScaleRestoreDto(scaleRestore);
		
		List<Double> scaledLabels = new ArrayList<Double>(labels.size());
		List<List<IndexValuePair>> scaledFeatures = new ArrayList<List<IndexValuePair>>(labels.size());
		for(int i = 0; i < labels.size(); ++i) {
			int label = labels.get(i);
			double labelVal = label;
			if(y_scaling) {
				labelVal = scaleLabel(label, y_lower, y_upper, y_min, y_max);
			}
			scaledLabels.add(labelVal);
			
			List<Number> currentFeatures = features.get(i);
			List<IndexValuePair> currentScaledFeatures = new ArrayList<IndexValuePair>();
			for(int j = 0; j < currentFeatures.size(); ++j) {
				//indexes are 1 based
				int index = j + 1;
				Double value = currentFeatures.get(j).doubleValue();
				Double scaledValue = scaleFeature(index, value, lower, upper, feature_min, feature_max);
				if(scaledValue != null) {
					currentScaledFeatures.add(new IndexValuePair(index, scaledValue));
				}
			}
			scaledFeatures.add(currentScaledFeatures);
		}
		
		result.setLabels(scaledLabels);
		result.setFeatures(scaledFeatures);
		
		return result;
	}
	
	private double scaleLabel(double value, double y_lower, double y_upper, double y_min, double y_max) {
		if (value == y_min)
			value = y_lower;
		else if (value == y_max)
			value = y_upper;
		else
			value = y_lower + (y_upper - y_lower) * (value - y_min)
					/ (y_max - y_min);

		return value;
	}

	private Double scaleFeature(int index, double value, double lower, double upper, double[] feature_min, double[] feature_max) {
		/* skip single-valued attribute */
		if (feature_max[index] == feature_min[index])
			return null;
		if (value == feature_min[index])
			value = lower;
		else if (value == feature_max[index])
			value = upper;
		else
			value = lower + (upper - lower) * (value - feature_min[index])
					/ (feature_max[index] - feature_min[index]);
		if (value != 0) {
			return value;
		}
		
		return null;
	}
}
