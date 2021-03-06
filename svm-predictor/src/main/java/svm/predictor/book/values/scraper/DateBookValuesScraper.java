package svm.predictor.book.values.scraper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import svm.predictor.service.impl.DocumentGetter;

@Service("dateBookValuesScraper")
public class DateBookValuesScraper {

	private static Logger logger = LoggerFactory.getLogger(DateBookValuesScraper.class);
	
	@Value("${book.values.root.url}")
	private String bookValuesRootURL;
	
	@Value("${book.values.sbrSession}")
	private String sbrSession;
	
	@Value("${book.values.bbuserid}")
	private String bbuserid;
	
	@Value("${book.values.bbpassword}")
	private String bbpassword;
	
	@Autowired
	private DocumentGetter documentGetter;
	
	private DateFormat dateFormat;
	
	public DateBookValuesScraper() {
		dateFormat = new SimpleDateFormat("yyyyMMdd");
	}
	
	public List<GameBookValueDto> getBookValues(Date date, BookValueScraper valueScraper) {
		String strDate = dateFormat.format(date);
		logger.info("Getting book values for date: " + strDate);
		String url = bookValuesRootURL + valueScraper.getSportUrlPart() + valueScraper.getSpecificUrlPart() + 
				"/?date=" + strDate;
		Map<String, String> cookies = buildCookies();
		Document doc = documentGetter.getDocument(url, cookies);
		
		List<GameBookValueDto> result = new ArrayList<GameBookValueDto>();
		Elements eventLinesGroup = doc.select("div.eventLines");
		Elements eventLines = eventLinesGroup.select("div.eventLine");
		for(Element eventLine : eventLines) {
			GameBookValueDto currentGame = new GameBookValueDto();
			Elements teamNames = eventLine.select("div.el-div.eventLine-team");
			Elements teamNameSpans = teamNames.select("span.team-name");
			String awayTeam = teamNameSpans.get(0).text();
			awayTeam = removeRankFromName(awayTeam);
			String homeTeam = teamNameSpans.get(1).text();
			homeTeam = removeRankFromName(homeTeam);
			currentGame.setHomeTeam(homeTeam);
			currentGame.setAwayTeam(awayTeam);
			
			Elements opener = eventLine.select("div.el-div.eventLine-opener");
			Elements openerValues = opener.select("div.eventLine-book-value");
			String awayValue = openerValues.get(0).text();
			String homeValue = openerValues.get(1).text();
			BookValuesDto currentBookValues = valueScraper.getBookValues(homeValue, awayValue);
			
			if(currentBookValues == null) {
				Elements bookieValues = eventLine.select("div.el-div.eventLine-book");
				for(Element value : bookieValues) {
					Elements bookieValue = value.select("div.eventLine-book-value");
					awayValue = bookieValue.get(0).text();
					homeValue = bookieValue.get(1).text();
					currentBookValues = valueScraper.getBookValues(homeValue, awayValue);
					if(currentBookValues != null) {
						break;
					}
				}
			}
			
			currentGame.setBookValues(currentBookValues);
			result.add(currentGame);
		}

		logger.info("Finished book values for date: " + strDate + ". " + result.size() + " game book values fetched");
		return result;
	}
	
	private String removeRankFromName(String teamName) {
		String result = teamName;
		if(teamName.startsWith("(")) {
			int closingBracketInd = teamName.indexOf(")");
			result = teamName.substring(closingBracketInd + 2);
		}
		return result;
	}
	
	private Map<String, String> buildCookies() {
		Map<String, String> cookies = new HashMap<String, String>();
		cookies.put("NEWSIGNUP","true");
		cookies.put("bb_lastvisit", "1411183220");
		cookies.put("bb_password", bbpassword);
		cookies.put("bb_userid", bbuserid);
		cookies.put("bbpassword", bbpassword);
		cookies.put("bbuserid", bbuserid);
		cookies.put("odds_option_GAME_STATUS_ORDER", "False");
		cookies.put("odds_option_SHOW_PLAYBYPLAY", "True");
		cookies.put("sbrSession", sbrSession);
		
		return cookies;
	}
}
