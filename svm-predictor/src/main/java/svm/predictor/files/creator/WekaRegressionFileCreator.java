package svm.predictor.files.creator;

import org.springframework.stereotype.Service;

@Service("wekaRegressionFileCreator")
public class WekaRegressionFileCreator extends BaseWekaFileCreator {

	@Override
	protected String getClassType() {
		return "NUMERIC";
	}

}
