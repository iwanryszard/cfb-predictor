package svm.predictor.stats.web;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_parameter;
import svm.predictor.libsvm.PredictionResultDto;
import svm.predictor.libsvm.SvmPredictor;
import svm.predictor.libsvm.SvmTrainer;
import svm.predictor.libsvm.data.retrieving.SvmDataDto;
import svm.predictor.libsvm.data.retrieving.SvmDataRetriever;
import svm.predictor.libsvm.data.scaling.DataScaler;
import svm.predictor.libsvm.data.scaling.ScaleRestoreDto;
import svm.predictor.libsvm.data.scaling.ScaleResultDto;

@Component("predictionsWebBean")
@Scope("view")
public class PredictionsWebBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1003232478601320283L;
	
	private static Logger logger = LoggerFactory.getLogger(PredictionsWebBean.class);
	
	private Integer trainingStartYear;
	private Integer trainingEndYear;
	
	private Integer testingStartYear;
	private Integer testingEndYear;
	
	private Integer minimumGamesPlayed;
	
	private String resultMessage;
	
	private svm_model model;
	
	private boolean modelTrained;
	
	private ScaleRestoreDto scaleRestoreDto;
	
	@Autowired
	private DataScaler dataScaler;
	
	@Autowired
	private SvmTrainer svmTrainer;
	
	@Autowired
	private SvmPredictor svmPredictor;
	
	@Autowired
	private SvmDataRetriever svmDataRetriever;
	
	public void trainModel() {
		modelTrained = false;
		SvmDataDto trainingData = svmDataRetriever.getGamesAsSvmData(trainingStartYear, trainingEndYear, minimumGamesPlayed);
		ScaleResultDto scaledTrainingData = dataScaler.getScaledData(trainingData.getLabels(), trainingData.getFeatures(), 
				-1.0, 1.0, null, null, null);
		scaleRestoreDto = scaledTrainingData.getScaleRestoreDto();
		model = svmTrainer.trainModel(scaledTrainingData.getLabels(), scaledTrainingData.getFeatures());
		modelTrained = true;
	}
	
	public void predict() {
		SvmDataDto testingData = svmDataRetriever.getGamesAsSvmData(testingStartYear, testingEndYear, minimumGamesPlayed);
		ScaleResultDto scaledTestingData = dataScaler.getScaledData(testingData.getLabels(), testingData.getFeatures(), null, null,
				null, null, scaleRestoreDto);

		PredictionResultDto predictionResult = svmPredictor.predict(scaledTestingData.getFeatures(), model, null);
		List<Double> expectedResult = scaledTestingData.getLabels();
		List<Double> predictions = predictionResult.getPredictions();

		int correct = 0;
		int total = 0;
		double error = 0;
		double sumv = 0, sumy = 0, sumvv = 0, sumyy = 0, sumvy = 0;
		for (int i = 0; i < predictions.size(); ++i) {
			double v = predictions.get(i);
			double target = expectedResult.get(i);
			if (v == target) {
				++correct;
			}
			error += (v - target) * (v - target);
			sumv += v;
			sumy += target;
			sumvv += v * v;
			sumyy += target * target;
			sumvy += v * target;
			++total;
		}

		int svm_type = svm.svm_get_svm_type(model);
		if (svm_type == svm_parameter.EPSILON_SVR || svm_type == svm_parameter.NU_SVR) {
			logger.info("Mean squared error = " + error / total + " (regression)\n");
			logger.info("Squared correlation coefficient = "
					+ ((total * sumvy - sumv * sumy) * (total * sumvy - sumv * sumy))
					/ ((total * sumvv - sumv * sumv) * (total * sumyy - sumy * sumy)) + " (regression)\n");
		} else {
			resultMessage = "Accuracy = " + (double) correct / total * 100 + "% (" + correct + "/" + total + ") (classification)";
			logger.info(resultMessage);
		}
	}

	public Integer getTrainingStartYear() {
		return trainingStartYear;
	}

	public void setTrainingStartYear(Integer trainingStartYear) {
		this.trainingStartYear = trainingStartYear;
	}

	public Integer getTrainingEndYear() {
		return trainingEndYear;
	}

	public void setTrainingEndYear(Integer trainingEndYear) {
		this.trainingEndYear = trainingEndYear;
	}

	public Integer getTestingStartYear() {
		return testingStartYear;
	}

	public void setTestingStartYear(Integer testingStartYear) {
		this.testingStartYear = testingStartYear;
	}

	public Integer getTestingEndYear() {
		return testingEndYear;
	}

	public void setTestingEndYear(Integer testingEndYear) {
		this.testingEndYear = testingEndYear;
	}

	public Integer getMinimumGamesPlayed() {
		return minimumGamesPlayed;
	}

	public void setMinimumGamesPlayed(Integer minimumGamesPlayed) {
		this.minimumGamesPlayed = minimumGamesPlayed;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public boolean isModelTrained() {
		return modelTrained;
	}

	public void setModelTrained(boolean modelTrained) {
		this.modelTrained = modelTrained;
	}

}
