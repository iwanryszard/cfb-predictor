package svm.predictor.stats.web;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.libsvm.PredictionResultDto;
import svm.predictor.libsvm.SvmPredictor;
import svm.predictor.libsvm.SvmTrainer;
import svm.predictor.libsvm.data.retrieving.BaseDataRetriever;
import svm.predictor.libsvm.data.retrieving.CfbSupportedFeaturesProvider;
import svm.predictor.libsvm.data.retrieving.GameOddsDto;
import svm.predictor.libsvm.data.retrieving.MoneyLineDataRetriever;
import svm.predictor.libsvm.data.retrieving.NflSupportedFeaturesProvider;
import svm.predictor.libsvm.data.retrieving.PointSpreadDataRetriever;
import svm.predictor.libsvm.data.retrieving.PointTotalDataRetriever;
import svm.predictor.libsvm.data.retrieving.SupportedFeaturesProvider;
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
	
	private ScaleRestoreDto scaleRestoreDto;
	
	private List<String> predictionTypes = Arrays.asList("Point Spread", "Point Total", "Money Line");
	
	private String selectedPredictionType;
	
	@Autowired
	private DataScaler dataScaler;
	
	@Autowired
	private SvmTrainer svmTrainer;
	
	@Autowired
	private SvmPredictor svmPredictor;
	
	@Autowired
	private SvmDataRetriever svmDataRetriever;

	private int leagueValue;
	
	public void trainModel() {
		modelTrained = false;
		BaseDataRetriever dataRetriever = getDataRetriever();
		SvmDataDto trainingData = svmDataRetriever.getGamesAsSvmData(trainingStartYear, trainingEndYear, minimumGamesPlayed, dataRetriever);
		trainingSummaryMsg = trainingData.getLabels().size() + " games with " + trainingData.getFeatures().get(0).size() + " features each";
		ScaleResultDto scaledTrainingData = dataScaler.getScaledData(trainingData.getLabels(), trainingData.getFeatures(), 
				-1.0, 1.0, null, null, null);
		scaleRestoreDto = scaledTrainingData.getScaleRestoreDto();
		model = svmTrainer.trainModel(scaledTrainingData.getLabels(), scaledTrainingData.getFeatures());
		modelTrained = true;
	}
	
	public void predict() {
		BaseDataRetriever dataRetriever = getDataRetriever();
		SvmDataDto testingData = svmDataRetriever.getGamesAsSvmData(testingStartYear, testingEndYear, minimumGamesPlayed, dataRetriever);
		testingSummaryMsg = testingData.getLabels().size() + " games with " + testingData.getFeatures().get(0).size() + " features each";
		ScaleResultDto scaledTestingData = dataScaler.getScaledData(testingData.getLabels(), testingData.getFeatures(), null, null,
				null, null, scaleRestoreDto);

		PredictionResultDto predictionResult = svmPredictor.predict(scaledTestingData.getFeatures(), model, null);
		expectedResult = scaledTestingData.getLabels();
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
	
	private BaseDataRetriever getDataRetriever() {
		BaseDataRetriever result = null;
		SupportedFeaturesProvider featureProvider = getSupportedFeaturesProvider();
		if(selectedPredictionType.equals("Point Spread")) {
			result = new PointSpreadDataRetriever(featureProvider);
		} else if(selectedPredictionType.equals("Point Total")) {
			result = new PointTotalDataRetriever(featureProvider);
		} else if(selectedPredictionType.equals("Money Line")) {
			result = new MoneyLineDataRetriever(featureProvider);
		} else {
			result = new PointSpreadDataRetriever(featureProvider);
		}
		
		return result;
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

	public List<String> getPredictionTypes() {
		return predictionTypes;
	}

	public void setPredictionTypes(List<String> predictionTypes) {
		this.predictionTypes = predictionTypes;
	}

	public String getSelectedPredictionType() {
		return selectedPredictionType;
	}

	public void setSelectedPredictionType(String selectedPredictionType) {
		this.selectedPredictionType = selectedPredictionType;
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
	
	public int getLeagueValue() {
		return leagueValue;
	}

	public void setLeagueValue(int leagueValue) {
		this.leagueValue = leagueValue;
	}
	
	private SupportedFeaturesProvider getSupportedFeaturesProvider() {
		if(leagueValue == 0) {
			return new CfbSupportedFeaturesProvider();
		} else {
			return new NflSupportedFeaturesProvider();
		}
	}

}
