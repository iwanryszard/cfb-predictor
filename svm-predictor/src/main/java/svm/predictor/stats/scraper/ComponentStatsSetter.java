package svm.predictor.stats.scraper;

import org.jsoup.select.Elements;

import svm.predictor.dto.TeamGameStatsDto;

public interface ComponentStatsSetter {

	void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats);
}
