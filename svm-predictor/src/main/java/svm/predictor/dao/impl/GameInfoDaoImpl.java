package svm.predictor.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import svm.predictor.dao.GameInfoDao;
import svm.predictor.domain.GameInfo;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;

public class GameInfoDaoImpl extends BaseDao<GameInfo, Integer> implements GameInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Date> getAllGameDates() {
		Session session = getSessionFactory().getCurrentSession();
		List<Date> result = session.createQuery("select distinct g.gameDate from GameInfo g order by g.gameDate").list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TeamAggregatedGameStatsDto getTeamAggregatedStats(Integer teamId, Date seasonStart, Date currentGame) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(teamAggregatedStatsQuery).setResultTransformer(Transformers.aliasToBean(TeamAggregatedGameStatsDto.class));
		query.setParameter("teamId", teamId);
		query.setParameter("seasonStart", seasonStart);
		query.setParameter("currentGame", currentGame);
		List<TeamAggregatedGameStatsDto> result = query.list();
		if(result.size() != 1) {
			throw new RuntimeException("One row expected, actual rows: " + result.size());
		}
		
		return result.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TeamSimpleAggregatedStats getPreviousNGamesStats(Integer teamId, Integer gameNumberLimit, Date currentGame) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(simpleGameLimitStatsQuery).setResultTransformer(Transformers.aliasToBean(TeamSimpleAggregatedStats.class));
		query.setParameter("teamId", teamId);
		query.setParameter("currentGame", currentGame);
		query.setParameter("gameNumberLimit", gameNumberLimit);
		List<TeamSimpleAggregatedStats> result = query.list();
		if(result.size() != 1) {
			throw new RuntimeException("One row expected, actual rows: " + result.size());
		}
		
		return result.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TeamSimpleAggregatedStats getSimpleSeasonStats(Integer teamId, Date seasonStart, Date seasonEnd) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(simpleSeasonStatsQuery).setResultTransformer(Transformers.aliasToBean(TeamSimpleAggregatedStats.class));
		query.setParameter("teamId", teamId);
		query.setParameter("seasonStart", seasonStart);
		query.setParameter("seasonEnd", seasonEnd);
		List<TeamSimpleAggregatedStats> result = query.list();
		if(result.size() != 1) {
			throw new RuntimeException("One row expected, actual rows: " + result.size());
		}
		
		return result.get(0);
	}
	
	private String teamAggregatedStatsQuery = "select count(*) as gamesPlayed, (count(win) / count(*)) * 100 as winPct, (count(winATS) / count(*)) * 100 as winATSPct, (count(under) / count(*)) * 100 as underPct,\r\n" + 
			"avg(rushOffAtts) as rushOffAttAvg, avg(rushOffYards) as rushOffYardsAvg, sum(rushOffYards) / sum(rushOffAtts) as rushOffYPA, avg(rushOffTDs) as rushOffTDsAvg, \r\n" + 
			"avg(rushDefAtts) as rushDefAttAvg, avg(rushDefYards) as rushDefYardsAvg, sum(rushDefYards) / sum(rushDefAtts) as rushDefYPA, avg(rushDefTDs) as rushDefTDsAvg, \r\n" + 
			"avg(passOffAtts) as passOffAttAvg, avg(passOffComp) as passOffCompAvg, (sum(passOffComp) / sum(passOffAtts)) * 100 as passOffCompPct,\r\n" + 
			"avg(passOffYards) as passOffYardsAvg, sum(passOffYards) / sum(passOffAtts) as passOffYPA, avg(passOffInts) as passOffINTsAvg, avg(passOffTDs) as passOffTDsAvg,\r\n" + 
			"avg(passOffRating) as passOffRatingAvg, sum(passOffYards) / sum(passOffComp) as passOffYPR,\r\n" + 
			"avg(passDefAtts) as passDefAttAvg, avg(passDefComp) as passDefCompAvg, (sum(passDefComp) / sum(passDefAtts)) * 100 as passDefCompPct,\r\n" + 
			"avg(passDefYards) as passDefYardsAvg, sum(passDefYards) / sum(passDefAtts) as passDefYPA, avg(passDefInts) as passDefINTsAvg, avg(passDefTDs) as passDefTDsAvg,\r\n" + 
			"avg(passDefRating) as passDefRatingAvg, sum(passDefYards) / sum(passDefComp) as passDefYPR, \r\n" + 
			"avg(puntReturns) as puntReturnsAvg, avg(puntReturnYards) as puntReturnYardsAvg, sum(puntReturnYards) / sum(puntReturns) as puntReturnAverage, avg(puntReturnTDs) as puntReturnTDsAvg,\r\n" + 
			"avg(puntReturnsDef) as puntReturnsDefAvg, avg(puntReturnYardsDef) as puntReturnYardsDefAvg, sum(puntReturnYardsDef) / sum(puntReturnsDef) as puntReturnAverageDef, avg(puntReturnTDsDef) as puntReturnTDsDefAvg,\r\n" + 
			"avg(kickoffReturns) as kickoffReturnsAvg, avg(kickoffReturnYards) as kickoffReturnYardsAvg, sum(kickoffReturnYards) / sum(kickoffReturns) as kickoffReturnAverage, avg(kickoffReturnTDs) as kickoffReturnTDsAvg,\r\n" + 
			"avg(kickoffReturnsDef) as kickoffReturnsDefAvg, avg(kickoffReturnYardsDef) as kickoffReturnYardsDefAvg, sum(kickoffReturnYardsDef) / sum(kickoffReturnsDef) as kickoffReturnAverageDef, avg(kickoffReturnTDsDef) as kickoffReturnTDsDefAvg,\r\n" + 
			"avg(punts) as puntsAvg, avg(puntYards) as puntYardsAvg, sum(puntYards) / sum(punts) as puntAverage,\r\n" + 
			"avg(kickoffs) as kickoffsAvg, avg(kickoffYards) as kickoffYardsAvg, sum(kickoffYards) / sum(kickoffs) as kickoffAverage, avg(kickoffTouchback) as kickoffTouchbackAvg,\r\n" + 
			"(sum(kickoffTouchback) / sum(kickoffs)) * 100 as kickoffTouchbackPct, avg(kickoffOutOfBounds) as kickoffOutOfBoundsAvg, avg(kickoffOnSide) as kickoffOnSideAvg,\r\n" + 
			"avg(fgOffAtt) as fgOffAttAvg, avg(fgOffMade) as FGOffMadeAvg, (sum(fgOffMade) / sum(fgOffAtt)) * 100 as FGOffPct,\r\n" + 
			"avg(fgDefAtt) as fgDefAttAvg, avg(fgDefMade) as FGDefMadeAvg, (sum(fgDefMade) / sum(fgDefAtt)) * 100 as FGDefPct,\r\n" + 
			"avg(scoringOffTDs) as scoringOffTDsAvg, avg(scoringOff2ptConv) as scoringOff2PtConvAvg, avg(scoringOffSafeties) as scoringOffSafetiesAvg, avg(scoringOffPoints) as scoringOffPointsAvg,\r\n" + 
			"avg(scoringDefTDs) as scoringDefTDsAvg, avg(scoringDef2ptConv) as scoringDef2PtConvAvg, avg(scoringDefSafeties) as scoringDefSafetiesAvg, avg(scoringDefPoints) as scoringDefPointsAvg,\r\n" + 
			"avg(totalOffPlays) as totalOffPlaysAvg, avg(totalOffYards) as totalOffYardsAvg, sum(totalOffYards) / sum(totalOffPlays) as totalOffYPP,\r\n" + 
			"avg(totalDefPlays) as totalDefPlaysAvg, avg(totalDefYards) as totalDefYardsAvg, sum(totalDefYards) / sum(totalDefPlays) as totalDefYPP,\r\n" + 
			"avg(passDefIntYards) as passDefIntYardsAvg, avg(passDefIntTDs) as passDefIntTDsAvg,\r\n" + 
			"avg(fumbleReturns) as fumbleReturnsAvg, avg(fumbleReturnYards) as fumbleReturnYardsAvg, avg(fumbleReturnTDs) as fumbleReturnTDsAvg,\r\n" + 
			"avg(totalTackles) as totalTacklesAvg,\r\n" + 
			"avg(tfls) as TFLsAvg, avg(tflYards) as TFLYardsAvg,\r\n" + 
			"avg(sacks) as sacksAvg, avg(sackYards) as sackYardsAvg,\r\n" + 
			"avg(sacksAllowed) as sacksAllowedAvg, avg(sackYardsAllowed) as sackYardsAllowedAvg,\r\n" + 
			"avg(passesBrokenUp) as passesBrokenUpAvg, avg(qbHurries) as QBHurriesAvg, avg(fumblesForced) as fumblesForcedAvg, avg(puntKicksBlocked) as puntKicksBlockedAvg,\r\n" + 
			"avg(qbHurriesAllowed) as QBHurriesAllowedAvg,\r\n" + 
			"avg(firstDownOffRush) as firstDownOffRushAvg, avg(firstDownOffPass) as firstDownOffPassAvg, avg(firstDownOffPenalty) as firstDownOffPenaltyAvg, avg(firstDownOffTotal) as firstDownOffTotalAvg,\r\n" + 
			"avg(firstDownDefRush) as firstDownDefRushAvg, avg(firstDownDefPass) as firstDownDefPassAvg, avg(firstDownDefPenalty) as firstDownDefPenaltyAvg, avg(firstDownDefTotal) as firstDownDefTotalAvg,\r\n" + 
			"avg(penalties) as penaltiesAvg, avg(penaltyYards) as penaltyYardsAvg,\r\n" + 
			"avg(thirdDownOffAtt) as thirdDownOffAttAvg, avg(thirdDownOffConv) as thirdDownOffConvAvg, (sum(thirdDownOffConv) / sum(thirdDownOffAtt)) * 100 as thirdDownOffConvPct,\r\n" + 
			"avg(thirdDownDefAtt) as thirdDownDefAttAvg, avg(thirdDownDefConv) as thirdDownDefConvAvg, (sum(thirdDownDefConv) / sum(thirdDownDefAtt)) * 100 as thirdDownDefConvPct,\r\n" + 
			"avg(fourthDownOffAtt) as fourthDownOffAttAvg, avg(fourthDownOffConv) as fourthDownOffConvAvg, (sum(fourthDownOffConv) / sum(fourthDownOffAtt)) * 100 as fourthDownOffConvPct,\r\n" + 
			"avg(fourthDownDefAtt) as fourthDownDefAttAvg, avg(fourthDownDefConv) as fourthDownDefConvAvg, (sum(fourthDownDefConv) / sum(fourthDownDefAtt)) * 100 as fourthDownDefConvPct,\r\n" + 
			"avg(redZoneOffAtt) as offRedZoneAttAvg, avg(redZoneOffScores) as offRedZoneScoresAvg, (sum(redZoneOffScores) / sum(redZoneOffAtt)) * 100 as offRedZoneScorePct,\r\n" + 
			"avg(redZoneOffTDs) as offRedZoneTDsAvg, (sum(redZoneOffTDs) / sum(redZoneOffAtt)) * 100 as offRedZoneTDPct, avg(redZoneOffFGs) as offRedZoneFGsAvg, (sum(redZoneOffFGs) / sum(redZoneOffAtt)) * 100 as offRedZoneFGPct,\r\n" + 
			"avg(redZoneDefAtt) as defRedZoneAttAvg, avg(redZoneDefScores) as defRedZoneScoresAvg, (sum(redZoneDefScores) / sum(redZoneDefAtt)) * 100 as defRedZoneScorePct,\r\n" + 
			"avg(redZoneDefTDs) as defRedZoneTDsAvg, (sum(redZoneDefTDs) / sum(redZoneDefAtt)) * 100 as defRedZoneTDPct, avg(redZoneDefFGs) as defRedZoneFGsAvg, (sum(redZoneDefFGs) / sum(redZoneDefAtt)) * 100 as defRedZoneFGPct,\r\n" + 
			"avg(fumbleGain) as fumbleGainAvg, avg(fumbleLost) as fubmleLostAvg, avg(turnoverMargin) as turnoverMarginAvg\r\n" + 
			"FROM\r\n" + 
			"((SELECT (CASE WHEN home_team_points >= away_team_points THEN 1 ELSE NULL END) as win,\r\n" +
			"(CASE WHEN home_team_points + COALESCE(point_spread, 0) >= away_team_points THEN 1 ELSE NULL END) as winATS,\r\n" +
			"(CASE WHEN home_team_points + away_team_points <= COALESCE(point_total, 0) THEN 1 ELSE NULL END) as under,\r\n" +
			"home_rush_off_att as rushOffAtts, home_rush_off_yards as rushOffYards, home_rush_off_tds as rushOffTDs, \r\n" + 
			"away_rush_off_att as rushDefAtts, away_rush_off_yards as rushDefYards, away_rush_off_tds as rushDefTDs, \r\n" + 
			"home_pass_off_att as passOffAtts, home_pass_off_comp as passOffComp, home_pass_off_yards as passOffYards, home_pass_off_ints as passOffInts,\r\n" + 
			"home_pass_off_tds as passOffTDs, home_pass_off_rating as passOffRating,\r\n" + 
			"away_pass_off_att as passDefAtts, away_pass_off_comp as passDefComp, away_pass_off_yards as passDefYards, away_pass_off_ints as passDefInts,\r\n" + 
			"away_pass_off_tds as passDefTDs, away_pass_off_rating as passDefRating, \r\n" + 
			"home_punt_returns as puntReturns, home_punt_return_yards as puntReturnYards, home_punt_return_tds as puntReturnTDs,\r\n" + 
			"away_punt_returns as puntReturnsDef, away_punt_return_yards as puntReturnYardsDef, away_punt_return_tds as puntReturnTDsDef,\r\n" + 
			"home_kickoff_returns as kickoffReturns, home_kickoff_return_yards as kickoffReturnYards, home_kickoff_return_tds as kickoffReturnTDs,\r\n" + 
			"away_kickoff_returns as kickoffReturnsDef, away_kickoff_return_yards as kickoffReturnYardsDef, away_kickoff_return_tds as kickoffReturnTDsDef,\r\n" + 
			"home_punts as punts, home_punt_yards as puntYards,\r\n" + 
			"home_kickoffs as kickoffs, home_kickoff_yards as kickoffYards, home_kickoff_touchback as kickoffTouchback, home_kickoff_out_of_bounds as kickoffOutOfBounds, home_kickoff_onside as kickoffOnSide,\r\n" + 
			"home_fg_off_att as fgOffAtt, home_fg_off_made as fgOffMade,\r\n" + 
			"away_fg_off_att as fgDefAtt, away_fg_off_made as fgDefMade,\r\n" + 
			"home_scoring_off_tds as scoringOffTDs, home_scoring_off_2pt_conv as scoringOff2ptConv, home_scoring_off_safeties as scoringOffSafeties, home_scoring_off_points as scoringOffPoints,\r\n" + 
			"away_scoring_off_tds as scoringDefTDs, away_scoring_off_2pt_conv as scoringDef2ptConv, away_scoring_off_safeties as scoringDefSafeties, away_scoring_off_points as scoringDefPoints,\r\n" + 
			"home_total_off_plays as totalOffPlays, home_scoring_off_yards as totalOffYards,\r\n" + 
			"away_total_off_plays as totalDefPlays, away_scoring_off_yards as totalDefYards,\r\n" + 
			"home_pass_def_int_yards as passDefIntYards, home_pass_def_int_tds as passDefIntTDs,\r\n" + 
			"home_fumble_returns as fumbleReturns, home_fumble_return_yards as fumbleReturnYards, home_fumble_return_tds as fumbleReturnTDs,\r\n" + 
			"home_total_tackles as totalTackles,\r\n" + 
			"home_tfls as tfls, home_tfl_yards as tflYards,\r\n" + 
			"home_sacks as sacks, home_sack_yards as sackYards,\r\n" + 
			"away_sacks as sacksAllowed, away_sack_yards as sackYardsAllowed,\r\n" + 
			"home_passes_broken_up as passesBrokenUp, home_qb_hurries as qbHurries, home_fumbles_forced as fumblesForced, home_punt_kicks_blocked as puntKicksBlocked,\r\n" + 
			"away_qb_hurries as qbHurriesAllowed,\r\n" + 
			"home_first_down_off_rush as firstDownOffRush, home_first_down_off_pass as firstDownOffPass, home_first_down_off_penalty as firstDownOffPenalty, home_first_down_off_total as firstDownOffTotal,\r\n" + 
			"away_first_down_off_rush as firstDownDefRush, away_first_down_off_pass as firstDownDefPass, away_first_down_off_penalty as firstDownDefPenalty, away_first_down_off_total as firstDownDefTotal,\r\n" + 
			"home_penalties as penalties, home_penalty_yards as penaltyYards,\r\n" + 
			"home_third_down_off_att as thirdDownOffAtt, home_third_down_off_conv as thirdDownOffConv,\r\n" + 
			"away_third_down_off_att as thirdDownDefAtt, away_third_down_off_conv as thirdDownDefConv,\r\n" + 
			"home_fourth_down_off_att as fourthDownOffAtt, home_fourth_down_off_conv as fourthDownOffConv,\r\n" + 
			"away_fourth_down_off_att as fourthDownDefAtt, away_fourth_down_off_conv as fourthDownDefConv,\r\n" + 
			"home_off_red_zone_att as redZoneOffAtt, home_off_red_zone_scores as redZoneOffScores, home_off_red_zone_tds as redZoneOffTDs, home_off_red_zone_fgs as redZoneOffFGs,\r\n" + 
			"away_off_red_zone_att as redZoneDefAtt, away_off_red_zone_scores as redZoneDefScores, away_off_red_zone_tds as redZoneDefTDs, away_off_red_zone_fgs as redZoneDefFGs,\r\n" + 
			"home_fumble_gain as fumbleGain, home_fumble_lost as fumbleLost, home_turnover_margin as turnoverMargin\r\n" + 
			"FROM game_info\r\n" + 
			"where home_team_id = :teamId AND game_date > :seasonStart\r\n" + 
			"AND game_date < :currentGame)\r\n" + 
			"UNION ALL\r\n" + 
			"(SELECT (CASE WHEN home_team_points <= away_team_points THEN 1 ELSE NULL END) as win,\r\n" +
			"(CASE WHEN home_team_points + COALESCE(point_spread, 0) <= away_team_points THEN 1 ELSE NULL END) as winATS,\r\n" +
			"(CASE WHEN home_team_points + away_team_points <= COALESCE(point_total, 0) THEN 1 ELSE NULL END) as under,\r\n" +
			"away_rush_off_att as rushOffAtts, away_rush_off_yards as rushOffYards, away_rush_off_tds as rushOffTDs, \r\n" + 
			"home_rush_off_att as rushDefAtts, home_rush_off_yards as rushDefYards, home_rush_off_tds as rushDefTDs, \r\n" + 
			"away_pass_off_att as passOffAtts, away_pass_off_comp as passOffComp, away_pass_off_yards as passOffYards, away_pass_off_ints as passOffInts,\r\n" + 
			"away_pass_off_tds as passOffTDs, away_pass_off_rating as passOffRating,\r\n" + 
			"home_pass_off_att as passDefAtts, home_pass_off_comp as passDefComp, home_pass_off_yards as passDefYards, home_pass_off_ints as passDefInts,\r\n" + 
			"home_pass_off_tds as passDefTDs, home_pass_off_rating as passDefRating, \r\n" + 
			"away_punt_returns as puntReturns, away_punt_return_yards as puntReturnYards, away_punt_return_tds as puntReturnTDs,\r\n" + 
			"home_punt_returns as puntReturnsDef, home_punt_return_yards as puntReturnYardsDef, home_punt_return_tds as puntReturnTDsDef,\r\n" + 
			"away_kickoff_returns as kickoffReturns, away_kickoff_return_yards as kickoffReturnYards, away_kickoff_return_tds as kickoffReturnTDs,\r\n" + 
			"home_kickoff_returns as kickoffReturnsDef, home_kickoff_return_yards as kickoffReturnYardsDef, home_kickoff_return_tds as kickoffReturnTDsDef,\r\n" + 
			"away_punts as punts, away_punt_yards as puntYards,\r\n" + 
			"away_kickoffs as kickoffs, away_kickoff_yards as kickoffYards, away_kickoff_touchback as kickoffTouchback, away_kickoff_out_of_bounds as kickoffOutOfBounds, away_kickoff_onside as kickoffOnSide,\r\n" + 
			"away_fg_off_att as fgOffAtt, away_fg_off_made as fgOffMade,\r\n" + 
			"home_fg_off_att as fgDefAtt, home_fg_off_made as fgDefMade,\r\n" + 
			"away_scoring_off_tds as scoringOffTDs, away_scoring_off_2pt_conv as scoringOff2ptConv, away_scoring_off_safeties as scoringOffSafeties, away_scoring_off_points as scoringOffPoints,\r\n" + 
			"home_scoring_off_tds as scoringDefTDs, home_scoring_off_2pt_conv as scoringDef2ptConv, home_scoring_off_safeties as scoringDefSafeties, home_scoring_off_points as scoringDefPoints,\r\n" + 
			"away_total_off_plays as totalOffPlays, away_scoring_off_yards as totalOffYards,\r\n" + 
			"home_total_off_plays as totalDefPlays, home_scoring_off_yards as totalDefYards,\r\n" + 
			"away_pass_def_int_yards as passDefIntYards, away_pass_def_int_tds as passDefIntTDs,\r\n" + 
			"away_fumble_returns as fumbleReturns, away_fumble_return_yards as fumbleReturnYards, away_fumble_return_tds as fumbleReturnTDs,\r\n" + 
			"away_total_tackles as totalTackles,\r\n" + 
			"away_tfls as tfls, away_tfl_yards as tflYards,\r\n" + 
			"away_sacks as sacks, away_sack_yards as sackYards,\r\n" + 
			"home_sacks as sacksAllowed, home_sack_yards as sackYardsAllowed,\r\n" + 
			"away_passes_broken_up as passesBrokenUp, away_qb_hurries as qbHurries, away_fumbles_forced as fumblesForced, away_punt_kicks_blocked as puntKicksBlocked,\r\n" + 
			"home_qb_hurries as qbHurriesAllowed,\r\n" + 
			"away_first_down_off_rush as firstDownOffRush, away_first_down_off_pass as firstDownOffPass, away_first_down_off_penalty as firstDownOffPenalty, away_first_down_off_total as firstDownOffTotal,\r\n" + 
			"home_first_down_off_rush as firstDownDefRush, home_first_down_off_pass as firstDownDefPass, home_first_down_off_penalty as firstDownDefPenalty, home_first_down_off_total as firstDownDefTotal,\r\n" + 
			"away_penalties as penalties, away_penalty_yards as penaltyYards,\r\n" + 
			"away_third_down_off_att as thirdDownOffAtt, away_third_down_off_conv as thirdDownOffConv,\r\n" + 
			"home_third_down_off_att as thirdDownDefAtt, home_third_down_off_conv as thirdDownDefConv,\r\n" + 
			"away_fourth_down_off_att as fourthDownOffAtt, away_fourth_down_off_conv as fourthDownOffConv,\r\n" + 
			"home_fourth_down_off_att as fourthDownDefAtt, home_fourth_down_off_conv as fourthDownDefConv,\r\n" + 
			"away_off_red_zone_att as redZoneOffAtt, away_off_red_zone_scores as redZoneOffScores, away_off_red_zone_tds as redZoneOffTDs, away_off_red_zone_fgs as redZoneOffFGs,\r\n" + 
			"home_off_red_zone_att as redZoneDefAtt, home_off_red_zone_scores as redZoneDefScores, home_off_red_zone_tds as redZoneDefTDs, home_off_red_zone_fgs as redZoneDefFGs,\r\n" + 
			"away_fumble_gain as fumbleGain, away_fumble_lost as fumbleLost, away_turnover_margin as turnoverMargin\r\n" + 
			"FROM game_info\r\n" + 
			"where away_team_id = :teamId AND game_date > :seasonStart\r\n" + 
			"AND game_date < :currentGame)) as h";
	
	private String simpleGameLimitStatsQuery = "select (count(win) / count(*)) * 100 as winPct, (count(winATS) / count(*)) * 100 as winATSPct, (count(under) / count(*)) * 100 as underPct,\r\n" + 
			"avg(rushOffYards) as rushOffYardsAvg, avg(passOffYards) as passOffYardsAvg, avg(scoringOffPoints) as scoringOffPointsAvg, \r\n" + 
			"avg(rushDefYards) as rushDefYardsAvg, avg(passDefYards) as passDefYardsAvg, avg(scoringDefPoints) as scoringDefPointsAvg\r\n" + 
			"from\r\n" + 
			"((SELECT game_date, (CASE WHEN home_team_points >= away_team_points THEN 1 ELSE NULL END) as win,\r\n" + 
			"(CASE WHEN home_team_points + COALESCE(point_spread, 0) >= away_team_points THEN 1 ELSE NULL END) as winATS,\r\n" + 
			"(CASE WHEN home_team_points + away_team_points <= COALESCE(point_total, 0) THEN 1 ELSE NULL END) as under,\r\n" +
			"home_rush_off_yards as rushOffYards, home_pass_off_yards as passOffYards, home_scoring_off_points as scoringOffPoints,\r\n" + 
			"away_rush_off_yards as rushDefYards, away_pass_off_yards as passDefYards, away_scoring_off_points as scoringDefPoints\r\n" + 
			"FROM game_info\r\n" + 
			"where home_team_id = :teamId\r\n" + 
			"AND game_date < :currentGame)\r\n" + 
			"UNION ALL\r\n" + 
			"(SELECT game_date, (CASE WHEN home_team_points <= away_team_points THEN 1 ELSE NULL END) as win, \r\n" + 
			"(CASE WHEN home_team_points + COALESCE(point_spread, 0) <= away_team_points THEN 1 ELSE NULL END) as winATS,\r\n" + 
			"(CASE WHEN home_team_points + away_team_points <= COALESCE(point_total, 0) THEN 1 ELSE NULL END) as under,\r\n" +
			"away_rush_off_yards as rushOffYards, away_pass_off_yards as passOffYards, away_scoring_off_points as scoringOffPoints,\r\n" + 
			"home_rush_off_yards as rushDefYards, home_pass_off_yards as passDefYards, home_scoring_off_points as scoringDefPoints\r\n" + 
			"FROM game_info\r\n" + 
			"where away_team_id = :teamId \r\n" + 
			"AND game_date < :currentGame)\r\n" + 
			"order by game_date desc\r\n" + 
			"limit :gameNumberLimit) as h";
	
	private String simpleSeasonStatsQuery = "select (count(win) / count(*)) * 100 as winPct, (count(winATS) / count(*)) * 100 as winATSPct, (count(under) / count(*)) * 100 as underPct,\r\n" + 
			"avg(rushOffYards) as rushOffYardsAvg, avg(passOffYards) as passOffYardsAvg, avg(scoringOffPoints) as scoringOffPointsAvg, \r\n" + 
			"avg(rushDefYards) as rushDefYardsAvg, avg(passDefYards) as passDefYardsAvg, avg(scoringDefPoints) as scoringDefPointsAvg\r\n" + 
			"from\r\n" + 
			"((SELECT (CASE WHEN home_team_points >= away_team_points THEN 1 ELSE NULL END) as win,\r\n" + 
			"(CASE WHEN home_team_points + COALESCE(point_spread, 0) >= away_team_points THEN 1 ELSE NULL END) as winATS,\r\n" + 
			"(CASE WHEN home_team_points + away_team_points <= COALESCE(point_total, 0) THEN 1 ELSE NULL END) as under,\r\n" +
			"home_rush_off_yards as rushOffYards, home_pass_off_yards as passOffYards, home_scoring_off_points as scoringOffPoints,\r\n" + 
			"away_rush_off_yards as rushDefYards, away_pass_off_yards as passDefYards, away_scoring_off_points as scoringDefPoints\r\n" + 
			"FROM game_info\r\n" + 
			"where home_team_id = :teamId\r\n" + 
			"AND game_date > :seasonStart AND game_date < :seasonEnd)\r\n" + 
			"UNION ALL\r\n" + 
			"(SELECT (CASE WHEN home_team_points <= away_team_points THEN 1 ELSE NULL END) as win, \r\n" + 
			"(CASE WHEN home_team_points + COALESCE(point_spread, 0) <= away_team_points THEN 1 ELSE NULL END) as winATS,\r\n" + 
			"(CASE WHEN home_team_points + away_team_points <= COALESCE(point_total, 0) THEN 1 ELSE NULL END) as under,\r\n" +
			"away_rush_off_yards as rushOffYards, away_pass_off_yards as passOffYards, away_scoring_off_points as scoringOffPoints,\r\n" + 
			"home_rush_off_yards as rushDefYards, home_pass_off_yards as passDefYards, home_scoring_off_points as scoringDefPoints\r\n" + 
			"FROM game_info\r\n" + 
			"where away_team_id = :teamId \r\n" + 
			"AND game_date > :seasonStart AND game_date < :seasonEnd)) as h";

}
