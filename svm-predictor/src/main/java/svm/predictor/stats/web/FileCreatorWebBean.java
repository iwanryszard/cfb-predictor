package svm.predictor.stats.web;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.files.creator.BaseFileCreator;

@Component("fileCreatorWebBean")
@Scope("view")
public class FileCreatorWebBean extends BasePredictionWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6136528293230839968L;

	private List<String> attributeNames;
	
	private String fileLocation;
	private List<String> allFileTypes = Arrays.asList("Weka", "libsvm");
	private List<String> fileTypes = allFileTypes;
	private String selectedFileType;
	
	@PostConstruct
	private void setFileLocation() {
		BaseFileCreator fileCreator = learningFactory.getFileCreator(selectedFileType, getLearningCategory());
		fileLocation = fileCreator.getDefaultLocation();
	}
	
	public void createTrainingFile() {
		scaleRestoreDto = null;
		GameDataDto trainingData = getGamesData(trainingStartYear, trainingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		attributeNames = trainingData.getAttributeNames();
		
		BaseFileCreator fileCreator = learningFactory.getFileCreator(selectedFileType, getLearningCategory());
		fileCreator.createFile(fileLocation + "CFB-train", trainingData.getLabels(), trainingData.getInstances(), attributeNames);
	}
	
	public void createTestingFile() {
		GameDataDto testingData = getGamesData(testingStartYear, testingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		attributeNames = testingData.getAttributeNames();
		
		BaseFileCreator fileCreator = learningFactory.getFileCreator(selectedFileType, getLearningCategory());
		fileCreator.createFile(fileLocation + "CFB-test", testingData.getLabels(), testingData.getInstances(), attributeNames);
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public List<String> getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(List<String> fileTypes) {
		this.fileTypes = fileTypes;
	}

	public String getSelectedFileType() {
		return selectedFileType;
	}

	public void setSelectedFileType(String selectedFileType) {
		this.selectedFileType = selectedFileType;
	}
	
	public void fileTypeChanged() {
		setFileLocation();
	}
	
	@Override
	public void predictionTypeChanged() {
		super.predictionTypeChanged();
		if(attributeEnabled) {
			fileTypes = Arrays.asList("Weka");
		} else {
			fileTypes = allFileTypes;
		}
	}
	
}
