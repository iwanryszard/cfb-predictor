package svm.predictor.stats.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.libsvm.data.retrieving.CfbSupportedFeaturesProvider;
import svm.predictor.libsvm.data.retrieving.PointSpreadDataRetriever;
import svm.predictor.libsvm.data.retrieving.SvmDataDto;
import svm.predictor.libsvm.data.retrieving.SvmDataRetriever;
import svm.predictor.libsvm.data.scaling.DataScaler;
import svm.predictor.libsvm.data.scaling.ScaleRestoreDto;
import svm.predictor.libsvm.data.scaling.ScaleResultDto;
import svm.predictor.weka.dto.Attribute;
import svm.predictor.weka.dto.Instance;

@Component("wekaFileCreator")
@Scope("view")
public class WekaFileCreator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6136528293230839968L;
	
	private static Logger logger = LoggerFactory.getLogger(WekaFileCreator.class);

	private Integer startYear;
	private Integer endYear;
	private ScaleRestoreDto scaleRestoreDto;
	private Integer minimumGamesPlayed;
	private boolean testFile;
	private boolean scaleData = true;
	private int attributeCount;
	private List<String> attributeNames;
	
	@Autowired
	private DataScaler dataScaler;
	
	@Autowired
	private SvmDataRetriever svmDataRetriever;

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}
	
	public void createFile() {
		SvmDataDto data = svmDataRetriever.getGamesAsSvmData(startYear, endYear, minimumGamesPlayed, new PointSpreadDataRetriever(new CfbSupportedFeaturesProvider()));
		attributeNames = data.getAttributeNames();
		attributeCount = attributeNames.size();
		List<Instance> instances = data.getInstances();
		List<Double> labels = data.getLabels();
		ScaleResultDto scaledData = null;
		if(scaleData) {
			scaledData = dataScaler.getScaledData(data.getLabels(), data.getInstances(), 
				-1.0, 1.0, null, null, scaleRestoreDto);
			instances = scaledData.getInstances();
			labels = scaledData.getLabels();
		}
		
		if( !testFile && scaledData != null) {
			scaleRestoreDto = scaledData.getScaleRestoreDto();
		} else {
			scaleRestoreDto = null;
		}
		String fileSpecPart = "";
		if( !testFile) {
			fileSpecPart = "train";
		} else {
			fileSpecPart = "test";
		}
		
		writeToFile("CFB-" + fileSpecPart + ".arff", labels, instances);
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

	public Integer getMinimumGamesPlayed() {
		return minimumGamesPlayed;
	}

	public void setMinimumGamesPlayed(Integer minimumGamesPlayed) {
		this.minimumGamesPlayed = minimumGamesPlayed;
	}

	public boolean getTestFile() {
		return testFile;
	}

	public void setTestFile(boolean testFile) {
		this.testFile = testFile;
	}

	public boolean getScaleData() {
		return scaleData;
	}

	public void setScaleData(boolean scaleData) {
		this.scaleData = scaleData;
	}
}
