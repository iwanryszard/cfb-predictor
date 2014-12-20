package svm.predictor.stats.web;

import java.io.Serializable;
import java.util.List;

import libsvm.svm_model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import svm.predictor.distance.calculation.GamesDistanceSetter;
import svm.predictor.libsvm.SvmPredictor;
import svm.predictor.libsvm.SvmTrainer;
import svm.predictor.libsvm.data.scaling.DataScaler;
import svm.predictor.libsvm.data.scaling.ScaleResultDto;
import svm.predictor.spreads.scraper.PointSpreadsSetter;
import svm.predictor.stats.aggregation.StatsAggregator;
import svm.predictor.stats.aggregation.SvmDataDto;
import svm.predictor.stats.scraper.SeasonGamesStatsScraper;
import svm.predictor.teams.scraper.TeamsStadiumLocationsSetter;

@Component("startWebBean")
@Scope("view")
public class StartWebBean implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(StartWebBean.class);
	
	@Autowired
	private SeasonGamesStatsScraper seasonGamesStatsScraper;
	
	@Autowired
	private PointSpreadsSetter pointSpreadsSetter;
	
	@Autowired
	private TeamsStadiumLocationsSetter teamsStadiumLocationsSetter;
	
	@Autowired
	private GamesDistanceSetter gamesDistanceSetter;
	
	@Autowired
	private StatsAggregator statsAggregator;
	
	@Autowired
	private DataScaler dataScaler;
	
	@Autowired
	private SvmTrainer svmTrainer;
	
	@Autowired
	private SvmPredictor svmPredictor;
	
	public String getStartMessage() {
		logger.info("getStartMessage called...");
		return "Current time in millis: " + System.currentTimeMillis();
	}
	
	public void getStats() {
		try {
			seasonGamesStatsScraper.createAllSeasonStats();
		} catch(Exception e) {
			logger.info("Exception while getting game stats", e);
		}
	}
	
	public void getSpreads() {
		try {
			pointSpreadsSetter.setAllGamesPointSpreads();
		} catch(Exception e) {
			logger.info("Exception while setting spreads", e);
		}
	}
	
	public void getTeams() {
		try {
			teamsStadiumLocationsSetter.createAllTeams();
		} catch(Exception e) {
			logger.info("Exception while getting teams", e);
		}
	}
	
	public void getDistances() {
		try {
			gamesDistanceSetter.setAllGamesDistances();
		} catch(Exception e) {
			logger.info("Exception while setting distances", e);
		}
	}
	
	public void aggregateGameStats() {
		try {
			statsAggregator.aggregateGamesForSeasons(2010, 2013);
		} catch(Exception e) {
			logger.info("Exception while aggregating stats", e);
		}
	}
	
	public void createSVMFiles() {
		try {
			statsAggregator.createSVMFile(2010, 2011, "cfb");
			statsAggregator.createSVMFile(2013, 2013, "cfb.t");
		} catch(Exception e) {
			logger.info("Exception while creating SVM files", e);
		}
	}
	
	public void trainAndPredictInMemory() {
		try {
			SvmDataDto trainingData = statsAggregator.getGamesAsSvmData(2010, 2011);
			ScaleResultDto scaledTrainingData = dataScaler.getScaledData(trainingData.getLabels(), trainingData.getFeatures(), 
					-1.0, 1.0, null, null, null);
		
			SvmDataDto testingData = statsAggregator.getGamesAsSvmData(2013, 2013);
			ScaleResultDto scaledTestingData = dataScaler.getScaledData(testingData.getLabels(), testingData.getFeatures(), 
					null, null, null, null, scaledTrainingData.getScaleRestoreDto());
		
			svm_model model = svmTrainer.trainModel(scaledTrainingData.getLabels(), scaledTrainingData.getFeatures());
			
			List<Double> predictions = svmPredictor.predict(scaledTestingData.getLabels(), scaledTestingData.getFeatures(), model, null);
			List<Double> expectedResult = scaledTestingData.getLabels();
			int correct = 0;
			for(int i = 0; i < predictions.size(); ++i) {
				if(predictions.get(i).equals(expectedResult.get(i))) {
					++correct;
				}
			}
			logger.info("Accuracy = " + (double) correct / predictions.size() * 100 + "% (" + correct + "/" + predictions.size() + ")");
		} catch(Exception e) {
			logger.info("Exception while creating scaled SVM files", e);
		}
	}
}
