package svm.predictor.files.creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svm.predictor.data.retrieving.Instance;
import svm.predictor.dto.LearningCategory;

public abstract class BaseFileCreator {

	private static Logger logger = LoggerFactory.getLogger(BaseFileCreator.class);
	
	public void createFile(String fileName, List<Double> labels, List<Instance> instances, List<String> attributeNames, 
			LearningCategory learningCategory) {
		String fullFileName = fileName + getFileExtension();
		BufferedWriter writer = null;
		try {
			File file = new File(fullFileName);
			writer = new BufferedWriter(new FileWriter(file));
			
			StringBuilder header = getHeader(attributeNames, learningCategory);
			writer.append(header);
			
			String dataStartMarker = getDataStartMarker();
			writer.append(dataStartMarker);
			for(int i = 0; i < labels.size(); ++i) {
				Double label = labels.get(i);
				Instance instance = instances.get(i);
				StringBuilder line = getDataLine(label, instance, attributeNames.size());
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
	
	public abstract String getDefaultLocation();
	
	protected abstract String getFileExtension();
	
	protected abstract StringBuilder getHeader(List<String> attributeNames, LearningCategory learningCategory);
	
	protected abstract StringBuilder getDataLine(Double label, Instance instance, int attributeCount);
	
	protected abstract String getDataStartMarker();
}
