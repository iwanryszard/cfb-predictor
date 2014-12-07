package svm.predictor.service.impl;

import java.util.Date;
import java.util.List;

import svm.predictor.dao.GameInfoDao;
import svm.predictor.domain.GameInfo;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;
import svm.predictor.service.GameInfoService;

public class GameInfoServiceImpl extends BaseService<GameInfoDto, GameInfoDao, GameInfo, Integer> implements GameInfoService {

	@Override
	public void createGameInfos(List<GameInfoDto> games) {
		for(GameInfoDto game : games) {
			create(game);
		}
	}

	@Override
	public void updateGameInfos(List<GameInfoDto> games) {
		for(GameInfoDto game : games) {
			update(game);
		}
	}

	@Override
	public List<Date> getAllGameDates() {
		return getDao().getAllGameDates();
	}

	@Override
	public TeamAggregatedGameStatsDto getTeamAggregatedStats(Integer teamId, Date seasonStart, Date currentGame) {
		return getDao().getTeamAggregatedStats(teamId, seasonStart, currentGame);
	}

	@Override
	public TeamSimpleAggregatedStats getPreviousNGamesStats(Integer teamId, Integer gameNumberLimit, Date currentGame) {
		return getDao().getPreviousNGamesStats(teamId, gameNumberLimit, currentGame);
	}

	@Override
	public TeamSimpleAggregatedStats getSimpleSeasonStats(Integer teamId, Date seasonStart, Date seasonEnd) {
		return getDao().getSimpleSeasonStats(teamId, seasonStart, seasonEnd);
	}

}
