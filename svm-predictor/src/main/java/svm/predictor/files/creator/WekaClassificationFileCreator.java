package svm.predictor.files.creator;

import org.springframework.stereotype.Service;

@Service("wekaClassificationFileCreator")
public class WekaClassificationFileCreator extends BaseWekaFileCreator {
	
	@Override
	protected String getClassType() {
		return "{1,-1}";
	}
}
