package svm.predictor.dao;

import java.util.Date;
import java.util.List;

import svm.predictor.domain.GameInfo;
import svm.predictor.dto.League;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public interface GameInfoDao extends Dao<GameInfo, Integer>{
	List<Date> getAllGameDates(League league, Date startDate);
	TeamAggregatedGameStatsDto getTeamAggregatedStats(Integer teamId, Date seasonStart, Date currentGame);
	TeamSimpleAggregatedStats getPreviousNGamesStats(Integer teamId, Integer gameNumberLimit, Date currentGame);
	TeamSimpleAggregatedStats getSimpleSeasonStats(Integer teamId, Date seasonStart, Date seasonEnd);
}
