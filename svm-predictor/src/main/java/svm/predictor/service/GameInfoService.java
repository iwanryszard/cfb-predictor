package svm.predictor.service;

import java.util.Date;
import java.util.List;

import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.League;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public interface GameInfoService extends Service<GameInfoDto, Integer> {

	void createGameInfos(List<GameInfoDto> games);
	void updateGameInfos(List<GameInfoDto> games);
	List<Date> getAllGameDates(League league, Date startDate);
	TeamAggregatedGameStatsDto getTeamAggregatedStats(Integer teamId, Date seasonStart, Date currentGame);
	TeamSimpleAggregatedStats getPreviousNGamesStats(Integer teamId, Integer gameNumberLimit, Date currentGame);
	TeamSimpleAggregatedStats getSimpleSeasonStats(Integer teamId, Date seasonStart, Date seasonEnd);
}
