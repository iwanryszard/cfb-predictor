package svm.predictor.libsvm.data.retrieving;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("svmFileCreator")
public class SvmFileCreator {

	private static Logger logger = LoggerFactory.getLogger(SvmFileCreator.class);
	
	@Autowired
	private SvmDataRetriever svmDataRetriever;
	
	public void createSVMFile(int startSeason, int endSeason, String fileName, Integer minimumGamesPlayed) {
		SvmDataDto svmData = svmDataRetriever.getGamesAsSvmData(startSeason, endSeason, minimumGamesPlayed, new PointSpreadDataRetriever(new CfbSupportedFeaturesProvider()));
		writeToFile(fileName, svmData.getLabels(), svmData.getFeatures());
	}
	
	private void writeToFile(String fileName, List<Integer> labels, List<List<Number>> features) {
		String path = "D:\\libsvm-320\\windows\\";
		BufferedWriter writer = null;
		try {
			File file = new File(path + fileName);
			writer = new BufferedWriter(new FileWriter(file));
			
			for(int i = 0; i < labels.size(); ++i) {
				Integer label = labels.get(i);
				List<Number> currentFeatures = features.get(i);
				StringBuilder line = getLine(label, currentFeatures);
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
	
	private StringBuilder getLine(Integer label, List<Number> features ) {
		StringBuilder line = new StringBuilder();
		line.append(label + " ");
		for(int i = 0; i < features.size(); ++i) {
			line.append((i + 1) + ":" + features.get(i) + " ");
		}
		line.append("\n");
		
		return line;
	}
}
