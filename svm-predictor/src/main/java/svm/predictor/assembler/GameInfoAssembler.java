package svm.predictor.assembler;

import svm.predictor.domain.GameInfo;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamGameStatsDto;

public class GameInfoAssembler extends BaseAssembler<GameInfoDto, GameInfo, Integer> {

	@Override
	public GameInfo createEntity() {
		return new GameInfo();
	}

	@Override
	public GameInfoDto createDto() {
		return new GameInfoDto();
	}

	@Override
	protected void doConvertToDto(GameInfo entity, GameInfoDto dto) {
		dto.setAttendance(entity.getAttendance());
		dto.setAwayTeamId(entity.getAwayTeamId());
		dto.setAwayTeamPoints(entity.getAwayTeamPoints());
		dto.setHomeTeamId(entity.getHomeTeamId());
		dto.setHomeTeamPoints(entity.getHomeTeamPoints());
		dto.setPointSpread(entity.getPointSpread());
		dto.setPointTotal(entity.getPointTotal());
		dto.setHomeStraightOdds(entity.getHomeStraightOdds());
		dto.setAwayStraightOdds(entity.getAwayStraightOdds());
		dto.setGameDate(entity.getGameDate());
		dto.setDistanceBetweenTeamsKm(entity.getDistanceBetweenTeamsKm());
		dto.setNeutralVenue(entity.isNeutralVenue());
		dto.setLeague(entity.getLeague());
		
		//away team stats;
		TeamGameStatsDto awayTeamStats = new TeamGameStatsDto();
		awayTeamStats.setFGOffAtt(entity.getAwayFGOffAtt());
		awayTeamStats.setFGOffMade(entity.getAwayFGOffMade());
		awayTeamStats.setFGOffPct(entity.getAwayFGOffPct());

		awayTeamStats.setFirstDownOffPass(entity.getAwayFirstDownOffPass());
		awayTeamStats.setFirstDownOffPenalty(entity.getAwayFirstDownOffPenalty());
		awayTeamStats.setFirstDownOffRush(entity.getAwayFirstDownOffRush());
		awayTeamStats.setFirstDownOffTotal(entity.getAwayFirstDownOffTotal());

		awayTeamStats.setFourthDownOffAtt(entity.getAwayFourthDownOffAtt());
		awayTeamStats.setFourthDownOffConv(entity.getAwayFourthDownOffConv());
		awayTeamStats.setFourthDownOffConvPct(entity.getAwayFourthDownOffConvPct());

		awayTeamStats.setFumbleGain(entity.getAwayFumbleGain());
		awayTeamStats.setFubmleLost(entity.getAwayFumbleLost());
		awayTeamStats.setFumbleReturns(entity.getAwayFumbleReturns());
		awayTeamStats.setFumbleReturnTDs(entity.getAwayFumbleReturnTDs());
		awayTeamStats.setFumbleReturnYards(entity.getAwayFumbleReturnYards());
		awayTeamStats.setFumblesForced(entity.getAwayFumblesForced());

		awayTeamStats.setKickoffAverage(entity.getAwayKickoffAverage());
		awayTeamStats.setKickoffOnSide(entity.getAwayKickoffOnSide());
		awayTeamStats.setKickoffOutOfBounds(entity.getAwayKickoffOutOfBounds());
		awayTeamStats.setKickoffReturnAverage(entity.getAwayKickoffReturnAverage());
		awayTeamStats.setKickoffReturns(entity.getAwayKickoffReturns());
		awayTeamStats.setKickoffReturnTDs(entity.getAwayKickoffReturnTDs());
		awayTeamStats.setKickoffReturnYards(entity.getAwayKickoffReturnYards());
		awayTeamStats.setKickoffs(entity.getAwayKickoffs());
		awayTeamStats.setKickoffTouchback(entity.getAwayKickoffTouchback());
		awayTeamStats.setKickoffTouchbackPct(entity.getAwayKickoffTouchbackPct());
		awayTeamStats.setKickoffYards(entity.getAwayKickoffYards());

		awayTeamStats.setOffRedZoneAtt(entity.getAwayOffRedZoneAtt());
		awayTeamStats.setOffRedZoneFGPct(entity.getAwayOffRedZoneFGPct());
		awayTeamStats.setOffRedZoneFGs(entity.getAwayOffRedZoneFGs());
		awayTeamStats.setOffRedZoneScorePct(entity.getAwayOffRedZoneScorePct());
		awayTeamStats.setOffRedZoneScores(entity.getAwayOffRedZoneScores());
		awayTeamStats.setOffRedZoneTDPct(entity.getAwayOffRedZoneTDPct());
		awayTeamStats.setOffRedZoneTDs(entity.getAwayOffRedZoneTDs());

		awayTeamStats.setPassDefInts(entity.getAwayPassDefInts());
		awayTeamStats.setPassDefIntTDs(entity.getAwayPassDefIntTDs());
		awayTeamStats.setPassDefIntYards(entity.getAwayPassDefIntYards());
		awayTeamStats.setPassesBrokenUp(entity.getAwayPassesBrokenUp());
		awayTeamStats.setPassOffAtt(entity.getAwayPassOffAtt());
		awayTeamStats.setPassOffComp(entity.getAwayPassOffComp());
		awayTeamStats.setPassOffCompPct(entity.getAwayPassOffCompPct());
		awayTeamStats.setPassOffINTs(entity.getAwayPassOffINTs());
		awayTeamStats.setPassOffRating(entity.getAwayPassOffRating());
		awayTeamStats.setPassOffTDs(entity.getAwayPassOffTDs());
		awayTeamStats.setPassOffYards(entity.getAwayPassOffYards());
		awayTeamStats.setPassOffYPA(entity.getAwayPassOffYPA());
		awayTeamStats.setPassOffYPR(entity.getAwayPassOffYPR());

		awayTeamStats.setPenalties(entity.getAwayPenalties());
		awayTeamStats.setPenaltyYards(entity.getAwayPenaltyYards());

		awayTeamStats.setPuntAverage(entity.getAwayPuntAverage());
		awayTeamStats.setPuntKicksBlocked(entity.getAwayPuntKicksBlocked());
		awayTeamStats.setPuntReturnAverage(entity.getAwayPuntReturnAverage());
		awayTeamStats.setPuntReturns(entity.getAwayPuntReturns());
		awayTeamStats.setPuntReturnTDs(entity.getAwayPuntReturnTDs());
		awayTeamStats.setPuntReturnYards(entity.getAwayPuntReturnYards());
		awayTeamStats.setPunts(entity.getAwayPunts());
		awayTeamStats.setPuntYards(entity.getAwayPuntYards());

		awayTeamStats.setQBHurries(entity.getAwayQBHurries());

		awayTeamStats.setRushOffAtt(entity.getAwayRushOffAtt());
		awayTeamStats.setRushOffTDs(entity.getAwayRushOffTDs());
		awayTeamStats.setRushOffYards(entity.getAwayRushOffYards());
		awayTeamStats.setRushOffYPA(entity.getAwayRushOffYPA());

		awayTeamStats.setSacks(entity.getAwaySacks());
		awayTeamStats.setSackYards(entity.getAwaySackYards());

		awayTeamStats.setScoringOff2PtConv(entity.getAwayScoringOff2PtConv());
		awayTeamStats.setScoringOffPoints(entity.getAwayScoringOffPoints());
		awayTeamStats.setScoringOffSafeties(entity.getAwayScoringOffSafeties());
		awayTeamStats.setScoringOffTDs(entity.getAwayScoringOffTDs());

		awayTeamStats.setTFLs(entity.getAwayTFLs());
		awayTeamStats.setTFLYards(entity.getAwayTFLYards());

		awayTeamStats.setThirdDownOffAtt(entity.getAwayThirdDownOffAtt());
		awayTeamStats.setThirdDownOffConv(entity.getAwayThirdDownOffConv());
		awayTeamStats.setThirdDownOffConvPct(entity.getAwayThirdDownOffConvPct());

		awayTeamStats.setTotalOffPlays(entity.getAwayTotalOffPlays());
		awayTeamStats.setTotalOffYards(entity.getAwayTotalOffYards());
		awayTeamStats.setTotalOffYPP(entity.getAwayTotalOffYPP());

		awayTeamStats.setTotalTackles(entity.getAwayTotalTackles());
		awayTeamStats.setTurnoverMargin(entity.getAwayTurnoverMargin());

		dto.setAwayTeamStats(awayTeamStats);
		
		//home team stats;
		TeamGameStatsDto homeTeamStats = new TeamGameStatsDto();
		homeTeamStats.setFGOffAtt(entity.getHomeFGOffAtt());
		homeTeamStats.setFGOffMade(entity.getHomeFGOffMade());
		homeTeamStats.setFGOffPct(entity.getHomeFGOffPct());

		homeTeamStats.setFirstDownOffPass(entity.getHomeFirstDownOffPass());
		homeTeamStats.setFirstDownOffPenalty(entity
				.getHomeFirstDownOffPenalty());
		homeTeamStats.setFirstDownOffRush(entity.getHomeFirstDownOffRush());
		homeTeamStats.setFirstDownOffTotal(entity.getHomeFirstDownOffTotal());

		homeTeamStats.setFourthDownOffAtt(entity.getHomeFourthDownOffAtt());
		homeTeamStats.setFourthDownOffConv(entity.getHomeFourthDownOffConv());
		homeTeamStats.setFourthDownOffConvPct(entity
				.getHomeFourthDownOffConvPct());

		homeTeamStats.setFumbleGain(entity.getHomeFumbleGain());
		homeTeamStats.setFubmleLost(entity.getHomeFumbleLost());
		homeTeamStats.setFumbleReturns(entity.getHomeFumbleReturns());
		homeTeamStats.setFumbleReturnTDs(entity.getHomeFumbleReturnTDs());
		homeTeamStats.setFumbleReturnYards(entity.getHomeFumbleReturnYards());
		homeTeamStats.setFumblesForced(entity.getHomeFumblesForced());

		homeTeamStats.setKickoffAverage(entity.getHomeKickoffAverage());
		homeTeamStats.setKickoffOnSide(entity.getHomeKickoffOnSide());
		homeTeamStats.setKickoffOutOfBounds(entity.getHomeKickoffOutOfBounds());
		homeTeamStats.setKickoffReturnAverage(entity
				.getHomeKickoffReturnAverage());
		homeTeamStats.setKickoffReturns(entity.getHomeKickoffReturns());
		homeTeamStats.setKickoffReturnTDs(entity.getHomeKickoffReturnTDs());
		homeTeamStats.setKickoffReturnYards(entity.getHomeKickoffReturnYards());
		homeTeamStats.setKickoffs(entity.getHomeKickoffs());
		homeTeamStats.setKickoffTouchback(entity.getHomeKickoffTouchback());
		homeTeamStats.setKickoffTouchbackPct(entity
				.getHomeKickoffTouchbackPct());
		homeTeamStats.setKickoffYards(entity.getHomeKickoffYards());

		homeTeamStats.setOffRedZoneAtt(entity.getHomeOffRedZoneAtt());
		homeTeamStats.setOffRedZoneFGPct(entity.getHomeOffRedZoneFGPct());
		homeTeamStats.setOffRedZoneFGs(entity.getHomeOffRedZoneFGs());
		homeTeamStats.setOffRedZoneScorePct(entity.getHomeOffRedZoneScorePct());
		homeTeamStats.setOffRedZoneScores(entity.getHomeOffRedZoneScores());
		homeTeamStats.setOffRedZoneTDPct(entity.getHomeOffRedZoneTDPct());
		homeTeamStats.setOffRedZoneTDs(entity.getHomeOffRedZoneTDs());

		homeTeamStats.setPassDefInts(entity.getHomePassDefInts());
		homeTeamStats.setPassDefIntTDs(entity.getHomePassDefIntTDs());
		homeTeamStats.setPassDefIntYards(entity.getHomePassDefIntYards());
		homeTeamStats.setPassesBrokenUp(entity.getHomePassesBrokenUp());
		homeTeamStats.setPassOffAtt(entity.getHomePassOffAtt());
		homeTeamStats.setPassOffComp(entity.getHomePassOffComp());
		homeTeamStats.setPassOffCompPct(entity.getHomePassOffCompPct());
		homeTeamStats.setPassOffINTs(entity.getHomePassOffINTs());
		homeTeamStats.setPassOffRating(entity.getHomePassOffRating());
		homeTeamStats.setPassOffTDs(entity.getHomePassOffTDs());
		homeTeamStats.setPassOffYards(entity.getHomePassOffYards());
		homeTeamStats.setPassOffYPA(entity.getHomePassOffYPA());
		homeTeamStats.setPassOffYPR(entity.getHomePassOffYPR());

		homeTeamStats.setPenalties(entity.getHomePenalties());
		homeTeamStats.setPenaltyYards(entity.getHomePenaltyYards());

		homeTeamStats.setPuntAverage(entity.getHomePuntAverage());
		homeTeamStats.setPuntKicksBlocked(entity.getHomePuntKicksBlocked());
		homeTeamStats.setPuntReturnAverage(entity.getHomePuntReturnAverage());
		homeTeamStats.setPuntReturns(entity.getHomePuntReturns());
		homeTeamStats.setPuntReturnTDs(entity.getHomePuntReturnTDs());
		homeTeamStats.setPuntReturnYards(entity.getHomePuntReturnYards());
		homeTeamStats.setPunts(entity.getHomePunts());
		homeTeamStats.setPuntYards(entity.getHomePuntYards());

		homeTeamStats.setQBHurries(entity.getHomeQBHurries());

		homeTeamStats.setRushOffAtt(entity.getHomeRushOffAtt());
		homeTeamStats.setRushOffTDs(entity.getHomeRushOffTDs());
		homeTeamStats.setRushOffYards(entity.getHomeRushOffYards());
		homeTeamStats.setRushOffYPA(entity.getHomeRushOffYPA());

		homeTeamStats.setSacks(entity.getHomeSacks());
		homeTeamStats.setSackYards(entity.getHomeSackYards());

		homeTeamStats.setScoringOff2PtConv(entity.getHomeScoringOff2PtConv());
		homeTeamStats.setScoringOffPoints(entity.getHomeScoringOffPoints());
		homeTeamStats.setScoringOffSafeties(entity.getHomeScoringOffSafeties());
		homeTeamStats.setScoringOffTDs(entity.getHomeScoringOffTDs());

		homeTeamStats.setTFLs(entity.getHomeTFLs());
		homeTeamStats.setTFLYards(entity.getHomeTFLYards());

		homeTeamStats.setThirdDownOffAtt(entity.getHomeThirdDownOffAtt());
		homeTeamStats.setThirdDownOffConv(entity.getHomeThirdDownOffConv());
		homeTeamStats.setThirdDownOffConvPct(entity
				.getHomeThirdDownOffConvPct());

		homeTeamStats.setTotalOffPlays(entity.getHomeTotalOffPlays());
		homeTeamStats.setTotalOffYards(entity.getHomeTotalOffYards());
		homeTeamStats.setTotalOffYPP(entity.getHomeTotalOffYPP());

		homeTeamStats.setTotalTackles(entity.getHomeTotalTackles());
		homeTeamStats.setTurnoverMargin(entity.getHomeTurnoverMargin());

		dto.setHomeTeamStats(homeTeamStats);
	}

	@Override
	protected void doConvertToEntity(GameInfoDto dto, GameInfo entity) {
		entity.setAttendance(dto.getAttendance());
		entity.setAwayTeamId(dto.getAwayTeamId());
		entity.setAwayTeamPoints(dto.getAwayTeamPoints());
		entity.setHomeTeamId(dto.getHomeTeamId());
		entity.setHomeTeamPoints(dto.getHomeTeamPoints());
		entity.setPointSpread(dto.getPointSpread());
		entity.setPointTotal(dto.getPointTotal());
		entity.setHomeStraightOdds(dto.getHomeStraightOdds());
		entity.setAwayStraightOdds(dto.getAwayStraightOdds());
		entity.setGameDate(dto.getGameDate());
		entity.setDistanceBetweenTeamsKm(dto.getDistanceBetweenTeamsKm());
		entity.setNeutralVenue(dto.isNeutralVenue());
		entity.setLeague(dto.getLeague());
		
		//away team stats;
		TeamGameStatsDto awayTeamStats = dto.getAwayTeamStats();
		entity.setAwayFGOffAtt(awayTeamStats.getFGOffAtt());
		entity.setAwayFGOffMade(awayTeamStats.getFGOffMade());
		entity.setAwayFGOffPct(awayTeamStats.getFGOffPct());
		
		entity.setAwayFirstDownOffPass(awayTeamStats.getFirstDownOffPass());
		entity.setAwayFirstDownOffPenalty(awayTeamStats.getFirstDownOffPenalty());
		entity.setAwayFirstDownOffRush(awayTeamStats.getFirstDownOffRush());
		entity.setAwayFirstDownOffTotal(awayTeamStats.getFirstDownOffTotal());
		
		entity.setAwayFourthDownOffAtt(awayTeamStats.getFourthDownOffAtt());
		entity.setAwayFourthDownOffConv(awayTeamStats.getFourthDownOffConv());
		entity.setAwayFourthDownOffConvPct(awayTeamStats.getFourthDownOffConvPct());
		
		entity.setAwayFumbleGain(awayTeamStats.getFumbleGain());
		entity.setAwayFumbleLost(awayTeamStats.getFubmleLost());
		entity.setAwayFumbleReturns(awayTeamStats.getFumbleReturns());
		entity.setAwayFumbleReturnTDs(awayTeamStats.getFumbleReturnTDs());
		entity.setAwayFumbleReturnYards(awayTeamStats.getFumbleReturnYards());
		entity.setAwayFumblesForced(awayTeamStats.getFumblesForced());
		
		entity.setAwayKickoffAverage(awayTeamStats.getKickoffAverage());
		entity.setAwayKickoffOnSide(awayTeamStats.getKickoffOnSide());
		entity.setAwayKickoffOutOfBounds(awayTeamStats.getKickoffOutOfBounds());
		entity.setAwayKickoffReturnAverage(awayTeamStats.getKickoffReturnAverage());
		entity.setAwayKickoffReturns(awayTeamStats.getKickoffReturns());
		entity.setAwayKickoffReturnTDs(awayTeamStats.getKickoffReturnTDs());
		entity.setAwayKickoffReturnYards(awayTeamStats.getKickoffReturnYards());
		entity.setAwayKickoffs(awayTeamStats.getKickoffs());
		entity.setAwayKickoffTouchback(awayTeamStats.getKickoffTouchback());
		entity.setAwayKickoffTouchbackPct(awayTeamStats.getKickoffTouchbackPct());
		entity.setAwayKickoffYards(awayTeamStats.getKickoffYards());
		
		entity.setAwayOffRedZoneAtt(awayTeamStats.getOffRedZoneAtt());
		entity.setAwayOffRedZoneFGPct(awayTeamStats.getOffRedZoneFGPct());
		entity.setAwayOffRedZoneFGs(awayTeamStats.getOffRedZoneFGs());
		entity.setAwayOffRedZoneScorePct(awayTeamStats.getOffRedZoneScorePct());
		entity.setAwayOffRedZoneScores(awayTeamStats.getOffRedZoneScores());
		entity.setAwayOffRedZoneTDPct(awayTeamStats.getOffRedZoneTDPct());
		entity.setAwayOffRedZoneTDs(awayTeamStats.getOffRedZoneTDs());
		
		entity.setAwayPassDefInts(awayTeamStats.getPassDefInts());
		entity.setAwayPassDefIntTDs(awayTeamStats.getPassDefIntTDs());
		entity.setAwayPassDefIntYards(awayTeamStats.getPassDefIntYards());
		entity.setAwayPassesBrokenUp(awayTeamStats.getPassesBrokenUp());
		entity.setAwayPassOffAtt(awayTeamStats.getPassOffAtt());
		entity.setAwayPassOffComp(awayTeamStats.getPassOffComp());
		entity.setAwayPassOffCompPct(awayTeamStats.getPassOffCompPct());
		entity.setAwayPassOffINTs(awayTeamStats.getPassOffINTs());
		entity.setAwayPassOffRating(awayTeamStats.getPassOffRating());
		entity.setAwayPassOffTDs(awayTeamStats.getPassOffTDs());
		entity.setAwayPassOffYards(awayTeamStats.getPassOffYards());
		entity.setAwayPassOffYPA(awayTeamStats.getPassOffYPA());
		entity.setAwayPassOffYPR(awayTeamStats.getPassOffYPR());
		
		entity.setAwayPenalties(awayTeamStats.getPenalties());
		entity.setAwayPenaltyYards(awayTeamStats.getPenaltyYards());
		
		entity.setAwayPuntAverage(awayTeamStats.getPuntAverage());
		entity.setAwayPuntKicksBlocked(awayTeamStats.getPuntKicksBlocked());
		entity.setAwayPuntReturnAverage(awayTeamStats.getPuntReturnAverage());
		entity.setAwayPuntReturns(awayTeamStats.getPuntReturns());
		entity.setAwayPuntReturnTDs(awayTeamStats.getPuntReturnTDs());
		entity.setAwayPuntReturnYards(awayTeamStats.getPuntReturnYards());
		entity.setAwayPunts(awayTeamStats.getPunts());
		entity.setAwayPuntYards(awayTeamStats.getPuntYards());
		
		entity.setAwayQBHurries(awayTeamStats.getQBHurries());
		
		entity.setAwayRushOffAtt(awayTeamStats.getRushOffAtt());
		entity.setAwayRushOffTDs(awayTeamStats.getRushOffTDs());
		entity.setAwayRushOffYards(awayTeamStats.getRushOffYards());
		entity.setAwayRushOffYPA(awayTeamStats.getRushOffYPA());
		
		entity.setAwaySacks(awayTeamStats.getSacks());
		entity.setAwaySackYards(awayTeamStats.getSackYards());
		
		entity.setAwayScoringOff2PtConv(awayTeamStats.getScoringOff2PtConv());
		entity.setAwayScoringOffPoints(awayTeamStats.getScoringOffPoints());
		entity.setAwayScoringOffSafeties(awayTeamStats.getScoringOffSafeties());
		entity.setAwayScoringOffTDs(awayTeamStats.getScoringOffTDs());
		
		entity.setAwayTFLs(awayTeamStats.getTFLs());
		entity.setAwayTFLYards(awayTeamStats.getTFLYards());
		
		entity.setAwayThirdDownOffAtt(awayTeamStats.getThirdDownOffAtt());
		entity.setAwayThirdDownOffConv(awayTeamStats.getThirdDownOffConv());
		entity.setAwayThirdDownOffConvPct(awayTeamStats.getThirdDownOffConvPct());
		
		entity.setAwayTotalOffPlays(awayTeamStats.getTotalOffPlays());
		entity.setAwayTotalOffYards(awayTeamStats.getTotalOffYards());
		entity.setAwayTotalOffYPP(awayTeamStats.getTotalOffYPP());
		
		entity.setAwayTotalTackles(awayTeamStats.getTotalTackles());
		entity.setAwayTurnoverMargin(awayTeamStats.getTurnoverMargin());
		
		//home team stats;
		TeamGameStatsDto homeTeamStats = dto.getHomeTeamStats();
		entity.setHomeFGOffAtt(homeTeamStats.getFGOffAtt());
		entity.setHomeFGOffMade(homeTeamStats.getFGOffMade());
		entity.setHomeFGOffPct(homeTeamStats.getFGOffPct());

		entity.setHomeFirstDownOffPass(homeTeamStats.getFirstDownOffPass());
		entity.setHomeFirstDownOffPenalty(homeTeamStats
				.getFirstDownOffPenalty());
		entity.setHomeFirstDownOffRush(homeTeamStats.getFirstDownOffRush());
		entity.setHomeFirstDownOffTotal(homeTeamStats.getFirstDownOffTotal());

		entity.setHomeFourthDownOffAtt(homeTeamStats.getFourthDownOffAtt());
		entity.setHomeFourthDownOffConv(homeTeamStats.getFourthDownOffConv());
		entity.setHomeFourthDownOffConvPct(homeTeamStats
				.getFourthDownOffConvPct());

		entity.setHomeFumbleGain(homeTeamStats.getFumbleGain());
		entity.setHomeFumbleLost(homeTeamStats.getFubmleLost());
		entity.setHomeFumbleReturns(homeTeamStats.getFumbleReturns());
		entity.setHomeFumbleReturnTDs(homeTeamStats.getFumbleReturnTDs());
		entity.setHomeFumbleReturnYards(homeTeamStats.getFumbleReturnYards());
		entity.setHomeFumblesForced(homeTeamStats.getFumblesForced());

		entity.setHomeKickoffAverage(homeTeamStats.getKickoffAverage());
		entity.setHomeKickoffOnSide(homeTeamStats.getKickoffOnSide());
		entity.setHomeKickoffOutOfBounds(homeTeamStats.getKickoffOutOfBounds());
		entity.setHomeKickoffReturnAverage(homeTeamStats
				.getKickoffReturnAverage());
		entity.setHomeKickoffReturns(homeTeamStats.getKickoffReturns());
		entity.setHomeKickoffReturnTDs(homeTeamStats.getKickoffReturnTDs());
		entity.setHomeKickoffReturnYards(homeTeamStats.getKickoffReturnYards());
		entity.setHomeKickoffs(homeTeamStats.getKickoffs());
		entity.setHomeKickoffTouchback(homeTeamStats.getKickoffTouchback());
		entity.setHomeKickoffTouchbackPct(homeTeamStats
				.getKickoffTouchbackPct());
		entity.setHomeKickoffYards(homeTeamStats.getKickoffYards());

		entity.setHomeOffRedZoneAtt(homeTeamStats.getOffRedZoneAtt());
		entity.setHomeOffRedZoneFGPct(homeTeamStats.getOffRedZoneFGPct());
		entity.setHomeOffRedZoneFGs(homeTeamStats.getOffRedZoneFGs());
		entity.setHomeOffRedZoneScorePct(homeTeamStats.getOffRedZoneScorePct());
		entity.setHomeOffRedZoneScores(homeTeamStats.getOffRedZoneScores());
		entity.setHomeOffRedZoneTDPct(homeTeamStats.getOffRedZoneTDPct());
		entity.setHomeOffRedZoneTDs(homeTeamStats.getOffRedZoneTDs());

		entity.setHomePassDefInts(homeTeamStats.getPassDefInts());
		entity.setHomePassDefIntTDs(homeTeamStats.getPassDefIntTDs());
		entity.setHomePassDefIntYards(homeTeamStats.getPassDefIntYards());
		entity.setHomePassesBrokenUp(homeTeamStats.getPassesBrokenUp());
		entity.setHomePassOffAtt(homeTeamStats.getPassOffAtt());
		entity.setHomePassOffComp(homeTeamStats.getPassOffComp());
		entity.setHomePassOffCompPct(homeTeamStats.getPassOffCompPct());
		entity.setHomePassOffINTs(homeTeamStats.getPassOffINTs());
		entity.setHomePassOffRating(homeTeamStats.getPassOffRating());
		entity.setHomePassOffTDs(homeTeamStats.getPassOffTDs());
		entity.setHomePassOffYards(homeTeamStats.getPassOffYards());
		entity.setHomePassOffYPA(homeTeamStats.getPassOffYPA());
		entity.setHomePassOffYPR(homeTeamStats.getPassOffYPR());

		entity.setHomePenalties(homeTeamStats.getPenalties());
		entity.setHomePenaltyYards(homeTeamStats.getPenaltyYards());

		entity.setHomePuntAverage(homeTeamStats.getPuntAverage());
		entity.setHomePuntKicksBlocked(homeTeamStats.getPuntKicksBlocked());
		entity.setHomePuntReturnAverage(homeTeamStats.getPuntReturnAverage());
		entity.setHomePuntReturns(homeTeamStats.getPuntReturns());
		entity.setHomePuntReturnTDs(homeTeamStats.getPuntReturnTDs());
		entity.setHomePuntReturnYards(homeTeamStats.getPuntReturnYards());
		entity.setHomePunts(homeTeamStats.getPunts());
		entity.setHomePuntYards(homeTeamStats.getPuntYards());

		entity.setHomeQBHurries(homeTeamStats.getQBHurries());

		entity.setHomeRushOffAtt(homeTeamStats.getRushOffAtt());
		entity.setHomeRushOffTDs(homeTeamStats.getRushOffTDs());
		entity.setHomeRushOffYards(homeTeamStats.getRushOffYards());
		entity.setHomeRushOffYPA(homeTeamStats.getRushOffYPA());

		entity.setHomeSacks(homeTeamStats.getSacks());
		entity.setHomeSackYards(homeTeamStats.getSackYards());

		entity.setHomeScoringOff2PtConv(homeTeamStats.getScoringOff2PtConv());
		entity.setHomeScoringOffPoints(homeTeamStats.getScoringOffPoints());
		entity.setHomeScoringOffSafeties(homeTeamStats.getScoringOffSafeties());
		entity.setHomeScoringOffTDs(homeTeamStats.getScoringOffTDs());

		entity.setHomeTFLs(homeTeamStats.getTFLs());
		entity.setHomeTFLYards(homeTeamStats.getTFLYards());

		entity.setHomeThirdDownOffAtt(homeTeamStats.getThirdDownOffAtt());
		entity.setHomeThirdDownOffConv(homeTeamStats.getThirdDownOffConv());
		entity.setHomeThirdDownOffConvPct(homeTeamStats
				.getThirdDownOffConvPct());

		entity.setHomeTotalOffPlays(homeTeamStats.getTotalOffPlays());
		entity.setHomeTotalOffYards(homeTeamStats.getTotalOffYards());
		entity.setHomeTotalOffYPP(homeTeamStats.getTotalOffYPP());

		entity.setHomeTotalTackles(homeTeamStats.getTotalTackles());
		entity.setHomeTurnoverMargin(homeTeamStats.getTurnoverMargin());
	}

}
