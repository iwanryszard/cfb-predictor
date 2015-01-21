package svm.predictor.stats.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.libsvm.data.retrieving.SvmDataDto;
import svm.predictor.weka.dto.Attribute;
import svm.predictor.weka.dto.Instance;

@Component("wekaFileCreator")
@Scope("view")
public class WekaFileCreator extends BasePredictionWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6136528293230839968L;
	
	private static Logger logger = LoggerFactory.getLogger(WekaFileCreator.class);

	private int attributeCount;
	private List<String> attributeNames;
	
	public void createTrainingFile() {
		scaleRestoreDto = null;
		SvmDataDto trainingData = getGamesData(trainingStartYear, trainingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		attributeNames = trainingData.getAttributeNames();
		attributeCount = attributeNames.size();
		
		writeToFile("CFB-train.arff", trainingData.getLabels(), trainingData.getInstances());
	}
	
	public void createTestingFile() {
		SvmDataDto trainingData = getGamesData(testingStartYear, testingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		attributeNames = trainingData.getAttributeNames();
		attributeCount = attributeNames.size();
		
		writeToFile("CFB-test.arff", trainingData.getLabels(), trainingData.getInstances());
	}
	
	private void writeToFile(String fileName, List<Double> labels, List<Instance> instances) {
		String path = "C:\\Users\\vanko\\Documents\\weka-data-files\\";
		BufferedWriter writer = null;
		try {
			File file = new File(path + fileName);
			writer = new BufferedWriter(new FileWriter(file));
			
			StringBuilder header = getHeader();
			writer.append(header);
			
			writer.append("@DATA\n");
			for(int i = 0; i < labels.size(); ++i) {
				Double label = labels.get(i);
				Instance instance = instances.get(i);
				StringBuilder line = getDataLine(label, instance);
				writer.append(line);
			}
		} catch(Exception e) {
			logger.error("Error writing to file", e);
		} finally {
			try {
                writer.close();
            } catch (Exception e) {
            	logger.error("Error closing writer", e);
            }
		}
	}
	
	private StringBuilder getHeader() {
		StringBuilder result = new StringBuilder();
		result.append("@RELATION CFB\n\n");
		
		for(String attribute : attributeNames) {
			result.append("@ATTRIBUTE " + attribute + " NUMERIC\n");
		}
		result.append("@ATTRIBUTE class {1,-1}\n");
		
		return result;
	}
	
	private StringBuilder getDataLine(Double label, Instance instance) {
		StringBuilder line = new StringBuilder();
		line.append("{");
		for(int i = 0; i < instance.getAttributes().size(); ++i) {
			Attribute attribute = instance.getAttributes().get(i);
			line.append((attribute.getIndex() - 1) + " " + attribute.getValue() + ", ");
		}
		line.append(attributeCount + " " + label.intValue() + "}\n");
		
		return line;
	}
}
