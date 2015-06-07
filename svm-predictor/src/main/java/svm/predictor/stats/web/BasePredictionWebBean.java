package svm.predictor.stats.web;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import svm.predictor.data.retrieving.AttributeDataRetriever;
import svm.predictor.data.retrieving.BaseDataRetriever;
import svm.predictor.data.retrieving.CfbSupportedFeaturesProvider;
import svm.predictor.data.retrieving.GameDataDto;
import svm.predictor.data.retrieving.GameDataRetriever;
import svm.predictor.data.retrieving.MoneyLineDataRetriever;
import svm.predictor.data.retrieving.NflSupportedFeaturesProvider;
import svm.predictor.data.retrieving.PointSpreadDataRetriever;
import svm.predictor.data.retrieving.PointTotalDataRetriever;
import svm.predictor.data.retrieving.SupportedFeaturesProvider;
import svm.predictor.dto.LearningCategory;
import svm.predictor.dto.TeamGameStatsDto;
import svm.predictor.libsvm.data.scaling.DataScaler;
import svm.predictor.libsvm.data.scaling.ScaleRestoreDto;
import svm.predictor.libsvm.data.scaling.ScaleResultDto;
import svm.predictor.utils.LearningFactory;

public abstract class BasePredictionWebBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1733271796797048820L;
	
	@Autowired
	protected DataScaler dataScaler;
	
	@Autowired
	protected GameDataRetriever gameDataRetriever;
	
	@Autowired 
	protected LearningFactory learningFactory;
	
	protected int leagueValue;
	
	protected ScaleRestoreDto scaleRestoreDto;
	
	protected List<String> predictionTypes = Arrays.asList("Point Spread", "Point Total", "Money Line", "Attribute", "Winner by Regression");
	
	protected String selectedPredictionType;
	
	protected Integer trainingStartYear;
	protected Integer trainingEndYear;
	
	protected Integer testingStartYear;
	protected Integer testingEndYear;
	
	protected Integer minimumGamesPlayed;
	
	protected boolean scaleData = true;
	protected Double lower = -1.0;
	protected Double upper = 1.0;
	
	protected List<String> attributeNames;
	protected String selectedAttribute;
	protected String homeAway;
	protected boolean attributeEnabled;
	protected boolean winnerByRegression;
	
	@PostConstruct
	public void postConstruct() {
		Field[] attributeFields = TeamGameStatsDto.class.getDeclaredFields();
		attributeNames = new ArrayList<String>(attributeFields.length);
		for(Field field : attributeFields) {
			attributeNames.add(field.getName());
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
		} else if(selectedPredictionType.equals("Attribute")) {
			result = new AttributeDataRetriever(featureProvider, homeAway + selectedAttribute);
		} else if(selectedPredictionType.equals("Winner by Regression")) {
			result = new AttributeDataRetriever(featureProvider, homeAway + "scoringOffPoints");
		} else {
			result = new PointSpreadDataRetriever(featureProvider);
		}
		
		return result;
	}
	
	private SupportedFeaturesProvider getSupportedFeaturesProvider() {
		if(leagueValue == 0) {
			return new CfbSupportedFeaturesProvider();
		} else {
			return new NflSupportedFeaturesProvider();
		}
	}
	
	protected GameDataDto getGamesData(int startYear, int endYear, Integer minimumGamesPlayed, boolean scaleData, Double lower, Double upper) {
		BaseDataRetriever dataRetriever = getDataRetriever();
		GameDataDto data = gameDataRetriever.getGameData(startYear, endYear, minimumGamesPlayed, dataRetriever);
		if(scaleData) {
			ScaleResultDto scaledData = dataScaler.getScaledData(data.getLabels(), data.getInstances(), lower, upper, null, null, scaleRestoreDto);
			scaleRestoreDto = scaledData.getScaleRestoreDto();
			data.setLabels(scaledData.getLabels());
			data.setInstances(scaledData.getInstances());
		}
		
		return data;
	}
	
	protected LearningCategory getLearningCategory() {
		if("Attribute".equals(selectedPredictionType) || "Winner by Regression".equals(selectedPredictionType)) {
			return LearningCategory.REGRESSION;
		} else {
			return LearningCategory.CLASSIFICATION;
		}
	}

	public int getLeagueValue() {
		return leagueValue;
	}

	public void setLeagueValue(int leagueValue) {
		this.leagueValue = leagueValue;
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

	public boolean getScaleData() {
		return scaleData;
	}

	public void setScaleData(boolean scaleData) {
		this.scaleData = scaleData;
	}

	public Double getLower() {
		return lower;
	}

	public void setLower(Double lower) {
		this.lower = lower;
	}

	public Double getUpper() {
		return upper;
	}

	public void setUpper(Double upper) {
		this.upper = upper;
	}
	
	public void predictionTypeChanged() {
		attributeEnabled = "Attribute".equals(selectedPredictionType);
		winnerByRegression = "Winner by Regression".equals(selectedPredictionType);
	}

	public List<String> getAttributeNames() {
		return attributeNames;
	}

	public void setAttributeNames(List<String> attributeNames) {
		this.attributeNames = attributeNames;
	}

	public String getSelectedAttribute() {
		return selectedAttribute;
	}

	public void setSelectedAttribute(String selectedAttribute) {
		this.selectedAttribute = selectedAttribute;
	}

	public String getHomeAway() {
		return homeAway;
	}

	public void setHomeAway(String homeAway) {
		this.homeAway = homeAway;
	}

	public boolean getAttributeEnabled() {
		return attributeEnabled;
	}

	public void setAttributeEnabled(boolean attributeEnabled) {
		this.attributeEnabled = attributeEnabled;
	}

	public boolean getWinnerByRegression() {
		return winnerByRegression;
	}

	public void setWinnerByRegression(boolean winnerByRegression) {
		this.winnerByRegression = winnerByRegression;
	}

}
