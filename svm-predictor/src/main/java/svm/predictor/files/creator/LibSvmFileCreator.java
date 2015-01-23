package svm.predictor.files.creator;

import java.util.List;

import org.springframework.stereotype.Service;

import svm.predictor.weka.dto.Attribute;
import svm.predictor.weka.dto.Instance;

@Service("libSvmFileCreator")
public class LibSvmFileCreator extends BaseFileCreator {

	@Override
	public String getDefaultLocation() {
		return "D:\\libsvm-320\\windows\\";
	}

	@Override
	protected String getFileExtension() {
		return "";
	}

	@Override
	protected StringBuilder getHeader(List<String> attributeNames) {
		return new StringBuilder("");
	}

	@Override
	protected StringBuilder getDataLine(Double label, Instance instance, int attributeCount) {
		StringBuilder line = new StringBuilder();
		line.append(label + " ");
		for(int i = 0; i < instance.getAttributes().size(); ++i) {
			Attribute attribute = instance.getAttributes().get(i);
			line.append(attribute.getIndex() + ":" + attribute.getValue() + " ");
		}
		line.append("\n");
		
		return line;
	}

	@Override
	protected String getDataStartMarker() {
		return "";
	}

}
