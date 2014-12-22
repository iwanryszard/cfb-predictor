package svm.predictor.dto;

import java.math.BigDecimal;

public class TeamSimpleAggregatedStats {

	private BigDecimal winPct;
	private BigDecimal winATSPct;
	private BigDecimal underPct;
	private BigDecimal rushOffYardsAvg;
	private BigDecimal passOffYardsAvg;
	private BigDecimal scoringOffPointsAvg;
	private BigDecimal rushDefYardsAvg;
	private BigDecimal passDefYardsAvg;
	private BigDecimal scoringDefPointsAvg;
	
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
	public BigDecimal getUnderPct() {
		return underPct;
	}
	public void setUnderPct(BigDecimal underPct) {
		this.underPct = underPct;
	}
	public BigDecimal getRushOffYardsAvg() {
		return rushOffYardsAvg;
	}
	public void setRushOffYardsAvg(BigDecimal rushOffYardsAvg) {
		this.rushOffYardsAvg = rushOffYardsAvg;
	}
	public BigDecimal getPassOffYardsAvg() {
		return passOffYardsAvg;
	}
	public void setPassOffYardsAvg(BigDecimal passOffYardsAvg) {
		this.passOffYardsAvg = passOffYardsAvg;
	}
	public BigDecimal getScoringOffPointsAvg() {
		return scoringOffPointsAvg;
	}
	public void setScoringOffPointsAvg(BigDecimal scoringOffPointsAvg) {
		this.scoringOffPointsAvg = scoringOffPointsAvg;
	}
	public BigDecimal getRushDefYardsAvg() {
		return rushDefYardsAvg;
	}
	public void setRushDefYardsAvg(BigDecimal rushDefYardsAvg) {
		this.rushDefYardsAvg = rushDefYardsAvg;
	}
	public BigDecimal getPassDefYardsAvg() {
		return passDefYardsAvg;
	}
	public void setPassDefYardsAvg(BigDecimal passDefYardsAvg) {
		this.passDefYardsAvg = passDefYardsAvg;
	}
	public BigDecimal getScoringDefPointsAvg() {
		return scoringDefPointsAvg;
	}
	public void setScoringDefPointsAvg(BigDecimal scoringDefPointsAvg) {
		this.scoringDefPointsAvg = scoringDefPointsAvg;
	}
}
