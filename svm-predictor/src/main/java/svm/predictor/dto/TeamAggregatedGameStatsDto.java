package svm.predictor.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TeamAggregatedGameStatsDto {

	private BigInteger gamesPlayed;
	
	private BigDecimal winPct;
	private BigDecimal winATSPct;
	
	private BigDecimal rushOffAttAvg;
	private BigDecimal rushOffYardsAvg;
	private BigDecimal rushOffYPA;
	private BigDecimal rushOffTDsAvg;
	
	private BigDecimal rushDefAttAvg;
	private BigDecimal rushDefYardsAvg;
	private BigDecimal rushDefYPA;
	private BigDecimal rushDefTDsAvg;
	
	private BigDecimal passOffAttAvg;
	private BigDecimal passOffCompAvg;
	private BigDecimal passOffCompPct;
	private BigDecimal passOffYardsAvg;
	private BigDecimal passOffYPA;
	private BigDecimal passOffINTsAvg;
	private BigDecimal passOffTDsAvg;
	private Double passOffRatingAvg;
	private BigDecimal passOffYPR;
	
	private BigDecimal passDefAttAvg;
	private BigDecimal passDefCompAvg;
	private BigDecimal passDefCompPct;
	private BigDecimal passDefYardsAvg;
	private BigDecimal passDefYPA;
	private BigDecimal passDefINTsAvg;
	private BigDecimal passDefTDsAvg;
	private Double passDefRatingAvg;
	private BigDecimal passDefYPR;
	
	private BigDecimal puntReturnsAvg;
	private BigDecimal puntReturnYardsAvg;
	private BigDecimal puntReturnAverage;
	private BigDecimal puntReturnTDsAvg;
	
	private BigDecimal puntReturnsDefAvg;
	private BigDecimal puntReturnYardsDefAvg;
	private BigDecimal puntReturnAverageDef;
	private BigDecimal puntReturnTDsDefAvg;
	
	private BigDecimal kickoffReturnsAvg;
	private BigDecimal kickoffReturnYardsAvg;
	private BigDecimal kickoffReturnAverage;
	private BigDecimal kickoffReturnTDsAvg;
	
	private BigDecimal kickoffReturnsDefAvg;
	private BigDecimal kickoffReturnYardsDefAvg;
	private BigDecimal kickoffReturnAverageDef;
	private BigDecimal kickoffReturnTDsDefAvg;
	
	private BigDecimal puntsAvg;
	private BigDecimal puntYardsAvg;
	private BigDecimal puntAverage;
	
	private BigDecimal kickoffsAvg;
	private BigDecimal kickoffYardsAvg;
	private BigDecimal kickoffAverage;
	private BigDecimal kickoffTouchbackAvg;
	private BigDecimal kickoffTouchbackPct;
	private BigDecimal kickoffOutOfBoundsAvg;
	private BigDecimal kickoffOnSideAvg;
	
	private BigDecimal FGOffAttAvg;
	private BigDecimal FGOffMadeAvg;
	private BigDecimal FGOffPct;
	
	private BigDecimal FGDefAttAvg;
	private BigDecimal FGDefMadeAvg;
	private BigDecimal FGDefPct;

	private BigDecimal scoringOffTDsAvg;
	private BigDecimal scoringOff2PtConvAvg;
	private BigDecimal scoringOffSafetiesAvg;
	private BigDecimal scoringOffPointsAvg;
	
	private BigDecimal scoringDefTDsAvg;
	private BigDecimal scoringDef2PtConvAvg;
	private BigDecimal scoringDefSafetiesAvg;
	private BigDecimal scoringDefPointsAvg;
	
	private BigDecimal totalOffPlaysAvg;
	private BigDecimal totalOffYardsAvg;
	private BigDecimal totalOffYPP;
	
	private BigDecimal totalDefPlaysAvg;
	private BigDecimal totalDefYardsAvg;
	private BigDecimal totalDefYPP;
	
	private BigDecimal passDefIntYardsAvg;
	private BigDecimal passDefIntTDsAvg;
	
	private BigDecimal fumbleReturnsAvg;
	private BigDecimal fumbleReturnYardsAvg;
	private BigDecimal fumbleReturnTDsAvg;
	
	private BigDecimal totalTacklesAvg;
	
	private BigDecimal TFLsAvg;
	private BigDecimal TFLYardsAvg;
	
	private BigDecimal sacksAvg;
	private BigDecimal sackYardsAvg;
	
	private BigDecimal sacksAllowedAvg;
	private BigDecimal sackYardsAllowedAvg;
	
	private BigDecimal passesBrokenUpAvg;
	private BigDecimal QBHurriesAvg;
	private BigDecimal fumblesForcedAvg;
	private BigDecimal puntKicksBlockedAvg;
	
	private BigDecimal QBHurriesAllowedAvg;
	
	private BigDecimal firstDownOffRushAvg;
	private BigDecimal firstDownOffPassAvg;
	private BigDecimal firstDownOffPenaltyAvg;
	private BigDecimal firstDownOffTotalAvg;
	
	private BigDecimal firstDownDefRushAvg;
	private BigDecimal firstDownDefPassAvg;
	private BigDecimal firstDownDefPenaltyAvg;
	private BigDecimal firstDownDefTotalAvg;

	private BigDecimal penaltiesAvg;
	private BigDecimal penaltyYardsAvg;
	
	private BigDecimal thirdDownOffAttAvg;
	private BigDecimal thirdDownOffConvAvg;
	private BigDecimal thirdDownOffConvPct;
	
	private BigDecimal thirdDownDefAttAvg;
	private BigDecimal thirdDownDefConvAvg;
	private BigDecimal thirdDownDefConvPct;

	private BigDecimal fourthDownOffAttAvg;
	private BigDecimal fourthDownOffConvAvg;
	private BigDecimal fourthDownOffConvPct;
	
	private BigDecimal fourthDownDefAttAvg;
	private BigDecimal fourthDownDefConvAvg;
	private BigDecimal fourthDownDefConvPct;

	private BigDecimal offRedZoneAttAvg;
	private BigDecimal offRedZoneScoresAvg;
	private BigDecimal offRedZoneScorePct;
	private BigDecimal offRedZoneTDsAvg;
	private BigDecimal offRedZoneTDPct;
	private BigDecimal offRedZoneFGsAvg;
	private BigDecimal offRedZoneFGPct;
	
	private BigDecimal defRedZoneAttAvg;
	private BigDecimal defRedZoneScoresAvg;
	private BigDecimal defRedZoneScorePct;
	private BigDecimal defRedZoneTDsAvg;
	private BigDecimal defRedZoneTDPct;
	private BigDecimal defRedZoneFGsAvg;
	private BigDecimal defRedZoneFGPct;
	
	private BigDecimal fumbleGainAvg;
	private BigDecimal fubmleLostAvg;
	private BigDecimal turnoverMarginAvg;
	
	public BigDecimal getRushOffAttAvg() {
		return rushOffAttAvg;
	}
	public void setRushOffAttAvg(BigDecimal rushOffAttAvg) {
		this.rushOffAttAvg = rushOffAttAvg;
	}
	public BigDecimal getRushOffYardsAvg() {
		return rushOffYardsAvg;
	}
	public void setRushOffYardsAvg(BigDecimal rushOffYardsAvg) {
		this.rushOffYardsAvg = rushOffYardsAvg;
	}
	public BigDecimal getRushOffTDsAvg() {
		return rushOffTDsAvg;
	}
	public void setRushOffTDsAvg(BigDecimal rushOffTDsAvg) {
		this.rushOffTDsAvg = rushOffTDsAvg;
	}
	public BigDecimal getRushDefAttAvg() {
		return rushDefAttAvg;
	}
	public void setRushDefAttAvg(BigDecimal rushDefAttAvg) {
		this.rushDefAttAvg = rushDefAttAvg;
	}
	public BigDecimal getRushDefYardsAvg() {
		return rushDefYardsAvg;
	}
	public void setRushDefYardsAvg(BigDecimal rushDefYardsAvg) {
		this.rushDefYardsAvg = rushDefYardsAvg;
	}
	public BigDecimal getRushDefTDsAvg() {
		return rushDefTDsAvg;
	}
	public void setRushDefTDsAvg(BigDecimal rushDefTDsAvg) {
		this.rushDefTDsAvg = rushDefTDsAvg;
	}
	public BigDecimal getPassOffAttAvg() {
		return passOffAttAvg;
	}
	public void setPassOffAttAvg(BigDecimal passOffAttAvg) {
		this.passOffAttAvg = passOffAttAvg;
	}
	public BigDecimal getPassOffCompAvg() {
		return passOffCompAvg;
	}
	public void setPassOffCompAvg(BigDecimal passOffCompAvg) {
		this.passOffCompAvg = passOffCompAvg;
	}
	public BigDecimal getPassOffYardsAvg() {
		return passOffYardsAvg;
	}
	public void setPassOffYardsAvg(BigDecimal passOffYardsAvg) {
		this.passOffYardsAvg = passOffYardsAvg;
	}
	public BigDecimal getPassOffINTsAvg() {
		return passOffINTsAvg;
	}
	public void setPassOffINTsAvg(BigDecimal passOffINTsAvg) {
		this.passOffINTsAvg = passOffINTsAvg;
	}
	public BigDecimal getPassOffTDsAvg() {
		return passOffTDsAvg;
	}
	public void setPassOffTDsAvg(BigDecimal passOffTDsAvg) {
		this.passOffTDsAvg = passOffTDsAvg;
	}
	public Double getPassOffRatingAvg() {
		return passOffRatingAvg;
	}
	public void setPassOffRatingAvg(Double passOffRatingAvg) {
		this.passOffRatingAvg = passOffRatingAvg;
	}
	public BigDecimal getPassDefAttAvg() {
		return passDefAttAvg;
	}
	public void setPassDefAttAvg(BigDecimal passDefAttAvg) {
		this.passDefAttAvg = passDefAttAvg;
	}
	public BigDecimal getPassDefCompAvg() {
		return passDefCompAvg;
	}
	public void setPassDefCompAvg(BigDecimal passDefCompAvg) {
		this.passDefCompAvg = passDefCompAvg;
	}
	public BigDecimal getPassDefYardsAvg() {
		return passDefYardsAvg;
	}
	public void setPassDefYardsAvg(BigDecimal passDefYardsAvg) {
		this.passDefYardsAvg = passDefYardsAvg;
	}
	public BigDecimal getPassDefINTsAvg() {
		return passDefINTsAvg;
	}
	public void setPassDefINTsAvg(BigDecimal passDefINTsAvg) {
		this.passDefINTsAvg = passDefINTsAvg;
	}
	public BigDecimal getPassDefTDsAvg() {
		return passDefTDsAvg;
	}
	public void setPassDefTDsAvg(BigDecimal passDefTDsAvg) {
		this.passDefTDsAvg = passDefTDsAvg;
	}
	public Double getPassDefRatingAvg() {
		return passDefRatingAvg;
	}
	public void setPassDefRatingAvg(Double passDefRatingAvg) {
		this.passDefRatingAvg = passDefRatingAvg;
	}
	public BigDecimal getPuntReturnsAvg() {
		return puntReturnsAvg;
	}
	public void setPuntReturnsAvg(BigDecimal puntReturnsAvg) {
		this.puntReturnsAvg = puntReturnsAvg;
	}
	public BigDecimal getPuntReturnYardsAvg() {
		return puntReturnYardsAvg;
	}
	public void setPuntReturnYardsAvg(BigDecimal puntReturnYardsAvg) {
		this.puntReturnYardsAvg = puntReturnYardsAvg;
	}
	public BigDecimal getPuntReturnTDsAvg() {
		return puntReturnTDsAvg;
	}
	public void setPuntReturnTDsAvg(BigDecimal puntReturnTDsAvg) {
		this.puntReturnTDsAvg = puntReturnTDsAvg;
	}
	public BigDecimal getPuntReturnsDefAvg() {
		return puntReturnsDefAvg;
	}
	public void setPuntReturnsDefAvg(BigDecimal puntReturnsDefAvg) {
		this.puntReturnsDefAvg = puntReturnsDefAvg;
	}
	public BigDecimal getPuntReturnYardsDefAvg() {
		return puntReturnYardsDefAvg;
	}
	public void setPuntReturnYardsDefAvg(BigDecimal puntReturnYardsDefAvg) {
		this.puntReturnYardsDefAvg = puntReturnYardsDefAvg;
	}
	public BigDecimal getPuntReturnTDsDefAvg() {
		return puntReturnTDsDefAvg;
	}
	public void setPuntReturnTDsDefAvg(BigDecimal puntReturnTDsDefAvg) {
		this.puntReturnTDsDefAvg = puntReturnTDsDefAvg;
	}
	public BigDecimal getKickoffReturnsAvg() {
		return kickoffReturnsAvg;
	}
	public void setKickoffReturnsAvg(BigDecimal kickoffReturnsAvg) {
		this.kickoffReturnsAvg = kickoffReturnsAvg;
	}
	public BigDecimal getKickoffReturnYardsAvg() {
		return kickoffReturnYardsAvg;
	}
	public void setKickoffReturnYardsAvg(BigDecimal kickoffReturnYardsAvg) {
		this.kickoffReturnYardsAvg = kickoffReturnYardsAvg;
	}
	public BigDecimal getKickoffReturnTDsAvg() {
		return kickoffReturnTDsAvg;
	}
	public void setKickoffReturnTDsAvg(BigDecimal kickoffReturnTDsAvg) {
		this.kickoffReturnTDsAvg = kickoffReturnTDsAvg;
	}
	public BigDecimal getKickoffReturnsDefAvg() {
		return kickoffReturnsDefAvg;
	}
	public void setKickoffReturnsDefAvg(BigDecimal kickoffReturnsDefAvg) {
		this.kickoffReturnsDefAvg = kickoffReturnsDefAvg;
	}
	public BigDecimal getKickoffReturnYardsDefAvg() {
		return kickoffReturnYardsDefAvg;
	}
	public void setKickoffReturnYardsDefAvg(BigDecimal kickoffReturnYardsDefAvg) {
		this.kickoffReturnYardsDefAvg = kickoffReturnYardsDefAvg;
	}
	public BigDecimal getKickoffReturnTDsDefAvg() {
		return kickoffReturnTDsDefAvg;
	}
	public void setKickoffReturnTDsDefAvg(BigDecimal kickoffReturnTDsDefAvg) {
		this.kickoffReturnTDsDefAvg = kickoffReturnTDsDefAvg;
	}
	public BigDecimal getPuntsAvg() {
		return puntsAvg;
	}
	public void setPuntsAvg(BigDecimal puntsAvg) {
		this.puntsAvg = puntsAvg;
	}
	public BigDecimal getPuntYardsAvg() {
		return puntYardsAvg;
	}
	public void setPuntYardsAvg(BigDecimal puntYardsAvg) {
		this.puntYardsAvg = puntYardsAvg;
	}
	public BigDecimal getKickoffsAvg() {
		return kickoffsAvg;
	}
	public void setKickoffsAvg(BigDecimal kickoffsAvg) {
		this.kickoffsAvg = kickoffsAvg;
	}
	public BigDecimal getKickoffYardsAvg() {
		return kickoffYardsAvg;
	}
	public void setKickoffYardsAvg(BigDecimal kickoffYardsAvg) {
		this.kickoffYardsAvg = kickoffYardsAvg;
	}
	public BigDecimal getKickoffTouchbackAvg() {
		return kickoffTouchbackAvg;
	}
	public void setKickoffTouchbackAvg(BigDecimal kickoffTouchbackAvg) {
		this.kickoffTouchbackAvg = kickoffTouchbackAvg;
	}
	public BigDecimal getKickoffOutOfBoundsAvg() {
		return kickoffOutOfBoundsAvg;
	}
	public void setKickoffOutOfBoundsAvg(BigDecimal kickoffOutOfBoundsAvg) {
		this.kickoffOutOfBoundsAvg = kickoffOutOfBoundsAvg;
	}
	public BigDecimal getKickoffOnSideAvg() {
		return kickoffOnSideAvg;
	}
	public void setKickoffOnSideAvg(BigDecimal kickoffOnSideAvg) {
		this.kickoffOnSideAvg = kickoffOnSideAvg;
	}
	public BigDecimal getFgOffAttAvg() {
		return FGOffAttAvg;
	}
	public void setFgOffAttAvg(BigDecimal fGOffAttAvg) {
		FGOffAttAvg = fGOffAttAvg;
	}
	public BigDecimal getFgOffMadeAvg() {
		return FGOffMadeAvg;
	}
	public void setFgOffMadeAvg(BigDecimal fGOffMadeAvg) {
		FGOffMadeAvg = fGOffMadeAvg;
	}
	public BigDecimal getFgDefAttAvg() {
		return FGDefAttAvg;
	}
	public void setFgDefAttAvg(BigDecimal fGDefAttAvg) {
		FGDefAttAvg = fGDefAttAvg;
	}
	public BigDecimal getFgDefMadeAvg() {
		return FGDefMadeAvg;
	}
	public void setFgDefMadeAvg(BigDecimal fGDefMadeAvg) {
		FGDefMadeAvg = fGDefMadeAvg;
	}
	public BigDecimal getScoringOffTDsAvg() {
		return scoringOffTDsAvg;
	}
	public void setScoringOffTDsAvg(BigDecimal scoringOffTDsAvg) {
		this.scoringOffTDsAvg = scoringOffTDsAvg;
	}
	public BigDecimal getScoringOff2PtConvAvg() {
		return scoringOff2PtConvAvg;
	}
	public void setScoringOff2PtConvAvg(BigDecimal scoringOff2PtConvAvg) {
		this.scoringOff2PtConvAvg = scoringOff2PtConvAvg;
	}
	public BigDecimal getScoringOffSafetiesAvg() {
		return scoringOffSafetiesAvg;
	}
	public void setScoringOffSafetiesAvg(BigDecimal scoringOffSafetiesAvg) {
		this.scoringOffSafetiesAvg = scoringOffSafetiesAvg;
	}
	public BigDecimal getScoringOffPointsAvg() {
		return scoringOffPointsAvg;
	}
	public void setScoringOffPointsAvg(BigDecimal scoringOffPointsAvg) {
		this.scoringOffPointsAvg = scoringOffPointsAvg;
	}
	public BigDecimal getScoringDefTDsAvg() {
		return scoringDefTDsAvg;
	}
	public void setScoringDefTDsAvg(BigDecimal scoringDefTDsAvg) {
		this.scoringDefTDsAvg = scoringDefTDsAvg;
	}
	public BigDecimal getScoringDef2PtConvAvg() {
		return scoringDef2PtConvAvg;
	}
	public void setScoringDef2PtConvAvg(BigDecimal scoringDef2PtConvAvg) {
		this.scoringDef2PtConvAvg = scoringDef2PtConvAvg;
	}
	public BigDecimal getScoringDefSafetiesAvg() {
		return scoringDefSafetiesAvg;
	}
	public void setScoringDefSafetiesAvg(BigDecimal scoringDefSafetiesAvg) {
		this.scoringDefSafetiesAvg = scoringDefSafetiesAvg;
	}
	public BigDecimal getScoringDefPointsAvg() {
		return scoringDefPointsAvg;
	}
	public void setScoringDefPointsAvg(BigDecimal scoringDefPointsAvg) {
		this.scoringDefPointsAvg = scoringDefPointsAvg;
	}
	public BigDecimal getTotalOffPlaysAvg() {
		return totalOffPlaysAvg;
	}
	public void setTotalOffPlaysAvg(BigDecimal totalOffPlaysAvg) {
		this.totalOffPlaysAvg = totalOffPlaysAvg;
	}
	public BigDecimal getTotalOffYardsAvg() {
		return totalOffYardsAvg;
	}
	public void setTotalOffYardsAvg(BigDecimal totalOffYardsAvg) {
		this.totalOffYardsAvg = totalOffYardsAvg;
	}
	public BigDecimal getTotalDefPlaysAvg() {
		return totalDefPlaysAvg;
	}
	public void setTotalDefPlaysAvg(BigDecimal totalDefPlaysAvg) {
		this.totalDefPlaysAvg = totalDefPlaysAvg;
	}
	public BigDecimal getTotalDefYardsAvg() {
		return totalDefYardsAvg;
	}
	public void setTotalDefYardsAvg(BigDecimal totalDefYardsAvg) {
		this.totalDefYardsAvg = totalDefYardsAvg;
	}
	public BigDecimal getPassDefIntYardsAvg() {
		return passDefIntYardsAvg;
	}
	public void setPassDefIntYardsAvg(BigDecimal passDefIntYardsAvg) {
		this.passDefIntYardsAvg = passDefIntYardsAvg;
	}
	public BigDecimal getPassDefIntTDsAvg() {
		return passDefIntTDsAvg;
	}
	public void setPassDefIntTDsAvg(BigDecimal passDefIntTDsAvg) {
		this.passDefIntTDsAvg = passDefIntTDsAvg;
	}
	public BigDecimal getFumbleReturnsAvg() {
		return fumbleReturnsAvg;
	}
	public void setFumbleReturnsAvg(BigDecimal fumbleReturnsAvg) {
		this.fumbleReturnsAvg = fumbleReturnsAvg;
	}
	public BigDecimal getFumbleReturnYardsAvg() {
		return fumbleReturnYardsAvg;
	}
	public void setFumbleReturnYardsAvg(BigDecimal fumbleReturnYardsAvg) {
		this.fumbleReturnYardsAvg = fumbleReturnYardsAvg;
	}
	public BigDecimal getFumbleReturnTDsAvg() {
		return fumbleReturnTDsAvg;
	}
	public void setFumbleReturnTDsAvg(BigDecimal fumbleReturnTDsAvg) {
		this.fumbleReturnTDsAvg = fumbleReturnTDsAvg;
	}
	public BigDecimal getTotalTacklesAvg() {
		return totalTacklesAvg;
	}
	public void setTotalTacklesAvg(BigDecimal totalTacklesAvg) {
		this.totalTacklesAvg = totalTacklesAvg;
	}
	public BigDecimal getTFLsAvg() {
		return TFLsAvg;
	}
	public void setTFLsAvg(BigDecimal tFLsAvg) {
		TFLsAvg = tFLsAvg;
	}
	public BigDecimal getTFLYardsAvg() {
		return TFLYardsAvg;
	}
	public void setTFLYardsAvg(BigDecimal tFLYardsAvg) {
		TFLYardsAvg = tFLYardsAvg;
	}
	public BigDecimal getSacksAvg() {
		return sacksAvg;
	}
	public void setSacksAvg(BigDecimal sacksAvg) {
		this.sacksAvg = sacksAvg;
	}
	public BigDecimal getSackYardsAvg() {
		return sackYardsAvg;
	}
	public void setSackYardsAvg(BigDecimal sackYardsAvg) {
		this.sackYardsAvg = sackYardsAvg;
	}
	public BigDecimal getSacksAllowedAvg() {
		return sacksAllowedAvg;
	}
	public void setSacksAllowedAvg(BigDecimal sacksAllowedAvg) {
		this.sacksAllowedAvg = sacksAllowedAvg;
	}
	public BigDecimal getSackYardsAllowedAvg() {
		return sackYardsAllowedAvg;
	}
	public void setSackYardsAllowedAvg(BigDecimal sackYardsAllowedAvg) {
		this.sackYardsAllowedAvg = sackYardsAllowedAvg;
	}
	public BigDecimal getPassesBrokenUpAvg() {
		return passesBrokenUpAvg;
	}
	public void setPassesBrokenUpAvg(BigDecimal passesBrokenUpAvg) {
		this.passesBrokenUpAvg = passesBrokenUpAvg;
	}
	public BigDecimal getQBHurriesAvg() {
		return QBHurriesAvg;
	}
	public void setQBHurriesAvg(BigDecimal qBHurriesAvg) {
		QBHurriesAvg = qBHurriesAvg;
	}
	public BigDecimal getFumblesForcedAvg() {
		return fumblesForcedAvg;
	}
	public void setFumblesForcedAvg(BigDecimal fumblesForcedAvg) {
		this.fumblesForcedAvg = fumblesForcedAvg;
	}
	public BigDecimal getPuntKicksBlockedAvg() {
		return puntKicksBlockedAvg;
	}
	public void setPuntKicksBlockedAvg(BigDecimal puntKicksBlockedAvg) {
		this.puntKicksBlockedAvg = puntKicksBlockedAvg;
	}
	public BigDecimal getQBHurriesAllowedAvg() {
		return QBHurriesAllowedAvg;
	}
	public void setQBHurriesAllowedAvg(BigDecimal qBHurriesAllowedAvg) {
		QBHurriesAllowedAvg = qBHurriesAllowedAvg;
	}
	public BigDecimal getFirstDownOffRushAvg() {
		return firstDownOffRushAvg;
	}
	public void setFirstDownOffRushAvg(BigDecimal firstDownOffRushAvg) {
		this.firstDownOffRushAvg = firstDownOffRushAvg;
	}
	public BigDecimal getFirstDownOffPassAvg() {
		return firstDownOffPassAvg;
	}
	public void setFirstDownOffPassAvg(BigDecimal firstDownOffPassAvg) {
		this.firstDownOffPassAvg = firstDownOffPassAvg;
	}
	public BigDecimal getFirstDownOffPenaltyAvg() {
		return firstDownOffPenaltyAvg;
	}
	public void setFirstDownOffPenaltyAvg(BigDecimal firstDownOffPenaltyAvg) {
		this.firstDownOffPenaltyAvg = firstDownOffPenaltyAvg;
	}
	public BigDecimal getFirstDownOffTotalAvg() {
		return firstDownOffTotalAvg;
	}
	public void setFirstDownOffTotalAvg(BigDecimal firstDownOffTotalAvg) {
		this.firstDownOffTotalAvg = firstDownOffTotalAvg;
	}
	public BigDecimal getFirstDownDefRushAvg() {
		return firstDownDefRushAvg;
	}
	public void setFirstDownDefRushAvg(BigDecimal firstDownDefRushAvg) {
		this.firstDownDefRushAvg = firstDownDefRushAvg;
	}
	public BigDecimal getFirstDownDefPassAvg() {
		return firstDownDefPassAvg;
	}
	public void setFirstDownDefPassAvg(BigDecimal firstDownDefPassAvg) {
		this.firstDownDefPassAvg = firstDownDefPassAvg;
	}
	public BigDecimal getFirstDownDefPenaltyAvg() {
		return firstDownDefPenaltyAvg;
	}
	public void setFirstDownDefPenaltyAvg(BigDecimal firstDownDefPenaltyAvg) {
		this.firstDownDefPenaltyAvg = firstDownDefPenaltyAvg;
	}
	public BigDecimal getFirstDownDefTotalAvg() {
		return firstDownDefTotalAvg;
	}
	public void setFirstDownDefTotalAvg(BigDecimal firstDownDefTotalAvg) {
		this.firstDownDefTotalAvg = firstDownDefTotalAvg;
	}
	public BigDecimal getPenaltiesAvg() {
		return penaltiesAvg;
	}
	public void setPenaltiesAvg(BigDecimal penaltiesAvg) {
		this.penaltiesAvg = penaltiesAvg;
	}
	public BigDecimal getPenaltyYardsAvg() {
		return penaltyYardsAvg;
	}
	public void setPenaltyYardsAvg(BigDecimal penaltyYardsAvg) {
		this.penaltyYardsAvg = penaltyYardsAvg;
	}
	public BigDecimal getThirdDownOffAttAvg() {
		return thirdDownOffAttAvg;
	}
	public void setThirdDownOffAttAvg(BigDecimal thirdDownOffAttAvg) {
		this.thirdDownOffAttAvg = thirdDownOffAttAvg;
	}
	public BigDecimal getThirdDownOffConvAvg() {
		return thirdDownOffConvAvg;
	}
	public void setThirdDownOffConvAvg(BigDecimal thirdDownOffConvAvg) {
		this.thirdDownOffConvAvg = thirdDownOffConvAvg;
	}
	public BigDecimal getThirdDownDefAttAvg() {
		return thirdDownDefAttAvg;
	}
	public void setThirdDownDefAttAvg(BigDecimal thirdDownDefAttAvg) {
		this.thirdDownDefAttAvg = thirdDownDefAttAvg;
	}
	public BigDecimal getThirdDownDefConvAvg() {
		return thirdDownDefConvAvg;
	}
	public void setThirdDownDefConvAvg(BigDecimal thirdDownDefConvAvg) {
		this.thirdDownDefConvAvg = thirdDownDefConvAvg;
	}
	public BigDecimal getFourthDownOffAttAvg() {
		return fourthDownOffAttAvg;
	}
	public void setFourthDownOffAttAvg(BigDecimal fourthDownOffAttAvg) {
		this.fourthDownOffAttAvg = fourthDownOffAttAvg;
	}
	public BigDecimal getFourthDownOffConvAvg() {
		return fourthDownOffConvAvg;
	}
	public void setFourthDownOffConvAvg(BigDecimal fourthDownOffConvAvg) {
		this.fourthDownOffConvAvg = fourthDownOffConvAvg;
	}
	public BigDecimal getFourthDownDefAttAvg() {
		return fourthDownDefAttAvg;
	}
	public void setFourthDownDefAttAvg(BigDecimal fourthDownDefAttAvg) {
		this.fourthDownDefAttAvg = fourthDownDefAttAvg;
	}
	public BigDecimal getFourthDownDefConvAvg() {
		return fourthDownDefConvAvg;
	}
	public void setFourthDownDefConvAvg(BigDecimal fourthDownDefConvAvg) {
		this.fourthDownDefConvAvg = fourthDownDefConvAvg;
	}
	public BigDecimal getOffRedZoneAttAvg() {
		return offRedZoneAttAvg;
	}
	public void setOffRedZoneAttAvg(BigDecimal offRedZoneAttAvg) {
		this.offRedZoneAttAvg = offRedZoneAttAvg;
	}
	public BigDecimal getOffRedZoneScoresAvg() {
		return offRedZoneScoresAvg;
	}
	public void setOffRedZoneScoresAvg(BigDecimal offRedZoneScoresAvg) {
		this.offRedZoneScoresAvg = offRedZoneScoresAvg;
	}
	public BigDecimal getOffRedZoneTDsAvg() {
		return offRedZoneTDsAvg;
	}
	public void setOffRedZoneTDsAvg(BigDecimal offRedZoneTDsAvg) {
		this.offRedZoneTDsAvg = offRedZoneTDsAvg;
	}
	public BigDecimal getOffRedZoneFGsAvg() {
		return offRedZoneFGsAvg;
	}
	public void setOffRedZoneFGsAvg(BigDecimal offRedZoneFGsAvg) {
		this.offRedZoneFGsAvg = offRedZoneFGsAvg;
	}
	public BigDecimal getDefRedZoneAttAvg() {
		return defRedZoneAttAvg;
	}
	public void setDefRedZoneAttAvg(BigDecimal defRedZoneAttAvg) {
		this.defRedZoneAttAvg = defRedZoneAttAvg;
	}
	public BigDecimal getDefRedZoneScoresAvg() {
		return defRedZoneScoresAvg;
	}
	public void setDefRedZoneScoresAvg(BigDecimal defRedZoneScoresAvg) {
		this.defRedZoneScoresAvg = defRedZoneScoresAvg;
	}
	public BigDecimal getDefRedZoneTDsAvg() {
		return defRedZoneTDsAvg;
	}
	public void setDefRedZoneTDsAvg(BigDecimal defRedZoneTDsAvg) {
		this.defRedZoneTDsAvg = defRedZoneTDsAvg;
	}
	public BigDecimal getDefRedZoneFGsAvg() {
		return defRedZoneFGsAvg;
	}
	public BigDecimal getFumbleGainAvg() {
		return fumbleGainAvg;
	}
	public void setFumbleGainAvg(BigDecimal fumbleGainAvg) {
		this.fumbleGainAvg = fumbleGainAvg;
	}
	public BigDecimal getFubmleLostAvg() {
		return fubmleLostAvg;
	}
	public void setFubmleLostAvg(BigDecimal fubmleLostAvg) {
		this.fubmleLostAvg = fubmleLostAvg;
	}
	public BigDecimal getTurnoverMarginAvg() {
		return turnoverMarginAvg;
	}
	public void setTurnoverMarginAvg(BigDecimal turnoverMarginAvg) {
		this.turnoverMarginAvg = turnoverMarginAvg;
	}
	public BigInteger getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(BigInteger gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public BigDecimal getWinPct() {
		return winPct;
	}
	public void setWinPct(BigDecimal winPct) {
		this.winPct = winPct;
	}
	public BigDecimal getWinATSPct() {
		return winATSPct;
	}
	public void setWinATSPct(BigDecimal winATSPct) {
		this.winATSPct = winATSPct;
	}
	public BigDecimal getRushOffYPA() {
		return rushOffYPA;
	}
	public void setRushOffYPA(BigDecimal rushOffYPA) {
		this.rushOffYPA = rushOffYPA;
	}
	public BigDecimal getRushDefYPA() {
		return rushDefYPA;
	}
	public void setRushDefYPA(BigDecimal rushDefYPA) {
		this.rushDefYPA = rushDefYPA;
	}
	public BigDecimal getPassOffCompPct() {
		return passOffCompPct;
	}
	public void setPassOffCompPct(BigDecimal passOffCompPct) {
		this.passOffCompPct = passOffCompPct;
	}
	public BigDecimal getPassOffYPA() {
		return passOffYPA;
	}
	public void setPassOffYPA(BigDecimal passOffYPA) {
		this.passOffYPA = passOffYPA;
	}
	public BigDecimal getPassOffYPR() {
		return passOffYPR;
	}
	public void setPassOffYPR(BigDecimal passOffYPR) {
		this.passOffYPR = passOffYPR;
	}
	public BigDecimal getPassDefCompPct() {
		return passDefCompPct;
	}
	public void setPassDefCompPct(BigDecimal passDefCompPct) {
		this.passDefCompPct = passDefCompPct;
	}
	public BigDecimal getPassDefYPA() {
		return passDefYPA;
	}
	public void setPassDefYPA(BigDecimal passDefYPA) {
		this.passDefYPA = passDefYPA;
	}
	public BigDecimal getPassDefYPR() {
		return passDefYPR;
	}
	public void setPassDefYPR(BigDecimal passDefYPR) {
		this.passDefYPR = passDefYPR;
	}
	public BigDecimal getPuntReturnAverage() {
		return puntReturnAverage;
	}
	public void setPuntReturnAverage(BigDecimal puntReturnAverage) {
		this.puntReturnAverage = puntReturnAverage;
	}
	public BigDecimal getPuntReturnAverageDef() {
		return puntReturnAverageDef;
	}
	public void setPuntReturnAverageDef(BigDecimal puntReturnAverageDef) {
		this.puntReturnAverageDef = puntReturnAverageDef;
	}
	public BigDecimal getKickoffReturnAverage() {
		return kickoffReturnAverage;
	}
	public void setKickoffReturnAverage(BigDecimal kickoffReturnAverage) {
		this.kickoffReturnAverage = kickoffReturnAverage;
	}
	public BigDecimal getKickoffReturnAverageDef() {
		return kickoffReturnAverageDef;
	}
	public void setKickoffReturnAverageDef(BigDecimal kickoffReturnAverageDef) {
		this.kickoffReturnAverageDef = kickoffReturnAverageDef;
	}
	public BigDecimal getPuntAverage() {
		return puntAverage;
	}
	public void setPuntAverage(BigDecimal puntAverage) {
		this.puntAverage = puntAverage;
	}
	public BigDecimal getKickoffAverage() {
		return kickoffAverage;
	}
	public void setKickoffAverage(BigDecimal kickoffAverage) {
		this.kickoffAverage = kickoffAverage;
	}
	public BigDecimal getKickoffTouchbackPct() {
		return kickoffTouchbackPct;
	}
	public void setKickoffTouchbackPct(BigDecimal kickoffTouchbackPct) {
		this.kickoffTouchbackPct = kickoffTouchbackPct;
	}
	public BigDecimal getFGOffPct() {
		return FGOffPct;
	}
	public void setFGOffPct(BigDecimal fGOffPct) {
		FGOffPct = fGOffPct;
	}
	public BigDecimal getFGDefPct() {
		return FGDefPct;
	}
	public void setFGDefPct(BigDecimal fGDefPct) {
		FGDefPct = fGDefPct;
	}
	public BigDecimal getTotalOffYPP() {
		return totalOffYPP;
	}
	public void setTotalOffYPP(BigDecimal totalOffYPP) {
		this.totalOffYPP = totalOffYPP;
	}
	public BigDecimal getTotalDefYPP() {
		return totalDefYPP;
	}
	public void setTotalDefYPP(BigDecimal totalDefYPP) {
		this.totalDefYPP = totalDefYPP;
	}
	public BigDecimal getThirdDownOffConvPct() {
		return thirdDownOffConvPct;
	}
	public void setThirdDownOffConvPct(BigDecimal thirdDownOffConvPct) {
		this.thirdDownOffConvPct = thirdDownOffConvPct;
	}
	public BigDecimal getThirdDownDefConvPct() {
		return thirdDownDefConvPct;
	}
	public void setThirdDownDefConvPct(BigDecimal thirdDownDefConvPct) {
		this.thirdDownDefConvPct = thirdDownDefConvPct;
	}
	public BigDecimal getFourthDownOffConvPct() {
		return fourthDownOffConvPct;
	}
	public void setFourthDownOffConvPct(BigDecimal fourthDownOffConvPct) {
		this.fourthDownOffConvPct = fourthDownOffConvPct;
	}
	public BigDecimal getFourthDownDefConvPct() {
		return fourthDownDefConvPct;
	}
	public void setFourthDownDefConvPct(BigDecimal fourthDownDefConvPct) {
		this.fourthDownDefConvPct = fourthDownDefConvPct;
	}
	public BigDecimal getOffRedZoneScorePct() {
		return offRedZoneScorePct;
	}
	public void setOffRedZoneScorePct(BigDecimal offRedZoneScorePct) {
		this.offRedZoneScorePct = offRedZoneScorePct;
	}
	public BigDecimal getOffRedZoneTDPct() {
		return offRedZoneTDPct;
	}
	public void setOffRedZoneTDPct(BigDecimal offRedZoneTDPct) {
		this.offRedZoneTDPct = offRedZoneTDPct;
	}
	public BigDecimal getOffRedZoneFGPct() {
		return offRedZoneFGPct;
	}
	public void setOffRedZoneFGPct(BigDecimal offRedZoneFGPct) {
		this.offRedZoneFGPct = offRedZoneFGPct;
	}
	public BigDecimal getDefRedZoneScorePct() {
		return defRedZoneScorePct;
	}
	public void setDefRedZoneScorePct(BigDecimal defRedZoneScorePct) {
		this.defRedZoneScorePct = defRedZoneScorePct;
	}
	public BigDecimal getDefRedZoneTDPct() {
		return defRedZoneTDPct;
	}
	public void setDefRedZoneTDPct(BigDecimal defRedZoneTDPct) {
		this.defRedZoneTDPct = defRedZoneTDPct;
	}
	public BigDecimal getDefRedZoneFGPct() {
		return defRedZoneFGPct;
	}
	public void setDefRedZoneFGPct(BigDecimal defRedZoneFGPct) {
		this.defRedZoneFGPct = defRedZoneFGPct;
	}
	public void setDefRedZoneFGsAvg(BigDecimal defRedZoneFGsAvg) {
		this.defRedZoneFGsAvg = defRedZoneFGsAvg;
	}
}
