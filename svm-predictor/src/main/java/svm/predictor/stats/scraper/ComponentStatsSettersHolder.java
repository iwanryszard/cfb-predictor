package svm.predictor.stats.scraper;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import svm.predictor.dto.TeamGameStatsDto;

@Service("componentStatsSettersHolder")
public class ComponentStatsSettersHolder {

	//offensive components
	public static final String RUSHING = "rushing";
	public static final String PASSING = "passing";
	public static final String RECEIVING = "receiving";
	public static final String PUNT_RETURN = "puntreturn";
	public static final String KICK_RETURN = "kickreturn";
	public static final String PUNTING = "punting";
	public static final String KICKOFF = "kickoff";
	public static final String KICKING = "kicking";
	public static final String SCORING = "scoring";
	public static final String TOTAL = "total";
	public static final String FIRST_DOWN = "firstdown";
	public static final String PENALTY = "penalty";
	public static final String THIRD_DOWN = "thirddown";
	public static final String FOURTH_DOWN = "fourthdown";
	public static final String RED_ZONE = "redzone";
	
	//defensive components
	public static final String INTERCEPTION = "interception";
	public static final String FUMBLE_RETURN = "fumblereturn";
	public static final String TACKLE = "tackle";
	public static final String TACKLE_FOR_LOSS = "tackleforloss";
	public static final String SACK = "sack";
	public static final String MISC_DEFENSE = "miscdefense";
	public static final String TURNOVER_MARGIN = "turnovermargin";
	
	private Map<String, ComponentStatsSetter> offensiveComponentSettersMap;
	private Map<String, ComponentStatsSetter> defensiveComponentSettersMap;
	
	public ComponentStatsSettersHolder() {
		offensiveComponentSettersMap = new LinkedHashMap<String, ComponentStatsSetter>();
		
		ComponentStatsSetter rushingStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int att = Integer.valueOf(rowCells.get(4).text());
				teamStats.setRushOffAtt(att);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setRushOffYards(yards);
				Double avg = getDouble(rowCells.get(6).text());
				teamStats.setRushOffYPA(avg);
				int TDs = Integer.valueOf(rowCells.get(7).text());
				teamStats.setRushOffTDs(TDs);
			}
		};
		offensiveComponentSettersMap.put(RUSHING, rushingStatsSetter);
		
		ComponentStatsSetter passingStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int att = Integer.valueOf(rowCells.get(4).text());
				teamStats.setPassOffAtt(att);
				int comp = Integer.valueOf(rowCells.get(5).text());
				teamStats.setPassOffComp(comp);
				Double pct = getDouble(rowCells.get(6).text());
				teamStats.setPassOffCompPct(pct);
				int yards = Integer.valueOf(rowCells.get(7).text());
				teamStats.setPassOffYards(yards);
				Double YPA = getDouble(rowCells.get(8).text());
				teamStats.setPassOffYPA(YPA);
				int TDs = Integer.valueOf(rowCells.get(9).text());
				teamStats.setPassOffTDs(TDs);
				int INTs = Integer.valueOf(rowCells.get(10).text());
				teamStats.setPassOffINTs(INTs);
				Double rating = getDouble(rowCells.get(11).text());
				teamStats.setPassOffRating(rating);
			}
		};
		offensiveComponentSettersMap.put(PASSING, passingStatsSetter);
		
		ComponentStatsSetter receivingStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				Double passOffYPR = getDouble(rowCells.get(6).text());
				teamStats.setPassOffYPR(passOffYPR);
			}
		};
		offensiveComponentSettersMap.put(RECEIVING, receivingStatsSetter);
		
		ComponentStatsSetter puntReturnStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int ret = Integer.valueOf(rowCells.get(4).text());
				teamStats.setPuntReturns(ret);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setPuntReturnYards(yards);
				Double avg = getDouble(rowCells.get(6).text());
				teamStats.setPuntReturnAverage(avg);
				int TDs = Integer.valueOf(rowCells.get(7).text());
				teamStats.setPuntReturnTDs(TDs);
			}
		};
		offensiveComponentSettersMap.put(PUNT_RETURN, puntReturnStatsSetter);
		
		ComponentStatsSetter kickoffReturnStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int ret = Integer.valueOf(rowCells.get(4).text());
				teamStats.setKickoffReturns(ret);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setKickoffReturnYards(yards);
				Double avg = getDouble(rowCells.get(6).text());
				teamStats.setKickoffReturnAverage(avg);
				int TDs = Integer.valueOf(rowCells.get(7).text());
				teamStats.setKickoffReturnTDs(TDs);
			}
		};
		offensiveComponentSettersMap.put(KICK_RETURN, kickoffReturnStatsSetter);
		
		ComponentStatsSetter puntsStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int punts = Integer.valueOf(rowCells.get(4).text());
				teamStats.setPunts(punts);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setPuntYards(yards);
				Double avg = getDouble(rowCells.get(6).text());
				teamStats.setPuntAverage(avg);
			}
		};
		offensiveComponentSettersMap.put(PUNTING, puntsStatsSetter);
		
		ComponentStatsSetter kickoffsStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int kickoffs = Integer.valueOf(rowCells.get(4).text());
				teamStats.setKickoffs(kickoffs);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setKickoffYards(yards);
				Double avg = getDouble(rowCells.get(6).text());
				teamStats.setKickoffAverage(avg);
				int touchbacks = Integer.valueOf(rowCells.get(7).text());
				teamStats.setKickoffTouchback(touchbacks);
				Double touchbackPct = getDouble(rowCells.get(8).text());
				teamStats.setKickoffTouchbackPct(touchbackPct);
				int onSide = Integer.valueOf(rowCells.get(9).text());
				teamStats.setKickoffOnSide(onSide);
			}
		};
		offensiveComponentSettersMap.put(KICKOFF, kickoffsStatsSetter);
		
		ComponentStatsSetter fieldGoalsStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int att = Integer.valueOf(rowCells.get(4).text());
				teamStats.setFGOffAtt(att);
				int made = Integer.valueOf(rowCells.get(5).text());
				teamStats.setFGOffMade(made);
				Double FGPct = getDouble(rowCells.get(6).text());
				teamStats.setFGOffPct(FGPct);
			}
		};
		offensiveComponentSettersMap.put(KICKING, fieldGoalsStatsSetter);
		
		ComponentStatsSetter scoringStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int TDs = Integer.valueOf(rowCells.get(4).text());
				teamStats.setScoringOffTDs(TDs);
				int TwoPtConv = Integer.valueOf(rowCells.get(7).text());
				teamStats.setScoringOff2PtConv(TwoPtConv);
				int safeties = Integer.valueOf(rowCells.get(8).text());
				teamStats.setScoringOffSafeties(safeties);
				int points = Integer.valueOf(rowCells.get(9).text());
				teamStats.setScoringOffPoints(points);
			}
		};
		offensiveComponentSettersMap.put(SCORING, scoringStatsSetter);
		
		ComponentStatsSetter totalStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int plays = Integer.valueOf(rowCells.get(6).text());
				teamStats.setTotalOffPlays(plays);
				int yards = Integer.valueOf(rowCells.get(7).text());
				teamStats.setTotalOffYards(yards);
				Double yardsPerPlay = getDouble(rowCells.get(8).text());
				teamStats.setTotalOffYPP(yardsPerPlay);
			}
		};
		offensiveComponentSettersMap.put(TOTAL, totalStatsSetter);
		
		ComponentStatsSetter firstDownsStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int rush = Integer.valueOf(rowCells.get(4).text());
				teamStats.setFirstDownOffRush(rush);
				int pass = Integer.valueOf(rowCells.get(5).text());
				teamStats.setFirstDownOffPass(pass);
				int penalty = Integer.valueOf(rowCells.get(6).text());
				teamStats.setFirstDownOffPenalty(penalty);
				int total = Integer.valueOf(rowCells.get(7).text());
				teamStats.setFirstDownOffTotal(total);
			}
		};
		offensiveComponentSettersMap.put(FIRST_DOWN, firstDownsStatsSetter);
		
		ComponentStatsSetter penaltyStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int penalties = Integer.valueOf(rowCells.get(4).text());
				teamStats.setPenalties(penalties);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setPenaltyYards(yards);
			}
		};
		offensiveComponentSettersMap.put(PENALTY, penaltyStatsSetter);
		
		ComponentStatsSetter thirdDownConvStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int attempts = Integer.valueOf(rowCells.get(4).text());
				teamStats.setThirdDownOffAtt(attempts);
				int conversions = Integer.valueOf(rowCells.get(5).text());
				teamStats.setThirdDownOffConv(conversions);
				Double convPct = getDouble(rowCells.get(6).text());
				teamStats.setThirdDownOffConvPct(convPct);
			}
		};
		offensiveComponentSettersMap.put(THIRD_DOWN, thirdDownConvStatsSetter);
		
		ComponentStatsSetter fourthDownConvStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int attempts = Integer.valueOf(rowCells.get(4).text());
				teamStats.setFourthDownOffAtt(attempts);
				int conversions = Integer.valueOf(rowCells.get(5).text());
				teamStats.setFourthDownOffConv(conversions);
				Double convPct = getDouble(rowCells.get(6).text());
				teamStats.setFourthDownOffConvPct(convPct);
			}
		};
		offensiveComponentSettersMap.put(FOURTH_DOWN, fourthDownConvStatsSetter);
		
		ComponentStatsSetter redZoneConvStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int attempts = Integer.valueOf(rowCells.get(4).text());
				teamStats.setOffRedZoneAtt(attempts);
				int scores = Integer.valueOf(rowCells.get(5).text());
				teamStats.setOffRedZoneScores(scores);
				Double scorePct = getDouble(rowCells.get(6).text());
				teamStats.setOffRedZoneScorePct(scorePct);
				int TDs = Integer.valueOf(rowCells.get(7).text());
				teamStats.setOffRedZoneTDs(TDs);
				Double TDPct = getDouble(rowCells.get(8).text());
				teamStats.setOffRedZoneTDPct(TDPct);
				int fieldGoals = Integer.valueOf(rowCells.get(9).text());
				teamStats.setOffRedZoneFGs(fieldGoals);
				Double FGPct = getDouble(rowCells.get(10).text());
				teamStats.setOffRedZoneFGPct(FGPct);
			}
		};
		offensiveComponentSettersMap.put(RED_ZONE, redZoneConvStatsSetter);
		
		//defensive
		defensiveComponentSettersMap = new LinkedHashMap<String, ComponentStatsSetter>();
		
		ComponentStatsSetter interceptionStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int interceptions = Integer.valueOf(rowCells.get(4).text());
				teamStats.setPassDefInts(interceptions);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setPassDefIntYards(yards);
				int TDs = Integer.valueOf(rowCells.get(6).text());
				teamStats.setPassDefIntTDs(TDs);
			}
		};
		defensiveComponentSettersMap.put(INTERCEPTION, interceptionStatsSetter);
		
		ComponentStatsSetter fumbleReturnStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int fumbleReturns = Integer.valueOf(rowCells.get(4).text());
				teamStats.setFumbleReturns(fumbleReturns);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setFumbleReturnYards(yards);
				int TDs = Integer.valueOf(rowCells.get(6).text());
				teamStats.setFumbleReturnTDs(TDs);
			}
		};
		defensiveComponentSettersMap.put(FUMBLE_RETURN, fumbleReturnStatsSetter);
		
		ComponentStatsSetter tacklesStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int totalTackles = Integer.valueOf(rowCells.get(6).text());
				teamStats.setTotalTackles(totalTackles);
			}
		};
		defensiveComponentSettersMap.put(TACKLE, tacklesStatsSetter);
		
		ComponentStatsSetter tacklesForLossStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				//hack because tfl numbers end with ".0" in cfb stats page
				Double TFLsDouble = getDouble(rowCells.get(4).text());
				int TFLs = TFLsDouble.intValue();
				teamStats.setTFLs(TFLs);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setTFLYards(yards);
			}
		};
		defensiveComponentSettersMap.put(TACKLE_FOR_LOSS, tacklesForLossStatsSetter);
		
		ComponentStatsSetter sacksStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				//hack because sack numbers end with ".0" in cfb stats page
				Double sacksDouble = getDouble(rowCells.get(4).text());
				int sacks = sacksDouble.intValue();
				teamStats.setSacks(sacks);
				int yards = Integer.valueOf(rowCells.get(5).text());
				teamStats.setSackYards(yards);
			}
		};
		defensiveComponentSettersMap.put(SACK, sacksStatsSetter);
		
		ComponentStatsSetter miscDefenseStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int passesBrokenUp = Integer.valueOf(rowCells.get(4).text());
				teamStats.setPassesBrokenUp(passesBrokenUp);
				int QBHurries = Integer.valueOf(rowCells.get(5).text());
				teamStats.setQBHurries(QBHurries);
				int fumblesForced = Integer.valueOf(rowCells.get(6).text());
				teamStats.setFumblesForced(fumblesForced);
				int kickPuntsBlocked = Integer.valueOf(rowCells.get(7).text());
				teamStats.setPuntKicksBlocked(kickPuntsBlocked);
			}
		};
		defensiveComponentSettersMap.put(MISC_DEFENSE, miscDefenseStatsSetter);
		
		ComponentStatsSetter turnoverMarginStatsSetter = new ComponentStatsSetter() {
			
			public void setTeamComponentStats(Elements rowCells, TeamGameStatsDto teamStats) {
				int fumbleGain = Integer.valueOf(rowCells.get(4).text());
				teamStats.setFumbleGain(fumbleGain);
				int fumbleLost = Integer.valueOf(rowCells.get(7).text());
				teamStats.setFubmleLost(fumbleLost);
				int turnoverMargin = Integer.valueOf(rowCells.get(10).text());
				teamStats.setTurnoverMargin(turnoverMargin);
			}
		};
		defensiveComponentSettersMap.put(TURNOVER_MARGIN, turnoverMarginStatsSetter);
	}
	
	private Double getDouble(String text) {
		Double result = null;
		if( !text.equals("-")) {
			result = Double.valueOf(text);
		}
		
		return result;
	}

	public Map<String, ComponentStatsSetter> getOffensiveComponentSettersMap() {
		return offensiveComponentSettersMap;
	}
	
	public Map<String, ComponentStatsSetter> getDefensiveComponentSettersMap() {
		return defensiveComponentSettersMap;
	}
}
