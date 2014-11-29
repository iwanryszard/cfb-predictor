package svm.predictor.service.impl;

import org.jsoup.select.Elements;

public class TeamIdExtractor {

	public int extractTeamId(String link) {
		if ("".equals(link)) {
			return -1;
		}

		int beginInd = link.indexOf("team/");
		int endInd = link.indexOf("/index");
		String strId = link.substring(beginInd + 5, endInd);
		return Integer.valueOf(strId);
	}
	
	public int extractTeamId(Elements opponentLink) {
		String link = "";
		if( !opponentLink.isEmpty()) {
			link = opponentLink.attr("abs:href");
		}
		if("".equals(link)) {
			return -1;
		}
		
		int beginInd = link.indexOf("team/");
		int endInd = link.indexOf("/index");
		String strId = link.substring(beginInd + 5, endInd);
		return Integer.valueOf(strId);
	}
}
