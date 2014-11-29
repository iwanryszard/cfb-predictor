package svm.predictor.service;

import java.util.Date;
import java.util.List;

import svm.predictor.dto.GameInfoDto;

public interface GameInfoService extends Service<GameInfoDto, Integer> {

	void createGameInfos(List<GameInfoDto> games);
	void updateGameInfos(List<GameInfoDto> games);
	List<Date> getAllGameDates();
}
