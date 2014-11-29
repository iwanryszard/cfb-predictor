package svm.predictor.stats.scraper;

import svm.predictor.dto.TeamGameStatsDto;

public interface TeamStatsGetter {

	TeamGameStatsDto getTeamStats(int gameInd);
}
