package svm.predictor.teams.scraper;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import svm.predictor.constants.CFBStatsURLConts;
import svm.predictor.service.impl.DocumentGetter;
import svm.predictor.service.impl.TeamIdExtractor;

@Service("stadiumLocationsScraper")
public class StadiumLocationsScraper {

	@Autowired
	private DocumentGetter documentGetter;
	
	private TeamIdExtractor teamIdExtractor = new TeamIdExtractor();
	
	public Map<Integer, String> getStadiumLocationsMap() {
		Document doc = documentGetter.getDocument(CFBStatsURLConts.rootURL + "stadium/index.html");
		
		Elements tableRows = doc.select("table.stadium-index > tbody > *");
		//remove header row
		tableRows.remove(0);
		
		Map<Integer, String> stadiumMap = new HashMap<Integer, String>();
		for(Element row : tableRows) {
			Elements rowCells = row.select("td");
			
			Elements teamLink = rowCells.get(2).select("a[href]");
			int teamId = teamIdExtractor.extractTeamId(teamLink);
			if(teamId != -1) {
				String stadiumLocation = rowCells.get(1).text();
				stadiumMap.put(teamId, stadiumLocation);
			}
		}
		
		return stadiumMap;
	}
}
