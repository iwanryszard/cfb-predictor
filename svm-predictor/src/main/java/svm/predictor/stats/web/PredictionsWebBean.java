package svm.predictor.stats.web;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.data.retrieving.GameOddsDto;
import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.libsvm.PredictionResultDto;
import svm.predictor.libsvm.SvmPredictor;
import svm.predictor.libsvm.SvmTrainer;

@Component("predictionsWebBean")
@Scope("view")
public class PredictionsWebBean extends BasePredictionWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1003232478601320283L;
	
	private static Logger logger = LoggerFactory.getLogger(PredictionsWebBean.class);
	
	private String resultMessage;
	
	private String trainingSummaryMsg;
	private String testingSummaryMsg;
	
	private Double stakeValue;
	private Double totalStaked;
	private Double totalWon;
	private Double netWon;
	private Double roiPct;
	
	private List<Double> expectedResult;
	private List<Double> predictions;
	private List<GameOddsDto> gamesOdds;
	
	private svm_model model;
	
	private boolean modelTrained;
	
	@Autowired
	private SvmTrainer svmTrainer;
	
	@Autowired
	private SvmPredictor svmPredictor;
	
	public void trainModel() {
		modelTrained = false;
		scaleRestoreDto = null;
		GameDataDto trainingData = getGamesData(trainingStartYear, trainingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		trainingSummaryMsg = trainingData.getLabels().size() + " games with " + trainingData.getAttributeNames().size() + " attributes each";
		model = svmTrainer.trainModel(trainingData.getLabels(), trainingData.getInstances());
		modelTrained = true;
	}
	
	public void predict() {
		GameDataDto testingData = getGamesData(testingStartYear, testingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		testingSummaryMsg = testingData.getLabels().size() + " games with " + testingData.getAttributeNames().size() + " attributes each";
		PredictionResultDto predictionResult = svmPredictor.predict(testingData.getInstances(), model, null);
		expectedResult = testingData.getLabels();
		predictions = predictionResult.getPredictions();
		gamesOdds = testingData.getGamesOdds();

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
			NumberFormat formatter = new DecimalFormat("#0.00");
			double accuracy = (double) correct / total * 100;
			resultMessage = "Accuracy = " + formatter.format(accuracy) + "% (" + correct + "/" + total + ") (classification)";
			logger.info(resultMessage);
		}
	}
	
	public void computeStatsForStake() {
		totalStaked = 0.0;
		totalWon = 0.0;
		netWon = 0.0;
		roiPct = 0.0;
		int gamesCount = predictions.size();
		totalStaked = gamesCount * stakeValue;
		for (int i = 0; i < predictions.size(); ++i) {
			double v = predictions.get(i);
			double target = expectedResult.get(i);
			if (v == target) {
				Double odds = v == 1 ? gamesOdds.get(i).getHomeOdds() : gamesOdds.get(i).getAwayOdds();
				totalWon += stakeValue * odds;
			}
		}
		netWon = totalWon - totalStaked;
		roiPct = (totalWon / totalStaked) * 100;
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

	public String getTrainingSummaryMsg() {
		return trainingSummaryMsg;
	}

	public void setTrainingSummaryMsg(String trainingSummaryMsg) {
		this.trainingSummaryMsg = trainingSummaryMsg;
	}

	public String getTestingSummaryMsg() {
		return testingSummaryMsg;
	}

	public void setTestingSummaryMsg(String testingSummaryMsg) {
		this.testingSummaryMsg = testingSummaryMsg;
	}

	public Double getStakeValue() {
		return stakeValue;
	}

	public void setStakeValue(Double stakeValue) {
		this.stakeValue = stakeValue;
	}

	public Double getTotalStaked() {
		return totalStaked;
	}

	public void setTotalStaked(Double totalStaked) {
		this.totalStaked = totalStaked;
	}

	public Double getTotalWon() {
		return totalWon;
	}

	public void setTotalWon(Double totalWon) {
		this.totalWon = totalWon;
	}

	public Double getNetWon() {
		return netWon;
	}

	public void setNetWon(Double netWon) {
		this.netWon = netWon;
	}

	public Double getRoiPct() {
		return roiPct;
	}

	public void setRoiPct(Double roiPct) {
		this.roiPct = roiPct;
	}

}
