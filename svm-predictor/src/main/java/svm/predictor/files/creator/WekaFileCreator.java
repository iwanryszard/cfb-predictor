package svm.predictor.files.creator;

import java.util.List;

import org.springframework.stereotype.Service;

import svm.predictor.data.retrieving.Attribute;
import svm.predictor.data.retrieving.Instance;
import svm.predictor.dto.LearningCategory;

@Service("wekaFileCreator")
public class WekaFileCreator extends BaseFileCreator {

	@Override
	public String getDefaultLocation() {
		return "C:\\Users\\vanko\\Documents\\weka-data-files\\";
	}

	@Override
	protected StringBuilder getHeader(List<String> attributeNames, LearningCategory learningCategory) {
		StringBuilder result = new StringBuilder();
		result.append("@RELATION CFB\n\n");
		
		for(String attribute : attributeNames) {
			result.append("@ATTRIBUTE " + attribute + " NUMERIC\n");
		}
		String classType = getClassType(learningCategory);
		result.append("@ATTRIBUTE class " + classType + "\n");
		
		return result;
	}
	
	private String getClassType(LearningCategory learningCategory) {
		String result = "";
		if(LearningCategory.CLASSIFICATION.equals(learningCategory)) {
			result =  "{1,-1}";
		} else {
			result = "NUMERIC"; 
		}
		
		return result;
	}

	@Override
	protected StringBuilder getDataLine(Double label, Instance instance, int attributeCount) {
		StringBuilder line = new StringBuilder();
		line.append("{");
		for(int i = 0; i < instance.getAttributes().size(); ++i) {
			Attribute attribute = instance.getAttributes().get(i);
			line.append((attribute.getIndex() - 1) + " " + attribute.getValue() + ", ");
		}
		line.append(attributeCount + " " + label.intValue() + "}\n");
		
		return line;
	}

	@Override
	protected String getDataStartMarker() {
		return "@DATA\n";
	}

	@Override
	protected String getFileExtension() {
		return ".arff";
	}
}
