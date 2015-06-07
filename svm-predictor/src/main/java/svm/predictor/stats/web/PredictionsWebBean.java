package svm.predictor.stats.web;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.data.retrieving.GameOddsDto;
import svm.predictor.dto.LearningCategory;
import svm.predictor.predictions.Classifier;
import svm.predictor.predictions.ClassifierBuilder;
import svm.predictor.predictions.EvaluationResultDto;

@Component("predictionsWebBean")
@Scope("view")
public class PredictionsWebBean extends BasePredictionWebBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1003232478601320283L;
	
	private String resultMessage;
	private String regressionResultMessage;
	
	private String trainingSummaryMsg;
	private String testingSummaryMsg;
	
	private Double stakeValue;
	private Double totalStaked;
	private Double totalWon;
	private Double netWon;
	private Double roiPct;
	
	private List<Double> expectedResult;
	private List<Double> predictions;
	private List<Double> awayExpectedResult;
	private List<Double> awayPredictions;
	private List<GameOddsDto> gamesOdds;
	
	private boolean modelTrained;
	
	private Classifier classifier;
	private Classifier awayClassifier;
	
	private String selectedClassifierType;
	private List<String> classifiers = Arrays.asList("libsvm", "wekaLibSVM", "wekaSMO", "wekaVotedPerceptron", 
			"wekaNaiveBayes", "wekaJ48");
	private List<String> regressions = Arrays.asList("wekaLinearRegression");
	private List<String> classifierTypes = classifiers;
	
	public void trainModel() {
		modelTrained = false;
		scaleRestoreDto = null;
		GameDataDto trainingData = getGamesData(trainingStartYear, trainingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		trainingSummaryMsg = trainingData.getLabels().size() + " games with " + trainingData.getAttributeNames().size() + " attributes each";
		LearningCategory learningCategory = getLearningCategory();
		ClassifierBuilder classifierBuilder = learningFactory.getClassifierBuilder(selectedClassifierType, learningCategory);
		classifier = classifierBuilder.buildClassifier(trainingData, selectedClassifierType);
		
		if(winnerByRegression) {
			homeAway = "away";
			trainingData = getGamesData(trainingStartYear, trainingEndYear, minimumGamesPlayed, scaleData, lower, upper);
			awayClassifier = classifierBuilder.buildClassifier(trainingData, selectedClassifierType);
			homeAway = "home";
		}
		modelTrained = true;
	}
	
	public void predict() {
		GameDataDto testingData = getGamesData(testingStartYear, testingEndYear, minimumGamesPlayed, scaleData, lower, upper);
		testingSummaryMsg = testingData.getLabels().size() + " games with " + testingData.getAttributeNames().size() + " attributes each";
		EvaluationResultDto evaluationResultDto = classifier.evaluate(testingData);
		expectedResult = testingData.getLabels();
		predictions = evaluationResultDto.getPredictions();
		gamesOdds = testingData.getGamesOdds();
		
		int correct = evaluationResultDto.getCorrect();
		int total = testingData.getInstances().size();
		
		if(winnerByRegression) {
			homeAway = "away";
			testingData = getGamesData(testingStartYear, testingEndYear, minimumGamesPlayed, scaleData, lower, upper);
			evaluationResultDto = awayClassifier.evaluate(testingData);
			awayExpectedResult = testingData.getLabels();
			awayPredictions = evaluationResultDto.getPredictions();
			homeAway = "home";
			
			correct = getCorrectForWinnerByRegression(expectedResult, predictions, awayExpectedResult, awayPredictions);
		}
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		double accuracy = (double) correct / total * 100;
		resultMessage = "Accuracy = " + formatter.format(accuracy) + "% (" + correct + "/" + total + ") (classification)";
		if(attributeEnabled) {
			double correlCoef = evaluationResultDto.getCorrelationCoef();
			double meanAbsError = evaluationResultDto.getMeanAbsoluteError();
			double rootMeanSqError = evaluationResultDto.getRootMeanSquaredError();
			regressionResultMessage = "Correlation Coefficient: " + formatter.format(correlCoef) +
				" Mean Absolute Error " + formatter.format(meanAbsError) + 
				" Root Mean Squared Error " + formatter.format(rootMeanSqError);
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
	
	private int getCorrectForWinnerByRegression(List<Double> homeExpected, List<Double> homePredictions, 
			List<Double> awayExpected, List<Double> awayPredictions) {
		int correct = 0;
		for(int i = 0; i < homeExpected.size(); ++i) {
			int target = homeExpected.get(i) >= awayExpected.get(i) ? 1 : -1;
			int value = homePredictions.get(i) >= awayPredictions.get(i) ? 1 : -1;
			if(target == value) {
				++correct;
			}
		}
		
		return correct;
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

	public String getSelectedClassifierType() {
		return selectedClassifierType;
	}

	public void setSelectedClassifierType(String selectedClassifierType) {
		this.selectedClassifierType = selectedClassifierType;
	}

	public List<String> getClassifierTypes() {
		return classifierTypes;
	}

	public void setClassifierTypes(List<String> classifierTypes) {
		this.classifierTypes = classifierTypes;
	}

	public String getRegressionResultMessage() {
		return regressionResultMessage;
	}

	public void setRegressionResultMessage(String regressionResultMessage) {
		this.regressionResultMessage = regressionResultMessage;
	}
	
	@Override
	public void predictionTypeChanged() {
		super.predictionTypeChanged();
		if(attributeEnabled || winnerByRegression) {
			classifierTypes = regressions;
		} else {
			classifierTypes = classifiers;
		}
	}

}
