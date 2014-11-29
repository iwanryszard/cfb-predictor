package svm.predictor.teams.scraper;

import java.util.Map;
import java.util.TreeMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.constants.CFBStatsURLConts;
import svm.predictor.service.impl.DocumentGetter;
import svm.predictor.service.impl.TeamIdExtractor;

@Service("teamsScraper")
public class TeamsScraper {

	@Autowired
	private DocumentGetter documentGetter;
	
	private TeamIdExtractor teamIdExtractor = new TeamIdExtractor();
	
	public Map<Integer, String> getAllTeamsMap() {
		Map<Integer, String> teamMap = new TreeMap<Integer, String>();
		for(int year = 2008; year <= 2014; ++year) {
			Map<Integer, String> currentYearTeamMap = getTeamMap(year);
			teamMap.putAll(currentYearTeamMap);
		}
		
		return teamMap;
	}
	
	private Map<Integer, String> getTeamMap(int year) {
		String url = CFBStatsURLConts.rootURL + year + "/team/index.html";
		Document doc = documentGetter.getDocument(url);

		Elements conferences = doc.select("div.conference");
		Map<Integer, String> teamMap = new TreeMap<Integer, String>();
		for (Element conf : conferences) {
			Elements teamLinks = conf.select("a[href]");
			for (Element link : teamLinks) {
				String teamName = link.text();
				String strTeamId = link.attr("abs:href");
				int curTeamId = teamIdExtractor.extractTeamId(strTeamId);
				teamMap.put(curTeamId, teamName);
			}
		}

		return teamMap;
	}
}
