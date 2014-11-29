package svm.predictor.dto;

public class TeamGameStatsDto {

	private int rushOffAtt;
	private int rushOffYards;
	private Double rushOffYPA;
	private int rushOffTDs;
	
	private int passOffAtt;
	private int passOffComp;
	private Double passOffCompPct;
	private int passOffYards;
	private Double passOffYPA;
	private int passOffINTs;
	private int passOffTDs;
	private Double passOffRating;
	private Double passOffYPR;
	
	private int puntReturns;
	private int puntReturnYards;
	private Double puntReturnAverage;
	private int puntReturnTDs;
	
	private int kickoffReturns;
	private int kickoffReturnYards;
	private Double kickoffReturnAverage;
	private int kickoffReturnTDs;
	
	private int punts;
	private int puntYards;
	private Double puntAverage;
	
	private int kickoffs;
	private int kickoffYards;
	private Double kickoffAverage;
	private int kickoffTouchback;
	private Double kickoffTouchbackPct;
	private int kickoffOutOfBounds;
	private int kickoffOnSide;
	
	private int FGOffAtt;
	private int FGOffMade;
	private Double FGOffPct;

	private int scoringOffTDs;
	private int scoringOff2PtConv;
	private int scoringOffSafeties;
	private int scoringOffPoints;
	
	private int totalOffPlays;
	private int totalOffYards;
	private Double totalOffYPP;
	
	private Integer passDefInts;
	private Integer passDefIntYards;
	private Integer passDefIntTDs;
	
	private Integer fumbleReturns;
	private Integer fumbleReturnYards;
	private Integer fumbleReturnTDs;
	
	private Integer totalTackles;
	
	private Integer TFLs;
	private Integer TFLYards;
	
	private Integer sacks;
	private Integer sackYards;
	
	private Integer passesBrokenUp;
	private Integer QBHurries;
	private Integer fumblesForced;
	private Integer puntKicksBlocked;
	
	private int firstDownOffRush;
	private int firstDownOffPass;
	private int firstDownOffPenalty;
	private int firstDownOffTotal;

	private int penalties;
	private int penaltyYards;
	
	private int thirdDownOffAtt;
	private int thirdDownOffConv;
	private Double thirdDownOffConvPct;

	private int fourthDownOffAtt;
	private int fourthDownOffConv;
	private Double fourthDownOffConvPct;

	private int offRedZoneAtt;
	private int offRedZoneScores;
	private Double offRedZoneScorePct;
	private int offRedZoneTDs;
	private Double offRedZoneTDPct;
	private int offRedZoneFGs;
	private Double offRedZoneFGPct;
	
	private Integer fumbleGain;
	private Integer fubmleLost;
	private Integer turnoverMargin;
	
	public int getRushOffAtt() {
		return rushOffAtt;
	}
	public void setRushOffAtt(int rushOffAtt) {
		this.rushOffAtt = rushOffAtt;
	}
	public int getRushOffYards() {
		return rushOffYards;
	}
	public void setRushOffYards(int rushOffYards) {
		this.rushOffYards = rushOffYards;
	}
	public Double getRushOffYPA() {
		return rushOffYPA;
	}
	public void setRushOffYPA(Double rushOffYPA) {
		this.rushOffYPA = rushOffYPA;
	}
	public int getRushOffTDs() {
		return rushOffTDs;
	}
	public void setRushOffTDs(int rushOffTDs) {
		this.rushOffTDs = rushOffTDs;
	}
	public int getPassOffAtt() {
		return passOffAtt;
	}
	public void setPassOffAtt(int passOffAtt) {
		this.passOffAtt = passOffAtt;
	}
	public int getPassOffComp() {
		return passOffComp;
	}
	public void setPassOffComp(int passOffComp) {
		this.passOffComp = passOffComp;
	}
	public Double getPassOffCompPct() {
		return passOffCompPct;
	}
	public void setPassOffCompPct(Double passOffCompPct) {
		this.passOffCompPct = passOffCompPct;
	}
	public int getPassOffYards() {
		return passOffYards;
	}
	public void setPassOffYards(int passOffYards) {
		this.passOffYards = passOffYards;
	}
	public Double getPassOffYPA() {
		return passOffYPA;
	}
	public void setPassOffYPA(Double passOffYPA) {
		this.passOffYPA = passOffYPA;
	}
	public int getPassOffINTs() {
		return passOffINTs;
	}
	public void setPassOffINTs(int passOffINTs) {
		this.passOffINTs = passOffINTs;
	}
	public int getPassOffTDs() {
		return passOffTDs;
	}
	public void setPassOffTDs(int passOffTDs) {
		this.passOffTDs = passOffTDs;
	}
	public Double getPassOffRating() {
		return passOffRating;
	}
	public void setPassOffRating(Double passOffRating) {
		this.passOffRating = passOffRating;
	}
	public Double getPassOffYPR() {
		return passOffYPR;
	}
	public void setPassOffYPR(Double passOffYPR) {
		this.passOffYPR = passOffYPR;
	}
	public int getPuntReturns() {
		return puntReturns;
	}
	public void setPuntReturns(int puntReturns) {
		this.puntReturns = puntReturns;
	}
	public int getPuntReturnYards() {
		return puntReturnYards;
	}
	public void setPuntReturnYards(int puntReturnYards) {
		this.puntReturnYards = puntReturnYards;
	}
	public Double getPuntReturnAverage() {
		return puntReturnAverage;
	}
	public void setPuntReturnAverage(Double puntReturnAverage) {
		this.puntReturnAverage = puntReturnAverage;
	}
	public int getPuntReturnTDs() {
		return puntReturnTDs;
	}
	public void setPuntReturnTDs(int puntReturnTDs) {
		this.puntReturnTDs = puntReturnTDs;
	}
	public int getKickoffReturns() {
		return kickoffReturns;
	}
	public void setKickoffReturns(int kickoffReturns) {
		this.kickoffReturns = kickoffReturns;
	}
	public int getKickoffReturnYards() {
		return kickoffReturnYards;
	}
	public void setKickoffReturnYards(int kickoffReturnYards) {
		this.kickoffReturnYards = kickoffReturnYards;
	}
	public Double getKickoffReturnAverage() {
		return kickoffReturnAverage;
	}
	public void setKickoffReturnAverage(Double kickoffReturnAverage) {
		this.kickoffReturnAverage = kickoffReturnAverage;
	}
	public int getKickoffReturnTDs() {
		return kickoffReturnTDs;
	}
	public void setKickoffReturnTDs(int kickoffReturnTDs) {
		this.kickoffReturnTDs = kickoffReturnTDs;
	}
	public int getPunts() {
		return punts;
	}
	public void setPunts(int punts) {
		this.punts = punts;
	}
	public int getPuntYards() {
		return puntYards;
	}
	public void setPuntYards(int puntYards) {
		this.puntYards = puntYards;
	}
	public Double getPuntAverage() {
		return puntAverage;
	}
	public void setPuntAverage(Double puntAverage) {
		this.puntAverage = puntAverage;
	}
	public int getKickoffs() {
		return kickoffs;
	}
	public void setKickoffs(int kickoffs) {
		this.kickoffs = kickoffs;
	}
	public int getKickoffYards() {
		return kickoffYards;
	}
	public void setKickoffYards(int kickoffYards) {
		this.kickoffYards = kickoffYards;
	}
	public Double getKickoffAverage() {
		return kickoffAverage;
	}
	public void setKickoffAverage(Double kickoffAverage) {
		this.kickoffAverage = kickoffAverage;
	}
	public int getKickoffTouchback() {
		return kickoffTouchback;
	}
	public void setKickoffTouchback(int kickoffTouchback) {
		this.kickoffTouchback = kickoffTouchback;
	}
	public Double getKickoffTouchbackPct() {
		return kickoffTouchbackPct;
	}
	public void setKickoffTouchbackPct(Double kickoffTouchbackPct) {
		this.kickoffTouchbackPct = kickoffTouchbackPct;
	}
	public int getKickoffOutOfBounds() {
		return kickoffOutOfBounds;
	}
	public void setKickoffOutOfBounds(int kickoffOutOfBounds) {
		this.kickoffOutOfBounds = kickoffOutOfBounds;
	}
	public int getKickoffOnSide() {
		return kickoffOnSide;
	}
	public void setKickoffOnSide(int kickoffOnSide) {
		this.kickoffOnSide = kickoffOnSide;
	}
	public int getFGOffAtt() {
		return FGOffAtt;
	}
	public void setFGOffAtt(int fGOffAtt) {
		FGOffAtt = fGOffAtt;
	}
	public int getFGOffMade() {
		return FGOffMade;
	}
	public void setFGOffMade(int fGOffMade) {
		FGOffMade = fGOffMade;
	}
	public Double getFGOffPct() {
		return FGOffPct;
	}
	public void setFGOffPct(Double fGOffPct) {
		FGOffPct = fGOffPct;
	}
	public int getScoringOffTDs() {
		return scoringOffTDs;
	}
	public void setScoringOffTDs(int scoringOffTDs) {
		this.scoringOffTDs = scoringOffTDs;
	}
	public int getScoringOff2PtConv() {
		return scoringOff2PtConv;
	}
	public void setScoringOff2PtConv(int scoringOff2PtConv) {
		this.scoringOff2PtConv = scoringOff2PtConv;
	}
	public int getScoringOffSafeties() {
		return scoringOffSafeties;
	}
	public void setScoringOffSafeties(int scoringOffSafeties) {
		this.scoringOffSafeties = scoringOffSafeties;
	}
	public int getScoringOffPoints() {
		return scoringOffPoints;
	}
	public void setScoringOffPoints(int scoringOffPoints) {
		this.scoringOffPoints = scoringOffPoints;
	}
	public int getTotalOffPlays() {
		return totalOffPlays;
	}
	public void setTotalOffPlays(int totalOffPlays) {
		this.totalOffPlays = totalOffPlays;
	}
	public int getTotalOffYards() {
		return totalOffYards;
	}
	public void setTotalOffYards(int totalOffYards) {
		this.totalOffYards = totalOffYards;
	}
	public Double getTotalOffYPP() {
		return totalOffYPP;
	}
	public void setTotalOffYPP(Double totalOffYPP) {
		this.totalOffYPP = totalOffYPP;
	}
	public Integer getPassDefInts() {
		return passDefInts;
	}
	public void setPassDefInts(Integer passDefInts) {
		this.passDefInts = passDefInts;
	}
	public Integer getPassDefIntYards() {
		return passDefIntYards;
	}
	public void setPassDefIntYards(Integer passDefIntYards) {
		this.passDefIntYards = passDefIntYards;
	}
	public Integer getPassDefIntTDs() {
		return passDefIntTDs;
	}
	public void setPassDefIntTDs(Integer passDefIntTDs) {
		this.passDefIntTDs = passDefIntTDs;
	}
	public Integer getFumbleReturns() {
		return fumbleReturns;
	}
	public void setFumbleReturns(Integer fumbleReturns) {
		this.fumbleReturns = fumbleReturns;
	}
	public Integer getFumbleReturnYards() {
		return fumbleReturnYards;
	}
	public void setFumbleReturnYards(Integer fumbleReturnYards) {
		this.fumbleReturnYards = fumbleReturnYards;
	}
	public Integer getFumbleReturnTDs() {
		return fumbleReturnTDs;
	}
	public void setFumbleReturnTDs(Integer fumbleReturnTDs) {
		this.fumbleReturnTDs = fumbleReturnTDs;
	}
	public Integer getTotalTackles() {
		return totalTackles;
	}
	public void setTotalTackles(Integer totalTackles) {
		this.totalTackles = totalTackles;
	}
	public Integer getTFLs() {
		return TFLs;
	}
	public void setTFLs(Integer tFLs) {
		TFLs = tFLs;
	}
	public Integer getTFLYards() {
		return TFLYards;
	}
	public void setTFLYards(Integer tFLYards) {
		TFLYards = tFLYards;
	}
	public Integer getSacks() {
		return sacks;
	}
	public void setSacks(Integer sacks) {
		this.sacks = sacks;
	}
	public Integer getSackYards() {
		return sackYards;
	}
	public void setSackYards(Integer sackYards) {
		this.sackYards = sackYards;
	}
	public Integer getPassesBrokenUp() {
		return passesBrokenUp;
	}
	public void setPassesBrokenUp(Integer passesBrokenUp) {
		this.passesBrokenUp = passesBrokenUp;
	}
	public Integer getQBHurries() {
		return QBHurries;
	}
	public void setQBHurries(Integer qBHurries) {
		QBHurries = qBHurries;
	}
	public Integer getFumblesForced() {
		return fumblesForced;
	}
	public void setFumblesForced(Integer fumblesForced) {
		this.fumblesForced = fumblesForced;
	}
	public Integer getPuntKicksBlocked() {
		return puntKicksBlocked;
	}
	public void setPuntKicksBlocked(Integer puntKicksBlocked) {
		this.puntKicksBlocked = puntKicksBlocked;
	}
	public int getFirstDownOffRush() {
		return firstDownOffRush;
	}
	public void setFirstDownOffRush(int firstDownOffRush) {
		this.firstDownOffRush = firstDownOffRush;
	}
	public int getFirstDownOffPass() {
		return firstDownOffPass;
	}
	public void setFirstDownOffPass(int firstDownOffPass) {
		this.firstDownOffPass = firstDownOffPass;
	}
	public int getFirstDownOffPenalty() {
		return firstDownOffPenalty;
	}
	public void setFirstDownOffPenalty(int firstDownOffPenalty) {
		this.firstDownOffPenalty = firstDownOffPenalty;
	}
	public int getFirstDownOffTotal() {
		return firstDownOffTotal;
	}
	public void setFirstDownOffTotal(int firstDownOffTotal) {
		this.firstDownOffTotal = firstDownOffTotal;
	}
	public int getPenalties() {
		return penalties;
	}
	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
	public int getPenaltyYards() {
		return penaltyYards;
	}
	public void setPenaltyYards(int penaltyYards) {
		this.penaltyYards = penaltyYards;
	}
	public int getThirdDownOffAtt() {
		return thirdDownOffAtt;
	}
	public void setThirdDownOffAtt(int thirdDownOffAtt) {
		this.thirdDownOffAtt = thirdDownOffAtt;
	}
	public int getThirdDownOffConv() {
		return thirdDownOffConv;
	}
	public void setThirdDownOffConv(int thirdDownOffConv) {
		this.thirdDownOffConv = thirdDownOffConv;
	}
	public Double getThirdDownOffConvPct() {
		return thirdDownOffConvPct;
	}
	public void setThirdDownOffConvPct(Double thirdDownOffConvPct) {
		this.thirdDownOffConvPct = thirdDownOffConvPct;
	}
	public int getFourthDownOffAtt() {
		return fourthDownOffAtt;
	}
	public void setFourthDownOffAtt(int fourthDownOffAtt) {
		this.fourthDownOffAtt = fourthDownOffAtt;
	}
	public int getFourthDownOffConv() {
		return fourthDownOffConv;
	}
	public void setFourthDownOffConv(int fourthDownOffConv) {
		this.fourthDownOffConv = fourthDownOffConv;
	}
	public Double getFourthDownOffConvPct() {
		return fourthDownOffConvPct;
	}
	public void setFourthDownOffConvPct(Double fourthDownOffConvPct) {
		this.fourthDownOffConvPct = fourthDownOffConvPct;
	}
	public int getOffRedZoneAtt() {
		return offRedZoneAtt;
	}
	public void setOffRedZoneAtt(int offRedZoneAtt) {
		this.offRedZoneAtt = offRedZoneAtt;
	}
	public int getOffRedZoneScores() {
		return offRedZoneScores;
	}
	public void setOffRedZoneScores(int offRedZoneScores) {
		this.offRedZoneScores = offRedZoneScores;
	}
	public Double getOffRedZoneScorePct() {
		return offRedZoneScorePct;
	}
	public void setOffRedZoneScorePct(Double offRedZoneScorePct) {
		this.offRedZoneScorePct = offRedZoneScorePct;
	}
	public int getOffRedZoneTDs() {
		return offRedZoneTDs;
	}
	public void setOffRedZoneTDs(int offRedZoneTDs) {
		this.offRedZoneTDs = offRedZoneTDs;
	}
	public Double getOffRedZoneTDPct() {
		return offRedZoneTDPct;
	}
	public void setOffRedZoneTDPct(Double offRedZoneTDPct) {
		this.offRedZoneTDPct = offRedZoneTDPct;
	}
	public int getOffRedZoneFGs() {
		return offRedZoneFGs;
	}
	public void setOffRedZoneFGs(int offRedZoneFGs) {
		this.offRedZoneFGs = offRedZoneFGs;
	}
	public Double getOffRedZoneFGPct() {
		return offRedZoneFGPct;
	}
	public void setOffRedZoneFGPct(Double offRedZoneFGPct) {
		this.offRedZoneFGPct = offRedZoneFGPct;
	}
	public Integer getFumbleGain() {
		return fumbleGain;
	}
	public void setFumbleGain(Integer fumbleGain) {
		this.fumbleGain = fumbleGain;
	}
	public Integer getFubmleLost() {
		return fubmleLost;
	}
	public void setFubmleLost(Integer fubmleLost) {
		this.fubmleLost = fubmleLost;
	}
	public Integer getTurnoverMargin() {
		return turnoverMargin;
	}
	public void setTurnoverMargin(Integer turnoverMargin) {
		this.turnoverMargin = turnoverMargin;
	}
}
