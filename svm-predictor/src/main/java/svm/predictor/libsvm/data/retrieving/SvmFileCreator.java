package svm.predictor.libsvm.data.retrieving;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.weka.dto.Attribute;
import svm.predictor.weka.dto.Instance;


@Service("svmFileCreator")
public class SvmFileCreator {

	private static Logger logger = LoggerFactory.getLogger(SvmFileCreator.class);
	
	@Autowired
	private SvmDataRetriever svmDataRetriever;
	
	public void createSVMFile(int startSeason, int endSeason, String fileName, Integer minimumGamesPlayed) {
		SvmDataDto svmData = svmDataRetriever.getGamesAsSvmData(startSeason, endSeason, minimumGamesPlayed, new PointSpreadDataRetriever(new CfbSupportedFeaturesProvider()));
		writeToFile(fileName, svmData.getLabels(), svmData.getInstances());
	}
	
	private void writeToFile(String fileName, List<Double> labels, List<Instance> instances) {
		String path = "D:\\libsvm-320\\windows\\";
		BufferedWriter writer = null;
		try {
			File file = new File(path + fileName);
			writer = new BufferedWriter(new FileWriter(file));
			
			for(int i = 0; i < labels.size(); ++i) {
				Double label = labels.get(i);
				List<Attribute> currentAttributes = instances.get(i).getAttributes();
				StringBuilder line = getLine(label, currentAttributes);
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
	
	private StringBuilder getLine(Double label, List<Attribute> attributes ) {
		StringBuilder line = new StringBuilder();
		line.append(label + " ");
		for(int i = 0; i < attributes.size(); ++i) {
			line.append((i + 1) + ":" + attributes.get(i).getValue() + " ");
		}
		line.append("\n");
		
		return line;
	}
}
