package svm.predictor.stats.web;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.files.creator.BaseFileCreator;
import svm.predictor.libsvm.data.retrieving.SvmDataDto;

@Component("fileCreatorWebBean")
@Scope("view")
public class FileCreatorWebBean extends BasePredictionWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6136528293230839968L;

	private List<String> attributeNames;
	
	@Autowired
	private BaseFileCreator wekaFileCreator;
	
	@Autowired
	private BaseFileCreator libSvmFileCreator;
	
	private String fileLocation;
	private List<String> fileTypes = Arrays.asList("Weka", "libsvm");
	private String selectedFileType;
	
	@PostConstruct
	private void setFileLocation() {
		BaseFileCreator fileCreator = getFileCreator();
		fileLocation = fileCreator.getDefaultLocation();
	}
	
	public void createTrainingFile() {
		scaleRestoreDto = null;
		SvmDataDto trainingData = getGamesData(trainingStartYear, trainingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		attributeNames = trainingData.getAttributeNames();
		
		BaseFileCreator fileCreator = getFileCreator();
		fileCreator.createFile(fileLocation + "CFB-train", trainingData.getLabels(), trainingData.getInstances(), attributeNames);
	}
	
	public void createTestingFile() {
		SvmDataDto trainingData = getGamesData(testingStartYear, testingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		attributeNames = trainingData.getAttributeNames();
		
		BaseFileCreator fileCreator = getFileCreator();
		fileCreator.createFile(fileLocation + "CFB-test", trainingData.getLabels(), trainingData.getInstances(), attributeNames);
	}
	
	private BaseFileCreator getFileCreator() {
		if("Weka".equals(selectedFileType)) {
			return wekaFileCreator;
		} else if("libsvm".equals(selectedFileType)) {
			return libSvmFileCreator;
		}
		
		return wekaFileCreator;
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
	
}
