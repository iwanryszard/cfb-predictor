package svm.predictor.spreads.scraper;

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
import org.springframework.stereotype.Service;

import svm.predictor.dto.GameSpreadDto;
import svm.predictor.service.impl.DocumentGetter;

@Service("datePointSpreadsScraper")
public class DatePointSpreadsScraper {

	private static Logger logger = LoggerFactory.getLogger(DatePointSpreadsScraper.class);
	
	private static String spreadsBaseURL = "http://www.sportsbookreview.com/betting-odds/college-football/?date=";
	private static String HALF = "½";
	private static String spreadOddSeparator = Character.toString((char)160);
	
	@Autowired
	private DocumentGetter documentGetter;
	
	private DateFormat dateFormat;
	
	public DatePointSpreadsScraper() {
		dateFormat = new SimpleDateFormat("yyyyMMdd");
	}
	
	public List<GameSpreadDto> getSpreads(Date date) {
		String strDate = dateFormat.format(date);
		logger.info("Getting spreads for date: " + strDate);
		String url = spreadsBaseURL + strDate;
		Map<String, String> cookies = buildCookies();
		Document doc = documentGetter.getDocument(url, cookies);
		
		List<GameSpreadDto> gameSpreads = new ArrayList<GameSpreadDto>();
		Elements eventLinesGroup = doc.select("div.eventLines");
		Elements eventLines = eventLinesGroup.select("div.eventLine");
		for(Element eventLine : eventLines) {
			GameSpreadDto currentGame = new GameSpreadDto();
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
			String awaySpread = openerValues.get(0).text();
			String homeSpread = openerValues.get(1).text();
			Double currentSpread = getSpread(homeSpread, awaySpread);
			
			if(currentSpread == null) {
				Elements bookieSpreads = eventLine.select("div.el-div.eventLine-book");
				for(Element spread : bookieSpreads) {
					Elements bookieSpread = spread.select("div.eventLine-book-value");
					awaySpread = bookieSpread.get(0).text();
					homeSpread = bookieSpread.get(1).text();
					currentSpread = getSpread(homeSpread, awaySpread);
					if(currentSpread != null) {
						break;
					}
				}
			}
			
			currentGame.setSpread(currentSpread);
			gameSpreads.add(currentGame);
		}

		logger.info("Finished spreads for date: " + strDate + ". " + gameSpreads.size() + " game spreads fetched");
		return gameSpreads;
	}
	
	private String removeRankFromName(String teamName) {
		String result = teamName;
		if(teamName.startsWith("(")) {
			int closingBracketInd = teamName.indexOf(")");
			result = teamName.substring(closingBracketInd + 2);
		}
		return result;
	}
	
	private Double getSpread(String homeSpread, String awaySpread) {
		Double result = parseSpread(homeSpread);
		if(result == null) {
			result = parseSpread(awaySpread);
			if(result != null) {
				result *= -1;
			}
		}
		
		return result;
	}
	
	private Double parseSpread(String spread) {
		Double result = null;
		if( !spread.equals("")) {
			if(spread.startsWith("PK")) {
				result = 0.0d;
			} else if(spread.startsWith("+") || spread.startsWith("-")) {
				int multiplier = 1;
				if(spread.startsWith("-")) {
					multiplier = -1;
				}

				int separatorIndex = spread.indexOf(spreadOddSeparator);
				if(separatorIndex != -1) {
					String extractedSpread = spread.substring(1, separatorIndex);
					int halfIndex = extractedSpread.indexOf(HALF);
					double halfAdd = 0.0d;
					if(halfIndex != -1) {
						extractedSpread = extractedSpread.substring(0, halfIndex);
						halfAdd = 0.5d;
					}
					Double decimalPart;
					try {
						decimalPart = Double.valueOf(extractedSpread);
					} catch(NumberFormatException e) {
						throw new RuntimeException("Cannot parse spread: " + extractedSpread, e);
					}
					result = decimalPart + halfAdd;
					result *= multiplier;
				}
			}
		}
		
		return result;
	}
	
	private Map<String, String> buildCookies() {
		Map<String, String> cookies = new HashMap<String, String>();
		cookies.put("NEWSIGNUP","true");
		cookies.put("bb_lastvisit", "1411183220");
		cookies.put("bb_password", "9650790fef5a5720c4e3314611d40877");
		cookies.put("bb_userid", "813273");
		cookies.put("bbpassword", "9650790fef5a5720c4e3314611d40877");
		cookies.put("bbuserid", "813273");
		cookies.put("odds_option_GAME_STATUS_ORDER", "False");
		cookies.put("odds_option_SHOW_PLAYBYPLAY", "True");
		cookies.put("sbrSession", "iwanryszard");
		
		return cookies;
	}
}
