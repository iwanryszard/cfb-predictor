package svm.predictor.dao;

import java.util.Date;
import java.util.List;

import svm.predictor.domain.GameInfo;

public interface GameInfoDao extends Dao<GameInfo, Integer>{
	List<Date> getAllGameDates();
}
