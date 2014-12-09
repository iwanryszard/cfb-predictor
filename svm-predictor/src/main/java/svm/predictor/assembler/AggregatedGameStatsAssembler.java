package svm.predictor.assembler;

import svm.predictor.domain.AggregatedGameStats;
import svm.predictor.domain.GameInfo;
import svm.predictor.dto.AggregatedGameStatsDto;
import svm.predictor.dto.GameInfoDto;
import svm.predictor.dto.TeamAggregatedGameStatsDto;
import svm.predictor.dto.TeamSimpleAggregatedStats;


public class AggregatedGameStatsAssembler extends BaseAssembler<AggregatedGameStatsDto, AggregatedGameStats, Integer> {

	private GameInfoAssembler gameInfoAssembler;
	
	@Override
	public AggregatedGameStats createEntity() {
		return new AggregatedGameStats();
	}

	@Override
	public AggregatedGameStatsDto createDto() {
		return new AggregatedGameStatsDto();
	}

	@Override
	protected void doConvertToDto(AggregatedGameStats entity, AggregatedGameStatsDto dto) {
		GameInfoDto game = gameInfoAssembler.convertToDto(entity.getGame());
		dto.setGame(game);
		
		TeamAggregatedGameStatsDto homeTeamStats = new TeamAggregatedGameStatsDto();
		homeTeamStats.setDefRedZoneAttAvg(entity.getHomeDefRedZoneAttAvg());
		homeTeamStats.setDefRedZoneFGPct(entity.getHomeDefRedZoneFGPct());
		homeTeamStats.setDefRedZoneFGsAvg(entity.getHomeDefRedZoneFGsAvg());
		homeTeamStats.setDefRedZoneScorePct(entity.getHomeDefRedZoneScorePct());
		homeTeamStats.setDefRedZoneScoresAvg(entity.getHomeDefRedZoneScoresAvg());
		homeTeamStats.setDefRedZoneTDPct(entity.getHomeDefRedZoneTDPct());
		homeTeamStats.setDefRedZoneTDsAvg(entity.getHomeDefRedZoneTDsAvg());
		
		homeTeamStats.setFgDefAttAvg(entity.getHomeFGDefAttAvg());
		homeTeamStats.setFgDefMadeAvg(entity.getHomeFGDefMadeAvg());
		homeTeamStats.setFGDefPct(entity.getHomeFGDefPct());
		homeTeamStats.setFgOffAttAvg(entity.getHomeFGOffAttAvg());
		homeTeamStats.setFgOffMadeAvg(entity.getHomeFGOffMadeAvg());
		homeTeamStats.setFGOffPct(entity.getHomeFGOffPct());
		
		homeTeamStats.setFirstDownDefPassAvg(entity.getHomeFirstDownDefPassAvg());
		homeTeamStats.setFirstDownDefPenaltyAvg(entity.getHomeFirstDownDefPenaltyAvg());
		homeTeamStats.setFirstDownDefRushAvg(entity.getHomeFirstDownDefRushAvg());
		homeTeamStats.setFirstDownDefTotalAvg(entity.getHomeFirstDownDefTotalAvg());
		homeTeamStats.setFirstDownOffPassAvg(entity.getHomeFirstDownOffPassAvg());
		homeTeamStats.setFirstDownOffPenaltyAvg(entity.getHomeFirstDownOffPenaltyAvg());
		homeTeamStats.setFirstDownOffRushAvg(entity.getHomeFirstDownOffRushAvg());
		homeTeamStats.setFirstDownOffTotalAvg(entity.getHomeFirstDownOffTotalAvg());
		
		homeTeamStats.setFourthDownDefAttAvg(entity.getHomeFourthDownDefAttAvg());
		homeTeamStats.setFourthDownDefConvAvg(entity.getHomeFourthDownDefConvAvg());
		homeTeamStats.setFourthDownDefConvPct(entity.getHomeFourthDownDefConvPct());
		homeTeamStats.setFourthDownOffAttAvg(entity.getHomeFourthDownOffAttAvg());
		homeTeamStats.setFourthDownOffConvAvg(entity.getHomeFourthDownOffConvAvg());
		homeTeamStats.setFourthDownOffConvPct(entity.getHomeFourthDownOffConvPct());
		
		homeTeamStats.setFubmleLostAvg(entity.getHomeFubmleLostAvg());
		homeTeamStats.setFumbleGainAvg(entity.getHomeFumbleGainAvg());
		homeTeamStats.setFumbleReturnsAvg(entity.getHomeFumbleReturnsAvg());
		homeTeamStats.setFumbleReturnTDsAvg(entity.getHomeFumbleReturnTDsAvg());
		homeTeamStats.setFumbleReturnYardsAvg(entity.getHomeFumbleReturnYardsAvg());
		homeTeamStats.setFumblesForcedAvg(entity.getHomeFumblesForcedAvg());
		
		homeTeamStats.setGamesPlayed(entity.getHomeGamesPlayed());
		
		homeTeamStats.setKickoffAverage(entity.getHomeKickoffAverage());
		homeTeamStats.setKickoffOnSideAvg(entity.getHomeKickoffOnSideAvg());
		homeTeamStats.setKickoffOutOfBoundsAvg(entity.getHomeKickoffOutOfBoundsAvg());
		homeTeamStats.setKickoffReturnAverage(entity.getHomeKickoffReturnAverage());
		homeTeamStats.setKickoffReturnAverageDef(entity.getHomeKickoffReturnAverageDef());
		homeTeamStats.setKickoffReturnsAvg(entity.getHomeKickoffReturnsAvg());
		homeTeamStats.setKickoffReturnsDefAvg(entity.getHomeKickoffReturnsDefAvg());
		homeTeamStats.setKickoffReturnTDsAvg(entity.getHomeKickoffReturnTDsAvg());
		homeTeamStats.setKickoffReturnTDsDefAvg(entity.getHomeKickoffReturnTDsDefAvg());
		homeTeamStats.setKickoffReturnYardsAvg(entity.getHomeKickoffReturnYardsAvg());
		homeTeamStats.setKickoffReturnYardsDefAvg(entity.getHomeKickoffReturnYardsDefAvg());
		homeTeamStats.setKickoffsAvg(entity.getHomeKickoffsAvg());
		homeTeamStats.setKickoffTouchbackAvg(entity.getHomeKickoffTouchbackAvg());
		homeTeamStats.setKickoffTouchbackPct(entity.getHomeKickoffTouchbackPct());
		homeTeamStats.setKickoffYardsAvg(entity.getHomeKickoffYardsAvg());
		
		homeTeamStats.setOffRedZoneAttAvg(entity.getHomeOffRedZoneAttAvg());
		homeTeamStats.setOffRedZoneFGPct(entity.getHomeOffRedZoneFGPct());
		homeTeamStats.setOffRedZoneFGsAvg(entity.getHomeOffRedZoneFGsAvg());
		homeTeamStats.setOffRedZoneScorePct(entity.getHomeOffRedZoneScorePct());
		homeTeamStats.setOffRedZoneScoresAvg(entity.getHomeOffRedZoneScoresAvg());
		homeTeamStats.setOffRedZoneTDPct(entity.getHomeOffRedZoneTDPct());
		homeTeamStats.setOffRedZoneTDsAvg(entity.getHomeOffRedZoneTDsAvg());
		
		homeTeamStats.setPassDefAttAvg(entity.getHomePassDefAttAvg());
		homeTeamStats.setPassDefCompAvg(entity.getHomePassDefCompAvg());
		homeTeamStats.setPassDefCompPct(entity.getHomePassDefCompPct());
		homeTeamStats.setPassDefINTsAvg(entity.getHomePassDefINTsAvg());
		homeTeamStats.setPassDefIntTDsAvg(entity.getHomePassDefIntTDsAvg());
		homeTeamStats.setPassDefIntYardsAvg(entity.getHomePassDefIntYardsAvg());
		homeTeamStats.setPassDefRatingAvg(entity.getHomePassDefRatingAvg());
		homeTeamStats.setPassDefTDsAvg(entity.getHomePassDefTDsAvg());
		homeTeamStats.setPassDefYardsAvg(entity.getHomePassDefYardsAvg());
		homeTeamStats.setPassDefYPA(entity.getHomePassDefYPA());
		homeTeamStats.setPassDefYPR(entity.getHomePassDefYPR());
		
		homeTeamStats.setPassesBrokenUpAvg(entity.getHomePassesBrokenUpAvg());
		
		homeTeamStats.setPassOffAttAvg(entity.getHomePassOffAttAvg());
		homeTeamStats.setPassOffCompAvg(entity.getHomePassOffCompAvg());
		homeTeamStats.setPassOffCompPct(entity.getHomePassOffCompPct());
		homeTeamStats.setPassOffINTsAvg(entity.getHomePassOffINTsAvg());
		homeTeamStats.setPassOffRatingAvg(entity.getHomePassOffRatingAvg());
		homeTeamStats.setPassOffTDsAvg(entity.getHomePassOffTDsAvg());
		homeTeamStats.setPassOffYardsAvg(entity.getHomePassOffYardsAvg());
		homeTeamStats.setPassOffYPA(entity.getHomePassOffYPA());
		homeTeamStats.setPassOffYPR(entity.getHomePassOffYPR());
		
		homeTeamStats.setPenaltiesAvg(entity.getHomePenaltiesAvg());
		homeTeamStats.setPenaltyYardsAvg(entity.getHomePenaltyYardsAvg());
		
		homeTeamStats.setPuntAverage(entity.getHomePuntAverage());
		homeTeamStats.setPuntKicksBlockedAvg(entity.getHomePuntKicksBlockedAvg());
		homeTeamStats.setPuntReturnAverage(entity.getHomePuntReturnAverage());
		homeTeamStats.setPuntReturnAverageDef(entity.getHomePuntReturnAverageDef());
		homeTeamStats.setPuntReturnsAvg(entity.getHomePuntReturnsAvg());
		homeTeamStats.setPuntReturnsDefAvg(entity.getHomePuntReturnsDefAvg());
		homeTeamStats.setPuntReturnTDsAvg(entity.getHomePuntReturnTDsAvg());
		homeTeamStats.setPuntReturnTDsDefAvg(entity.getHomePuntReturnTDsDefAvg());
		homeTeamStats.setPuntReturnYardsAvg(entity.getHomePuntReturnYardsAvg());
		homeTeamStats.setPuntReturnYardsDefAvg(entity.getHomePuntReturnYardsDefAvg());
		homeTeamStats.setPuntsAvg(entity.getHomePuntsAvg());
		homeTeamStats.setPuntYardsAvg(entity.getHomePuntAverage());
		
		homeTeamStats.setQBHurriesAllowedAvg(entity.getHomeQBHurriesAllowedAvg());
		homeTeamStats.setQBHurriesAvg(entity.getHomeQBHurriesAvg());
		
		homeTeamStats.setRushDefAttAvg(entity.getHomeRushDefAttAvg());
		homeTeamStats.setRushDefTDsAvg(entity.getHomeRushDefTDsAvg());
		homeTeamStats.setRushDefYardsAvg(entity.getHomeRushDefYardsAvg());
		homeTeamStats.setRushDefYPA(entity.getHomeRushDefYPA());
		
		homeTeamStats.setRushOffAttAvg(entity.getHomeRushOffAttAvg());
		homeTeamStats.setRushOffTDsAvg(entity.getHomeRushOffTDsAvg());
		homeTeamStats.setRushOffYardsAvg(entity.getHomeRushOffYardsAvg());
		homeTeamStats.setRushOffYPA(entity.getHomeRushOffYPA());
		
		homeTeamStats.setSacksAllowedAvg(entity.getHomeSacksAllowedAvg());
		homeTeamStats.setSacksAvg(entity.getHomeSacksAvg());
		homeTeamStats.setSackYardsAllowedAvg(entity.getHomeSackYardsAllowedAvg());
		homeTeamStats.setSackYardsAvg(entity.getHomeSackYardsAvg());
		
		homeTeamStats.setScoringDef2PtConvAvg(entity.getHomeScoringDef2PtConvAvg());
		homeTeamStats.setScoringDefPointsAvg(entity.getHomeScoringDefPointsAvg());
		homeTeamStats.setScoringDefSafetiesAvg(entity.getHomeScoringDefSafetiesAvg());
		homeTeamStats.setScoringDefTDsAvg(entity.getHomeScoringDefTDsAvg());
		
		homeTeamStats.setScoringOff2PtConvAvg(entity.getHomeScoringOff2PtConvAvg());
		homeTeamStats.setScoringOffPointsAvg(entity.getHomeScoringOffPointsAvg());
		homeTeamStats.setScoringOffSafetiesAvg(entity.getHomeScoringOffSafetiesAvg());
		homeTeamStats.setScoringOffTDsAvg(entity.getHomeScoringOffTDsAvg());
		
		homeTeamStats.setTFLsAvg(entity.getHomeTFLsAvg());
		homeTeamStats.setTFLYardsAvg(entity.getHomeTFLYardsAvg());
		
		homeTeamStats.setThirdDownDefAttAvg(entity.getHomeThirdDownDefAttAvg());
		homeTeamStats.setThirdDownDefConvAvg(entity.getHomeThirdDownDefConvAvg());
		homeTeamStats.setThirdDownDefConvPct(entity.getHomeThirdDownDefConvPct());
		
		homeTeamStats.setThirdDownOffAttAvg(entity.getHomeThirdDownOffAttAvg());
		homeTeamStats.setThirdDownOffConvAvg(entity.getHomeThirdDownOffConvAvg());
		homeTeamStats.setThirdDownOffConvPct(entity.getHomeThirdDownOffConvPct());
		
		homeTeamStats.setTotalDefPlaysAvg(entity.getHomeTotalDefPlaysAvg());
		homeTeamStats.setTotalDefYardsAvg(entity.getHomeTotalDefYardsAvg());
		homeTeamStats.setTotalDefYPP(entity.getHomeTotalDefYPP());
		
		homeTeamStats.setTotalOffPlaysAvg(entity.getHomeTotalOffPlaysAvg());
		homeTeamStats.setTotalOffYardsAvg(entity.getHomeTotalOffYardsAvg());
		homeTeamStats.setTotalOffYPP(entity.getHomeTotalOffYPP());
		
		homeTeamStats.setTotalTacklesAvg(entity.getHomeTotalTacklesAvg());
		
		homeTeamStats.setTurnoverMarginAvg(entity.getHomeTurnoverMarginAvg());
		
		homeTeamStats.setWinATSPct(entity.getHomeWinATSPct());
		homeTeamStats.setWinPct(entity.getHomeWinPct());
		
		
		TeamAggregatedGameStatsDto awayTeamStats = new TeamAggregatedGameStatsDto();
		awayTeamStats.setDefRedZoneAttAvg(entity.getAwayDefRedZoneAttAvg());
		awayTeamStats.setDefRedZoneFGPct(entity.getAwayDefRedZoneFGPct());
		awayTeamStats.setDefRedZoneFGsAvg(entity.getAwayDefRedZoneFGsAvg());
		awayTeamStats.setDefRedZoneScorePct(entity.getAwayDefRedZoneScorePct());
		awayTeamStats.setDefRedZoneScoresAvg(entity.getAwayDefRedZoneScoresAvg());
		awayTeamStats.setDefRedZoneTDPct(entity.getAwayDefRedZoneTDPct());
		awayTeamStats.setDefRedZoneTDsAvg(entity.getAwayDefRedZoneTDsAvg());
		
		awayTeamStats.setFgDefAttAvg(entity.getAwayFGDefAttAvg());
		awayTeamStats.setFgDefMadeAvg(entity.getAwayFGDefMadeAvg());
		awayTeamStats.setFGDefPct(entity.getAwayFGDefPct());
		awayTeamStats.setFgOffAttAvg(entity.getAwayFGOffAttAvg());
		awayTeamStats.setFgOffMadeAvg(entity.getAwayFGOffMadeAvg());
		awayTeamStats.setFGOffPct(entity.getAwayFGOffPct());
		
		awayTeamStats.setFirstDownDefPassAvg(entity.getAwayFirstDownDefPassAvg());
		awayTeamStats.setFirstDownDefPenaltyAvg(entity.getAwayFirstDownDefPenaltyAvg());
		awayTeamStats.setFirstDownDefRushAvg(entity.getAwayFirstDownDefRushAvg());
		awayTeamStats.setFirstDownDefTotalAvg(entity.getAwayFirstDownDefTotalAvg());
		awayTeamStats.setFirstDownOffPassAvg(entity.getAwayFirstDownOffPassAvg());
		awayTeamStats.setFirstDownOffPenaltyAvg(entity.getAwayFirstDownOffPenaltyAvg());
		awayTeamStats.setFirstDownOffRushAvg(entity.getAwayFirstDownOffRushAvg());
		awayTeamStats.setFirstDownOffTotalAvg(entity.getAwayFirstDownOffTotalAvg());
		
		awayTeamStats.setFourthDownDefAttAvg(entity.getAwayFourthDownDefAttAvg());
		awayTeamStats.setFourthDownDefConvAvg(entity.getAwayFourthDownDefConvAvg());
		awayTeamStats.setFourthDownDefConvPct(entity.getAwayFourthDownDefConvPct());
		awayTeamStats.setFourthDownOffAttAvg(entity.getAwayFourthDownOffAttAvg());
		awayTeamStats.setFourthDownOffConvAvg(entity.getAwayFourthDownOffConvAvg());
		awayTeamStats.setFourthDownOffConvPct(entity.getAwayFourthDownOffConvPct());
		
		awayTeamStats.setFubmleLostAvg(entity.getAwayFubmleLostAvg());
		awayTeamStats.setFumbleGainAvg(entity.getAwayFumbleGainAvg());
		awayTeamStats.setFumbleReturnsAvg(entity.getAwayFumbleReturnsAvg());
		awayTeamStats.setFumbleReturnTDsAvg(entity.getAwayFumbleReturnTDsAvg());
		awayTeamStats.setFumbleReturnYardsAvg(entity.getAwayFumbleReturnYardsAvg());
		awayTeamStats.setFumblesForcedAvg(entity.getAwayFumblesForcedAvg());
		
		awayTeamStats.setGamesPlayed(entity.getAwayGamesPlayed());
		
		awayTeamStats.setKickoffAverage(entity.getAwayKickoffAverage());
		awayTeamStats.setKickoffOnSideAvg(entity.getAwayKickoffOnSideAvg());
		awayTeamStats.setKickoffOutOfBoundsAvg(entity.getAwayKickoffOutOfBoundsAvg());
		awayTeamStats.setKickoffReturnAverage(entity.getAwayKickoffReturnAverage());
		awayTeamStats.setKickoffReturnAverageDef(entity.getAwayKickoffReturnAverageDef());
		awayTeamStats.setKickoffReturnsAvg(entity.getAwayKickoffReturnsAvg());
		awayTeamStats.setKickoffReturnsDefAvg(entity.getAwayKickoffReturnsDefAvg());
		awayTeamStats.setKickoffReturnTDsAvg(entity.getAwayKickoffReturnTDsAvg());
		awayTeamStats.setKickoffReturnTDsDefAvg(entity.getAwayKickoffReturnTDsDefAvg());
		awayTeamStats.setKickoffReturnYardsAvg(entity.getAwayKickoffReturnYardsAvg());
		awayTeamStats.setKickoffReturnYardsDefAvg(entity.getAwayKickoffReturnYardsDefAvg());
		awayTeamStats.setKickoffsAvg(entity.getAwayKickoffsAvg());
		awayTeamStats.setKickoffTouchbackAvg(entity.getAwayKickoffTouchbackAvg());
		awayTeamStats.setKickoffTouchbackPct(entity.getAwayKickoffTouchbackPct());
		awayTeamStats.setKickoffYardsAvg(entity.getAwayKickoffYardsAvg());
		
		awayTeamStats.setOffRedZoneAttAvg(entity.getAwayOffRedZoneAttAvg());
		awayTeamStats.setOffRedZoneFGPct(entity.getAwayOffRedZoneFGPct());
		awayTeamStats.setOffRedZoneFGsAvg(entity.getAwayOffRedZoneFGsAvg());
		awayTeamStats.setOffRedZoneScorePct(entity.getAwayOffRedZoneScorePct());
		awayTeamStats.setOffRedZoneScoresAvg(entity.getAwayOffRedZoneScoresAvg());
		awayTeamStats.setOffRedZoneTDPct(entity.getAwayOffRedZoneTDPct());
		awayTeamStats.setOffRedZoneTDsAvg(entity.getAwayOffRedZoneTDsAvg());
		
		awayTeamStats.setPassDefAttAvg(entity.getAwayPassDefAttAvg());
		awayTeamStats.setPassDefCompAvg(entity.getAwayPassDefCompAvg());
		awayTeamStats.setPassDefCompPct(entity.getAwayPassDefCompPct());
		awayTeamStats.setPassDefINTsAvg(entity.getAwayPassDefINTsAvg());
		awayTeamStats.setPassDefIntTDsAvg(entity.getAwayPassDefIntTDsAvg());
		awayTeamStats.setPassDefIntYardsAvg(entity.getAwayPassDefIntYardsAvg());
		awayTeamStats.setPassDefRatingAvg(entity.getAwayPassDefRatingAvg());
		awayTeamStats.setPassDefTDsAvg(entity.getAwayPassDefTDsAvg());
		awayTeamStats.setPassDefYardsAvg(entity.getAwayPassDefYardsAvg());
		awayTeamStats.setPassDefYPA(entity.getAwayPassDefYPA());
		awayTeamStats.setPassDefYPR(entity.getAwayPassDefYPR());
		
		awayTeamStats.setPassesBrokenUpAvg(entity.getAwayPassesBrokenUpAvg());
		
		awayTeamStats.setPassOffAttAvg(entity.getAwayPassOffAttAvg());
		awayTeamStats.setPassOffCompAvg(entity.getAwayPassOffCompAvg());
		awayTeamStats.setPassOffCompPct(entity.getAwayPassOffCompPct());
		awayTeamStats.setPassOffINTsAvg(entity.getAwayPassOffINTsAvg());
		awayTeamStats.setPassOffRatingAvg(entity.getAwayPassOffRatingAvg());
		awayTeamStats.setPassOffTDsAvg(entity.getAwayPassOffTDsAvg());
		awayTeamStats.setPassOffYardsAvg(entity.getAwayPassOffYardsAvg());
		awayTeamStats.setPassOffYPA(entity.getAwayPassOffYPA());
		awayTeamStats.setPassOffYPR(entity.getAwayPassOffYPR());
		
		awayTeamStats.setPenaltiesAvg(entity.getAwayPenaltiesAvg());
		awayTeamStats.setPenaltyYardsAvg(entity.getAwayPenaltyYardsAvg());
		
		awayTeamStats.setPuntAverage(entity.getAwayPuntAverage());
		awayTeamStats.setPuntKicksBlockedAvg(entity.getAwayPuntKicksBlockedAvg());
		awayTeamStats.setPuntReturnAverage(entity.getAwayPuntReturnAverage());
		awayTeamStats.setPuntReturnAverageDef(entity.getAwayPuntReturnAverageDef());
		awayTeamStats.setPuntReturnsAvg(entity.getAwayPuntReturnsAvg());
		awayTeamStats.setPuntReturnsDefAvg(entity.getAwayPuntReturnsDefAvg());
		awayTeamStats.setPuntReturnTDsAvg(entity.getAwayPuntReturnTDsAvg());
		awayTeamStats.setPuntReturnTDsDefAvg(entity.getAwayPuntReturnTDsDefAvg());
		awayTeamStats.setPuntReturnYardsAvg(entity.getAwayPuntReturnYardsAvg());
		awayTeamStats.setPuntReturnYardsDefAvg(entity.getAwayPuntReturnYardsDefAvg());
		awayTeamStats.setPuntsAvg(entity.getAwayPuntsAvg());
		awayTeamStats.setPuntYardsAvg(entity.getAwayPuntAverage());
		
		awayTeamStats.setQBHurriesAllowedAvg(entity.getAwayQBHurriesAllowedAvg());
		awayTeamStats.setQBHurriesAvg(entity.getAwayQBHurriesAvg());
		
		awayTeamStats.setRushDefAttAvg(entity.getAwayRushDefAttAvg());
		awayTeamStats.setRushDefTDsAvg(entity.getAwayRushDefTDsAvg());
		awayTeamStats.setRushDefYardsAvg(entity.getAwayRushDefYardsAvg());
		awayTeamStats.setRushDefYPA(entity.getAwayRushDefYPA());
		
		awayTeamStats.setRushOffAttAvg(entity.getAwayRushOffAttAvg());
		awayTeamStats.setRushOffTDsAvg(entity.getAwayRushOffTDsAvg());
		awayTeamStats.setRushOffYardsAvg(entity.getAwayRushOffYardsAvg());
		awayTeamStats.setRushOffYPA(entity.getAwayRushOffYPA());
		
		awayTeamStats.setSacksAllowedAvg(entity.getAwaySacksAllowedAvg());
		awayTeamStats.setSacksAvg(entity.getAwaySacksAvg());
		awayTeamStats.setSackYardsAllowedAvg(entity.getAwaySackYardsAllowedAvg());
		awayTeamStats.setSackYardsAvg(entity.getAwaySackYardsAvg());
		
		awayTeamStats.setScoringDef2PtConvAvg(entity.getAwayScoringDef2PtConvAvg());
		awayTeamStats.setScoringDefPointsAvg(entity.getAwayScoringDefPointsAvg());
		awayTeamStats.setScoringDefSafetiesAvg(entity.getAwayScoringDefSafetiesAvg());
		awayTeamStats.setScoringDefTDsAvg(entity.getAwayScoringDefTDsAvg());
		
		awayTeamStats.setScoringOff2PtConvAvg(entity.getAwayScoringOff2PtConvAvg());
		awayTeamStats.setScoringOffPointsAvg(entity.getAwayScoringOffPointsAvg());
		awayTeamStats.setScoringOffSafetiesAvg(entity.getAwayScoringOffSafetiesAvg());
		awayTeamStats.setScoringOffTDsAvg(entity.getAwayScoringOffTDsAvg());
		
		awayTeamStats.setTFLsAvg(entity.getAwayTFLsAvg());
		awayTeamStats.setTFLYardsAvg(entity.getAwayTFLYardsAvg());
		
		awayTeamStats.setThirdDownDefAttAvg(entity.getAwayThirdDownDefAttAvg());
		awayTeamStats.setThirdDownDefConvAvg(entity.getAwayThirdDownDefConvAvg());
		awayTeamStats.setThirdDownDefConvPct(entity.getAwayThirdDownDefConvPct());
		
		awayTeamStats.setThirdDownOffAttAvg(entity.getAwayThirdDownOffAttAvg());
		awayTeamStats.setThirdDownOffConvAvg(entity.getAwayThirdDownOffConvAvg());
		awayTeamStats.setThirdDownOffConvPct(entity.getAwayThirdDownOffConvPct());
		
		awayTeamStats.setTotalDefPlaysAvg(entity.getAwayTotalDefPlaysAvg());
		awayTeamStats.setTotalDefYardsAvg(entity.getAwayTotalDefYardsAvg());
		awayTeamStats.setTotalDefYPP(entity.getAwayTotalDefYPP());
		
		awayTeamStats.setTotalOffPlaysAvg(entity.getAwayTotalOffPlaysAvg());
		awayTeamStats.setTotalOffYardsAvg(entity.getAwayTotalOffYardsAvg());
		awayTeamStats.setTotalOffYPP(entity.getAwayTotalOffYPP());
		
		awayTeamStats.setTotalTacklesAvg(entity.getAwayTotalTacklesAvg());
		
		awayTeamStats.setTurnoverMarginAvg(entity.getAwayTurnoverMarginAvg());
		
		awayTeamStats.setWinATSPct(entity.getAwayWinATSPct());
		awayTeamStats.setWinPct(entity.getAwayWinPct());
		
		TeamSimpleAggregatedStats homeLast5Games = new TeamSimpleAggregatedStats();
		homeLast5Games.setPassDefYardsAvg(entity.getHomeLast5PassDefYardsAvg());
		homeLast5Games.setPassOffYardsAvg(entity.getHomeLast5PassOffYardsAvg());
		homeLast5Games.setRushDefYardsAvg(entity.getHomeLast5RushDefYardsAvg());
		homeLast5Games.setRushOffYardsAvg(entity.getHomeLast5RushOffYardsAvg());
		homeLast5Games.setScoringDefPointsAvg(entity.getHomeLast5ScoringDefPointsAvg());
		homeLast5Games.setScoringOffPointsAvg(entity.getHomeLast5ScoringOffPointsAvg());
		homeLast5Games.setWinATSPct(entity.getHomeLast5WinATSPct());
		homeLast5Games.setWinPct(entity.getHomeLast5WinPct());
		
		TeamSimpleAggregatedStats awayLast5Games = new TeamSimpleAggregatedStats();
		awayLast5Games.setPassDefYardsAvg(entity.getAwayLast5PassDefYardsAvg());
		awayLast5Games.setPassOffYardsAvg(entity.getAwayLast5PassOffYardsAvg());
		awayLast5Games.setRushDefYardsAvg(entity.getAwayLast5RushDefYardsAvg());
		awayLast5Games.setRushOffYardsAvg(entity.getAwayLast5RushOffYardsAvg());
		awayLast5Games.setScoringDefPointsAvg(entity.getAwayLast5ScoringDefPointsAvg());
		awayLast5Games.setScoringOffPointsAvg(entity.getAwayLast5ScoringOffPointsAvg());
		awayLast5Games.setWinATSPct(entity.getAwayLast5WinATSPct());
		awayLast5Games.setWinPct(entity.getAwayLast5WinPct());
		
		TeamSimpleAggregatedStats homeLastSeasonGames = new TeamSimpleAggregatedStats();
		homeLastSeasonGames.setPassDefYardsAvg(entity.getHomeLastSeasonPassDefYardsAvg());
		homeLastSeasonGames.setPassOffYardsAvg(entity.getHomeLastSeasonPassOffYardsAvg());
		homeLastSeasonGames.setRushDefYardsAvg(entity.getHomeLastSeasonRushDefYardsAvg());
		homeLastSeasonGames.setRushOffYardsAvg(entity.getHomeLastSeasonRushOffYardsAvg());
		homeLastSeasonGames.setScoringDefPointsAvg(entity.getHomeLastSeasonScoringDefPointsAvg());
		homeLastSeasonGames.setScoringOffPointsAvg(entity.getHomeLastSeasonScoringOffPointsAvg());
		homeLastSeasonGames.setWinATSPct(entity.getHomeLastSeasonWinATSPct());
		homeLastSeasonGames.setWinPct(entity.getHomeLastSeasonWinPct());
		
		TeamSimpleAggregatedStats awayLastSeasonGames = new TeamSimpleAggregatedStats();
		awayLastSeasonGames.setPassDefYardsAvg(entity.getAwayLastSeasonPassDefYardsAvg());
		awayLastSeasonGames.setPassOffYardsAvg(entity.getAwayLastSeasonPassOffYardsAvg());
		awayLastSeasonGames.setRushDefYardsAvg(entity.getAwayLastSeasonRushDefYardsAvg());
		awayLastSeasonGames.setRushOffYardsAvg(entity.getAwayLastSeasonRushOffYardsAvg());
		awayLastSeasonGames.setScoringDefPointsAvg(entity.getAwayLastSeasonScoringDefPointsAvg());
		awayLastSeasonGames.setScoringOffPointsAvg(entity.getAwayLastSeasonScoringOffPointsAvg());
		awayLastSeasonGames.setWinATSPct(entity.getAwayLastSeasonWinATSPct());
		awayLastSeasonGames.setWinPct(entity.getAwayLastSeasonWinPct());
		
		dto.setHomeTeamStats(homeTeamStats);
		dto.setAwayTeamStats(awayTeamStats);
		dto.setHomeTeamLastFive(homeLast5Games);
		dto.setAwayTeamLastFive(awayLast5Games);
		dto.setHomeTeamLastSeason(homeLastSeasonGames);
		dto.setAwayTeamLastSeason(awayLastSeasonGames);
	}

	@Override
	protected void doConvertToEntity(AggregatedGameStatsDto dto, AggregatedGameStats entity) {
		GameInfo game = gameInfoAssembler.convertToEntity(dto.getGame());
		entity.setGame(game);
		
		TeamAggregatedGameStatsDto homeTeamStats = dto.getHomeTeamStats();
		entity.setHomeDefRedZoneAttAvg(homeTeamStats.getDefRedZoneAttAvg());
		entity.setHomeDefRedZoneFGPct(homeTeamStats.getDefRedZoneFGPct());
		entity.setHomeDefRedZoneFGsAvg(homeTeamStats.getDefRedZoneFGsAvg());
		entity.setHomeDefRedZoneScorePct(homeTeamStats.getDefRedZoneScorePct());
		entity.setHomeDefRedZoneScoresAvg(homeTeamStats.getDefRedZoneScoresAvg());
		entity.setHomeDefRedZoneTDPct(homeTeamStats.getDefRedZoneTDPct());
		entity.setHomeDefRedZoneTDsAvg(homeTeamStats.getDefRedZoneTDsAvg());
		
		entity.setHomeFGDefAttAvg(homeTeamStats.getFgDefAttAvg());
		entity.setHomeFGDefMadeAvg(homeTeamStats.getFgDefMadeAvg());
		entity.setHomeFGDefPct(homeTeamStats.getFGDefPct());
		entity.setHomeFGOffAttAvg(homeTeamStats.getFgOffAttAvg());
		entity.setHomeFGOffMadeAvg(homeTeamStats.getFgOffMadeAvg());
		entity.setHomeFGOffPct(homeTeamStats.getFGOffPct());
		
		entity.setHomeFirstDownDefPassAvg(homeTeamStats.getFirstDownDefPassAvg());
		entity.setHomeFirstDownDefPenaltyAvg(homeTeamStats.getFirstDownDefPenaltyAvg());
		entity.setHomeFirstDownDefRushAvg(homeTeamStats.getFirstDownDefRushAvg());
		entity.setHomeFirstDownDefTotalAvg(homeTeamStats.getFirstDownDefTotalAvg());
		entity.setHomeFirstDownOffPassAvg(homeTeamStats.getFirstDownOffPassAvg());
		entity.setHomeFirstDownOffPenaltyAvg(homeTeamStats.getFirstDownOffPenaltyAvg());
		entity.setHomeFirstDownOffRushAvg(homeTeamStats.getFirstDownOffRushAvg());
		entity.setHomeFirstDownOffTotalAvg(homeTeamStats.getFirstDownOffTotalAvg());
		
		entity.setHomeFourthDownDefAttAvg(homeTeamStats.getFourthDownDefAttAvg());
		entity.setHomeFourthDownDefConvAvg(homeTeamStats.getFourthDownDefConvAvg());
		entity.setHomeFourthDownDefConvPct(homeTeamStats.getFourthDownDefConvPct());
		entity.setHomeFourthDownOffAttAvg(homeTeamStats.getFourthDownOffAttAvg());
		entity.setHomeFourthDownOffConvAvg(homeTeamStats.getFourthDownOffConvAvg());
		entity.setHomeFourthDownOffConvPct(homeTeamStats.getFourthDownOffConvPct());
		
		entity.setHomeFubmleLostAvg(homeTeamStats.getFubmleLostAvg());
		entity.setHomeFumbleGainAvg(homeTeamStats.getFumbleGainAvg());
		entity.setHomeFumbleReturnsAvg(homeTeamStats.getFumbleReturnsAvg());
		entity.setHomeFumbleReturnTDsAvg(homeTeamStats.getFumbleReturnTDsAvg());
		entity.setHomeFumbleReturnYardsAvg(homeTeamStats.getFumbleReturnYardsAvg());
		entity.setHomeFumblesForcedAvg(homeTeamStats.getFumblesForcedAvg());
		
		entity.setHomeGamesPlayed(homeTeamStats.getGamesPlayed());
		
		entity.setHomeKickoffAverage(homeTeamStats.getKickoffAverage());
		entity.setHomeKickoffOnSideAvg(homeTeamStats.getKickoffOnSideAvg());
		entity.setHomeKickoffOutOfBoundsAvg(homeTeamStats.getKickoffOutOfBoundsAvg());
		entity.setHomeKickoffReturnAverage(homeTeamStats.getKickoffReturnAverage());
		entity.setHomeKickoffReturnAverageDef(homeTeamStats.getKickoffReturnAverageDef());
		entity.setHomeKickoffReturnsAvg(homeTeamStats.getKickoffReturnsAvg());
		entity.setHomeKickoffReturnsDefAvg(homeTeamStats.getKickoffReturnsDefAvg());
		entity.setHomeKickoffReturnTDsAvg(homeTeamStats.getKickoffReturnTDsAvg());
		entity.setHomeKickoffReturnTDsDefAvg(homeTeamStats.getKickoffReturnTDsDefAvg());
		entity.setHomeKickoffReturnYardsAvg(homeTeamStats.getKickoffReturnYardsAvg());
		entity.setHomeKickoffReturnYardsDefAvg(homeTeamStats.getKickoffReturnYardsDefAvg());
		entity.setHomeKickoffsAvg(homeTeamStats.getKickoffsAvg());
		entity.setHomeKickoffTouchbackAvg(homeTeamStats.getKickoffTouchbackAvg());
		entity.setHomeKickoffTouchbackPct(homeTeamStats.getKickoffTouchbackPct());
		entity.setHomeKickoffYardsAvg(homeTeamStats.getKickoffYardsAvg());
		
		entity.setHomeOffRedZoneAttAvg(homeTeamStats.getOffRedZoneAttAvg());
		entity.setHomeOffRedZoneFGPct(homeTeamStats.getOffRedZoneFGPct());
		entity.setHomeOffRedZoneFGsAvg(homeTeamStats.getOffRedZoneFGsAvg());
		entity.setHomeOffRedZoneScorePct(homeTeamStats.getOffRedZoneScorePct());
		entity.setHomeOffRedZoneScoresAvg(homeTeamStats.getOffRedZoneScoresAvg());
		entity.setHomeOffRedZoneTDPct(homeTeamStats.getOffRedZoneTDPct());
		entity.setHomeOffRedZoneTDsAvg(homeTeamStats.getOffRedZoneTDsAvg());
		
		entity.setHomePassDefAttAvg(homeTeamStats.getPassDefAttAvg());
		entity.setHomePassDefCompAvg(homeTeamStats.getPassDefCompAvg());
		entity.setHomePassDefCompPct(homeTeamStats.getPassDefCompPct());
		entity.setHomePassDefINTsAvg(homeTeamStats.getPassDefINTsAvg());
		entity.setHomePassDefIntTDsAvg(homeTeamStats.getPassDefIntTDsAvg());
		entity.setHomePassDefIntYardsAvg(homeTeamStats.getPassDefIntYardsAvg());
		entity.setHomePassDefRatingAvg(homeTeamStats.getPassDefRatingAvg());
		entity.setHomePassDefTDsAvg(homeTeamStats.getPassDefTDsAvg());
		entity.setHomePassDefYardsAvg(homeTeamStats.getPassDefYardsAvg());
		entity.setHomePassDefYPA(homeTeamStats.getPassDefYPA());
		entity.setHomePassDefYPR(homeTeamStats.getPassDefYPR());
		
		entity.setHomePassesBrokenUpAvg(homeTeamStats.getPassesBrokenUpAvg());
		
		entity.setHomePassOffAttAvg(homeTeamStats.getPassOffAttAvg());
		entity.setHomePassOffCompAvg(homeTeamStats.getPassOffCompAvg());
		entity.setHomePassOffCompPct(homeTeamStats.getPassOffCompPct());
		entity.setHomePassOffINTsAvg(homeTeamStats.getPassOffINTsAvg());
		entity.setHomePassOffRatingAvg(homeTeamStats.getPassOffRatingAvg());
		entity.setHomePassOffTDsAvg(homeTeamStats.getPassOffTDsAvg());
		entity.setHomePassOffYardsAvg(homeTeamStats.getPassOffYardsAvg());
		entity.setHomePassOffYPA(homeTeamStats.getPassOffYPA());
		entity.setHomePassOffYPR(homeTeamStats.getPassOffYPR());
		
		entity.setHomePenaltiesAvg(homeTeamStats.getPenaltiesAvg());
		entity.setHomePenaltyYardsAvg(homeTeamStats.getPenaltyYardsAvg());
		
		entity.setHomePuntAverage(homeTeamStats.getPuntAverage());
		entity.setHomePuntKicksBlockedAvg(homeTeamStats.getPuntKicksBlockedAvg());
		entity.setHomePuntReturnAverage(homeTeamStats.getPuntReturnAverage());
		entity.setHomePuntReturnAverageDef(homeTeamStats.getPuntReturnAverageDef());
		entity.setHomePuntReturnsAvg(homeTeamStats.getPuntReturnsAvg());
		entity.setHomePuntReturnsDefAvg(homeTeamStats.getPuntReturnsDefAvg());
		entity.setHomePuntReturnTDsAvg(homeTeamStats.getPuntReturnTDsAvg());
		entity.setHomePuntReturnTDsDefAvg(homeTeamStats.getPuntReturnTDsDefAvg());
		entity.setHomePuntReturnYardsAvg(homeTeamStats.getPuntReturnYardsAvg());
		entity.setHomePuntReturnYardsDefAvg(homeTeamStats.getPuntReturnYardsDefAvg());
		entity.setHomePuntsAvg(homeTeamStats.getPuntsAvg());
		entity.setHomePuntYardsAvg(homeTeamStats.getPuntAverage());
		
		entity.setHomeQBHurriesAllowedAvg(homeTeamStats.getQBHurriesAllowedAvg());
		entity.setHomeQBHurriesAvg(homeTeamStats.getQBHurriesAvg());
		
		entity.setHomeRushDefAttAvg(homeTeamStats.getRushDefAttAvg());
		entity.setHomeRushDefTDsAvg(homeTeamStats.getRushDefTDsAvg());
		entity.setHomeRushDefYardsAvg(homeTeamStats.getRushDefYardsAvg());
		entity.setHomeRushDefYPA(homeTeamStats.getRushDefYPA());
		
		entity.setHomeRushOffAttAvg(homeTeamStats.getRushOffAttAvg());
		entity.setHomeRushOffTDsAvg(homeTeamStats.getRushOffTDsAvg());
		entity.setHomeRushOffYardsAvg(homeTeamStats.getRushOffYardsAvg());
		entity.setHomeRushOffYPA(homeTeamStats.getRushOffYPA());
		
		entity.setHomeSacksAllowedAvg(homeTeamStats.getSacksAllowedAvg());
		entity.setHomeSacksAvg(homeTeamStats.getSacksAvg());
		entity.setHomeSackYardsAllowedAvg(homeTeamStats.getSackYardsAllowedAvg());
		entity.setHomeSackYardsAvg(homeTeamStats.getSackYardsAvg());
		
		entity.setHomeScoringDef2PtConvAvg(homeTeamStats.getScoringDef2PtConvAvg());
		entity.setHomeScoringDefPointsAvg(homeTeamStats.getScoringDefPointsAvg());
		entity.setHomeScoringDefSafetiesAvg(homeTeamStats.getScoringDefSafetiesAvg());
		entity.setHomeScoringDefTDsAvg(homeTeamStats.getScoringDefTDsAvg());
		
		entity.setHomeScoringOff2PtConvAvg(homeTeamStats.getScoringOff2PtConvAvg());
		entity.setHomeScoringOffPointsAvg(homeTeamStats.getScoringOffPointsAvg());
		entity.setHomeScoringOffSafetiesAvg(homeTeamStats.getScoringOffSafetiesAvg());
		entity.setHomeScoringOffTDsAvg(homeTeamStats.getScoringOffTDsAvg());
		
		entity.setHomeTFLsAvg(homeTeamStats.getTFLsAvg());
		entity.setHomeTFLYardsAvg(homeTeamStats.getTFLYardsAvg());
		
		entity.setHomeThirdDownDefAttAvg(homeTeamStats.getThirdDownDefAttAvg());
		entity.setHomeThirdDownDefConvAvg(homeTeamStats.getThirdDownDefConvAvg());
		entity.setHomeThirdDownDefConvPct(homeTeamStats.getThirdDownDefConvPct());
		
		entity.setHomeThirdDownOffAttAvg(homeTeamStats.getThirdDownOffAttAvg());
		entity.setHomeThirdDownOffConvAvg(homeTeamStats.getThirdDownOffConvAvg());
		entity.setHomeThirdDownOffConvPct(homeTeamStats.getThirdDownOffConvPct());
		
		entity.setHomeTotalDefPlaysAvg(homeTeamStats.getTotalDefPlaysAvg());
		entity.setHomeTotalDefYardsAvg(homeTeamStats.getTotalDefYardsAvg());
		entity.setHomeTotalDefYPP(homeTeamStats.getTotalDefYPP());
		
		entity.setHomeTotalOffPlaysAvg(homeTeamStats.getTotalOffPlaysAvg());
		entity.setHomeTotalOffYardsAvg(homeTeamStats.getTotalOffYardsAvg());
		entity.setHomeTotalOffYPP(homeTeamStats.getTotalOffYPP());
		
		entity.setHomeTotalTacklesAvg(homeTeamStats.getTotalTacklesAvg());
		
		entity.setHomeTurnoverMarginAvg(homeTeamStats.getTurnoverMarginAvg());
		
		entity.setHomeWinATSPct(homeTeamStats.getWinATSPct());
		entity.setHomeWinPct(homeTeamStats.getWinPct());
		
		TeamAggregatedGameStatsDto awayTeamStats = dto.getAwayTeamStats();
		entity.setAwayDefRedZoneAttAvg(awayTeamStats.getDefRedZoneAttAvg());
		entity.setAwayDefRedZoneFGPct(awayTeamStats.getDefRedZoneFGPct());
		entity.setAwayDefRedZoneFGsAvg(awayTeamStats.getDefRedZoneFGsAvg());
		entity.setAwayDefRedZoneScorePct(awayTeamStats.getDefRedZoneScorePct());
		entity.setAwayDefRedZoneScoresAvg(awayTeamStats.getDefRedZoneScoresAvg());
		entity.setAwayDefRedZoneTDPct(awayTeamStats.getDefRedZoneTDPct());
		entity.setAwayDefRedZoneTDsAvg(awayTeamStats.getDefRedZoneTDsAvg());
		
		entity.setAwayFGDefAttAvg(awayTeamStats.getFgDefAttAvg());
		entity.setAwayFGDefMadeAvg(awayTeamStats.getFgDefMadeAvg());
		entity.setAwayFGDefPct(awayTeamStats.getFGDefPct());
		entity.setAwayFGOffAttAvg(awayTeamStats.getFgOffAttAvg());
		entity.setAwayFGOffMadeAvg(awayTeamStats.getFgOffMadeAvg());
		entity.setAwayFGOffPct(awayTeamStats.getFGOffPct());
		
		entity.setAwayFirstDownDefPassAvg(awayTeamStats.getFirstDownDefPassAvg());
		entity.setAwayFirstDownDefPenaltyAvg(awayTeamStats.getFirstDownDefPenaltyAvg());
		entity.setAwayFirstDownDefRushAvg(awayTeamStats.getFirstDownDefRushAvg());
		entity.setAwayFirstDownDefTotalAvg(awayTeamStats.getFirstDownDefTotalAvg());
		entity.setAwayFirstDownOffPassAvg(awayTeamStats.getFirstDownOffPassAvg());
		entity.setAwayFirstDownOffPenaltyAvg(awayTeamStats.getFirstDownOffPenaltyAvg());
		entity.setAwayFirstDownOffRushAvg(awayTeamStats.getFirstDownOffRushAvg());
		entity.setAwayFirstDownOffTotalAvg(awayTeamStats.getFirstDownOffTotalAvg());
		
		entity.setAwayFourthDownDefAttAvg(awayTeamStats.getFourthDownDefAttAvg());
		entity.setAwayFourthDownDefConvAvg(awayTeamStats.getFourthDownDefConvAvg());
		entity.setAwayFourthDownDefConvPct(awayTeamStats.getFourthDownDefConvPct());
		entity.setAwayFourthDownOffAttAvg(awayTeamStats.getFourthDownOffAttAvg());
		entity.setAwayFourthDownOffConvAvg(awayTeamStats.getFourthDownOffConvAvg());
		entity.setAwayFourthDownOffConvPct(awayTeamStats.getFourthDownOffConvPct());
		
		entity.setAwayFubmleLostAvg(awayTeamStats.getFubmleLostAvg());
		entity.setAwayFumbleGainAvg(awayTeamStats.getFumbleGainAvg());
		entity.setAwayFumbleReturnsAvg(awayTeamStats.getFumbleReturnsAvg());
		entity.setAwayFumbleReturnTDsAvg(awayTeamStats.getFumbleReturnTDsAvg());
		entity.setAwayFumbleReturnYardsAvg(awayTeamStats.getFumbleReturnYardsAvg());
		entity.setAwayFumblesForcedAvg(awayTeamStats.getFumblesForcedAvg());
		
		entity.setAwayGamesPlayed(awayTeamStats.getGamesPlayed());
		
		entity.setAwayKickoffAverage(awayTeamStats.getKickoffAverage());
		entity.setAwayKickoffOnSideAvg(awayTeamStats.getKickoffOnSideAvg());
		entity.setAwayKickoffOutOfBoundsAvg(awayTeamStats.getKickoffOutOfBoundsAvg());
		entity.setAwayKickoffReturnAverage(awayTeamStats.getKickoffReturnAverage());
		entity.setAwayKickoffReturnAverageDef(awayTeamStats.getKickoffReturnAverageDef());
		entity.setAwayKickoffReturnsAvg(awayTeamStats.getKickoffReturnsAvg());
		entity.setAwayKickoffReturnsDefAvg(awayTeamStats.getKickoffReturnsDefAvg());
		entity.setAwayKickoffReturnTDsAvg(awayTeamStats.getKickoffReturnTDsAvg());
		entity.setAwayKickoffReturnTDsDefAvg(awayTeamStats.getKickoffReturnTDsDefAvg());
		entity.setAwayKickoffReturnYardsAvg(awayTeamStats.getKickoffReturnYardsAvg());
		entity.setAwayKickoffReturnYardsDefAvg(awayTeamStats.getKickoffReturnYardsDefAvg());
		entity.setAwayKickoffsAvg(awayTeamStats.getKickoffsAvg());
		entity.setAwayKickoffTouchbackAvg(awayTeamStats.getKickoffTouchbackAvg());
		entity.setAwayKickoffTouchbackPct(awayTeamStats.getKickoffTouchbackPct());
		entity.setAwayKickoffYardsAvg(awayTeamStats.getKickoffYardsAvg());
		
		entity.setAwayOffRedZoneAttAvg(awayTeamStats.getOffRedZoneAttAvg());
		entity.setAwayOffRedZoneFGPct(awayTeamStats.getOffRedZoneFGPct());
		entity.setAwayOffRedZoneFGsAvg(awayTeamStats.getOffRedZoneFGsAvg());
		entity.setAwayOffRedZoneScorePct(awayTeamStats.getOffRedZoneScorePct());
		entity.setAwayOffRedZoneScoresAvg(awayTeamStats.getOffRedZoneScoresAvg());
		entity.setAwayOffRedZoneTDPct(awayTeamStats.getOffRedZoneTDPct());
		entity.setAwayOffRedZoneTDsAvg(awayTeamStats.getOffRedZoneTDsAvg());
		
		entity.setAwayPassDefAttAvg(awayTeamStats.getPassDefAttAvg());
		entity.setAwayPassDefCompAvg(awayTeamStats.getPassDefCompAvg());
		entity.setAwayPassDefCompPct(awayTeamStats.getPassDefCompPct());
		entity.setAwayPassDefINTsAvg(awayTeamStats.getPassDefINTsAvg());
		entity.setAwayPassDefIntTDsAvg(awayTeamStats.getPassDefIntTDsAvg());
		entity.setAwayPassDefIntYardsAvg(awayTeamStats.getPassDefIntYardsAvg());
		entity.setAwayPassDefRatingAvg(awayTeamStats.getPassDefRatingAvg());
		entity.setAwayPassDefTDsAvg(awayTeamStats.getPassDefTDsAvg());
		entity.setAwayPassDefYardsAvg(awayTeamStats.getPassDefYardsAvg());
		entity.setAwayPassDefYPA(awayTeamStats.getPassDefYPA());
		entity.setAwayPassDefYPR(awayTeamStats.getPassDefYPR());
		
		entity.setAwayPassesBrokenUpAvg(awayTeamStats.getPassesBrokenUpAvg());
		
		entity.setAwayPassOffAttAvg(awayTeamStats.getPassOffAttAvg());
		entity.setAwayPassOffCompAvg(awayTeamStats.getPassOffCompAvg());
		entity.setAwayPassOffCompPct(awayTeamStats.getPassOffCompPct());
		entity.setAwayPassOffINTsAvg(awayTeamStats.getPassOffINTsAvg());
		entity.setAwayPassOffRatingAvg(awayTeamStats.getPassOffRatingAvg());
		entity.setAwayPassOffTDsAvg(awayTeamStats.getPassOffTDsAvg());
		entity.setAwayPassOffYardsAvg(awayTeamStats.getPassOffYardsAvg());
		entity.setAwayPassOffYPA(awayTeamStats.getPassOffYPA());
		entity.setAwayPassOffYPR(awayTeamStats.getPassOffYPR());
		
		entity.setAwayPenaltiesAvg(awayTeamStats.getPenaltiesAvg());
		entity.setAwayPenaltyYardsAvg(awayTeamStats.getPenaltyYardsAvg());
		
		entity.setAwayPuntAverage(awayTeamStats.getPuntAverage());
		entity.setAwayPuntKicksBlockedAvg(awayTeamStats.getPuntKicksBlockedAvg());
		entity.setAwayPuntReturnAverage(awayTeamStats.getPuntReturnAverage());
		entity.setAwayPuntReturnAverageDef(awayTeamStats.getPuntReturnAverageDef());
		entity.setAwayPuntReturnsAvg(awayTeamStats.getPuntReturnsAvg());
		entity.setAwayPuntReturnsDefAvg(awayTeamStats.getPuntReturnsDefAvg());
		entity.setAwayPuntReturnTDsAvg(awayTeamStats.getPuntReturnTDsAvg());
		entity.setAwayPuntReturnTDsDefAvg(awayTeamStats.getPuntReturnTDsDefAvg());
		entity.setAwayPuntReturnYardsAvg(awayTeamStats.getPuntReturnYardsAvg());
		entity.setAwayPuntReturnYardsDefAvg(awayTeamStats.getPuntReturnYardsDefAvg());
		entity.setAwayPuntsAvg(awayTeamStats.getPuntsAvg());
		entity.setAwayPuntYardsAvg(awayTeamStats.getPuntAverage());
		
		entity.setAwayQBHurriesAllowedAvg(awayTeamStats.getQBHurriesAllowedAvg());
		entity.setAwayQBHurriesAvg(awayTeamStats.getQBHurriesAvg());
		
		entity.setAwayRushDefAttAvg(awayTeamStats.getRushDefAttAvg());
		entity.setAwayRushDefTDsAvg(awayTeamStats.getRushDefTDsAvg());
		entity.setAwayRushDefYardsAvg(awayTeamStats.getRushDefYardsAvg());
		entity.setAwayRushDefYPA(awayTeamStats.getRushDefYPA());
		
		entity.setAwayRushOffAttAvg(awayTeamStats.getRushOffAttAvg());
		entity.setAwayRushOffTDsAvg(awayTeamStats.getRushOffTDsAvg());
		entity.setAwayRushOffYardsAvg(awayTeamStats.getRushOffYardsAvg());
		entity.setAwayRushOffYPA(awayTeamStats.getRushOffYPA());
		
		entity.setAwaySacksAllowedAvg(awayTeamStats.getSacksAllowedAvg());
		entity.setAwaySacksAvg(awayTeamStats.getSacksAvg());
		entity.setAwaySackYardsAllowedAvg(awayTeamStats.getSackYardsAllowedAvg());
		entity.setAwaySackYardsAvg(awayTeamStats.getSackYardsAvg());
		
		entity.setAwayScoringDef2PtConvAvg(awayTeamStats.getScoringDef2PtConvAvg());
		entity.setAwayScoringDefPointsAvg(awayTeamStats.getScoringDefPointsAvg());
		entity.setAwayScoringDefSafetiesAvg(awayTeamStats.getScoringDefSafetiesAvg());
		entity.setAwayScoringDefTDsAvg(awayTeamStats.getScoringDefTDsAvg());
		
		entity.setAwayScoringOff2PtConvAvg(awayTeamStats.getScoringOff2PtConvAvg());
		entity.setAwayScoringOffPointsAvg(awayTeamStats.getScoringOffPointsAvg());
		entity.setAwayScoringOffSafetiesAvg(awayTeamStats.getScoringOffSafetiesAvg());
		entity.setAwayScoringOffTDsAvg(awayTeamStats.getScoringOffTDsAvg());
		
		entity.setAwayTFLsAvg(awayTeamStats.getTFLsAvg());
		entity.setAwayTFLYardsAvg(awayTeamStats.getTFLYardsAvg());
		
		entity.setAwayThirdDownDefAttAvg(awayTeamStats.getThirdDownDefAttAvg());
		entity.setAwayThirdDownDefConvAvg(awayTeamStats.getThirdDownDefConvAvg());
		entity.setAwayThirdDownDefConvPct(awayTeamStats.getThirdDownDefConvPct());
		
		entity.setAwayThirdDownOffAttAvg(awayTeamStats.getThirdDownOffAttAvg());
		entity.setAwayThirdDownOffConvAvg(awayTeamStats.getThirdDownOffConvAvg());
		entity.setAwayThirdDownOffConvPct(awayTeamStats.getThirdDownOffConvPct());
		
		entity.setAwayTotalDefPlaysAvg(awayTeamStats.getTotalDefPlaysAvg());
		entity.setAwayTotalDefYardsAvg(awayTeamStats.getTotalDefYardsAvg());
		entity.setAwayTotalDefYPP(awayTeamStats.getTotalDefYPP());
		
		entity.setAwayTotalOffPlaysAvg(awayTeamStats.getTotalOffPlaysAvg());
		entity.setAwayTotalOffYardsAvg(awayTeamStats.getTotalOffYardsAvg());
		entity.setAwayTotalOffYPP(awayTeamStats.getTotalOffYPP());
		
		entity.setAwayTotalTacklesAvg(awayTeamStats.getTotalTacklesAvg());
		
		entity.setAwayTurnoverMarginAvg(awayTeamStats.getTurnoverMarginAvg());
		
		entity.setAwayWinATSPct(awayTeamStats.getWinATSPct());
		entity.setAwayWinPct(awayTeamStats.getWinPct());
		
		TeamSimpleAggregatedStats homeLast5Games = dto.getHomeTeamLastFive();
		entity.setHomeLast5PassDefYardsAvg(homeLast5Games.getPassDefYardsAvg());
		entity.setHomeLast5PassOffYardsAvg(homeLast5Games.getPassOffYardsAvg());
		entity.setHomeLast5RushDefYardsAvg(homeLast5Games.getRushDefYardsAvg());
		entity.setHomeLast5RushOffYardsAvg(homeLast5Games.getRushOffYardsAvg());
		entity.setHomeLast5ScoringDefPointsAvg(homeLast5Games.getScoringDefPointsAvg());
		entity.setHomeLast5ScoringOffPointsAvg(homeLast5Games.getScoringOffPointsAvg());
		entity.setHomeLast5WinATSPct(homeLast5Games.getWinATSPct());
		entity.setHomeLast5WinPct(homeLast5Games.getWinPct());
		
		TeamSimpleAggregatedStats awayLast5Games = dto.getAwayTeamLastFive();
		entity.setAwayLast5PassDefYardsAvg(awayLast5Games.getPassDefYardsAvg());
		entity.setAwayLast5PassOffYardsAvg(awayLast5Games.getPassOffYardsAvg());
		entity.setAwayLast5RushDefYardsAvg(awayLast5Games.getRushDefYardsAvg());
		entity.setAwayLast5RushOffYardsAvg(awayLast5Games.getRushOffYardsAvg());
		entity.setAwayLast5ScoringDefPointsAvg(awayLast5Games.getScoringDefPointsAvg());
		entity.setAwayLast5ScoringOffPointsAvg(awayLast5Games.getScoringOffPointsAvg());
		entity.setAwayLast5WinATSPct(awayLast5Games.getWinATSPct());
		entity.setAwayLast5WinPct(awayLast5Games.getWinPct());
		
		TeamSimpleAggregatedStats homeLastSeasonGames = dto.getHomeTeamLastSeason();
		entity.setHomeLastSeasonPassDefYardsAvg(homeLastSeasonGames.getPassDefYardsAvg());
		entity.setHomeLastSeasonPassOffYardsAvg(homeLastSeasonGames.getPassOffYardsAvg());
		entity.setHomeLastSeasonRushDefYardsAvg(homeLastSeasonGames.getRushDefYardsAvg());
		entity.setHomeLastSeasonRushOffYardsAvg(homeLastSeasonGames.getRushOffYardsAvg());
		entity.setHomeLastSeasonScoringDefPointsAvg(homeLastSeasonGames.getScoringDefPointsAvg());
		entity.setHomeLastSeasonScoringOffPointsAvg(homeLastSeasonGames.getScoringOffPointsAvg());
		entity.setHomeLastSeasonWinATSPct(homeLastSeasonGames.getWinATSPct());
		entity.setHomeLastSeasonWinPct(homeLastSeasonGames.getWinPct());
		
		TeamSimpleAggregatedStats awayLastSeasonGames = dto.getAwayTeamLastSeason();
		entity.setAwayLastSeasonPassDefYardsAvg(awayLastSeasonGames.getPassDefYardsAvg());
		entity.setAwayLastSeasonPassOffYardsAvg(awayLastSeasonGames.getPassOffYardsAvg());
		entity.setAwayLastSeasonRushDefYardsAvg(awayLastSeasonGames.getRushDefYardsAvg());
		entity.setAwayLastSeasonRushOffYardsAvg(awayLastSeasonGames.getRushOffYardsAvg());
		entity.setAwayLastSeasonScoringDefPointsAvg(awayLastSeasonGames.getScoringDefPointsAvg());
		entity.setAwayLastSeasonScoringOffPointsAvg(awayLastSeasonGames.getScoringOffPointsAvg());
		entity.setAwayLastSeasonWinATSPct(awayLastSeasonGames.getWinATSPct());
		entity.setAwayLastSeasonWinPct(awayLastSeasonGames.getWinPct());
	}

	public GameInfoAssembler getGameInfoAssembler() {
		return gameInfoAssembler;
	}

	public void setGameInfoAssembler(GameInfoAssembler gameInfoAssembler) {
		this.gameInfoAssembler = gameInfoAssembler;
	}

}
