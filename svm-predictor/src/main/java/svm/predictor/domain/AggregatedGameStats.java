package svm.predictor.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="aggregated_game_stats")
public class AggregatedGameStats implements BaseEntity<Integer> {

	private Integer id;
	
	private GameInfo game;
	
	private BigInteger homeGamesPlayed;
	
	private BigDecimal homeWinPct;
	private BigDecimal homeWinATSPct;
	private BigDecimal homeUnderPct;
	
	private BigDecimal homeRushOffAttAvg;
	private BigDecimal homeRushOffYardsAvg;
	private BigDecimal homeRushOffYPA;
	private BigDecimal homeRushOffTDsAvg;
	
	private BigDecimal homeRushDefAttAvg;
	private BigDecimal homeRushDefYardsAvg;
	private BigDecimal homeRushDefYPA;
	private BigDecimal homeRushDefTDsAvg;
	
	private BigDecimal homePassOffAttAvg;
	private BigDecimal homePassOffCompAvg;
	private BigDecimal homePassOffCompPct;
	private BigDecimal homePassOffYardsAvg;
	private BigDecimal homePassOffYPA;
	private BigDecimal homePassOffINTsAvg;
	private BigDecimal homePassOffTDsAvg;
	private Double homePassOffRatingAvg;
	private BigDecimal homePassOffYPR;
	
	private BigDecimal homePassDefAttAvg;
	private BigDecimal homePassDefCompAvg;
	private BigDecimal homePassDefCompPct;
	private BigDecimal homePassDefYardsAvg;
	private BigDecimal homePassDefYPA;
	private BigDecimal homePassDefINTsAvg;
	private BigDecimal homePassDefTDsAvg;
	private Double homePassDefRatingAvg;
	private BigDecimal homePassDefYPR;
	
	private BigDecimal homePuntReturnsAvg;
	private BigDecimal homePuntReturnYardsAvg;
	private BigDecimal homePuntReturnAverage;
	private BigDecimal homePuntReturnTDsAvg;
	
	private BigDecimal homePuntReturnsDefAvg;
	private BigDecimal homePuntReturnYardsDefAvg;
	private BigDecimal homePuntReturnAverageDef;
	private BigDecimal homePuntReturnTDsDefAvg;
	
	private BigDecimal homeKickoffReturnsAvg;
	private BigDecimal homeKickoffReturnYardsAvg;
	private BigDecimal homeKickoffReturnAverage;
	private BigDecimal homeKickoffReturnTDsAvg;
	
	private BigDecimal homeKickoffReturnsDefAvg;
	private BigDecimal homeKickoffReturnYardsDefAvg;
	private BigDecimal homeKickoffReturnAverageDef;
	private BigDecimal homeKickoffReturnTDsDefAvg;
	
	private BigDecimal homePuntsAvg;
	private BigDecimal homePuntYardsAvg;
	private BigDecimal homePuntAverage;
	
	private BigDecimal homeKickoffsAvg;
	private BigDecimal homeKickoffYardsAvg;
	private BigDecimal homeKickoffAverage;
	private BigDecimal homeKickoffTouchbackAvg;
	private BigDecimal homeKickoffTouchbackPct;
	private BigDecimal homeKickoffOutOfBoundsAvg;
	private BigDecimal homeKickoffOnSideAvg;
	
	private BigDecimal homeFGOffAttAvg;
	private BigDecimal homeFGOffMadeAvg;
	private BigDecimal homeFGOffPct;
	
	private BigDecimal homeFGDefAttAvg;
	private BigDecimal homeFGDefMadeAvg;
	private BigDecimal homeFGDefPct;

	private BigDecimal homeScoringOffTDsAvg;
	private BigDecimal homeScoringOff2PtConvAvg;
	private BigDecimal homeScoringOffSafetiesAvg;
	private BigDecimal homeScoringOffPointsAvg;
	
	private BigDecimal homeScoringDefTDsAvg;
	private BigDecimal homeScoringDef2PtConvAvg;
	private BigDecimal homeScoringDefSafetiesAvg;
	private BigDecimal homeScoringDefPointsAvg;
	
	private BigDecimal homeTotalOffPlaysAvg;
	private BigDecimal homeTotalOffYardsAvg;
	private BigDecimal homeTotalOffYPP;
	
	private BigDecimal homeTotalDefPlaysAvg;
	private BigDecimal homeTotalDefYardsAvg;
	private BigDecimal homeTotalDefYPP;
	
	private BigDecimal homePassDefIntYardsAvg;
	private BigDecimal homePassDefIntTDsAvg;
	
	private BigDecimal homeFumbleReturnsAvg;
	private BigDecimal homeFumbleReturnYardsAvg;
	private BigDecimal homeFumbleReturnTDsAvg;
	
	private BigDecimal homeTotalTacklesAvg;
	
	private BigDecimal homeTFLsAvg;
	private BigDecimal homeTFLYardsAvg;
	
	private BigDecimal homeSacksAvg;
	private BigDecimal homeSackYardsAvg;
	
	private BigDecimal homeSacksAllowedAvg;
	private BigDecimal homeSackYardsAllowedAvg;
	
	private BigDecimal homePassesBrokenUpAvg;
	private BigDecimal homeQBHurriesAvg;
	private BigDecimal homeFumblesForcedAvg;
	private BigDecimal homePuntKicksBlockedAvg;
	
	private BigDecimal homeQBHurriesAllowedAvg;
	
	private BigDecimal homeFirstDownOffRushAvg;
	private BigDecimal homeFirstDownOffPassAvg;
	private BigDecimal homeFirstDownOffPenaltyAvg;
	private BigDecimal homeFirstDownOffTotalAvg;
	
	private BigDecimal homeFirstDownDefRushAvg;
	private BigDecimal homeFirstDownDefPassAvg;
	private BigDecimal homeFirstDownDefPenaltyAvg;
	private BigDecimal homeFirstDownDefTotalAvg;

	private BigDecimal homePenaltiesAvg;
	private BigDecimal homePenaltyYardsAvg;
	
	private BigDecimal homeThirdDownOffAttAvg;
	private BigDecimal homeThirdDownOffConvAvg;
	private BigDecimal homeThirdDownOffConvPct;
	
	private BigDecimal homeThirdDownDefAttAvg;
	private BigDecimal homeThirdDownDefConvAvg;
	private BigDecimal homeThirdDownDefConvPct;

	private BigDecimal homeFourthDownOffAttAvg;
	private BigDecimal homeFourthDownOffConvAvg;
	private BigDecimal homeFourthDownOffConvPct;
	
	private BigDecimal homeFourthDownDefAttAvg;
	private BigDecimal homeFourthDownDefConvAvg;
	private BigDecimal homeFourthDownDefConvPct;

	private BigDecimal homeOffRedZoneAttAvg;
	private BigDecimal homeOffRedZoneScoresAvg;
	private BigDecimal homeOffRedZoneScorePct;
	private BigDecimal homeOffRedZoneTDsAvg;
	private BigDecimal homeOffRedZoneTDPct;
	private BigDecimal homeOffRedZoneFGsAvg;
	private BigDecimal homeOffRedZoneFGPct;
	
	private BigDecimal homeDefRedZoneAttAvg;
	private BigDecimal homeDefRedZoneScoresAvg;
	private BigDecimal homeDefRedZoneScorePct;
	private BigDecimal homeDefRedZoneTDsAvg;
	private BigDecimal homeDefRedZoneTDPct;
	private BigDecimal homeDefRedZoneFGsAvg;
	private BigDecimal homeDefRedZoneFGPct;
	
	private BigDecimal homeFumbleGainAvg;
	private BigDecimal homeFubmleLostAvg;
	private BigDecimal homeTurnoverMarginAvg;
	
	private BigDecimal homeLast5WinPct;
	private BigDecimal homeLast5WinATSPct;
	private BigDecimal homeLast5UnderPct;
	private BigDecimal homeLast5RushOffYardsAvg;
	private BigDecimal homeLast5PassOffYardsAvg;
	private BigDecimal homeLast5ScoringOffPointsAvg;
	private BigDecimal homeLast5RushDefYardsAvg;
	private BigDecimal homeLast5PassDefYardsAvg;
	private BigDecimal homeLast5ScoringDefPointsAvg;
	
	private BigDecimal homeLastSeasonWinPct;
	private BigDecimal homeLastSeasonWinATSPct;
	private BigDecimal homeLastSeasonUnderPct;
	private BigDecimal homeLastSeasonRushOffYardsAvg;
	private BigDecimal homeLastSeasonPassOffYardsAvg;
	private BigDecimal homeLastSeasonScoringOffPointsAvg;
	private BigDecimal homeLastSeasonRushDefYardsAvg;
	private BigDecimal homeLastSeasonPassDefYardsAvg;
	private BigDecimal homeLastSeasonScoringDefPointsAvg;
	
	private BigInteger awayGamesPlayed;
	
	private BigDecimal awayWinPct;
	private BigDecimal awayWinATSPct;
	private BigDecimal awayUnderPct;
	
	private BigDecimal awayRushOffAttAvg;
	private BigDecimal awayRushOffYardsAvg;
	private BigDecimal awayRushOffYPA;
	private BigDecimal awayRushOffTDsAvg;
	
	private BigDecimal awayRushDefAttAvg;
	private BigDecimal awayRushDefYardsAvg;
	private BigDecimal awayRushDefYPA;
	private BigDecimal awayRushDefTDsAvg;
	
	private BigDecimal awayPassOffAttAvg;
	private BigDecimal awayPassOffCompAvg;
	private BigDecimal awayPassOffCompPct;
	private BigDecimal awayPassOffYardsAvg;
	private BigDecimal awayPassOffYPA;
	private BigDecimal awayPassOffINTsAvg;
	private BigDecimal awayPassOffTDsAvg;
	private Double awayPassOffRatingAvg;
	private BigDecimal awayPassOffYPR;
	
	private BigDecimal awayPassDefAttAvg;
	private BigDecimal awayPassDefCompAvg;
	private BigDecimal awayPassDefCompPct;
	private BigDecimal awayPassDefYardsAvg;
	private BigDecimal awayPassDefYPA;
	private BigDecimal awayPassDefINTsAvg;
	private BigDecimal awayPassDefTDsAvg;
	private Double awayPassDefRatingAvg;
	private BigDecimal awayPassDefYPR;
	
	private BigDecimal awayPuntReturnsAvg;
	private BigDecimal awayPuntReturnYardsAvg;
	private BigDecimal awayPuntReturnAverage;
	private BigDecimal awayPuntReturnTDsAvg;
	
	private BigDecimal awayPuntReturnsDefAvg;
	private BigDecimal awayPuntReturnYardsDefAvg;
	private BigDecimal awayPuntReturnAverageDef;
	private BigDecimal awayPuntReturnTDsDefAvg;
	
	private BigDecimal awayKickoffReturnsAvg;
	private BigDecimal awayKickoffReturnYardsAvg;
	private BigDecimal awayKickoffReturnAverage;
	private BigDecimal awayKickoffReturnTDsAvg;
	
	private BigDecimal awayKickoffReturnsDefAvg;
	private BigDecimal awayKickoffReturnYardsDefAvg;
	private BigDecimal awayKickoffReturnAverageDef;
	private BigDecimal awayKickoffReturnTDsDefAvg;
	
	private BigDecimal awayPuntsAvg;
	private BigDecimal awayPuntYardsAvg;
	private BigDecimal awayPuntAverage;
	
	private BigDecimal awayKickoffsAvg;
	private BigDecimal awayKickoffYardsAvg;
	private BigDecimal awayKickoffAverage;
	private BigDecimal awayKickoffTouchbackAvg;
	private BigDecimal awayKickoffTouchbackPct;
	private BigDecimal awayKickoffOutOfBoundsAvg;
	private BigDecimal awayKickoffOnSideAvg;
	
	private BigDecimal awayFGOffAttAvg;
	private BigDecimal awayFGOffMadeAvg;
	private BigDecimal awayFGOffPct;
	
	private BigDecimal awayFGDefAttAvg;
	private BigDecimal awayFGDefMadeAvg;
	private BigDecimal awayFGDefPct;

	private BigDecimal awayScoringOffTDsAvg;
	private BigDecimal awayScoringOff2PtConvAvg;
	private BigDecimal awayScoringOffSafetiesAvg;
	private BigDecimal awayScoringOffPointsAvg;
	
	private BigDecimal awayScoringDefTDsAvg;
	private BigDecimal awayScoringDef2PtConvAvg;
	private BigDecimal awayScoringDefSafetiesAvg;
	private BigDecimal awayScoringDefPointsAvg;
	
	private BigDecimal awayTotalOffPlaysAvg;
	private BigDecimal awayTotalOffYardsAvg;
	private BigDecimal awayTotalOffYPP;
	
	private BigDecimal awayTotalDefPlaysAvg;
	private BigDecimal awayTotalDefYardsAvg;
	private BigDecimal awayTotalDefYPP;
	
	private BigDecimal awayPassDefIntYardsAvg;
	private BigDecimal awayPassDefIntTDsAvg;
	
	private BigDecimal awayFumbleReturnsAvg;
	private BigDecimal awayFumbleReturnYardsAvg;
	private BigDecimal awayFumbleReturnTDsAvg;
	
	private BigDecimal awayTotalTacklesAvg;
	
	private BigDecimal awayTFLsAvg;
	private BigDecimal awayTFLYardsAvg;
	
	private BigDecimal awaySacksAvg;
	private BigDecimal awaySackYardsAvg;
	
	private BigDecimal awaySacksAllowedAvg;
	private BigDecimal awaySackYardsAllowedAvg;
	
	private BigDecimal awayPassesBrokenUpAvg;
	private BigDecimal awayQBHurriesAvg;
	private BigDecimal awayFumblesForcedAvg;
	private BigDecimal awayPuntKicksBlockedAvg;
	
	private BigDecimal awayQBHurriesAllowedAvg;
	
	private BigDecimal awayFirstDownOffRushAvg;
	private BigDecimal awayFirstDownOffPassAvg;
	private BigDecimal awayFirstDownOffPenaltyAvg;
	private BigDecimal awayFirstDownOffTotalAvg;
	
	private BigDecimal awayFirstDownDefRushAvg;
	private BigDecimal awayFirstDownDefPassAvg;
	private BigDecimal awayFirstDownDefPenaltyAvg;
	private BigDecimal awayFirstDownDefTotalAvg;

	private BigDecimal awayPenaltiesAvg;
	private BigDecimal awayPenaltyYardsAvg;
	
	private BigDecimal awayThirdDownOffAttAvg;
	private BigDecimal awayThirdDownOffConvAvg;
	private BigDecimal awayThirdDownOffConvPct;
	
	private BigDecimal awayThirdDownDefAttAvg;
	private BigDecimal awayThirdDownDefConvAvg;
	private BigDecimal awayThirdDownDefConvPct;

	private BigDecimal awayFourthDownOffAttAvg;
	private BigDecimal awayFourthDownOffConvAvg;
	private BigDecimal awayFourthDownOffConvPct;
	
	private BigDecimal awayFourthDownDefAttAvg;
	private BigDecimal awayFourthDownDefConvAvg;
	private BigDecimal awayFourthDownDefConvPct;

	private BigDecimal awayOffRedZoneAttAvg;
	private BigDecimal awayOffRedZoneScoresAvg;
	private BigDecimal awayOffRedZoneScorePct;
	private BigDecimal awayOffRedZoneTDsAvg;
	private BigDecimal awayOffRedZoneTDPct;
	private BigDecimal awayOffRedZoneFGsAvg;
	private BigDecimal awayOffRedZoneFGPct;
	
	private BigDecimal awayDefRedZoneAttAvg;
	private BigDecimal awayDefRedZoneScoresAvg;
	private BigDecimal awayDefRedZoneScorePct;
	private BigDecimal awayDefRedZoneTDsAvg;
	private BigDecimal awayDefRedZoneTDPct;
	private BigDecimal awayDefRedZoneFGsAvg;
	private BigDecimal awayDefRedZoneFGPct;
	
	private BigDecimal awayFumbleGainAvg;
	private BigDecimal awayFubmleLostAvg;
	private BigDecimal awayTurnoverMarginAvg;
	
	private BigDecimal awayLast5WinPct;
	private BigDecimal awayLast5WinATSPct;
	private BigDecimal awayLast5UnderPct;
	private BigDecimal awayLast5RushOffYardsAvg;
	private BigDecimal awayLast5PassOffYardsAvg;
	private BigDecimal awayLast5ScoringOffPointsAvg;
	private BigDecimal awayLast5RushDefYardsAvg;
	private BigDecimal awayLast5PassDefYardsAvg;
	private BigDecimal awayLast5ScoringDefPointsAvg;
	
	private BigDecimal awayLastSeasonWinPct;
	private BigDecimal awayLastSeasonWinATSPct;
	private BigDecimal awayLastSeasonUnderPct;
	private BigDecimal awayLastSeasonRushOffYardsAvg;
	private BigDecimal awayLastSeasonPassOffYardsAvg;
	private BigDecimal awayLastSeasonScoringOffPointsAvg;
	private BigDecimal awayLastSeasonRushDefYardsAvg;
	private BigDecimal awayLastSeasonPassDefYardsAvg;
	private BigDecimal awayLastSeasonScoringDefPointsAvg;
	
	@Override
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne  
    @JoinColumn(name="game_id")  
	public GameInfo getGame() {
		return game;
	}

	public void setGame(GameInfo game) {
		this.game = game;
	}

	public BigInteger getHomeGamesPlayed() {
		return homeGamesPlayed;
	}

	public void setHomeGamesPlayed(BigInteger homeGamesPlayed) {
		this.homeGamesPlayed = homeGamesPlayed;
	}

	public BigDecimal getHomeRushOffAttAvg() {
		return homeRushOffAttAvg;
	}

	public void setHomeRushOffAttAvg(BigDecimal homeRushOffAttAvg) {
		this.homeRushOffAttAvg = homeRushOffAttAvg;
	}

	public BigDecimal getHomeRushOffYardsAvg() {
		return homeRushOffYardsAvg;
	}

	public void setHomeRushOffYardsAvg(BigDecimal homeRushOffYardsAvg) {
		this.homeRushOffYardsAvg = homeRushOffYardsAvg;
	}

	public BigDecimal getHomeRushOffYPA() {
		return homeRushOffYPA;
	}

	public void setHomeRushOffYPA(BigDecimal homeRushOffYPA) {
		this.homeRushOffYPA = homeRushOffYPA;
	}

	public BigDecimal getHomeRushOffTDsAvg() {
		return homeRushOffTDsAvg;
	}

	public void setHomeRushOffTDsAvg(BigDecimal homeRushOffTDsAvg) {
		this.homeRushOffTDsAvg = homeRushOffTDsAvg;
	}

	public BigDecimal getHomeRushDefAttAvg() {
		return homeRushDefAttAvg;
	}

	public void setHomeRushDefAttAvg(BigDecimal homeRushDefAttAvg) {
		this.homeRushDefAttAvg = homeRushDefAttAvg;
	}

	public BigDecimal getHomeRushDefYardsAvg() {
		return homeRushDefYardsAvg;
	}

	public void setHomeRushDefYardsAvg(BigDecimal homeRushDefYardsAvg) {
		this.homeRushDefYardsAvg = homeRushDefYardsAvg;
	}

	public BigDecimal getHomeRushDefYPA() {
		return homeRushDefYPA;
	}

	public void setHomeRushDefYPA(BigDecimal homeRushDefYPA) {
		this.homeRushDefYPA = homeRushDefYPA;
	}

	public BigDecimal getHomeRushDefTDsAvg() {
		return homeRushDefTDsAvg;
	}

	public void setHomeRushDefTDsAvg(BigDecimal homeRushDefTDsAvg) {
		this.homeRushDefTDsAvg = homeRushDefTDsAvg;
	}

	public BigDecimal getHomePassOffAttAvg() {
		return homePassOffAttAvg;
	}

	public void setHomePassOffAttAvg(BigDecimal homePassOffAttAvg) {
		this.homePassOffAttAvg = homePassOffAttAvg;
	}

	public BigDecimal getHomePassOffCompAvg() {
		return homePassOffCompAvg;
	}

	public void setHomePassOffCompAvg(BigDecimal homePassOffCompAvg) {
		this.homePassOffCompAvg = homePassOffCompAvg;
	}

	public BigDecimal getHomePassOffCompPct() {
		return homePassOffCompPct;
	}

	public void setHomePassOffCompPct(BigDecimal homePassOffCompPct) {
		this.homePassOffCompPct = homePassOffCompPct;
	}

	public BigDecimal getHomePassOffYardsAvg() {
		return homePassOffYardsAvg;
	}

	public void setHomePassOffYardsAvg(BigDecimal homePassOffYardsAvg) {
		this.homePassOffYardsAvg = homePassOffYardsAvg;
	}

	public BigDecimal getHomePassOffYPA() {
		return homePassOffYPA;
	}

	public void setHomePassOffYPA(BigDecimal homePassOffYPA) {
		this.homePassOffYPA = homePassOffYPA;
	}

	public BigDecimal getHomePassOffINTsAvg() {
		return homePassOffINTsAvg;
	}

	public void setHomePassOffINTsAvg(BigDecimal homePassOffINTsAvg) {
		this.homePassOffINTsAvg = homePassOffINTsAvg;
	}

	public BigDecimal getHomePassOffTDsAvg() {
		return homePassOffTDsAvg;
	}

	public void setHomePassOffTDsAvg(BigDecimal homePassOffTDsAvg) {
		this.homePassOffTDsAvg = homePassOffTDsAvg;
	}

	public Double getHomePassOffRatingAvg() {
		return homePassOffRatingAvg;
	}

	public void setHomePassOffRatingAvg(Double homePassOffRatingAvg) {
		this.homePassOffRatingAvg = homePassOffRatingAvg;
	}

	public BigDecimal getHomePassOffYPR() {
		return homePassOffYPR;
	}

	public void setHomePassOffYPR(BigDecimal homePassOffYPR) {
		this.homePassOffYPR = homePassOffYPR;
	}

	public BigDecimal getHomePassDefAttAvg() {
		return homePassDefAttAvg;
	}

	public void setHomePassDefAttAvg(BigDecimal homePassDefAttAvg) {
		this.homePassDefAttAvg = homePassDefAttAvg;
	}

	public BigDecimal getHomePassDefCompAvg() {
		return homePassDefCompAvg;
	}

	public void setHomePassDefCompAvg(BigDecimal homePassDefCompAvg) {
		this.homePassDefCompAvg = homePassDefCompAvg;
	}

	public BigDecimal getHomePassDefCompPct() {
		return homePassDefCompPct;
	}

	public void setHomePassDefCompPct(BigDecimal homePassDefCompPct) {
		this.homePassDefCompPct = homePassDefCompPct;
	}

	public BigDecimal getHomePassDefYardsAvg() {
		return homePassDefYardsAvg;
	}

	public void setHomePassDefYardsAvg(BigDecimal homePassDefYardsAvg) {
		this.homePassDefYardsAvg = homePassDefYardsAvg;
	}

	public BigDecimal getHomePassDefYPA() {
		return homePassDefYPA;
	}

	public void setHomePassDefYPA(BigDecimal homePassDefYPA) {
		this.homePassDefYPA = homePassDefYPA;
	}

	public BigDecimal getHomePassDefINTsAvg() {
		return homePassDefINTsAvg;
	}

	public void setHomePassDefINTsAvg(BigDecimal homePassDefINTsAvg) {
		this.homePassDefINTsAvg = homePassDefINTsAvg;
	}

	public BigDecimal getHomePassDefTDsAvg() {
		return homePassDefTDsAvg;
	}

	public void setHomePassDefTDsAvg(BigDecimal homePassDefTDsAvg) {
		this.homePassDefTDsAvg = homePassDefTDsAvg;
	}

	public Double getHomePassDefRatingAvg() {
		return homePassDefRatingAvg;
	}

	public void setHomePassDefRatingAvg(Double homePassDefRatingAvg) {
		this.homePassDefRatingAvg = homePassDefRatingAvg;
	}

	public BigDecimal getHomePassDefYPR() {
		return homePassDefYPR;
	}

	public void setHomePassDefYPR(BigDecimal homePassDefYPR) {
		this.homePassDefYPR = homePassDefYPR;
	}

	public BigDecimal getHomePuntReturnsAvg() {
		return homePuntReturnsAvg;
	}

	public void setHomePuntReturnsAvg(BigDecimal homePuntReturnsAvg) {
		this.homePuntReturnsAvg = homePuntReturnsAvg;
	}

	public BigDecimal getHomePuntReturnYardsAvg() {
		return homePuntReturnYardsAvg;
	}

	public void setHomePuntReturnYardsAvg(BigDecimal homePuntReturnYardsAvg) {
		this.homePuntReturnYardsAvg = homePuntReturnYardsAvg;
	}

	public BigDecimal getHomePuntReturnAverage() {
		return homePuntReturnAverage;
	}

	public void setHomePuntReturnAverage(BigDecimal homePuntReturnAverage) {
		this.homePuntReturnAverage = homePuntReturnAverage;
	}

	public BigDecimal getHomePuntReturnTDsAvg() {
		return homePuntReturnTDsAvg;
	}

	public void setHomePuntReturnTDsAvg(BigDecimal homePuntReturnTDsAvg) {
		this.homePuntReturnTDsAvg = homePuntReturnTDsAvg;
	}

	public BigDecimal getHomePuntReturnsDefAvg() {
		return homePuntReturnsDefAvg;
	}

	public void setHomePuntReturnsDefAvg(BigDecimal homePuntReturnsDefAvg) {
		this.homePuntReturnsDefAvg = homePuntReturnsDefAvg;
	}

	public BigDecimal getHomePuntReturnYardsDefAvg() {
		return homePuntReturnYardsDefAvg;
	}

	public void setHomePuntReturnYardsDefAvg(BigDecimal homePuntReturnYardsDefAvg) {
		this.homePuntReturnYardsDefAvg = homePuntReturnYardsDefAvg;
	}

	public BigDecimal getHomePuntReturnAverageDef() {
		return homePuntReturnAverageDef;
	}

	public void setHomePuntReturnAverageDef(BigDecimal homePuntReturnAverageDef) {
		this.homePuntReturnAverageDef = homePuntReturnAverageDef;
	}

	public BigDecimal getHomePuntReturnTDsDefAvg() {
		return homePuntReturnTDsDefAvg;
	}

	public void setHomePuntReturnTDsDefAvg(BigDecimal homePuntReturnTDsDefAvg) {
		this.homePuntReturnTDsDefAvg = homePuntReturnTDsDefAvg;
	}

	public BigDecimal getHomeKickoffReturnsAvg() {
		return homeKickoffReturnsAvg;
	}

	public void setHomeKickoffReturnsAvg(BigDecimal homeKickoffReturnsAvg) {
		this.homeKickoffReturnsAvg = homeKickoffReturnsAvg;
	}

	public BigDecimal getHomeKickoffReturnYardsAvg() {
		return homeKickoffReturnYardsAvg;
	}

	public void setHomeKickoffReturnYardsAvg(BigDecimal homeKickoffReturnYardsAvg) {
		this.homeKickoffReturnYardsAvg = homeKickoffReturnYardsAvg;
	}

	public BigDecimal getHomeKickoffReturnAverage() {
		return homeKickoffReturnAverage;
	}

	public void setHomeKickoffReturnAverage(BigDecimal homeKickoffReturnAverage) {
		this.homeKickoffReturnAverage = homeKickoffReturnAverage;
	}

	public BigDecimal getHomeKickoffReturnTDsAvg() {
		return homeKickoffReturnTDsAvg;
	}

	public void setHomeKickoffReturnTDsAvg(BigDecimal homeKickoffReturnTDsAvg) {
		this.homeKickoffReturnTDsAvg = homeKickoffReturnTDsAvg;
	}

	public BigDecimal getHomeKickoffReturnsDefAvg() {
		return homeKickoffReturnsDefAvg;
	}

	public void setHomeKickoffReturnsDefAvg(BigDecimal homeKickoffReturnsDefAvg) {
		this.homeKickoffReturnsDefAvg = homeKickoffReturnsDefAvg;
	}

	public BigDecimal getHomeKickoffReturnYardsDefAvg() {
		return homeKickoffReturnYardsDefAvg;
	}

	public void setHomeKickoffReturnYardsDefAvg(
			BigDecimal homeKickoffReturnYardsDefAvg) {
		this.homeKickoffReturnYardsDefAvg = homeKickoffReturnYardsDefAvg;
	}

	public BigDecimal getHomeKickoffReturnAverageDef() {
		return homeKickoffReturnAverageDef;
	}

	public void setHomeKickoffReturnAverageDef(
			BigDecimal homeKickoffReturnAverageDef) {
		this.homeKickoffReturnAverageDef = homeKickoffReturnAverageDef;
	}

	public BigDecimal getHomeKickoffReturnTDsDefAvg() {
		return homeKickoffReturnTDsDefAvg;
	}

	public void setHomeKickoffReturnTDsDefAvg(BigDecimal homeKickoffReturnTDsDefAvg) {
		this.homeKickoffReturnTDsDefAvg = homeKickoffReturnTDsDefAvg;
	}

	public BigDecimal getHomePuntsAvg() {
		return homePuntsAvg;
	}

	public void setHomePuntsAvg(BigDecimal homePuntsAvg) {
		this.homePuntsAvg = homePuntsAvg;
	}

	public BigDecimal getHomePuntYardsAvg() {
		return homePuntYardsAvg;
	}

	public void setHomePuntYardsAvg(BigDecimal homePuntYardsAvg) {
		this.homePuntYardsAvg = homePuntYardsAvg;
	}

	public BigDecimal getHomePuntAverage() {
		return homePuntAverage;
	}

	public void setHomePuntAverage(BigDecimal homePuntAverage) {
		this.homePuntAverage = homePuntAverage;
	}

	public BigDecimal getHomeKickoffsAvg() {
		return homeKickoffsAvg;
	}

	public void setHomeKickoffsAvg(BigDecimal homeKickoffsAvg) {
		this.homeKickoffsAvg = homeKickoffsAvg;
	}

	public BigDecimal getHomeKickoffYardsAvg() {
		return homeKickoffYardsAvg;
	}

	public void setHomeKickoffYardsAvg(BigDecimal homeKickoffYardsAvg) {
		this.homeKickoffYardsAvg = homeKickoffYardsAvg;
	}

	public BigDecimal getHomeKickoffAverage() {
		return homeKickoffAverage;
	}

	public void setHomeKickoffAverage(BigDecimal homeKickoffAverage) {
		this.homeKickoffAverage = homeKickoffAverage;
	}

	public BigDecimal getHomeKickoffTouchbackAvg() {
		return homeKickoffTouchbackAvg;
	}

	public void setHomeKickoffTouchbackAvg(BigDecimal homeKickoffTouchbackAvg) {
		this.homeKickoffTouchbackAvg = homeKickoffTouchbackAvg;
	}

	public BigDecimal getHomeKickoffTouchbackPct() {
		return homeKickoffTouchbackPct;
	}

	public void setHomeKickoffTouchbackPct(BigDecimal homeKickoffTouchbackPct) {
		this.homeKickoffTouchbackPct = homeKickoffTouchbackPct;
	}

	public BigDecimal getHomeKickoffOutOfBoundsAvg() {
		return homeKickoffOutOfBoundsAvg;
	}

	public void setHomeKickoffOutOfBoundsAvg(BigDecimal homeKickoffOutOfBoundsAvg) {
		this.homeKickoffOutOfBoundsAvg = homeKickoffOutOfBoundsAvg;
	}

	public BigDecimal getHomeKickoffOnSideAvg() {
		return homeKickoffOnSideAvg;
	}

	public void setHomeKickoffOnSideAvg(BigDecimal homeKickoffOnSideAvg) {
		this.homeKickoffOnSideAvg = homeKickoffOnSideAvg;
	}

	public BigDecimal getHomeFGOffAttAvg() {
		return homeFGOffAttAvg;
	}

	public void setHomeFGOffAttAvg(BigDecimal homeFGOffAttAvg) {
		this.homeFGOffAttAvg = homeFGOffAttAvg;
	}

	public BigDecimal getHomeFGOffMadeAvg() {
		return homeFGOffMadeAvg;
	}

	public void setHomeFGOffMadeAvg(BigDecimal homeFGOffMadeAvg) {
		this.homeFGOffMadeAvg = homeFGOffMadeAvg;
	}

	public BigDecimal getHomeFGOffPct() {
		return homeFGOffPct;
	}

	public void setHomeFGOffPct(BigDecimal homeFGOffPct) {
		this.homeFGOffPct = homeFGOffPct;
	}

	public BigDecimal getHomeFGDefAttAvg() {
		return homeFGDefAttAvg;
	}

	public void setHomeFGDefAttAvg(BigDecimal homeFGDefAttAvg) {
		this.homeFGDefAttAvg = homeFGDefAttAvg;
	}

	public BigDecimal getHomeFGDefMadeAvg() {
		return homeFGDefMadeAvg;
	}

	public void setHomeFGDefMadeAvg(BigDecimal homeFGDefMadeAvg) {
		this.homeFGDefMadeAvg = homeFGDefMadeAvg;
	}

	public BigDecimal getHomeFGDefPct() {
		return homeFGDefPct;
	}

	public void setHomeFGDefPct(BigDecimal homeFGDefPct) {
		this.homeFGDefPct = homeFGDefPct;
	}

	public BigDecimal getHomeScoringOffTDsAvg() {
		return homeScoringOffTDsAvg;
	}

	public void setHomeScoringOffTDsAvg(BigDecimal homeScoringOffTDsAvg) {
		this.homeScoringOffTDsAvg = homeScoringOffTDsAvg;
	}

	public BigDecimal getHomeScoringOff2PtConvAvg() {
		return homeScoringOff2PtConvAvg;
	}

	public void setHomeScoringOff2PtConvAvg(BigDecimal homeScoringOff2PtConvAvg) {
		this.homeScoringOff2PtConvAvg = homeScoringOff2PtConvAvg;
	}

	public BigDecimal getHomeScoringOffSafetiesAvg() {
		return homeScoringOffSafetiesAvg;
	}

	public void setHomeScoringOffSafetiesAvg(BigDecimal homeScoringOffSafetiesAvg) {
		this.homeScoringOffSafetiesAvg = homeScoringOffSafetiesAvg;
	}

	public BigDecimal getHomeScoringOffPointsAvg() {
		return homeScoringOffPointsAvg;
	}

	public void setHomeScoringOffPointsAvg(BigDecimal homeScoringOffPointsAvg) {
		this.homeScoringOffPointsAvg = homeScoringOffPointsAvg;
	}

	public BigDecimal getHomeScoringDefTDsAvg() {
		return homeScoringDefTDsAvg;
	}

	public void setHomeScoringDefTDsAvg(BigDecimal homeScoringDefTDsAvg) {
		this.homeScoringDefTDsAvg = homeScoringDefTDsAvg;
	}

	public BigDecimal getHomeScoringDef2PtConvAvg() {
		return homeScoringDef2PtConvAvg;
	}

	public void setHomeScoringDef2PtConvAvg(BigDecimal homeScoringDef2PtConvAvg) {
		this.homeScoringDef2PtConvAvg = homeScoringDef2PtConvAvg;
	}

	public BigDecimal getHomeScoringDefSafetiesAvg() {
		return homeScoringDefSafetiesAvg;
	}

	public void setHomeScoringDefSafetiesAvg(BigDecimal homeScoringDefSafetiesAvg) {
		this.homeScoringDefSafetiesAvg = homeScoringDefSafetiesAvg;
	}

	public BigDecimal getHomeScoringDefPointsAvg() {
		return homeScoringDefPointsAvg;
	}

	public void setHomeScoringDefPointsAvg(BigDecimal homeScoringDefPointsAvg) {
		this.homeScoringDefPointsAvg = homeScoringDefPointsAvg;
	}

	public BigDecimal getHomeTotalOffPlaysAvg() {
		return homeTotalOffPlaysAvg;
	}

	public void setHomeTotalOffPlaysAvg(BigDecimal homeTotalOffPlaysAvg) {
		this.homeTotalOffPlaysAvg = homeTotalOffPlaysAvg;
	}

	public BigDecimal getHomeTotalOffYardsAvg() {
		return homeTotalOffYardsAvg;
	}

	public void setHomeTotalOffYardsAvg(BigDecimal homeTotalOffYardsAvg) {
		this.homeTotalOffYardsAvg = homeTotalOffYardsAvg;
	}

	public BigDecimal getHomeTotalOffYPP() {
		return homeTotalOffYPP;
	}

	public void setHomeTotalOffYPP(BigDecimal homeTotalOffYPP) {
		this.homeTotalOffYPP = homeTotalOffYPP;
	}

	public BigDecimal getHomeTotalDefPlaysAvg() {
		return homeTotalDefPlaysAvg;
	}

	public void setHomeTotalDefPlaysAvg(BigDecimal homeTotalDefPlaysAvg) {
		this.homeTotalDefPlaysAvg = homeTotalDefPlaysAvg;
	}

	public BigDecimal getHomeTotalDefYardsAvg() {
		return homeTotalDefYardsAvg;
	}

	public void setHomeTotalDefYardsAvg(BigDecimal homeTotalDefYardsAvg) {
		this.homeTotalDefYardsAvg = homeTotalDefYardsAvg;
	}

	public BigDecimal getHomeTotalDefYPP() {
		return homeTotalDefYPP;
	}

	public void setHomeTotalDefYPP(BigDecimal homeTotalDefYPP) {
		this.homeTotalDefYPP = homeTotalDefYPP;
	}

	public BigDecimal getHomePassDefIntYardsAvg() {
		return homePassDefIntYardsAvg;
	}

	public void setHomePassDefIntYardsAvg(BigDecimal homePassDefIntYardsAvg) {
		this.homePassDefIntYardsAvg = homePassDefIntYardsAvg;
	}

	public BigDecimal getHomePassDefIntTDsAvg() {
		return homePassDefIntTDsAvg;
	}

	public void setHomePassDefIntTDsAvg(BigDecimal homePassDefIntTDsAvg) {
		this.homePassDefIntTDsAvg = homePassDefIntTDsAvg;
	}

	public BigDecimal getHomeFumbleReturnsAvg() {
		return homeFumbleReturnsAvg;
	}

	public void setHomeFumbleReturnsAvg(BigDecimal homeFumbleReturnsAvg) {
		this.homeFumbleReturnsAvg = homeFumbleReturnsAvg;
	}

	public BigDecimal getHomeFumbleReturnYardsAvg() {
		return homeFumbleReturnYardsAvg;
	}

	public void setHomeFumbleReturnYardsAvg(BigDecimal homeFumbleReturnYardsAvg) {
		this.homeFumbleReturnYardsAvg = homeFumbleReturnYardsAvg;
	}

	public BigDecimal getHomeFumbleReturnTDsAvg() {
		return homeFumbleReturnTDsAvg;
	}

	public void setHomeFumbleReturnTDsAvg(BigDecimal homeFumbleReturnTDsAvg) {
		this.homeFumbleReturnTDsAvg = homeFumbleReturnTDsAvg;
	}

	public BigDecimal getHomeTotalTacklesAvg() {
		return homeTotalTacklesAvg;
	}

	public void setHomeTotalTacklesAvg(BigDecimal homeTotalTacklesAvg) {
		this.homeTotalTacklesAvg = homeTotalTacklesAvg;
	}

	public BigDecimal getHomeTFLsAvg() {
		return homeTFLsAvg;
	}

	public void setHomeTFLsAvg(BigDecimal homeTFLsAvg) {
		this.homeTFLsAvg = homeTFLsAvg;
	}

	public BigDecimal getHomeTFLYardsAvg() {
		return homeTFLYardsAvg;
	}

	public void setHomeTFLYardsAvg(BigDecimal homeTFLYardsAvg) {
		this.homeTFLYardsAvg = homeTFLYardsAvg;
	}

	public BigDecimal getHomeSacksAvg() {
		return homeSacksAvg;
	}

	public void setHomeSacksAvg(BigDecimal homeSacksAvg) {
		this.homeSacksAvg = homeSacksAvg;
	}

	public BigDecimal getHomeSackYardsAvg() {
		return homeSackYardsAvg;
	}

	public void setHomeSackYardsAvg(BigDecimal homeSackYardsAvg) {
		this.homeSackYardsAvg = homeSackYardsAvg;
	}

	public BigDecimal getHomeSacksAllowedAvg() {
		return homeSacksAllowedAvg;
	}

	public void setHomeSacksAllowedAvg(BigDecimal homeSacksAllowedAvg) {
		this.homeSacksAllowedAvg = homeSacksAllowedAvg;
	}

	public BigDecimal getHomeSackYardsAllowedAvg() {
		return homeSackYardsAllowedAvg;
	}

	public void setHomeSackYardsAllowedAvg(BigDecimal homeSackYardsAllowedAvg) {
		this.homeSackYardsAllowedAvg = homeSackYardsAllowedAvg;
	}

	public BigDecimal getHomePassesBrokenUpAvg() {
		return homePassesBrokenUpAvg;
	}

	public void setHomePassesBrokenUpAvg(BigDecimal homePassesBrokenUpAvg) {
		this.homePassesBrokenUpAvg = homePassesBrokenUpAvg;
	}

	public BigDecimal getHomeQBHurriesAvg() {
		return homeQBHurriesAvg;
	}

	public void setHomeQBHurriesAvg(BigDecimal homeQBHurriesAvg) {
		this.homeQBHurriesAvg = homeQBHurriesAvg;
	}

	public BigDecimal getHomeFumblesForcedAvg() {
		return homeFumblesForcedAvg;
	}

	public void setHomeFumblesForcedAvg(BigDecimal homeFumblesForcedAvg) {
		this.homeFumblesForcedAvg = homeFumblesForcedAvg;
	}

	public BigDecimal getHomePuntKicksBlockedAvg() {
		return homePuntKicksBlockedAvg;
	}

	public void setHomePuntKicksBlockedAvg(BigDecimal homePuntKicksBlockedAvg) {
		this.homePuntKicksBlockedAvg = homePuntKicksBlockedAvg;
	}

	public BigDecimal getHomeQBHurriesAllowedAvg() {
		return homeQBHurriesAllowedAvg;
	}

	public void setHomeQBHurriesAllowedAvg(BigDecimal homeQBHurriesAllowedAvg) {
		this.homeQBHurriesAllowedAvg = homeQBHurriesAllowedAvg;
	}

	public BigDecimal getHomeFirstDownOffRushAvg() {
		return homeFirstDownOffRushAvg;
	}

	public void setHomeFirstDownOffRushAvg(BigDecimal homeFirstDownOffRushAvg) {
		this.homeFirstDownOffRushAvg = homeFirstDownOffRushAvg;
	}

	public BigDecimal getHomeFirstDownOffPassAvg() {
		return homeFirstDownOffPassAvg;
	}

	public void setHomeFirstDownOffPassAvg(BigDecimal homeFirstDownOffPassAvg) {
		this.homeFirstDownOffPassAvg = homeFirstDownOffPassAvg;
	}

	public BigDecimal getHomeFirstDownOffPenaltyAvg() {
		return homeFirstDownOffPenaltyAvg;
	}

	public void setHomeFirstDownOffPenaltyAvg(BigDecimal homeFirstDownOffPenaltyAvg) {
		this.homeFirstDownOffPenaltyAvg = homeFirstDownOffPenaltyAvg;
	}

	public BigDecimal getHomeFirstDownOffTotalAvg() {
		return homeFirstDownOffTotalAvg;
	}

	public void setHomeFirstDownOffTotalAvg(BigDecimal homeFirstDownOffTotalAvg) {
		this.homeFirstDownOffTotalAvg = homeFirstDownOffTotalAvg;
	}

	public BigDecimal getHomeFirstDownDefRushAvg() {
		return homeFirstDownDefRushAvg;
	}

	public void setHomeFirstDownDefRushAvg(BigDecimal homeFirstDownDefRushAvg) {
		this.homeFirstDownDefRushAvg = homeFirstDownDefRushAvg;
	}

	public BigDecimal getHomeFirstDownDefPassAvg() {
		return homeFirstDownDefPassAvg;
	}

	public void setHomeFirstDownDefPassAvg(BigDecimal homeFirstDownDefPassAvg) {
		this.homeFirstDownDefPassAvg = homeFirstDownDefPassAvg;
	}

	public BigDecimal getHomeFirstDownDefPenaltyAvg() {
		return homeFirstDownDefPenaltyAvg;
	}

	public void setHomeFirstDownDefPenaltyAvg(BigDecimal homeFirstDownDefPenaltyAvg) {
		this.homeFirstDownDefPenaltyAvg = homeFirstDownDefPenaltyAvg;
	}

	public BigDecimal getHomeFirstDownDefTotalAvg() {
		return homeFirstDownDefTotalAvg;
	}

	public void setHomeFirstDownDefTotalAvg(BigDecimal homeFirstDownDefTotalAvg) {
		this.homeFirstDownDefTotalAvg = homeFirstDownDefTotalAvg;
	}

	public BigDecimal getHomePenaltiesAvg() {
		return homePenaltiesAvg;
	}

	public void setHomePenaltiesAvg(BigDecimal homePenaltiesAvg) {
		this.homePenaltiesAvg = homePenaltiesAvg;
	}

	public BigDecimal getHomePenaltyYardsAvg() {
		return homePenaltyYardsAvg;
	}

	public void setHomePenaltyYardsAvg(BigDecimal homePenaltyYardsAvg) {
		this.homePenaltyYardsAvg = homePenaltyYardsAvg;
	}

	public BigDecimal getHomeThirdDownOffAttAvg() {
		return homeThirdDownOffAttAvg;
	}

	public void setHomeThirdDownOffAttAvg(BigDecimal homeThirdDownOffAttAvg) {
		this.homeThirdDownOffAttAvg = homeThirdDownOffAttAvg;
	}

	public BigDecimal getHomeThirdDownOffConvAvg() {
		return homeThirdDownOffConvAvg;
	}

	public void setHomeThirdDownOffConvAvg(BigDecimal homeThirdDownOffConvAvg) {
		this.homeThirdDownOffConvAvg = homeThirdDownOffConvAvg;
	}

	public BigDecimal getHomeThirdDownOffConvPct() {
		return homeThirdDownOffConvPct;
	}

	public void setHomeThirdDownOffConvPct(BigDecimal homeThirdDownOffConvPct) {
		this.homeThirdDownOffConvPct = homeThirdDownOffConvPct;
	}

	public BigDecimal getHomeThirdDownDefAttAvg() {
		return homeThirdDownDefAttAvg;
	}

	public void setHomeThirdDownDefAttAvg(BigDecimal homeThirdDownDefAttAvg) {
		this.homeThirdDownDefAttAvg = homeThirdDownDefAttAvg;
	}

	public BigDecimal getHomeThirdDownDefConvAvg() {
		return homeThirdDownDefConvAvg;
	}

	public void setHomeThirdDownDefConvAvg(BigDecimal homeThirdDownDefConvAvg) {
		this.homeThirdDownDefConvAvg = homeThirdDownDefConvAvg;
	}

	public BigDecimal getHomeThirdDownDefConvPct() {
		return homeThirdDownDefConvPct;
	}

	public void setHomeThirdDownDefConvPct(BigDecimal homeThirdDownDefConvPct) {
		this.homeThirdDownDefConvPct = homeThirdDownDefConvPct;
	}

	public BigDecimal getHomeFourthDownOffAttAvg() {
		return homeFourthDownOffAttAvg;
	}

	public void setHomeFourthDownOffAttAvg(BigDecimal homeFourthDownOffAttAvg) {
		this.homeFourthDownOffAttAvg = homeFourthDownOffAttAvg;
	}

	public BigDecimal getHomeFourthDownOffConvAvg() {
		return homeFourthDownOffConvAvg;
	}

	public void setHomeFourthDownOffConvAvg(BigDecimal homeFourthDownOffConvAvg) {
		this.homeFourthDownOffConvAvg = homeFourthDownOffConvAvg;
	}

	public BigDecimal getHomeFourthDownOffConvPct() {
		return homeFourthDownOffConvPct;
	}

	public void setHomeFourthDownOffConvPct(BigDecimal homeFourthDownOffConvPct) {
		this.homeFourthDownOffConvPct = homeFourthDownOffConvPct;
	}

	public BigDecimal getHomeFourthDownDefAttAvg() {
		return homeFourthDownDefAttAvg;
	}

	public void setHomeFourthDownDefAttAvg(BigDecimal homeFourthDownDefAttAvg) {
		this.homeFourthDownDefAttAvg = homeFourthDownDefAttAvg;
	}

	public BigDecimal getHomeFourthDownDefConvAvg() {
		return homeFourthDownDefConvAvg;
	}

	public void setHomeFourthDownDefConvAvg(BigDecimal homeFourthDownDefConvAvg) {
		this.homeFourthDownDefConvAvg = homeFourthDownDefConvAvg;
	}

	public BigDecimal getHomeFourthDownDefConvPct() {
		return homeFourthDownDefConvPct;
	}

	public void setHomeFourthDownDefConvPct(BigDecimal homeFourthDownDefConvPct) {
		this.homeFourthDownDefConvPct = homeFourthDownDefConvPct;
	}

	public BigDecimal getHomeOffRedZoneAttAvg() {
		return homeOffRedZoneAttAvg;
	}

	public void setHomeOffRedZoneAttAvg(BigDecimal homeOffRedZoneAttAvg) {
		this.homeOffRedZoneAttAvg = homeOffRedZoneAttAvg;
	}

	public BigDecimal getHomeOffRedZoneScoresAvg() {
		return homeOffRedZoneScoresAvg;
	}

	public void setHomeOffRedZoneScoresAvg(BigDecimal homeOffRedZoneScoresAvg) {
		this.homeOffRedZoneScoresAvg = homeOffRedZoneScoresAvg;
	}

	public BigDecimal getHomeOffRedZoneScorePct() {
		return homeOffRedZoneScorePct;
	}

	public void setHomeOffRedZoneScorePct(BigDecimal homeOffRedZoneScorePct) {
		this.homeOffRedZoneScorePct = homeOffRedZoneScorePct;
	}

	public BigDecimal getHomeOffRedZoneTDsAvg() {
		return homeOffRedZoneTDsAvg;
	}

	public void setHomeOffRedZoneTDsAvg(BigDecimal homeOffRedZoneTDsAvg) {
		this.homeOffRedZoneTDsAvg = homeOffRedZoneTDsAvg;
	}

	public BigDecimal getHomeOffRedZoneTDPct() {
		return homeOffRedZoneTDPct;
	}

	public void setHomeOffRedZoneTDPct(BigDecimal homeOffRedZoneTDPct) {
		this.homeOffRedZoneTDPct = homeOffRedZoneTDPct;
	}

	public BigDecimal getHomeOffRedZoneFGsAvg() {
		return homeOffRedZoneFGsAvg;
	}

	public void setHomeOffRedZoneFGsAvg(BigDecimal homeOffRedZoneFGsAvg) {
		this.homeOffRedZoneFGsAvg = homeOffRedZoneFGsAvg;
	}

	public BigDecimal getHomeOffRedZoneFGPct() {
		return homeOffRedZoneFGPct;
	}

	public void setHomeOffRedZoneFGPct(BigDecimal homeOffRedZoneFGPct) {
		this.homeOffRedZoneFGPct = homeOffRedZoneFGPct;
	}

	public BigDecimal getHomeDefRedZoneAttAvg() {
		return homeDefRedZoneAttAvg;
	}

	public void setHomeDefRedZoneAttAvg(BigDecimal homeDefRedZoneAttAvg) {
		this.homeDefRedZoneAttAvg = homeDefRedZoneAttAvg;
	}

	public BigDecimal getHomeDefRedZoneScoresAvg() {
		return homeDefRedZoneScoresAvg;
	}

	public void setHomeDefRedZoneScoresAvg(BigDecimal homeDefRedZoneScoresAvg) {
		this.homeDefRedZoneScoresAvg = homeDefRedZoneScoresAvg;
	}

	public BigDecimal getHomeDefRedZoneScorePct() {
		return homeDefRedZoneScorePct;
	}

	public void setHomeDefRedZoneScorePct(BigDecimal homeDefRedZoneScorePct) {
		this.homeDefRedZoneScorePct = homeDefRedZoneScorePct;
	}

	public BigDecimal getHomeDefRedZoneTDsAvg() {
		return homeDefRedZoneTDsAvg;
	}

	public void setHomeDefRedZoneTDsAvg(BigDecimal homeDefRedZoneTDsAvg) {
		this.homeDefRedZoneTDsAvg = homeDefRedZoneTDsAvg;
	}

	public BigDecimal getHomeDefRedZoneTDPct() {
		return homeDefRedZoneTDPct;
	}

	public void setHomeDefRedZoneTDPct(BigDecimal homeDefRedZoneTDPct) {
		this.homeDefRedZoneTDPct = homeDefRedZoneTDPct;
	}

	public BigDecimal getHomeDefRedZoneFGsAvg() {
		return homeDefRedZoneFGsAvg;
	}

	public void setHomeDefRedZoneFGsAvg(BigDecimal homeDefRedZoneFGsAvg) {
		this.homeDefRedZoneFGsAvg = homeDefRedZoneFGsAvg;
	}

	public BigDecimal getHomeDefRedZoneFGPct() {
		return homeDefRedZoneFGPct;
	}

	public void setHomeDefRedZoneFGPct(BigDecimal homeDefRedZoneFGPct) {
		this.homeDefRedZoneFGPct = homeDefRedZoneFGPct;
	}

	public BigDecimal getHomeFumbleGainAvg() {
		return homeFumbleGainAvg;
	}

	public void setHomeFumbleGainAvg(BigDecimal homeFumbleGainAvg) {
		this.homeFumbleGainAvg = homeFumbleGainAvg;
	}

	public BigDecimal getHomeFubmleLostAvg() {
		return homeFubmleLostAvg;
	}

	public void setHomeFubmleLostAvg(BigDecimal homeFubmleLostAvg) {
		this.homeFubmleLostAvg = homeFubmleLostAvg;
	}

	public BigDecimal getHomeTurnoverMarginAvg() {
		return homeTurnoverMarginAvg;
	}

	public void setHomeTurnoverMarginAvg(BigDecimal homeTurnoverMarginAvg) {
		this.homeTurnoverMarginAvg = homeTurnoverMarginAvg;
	}

	public BigDecimal getHomeLast5WinPct() {
		return homeLast5WinPct;
	}

	public void setHomeLast5WinPct(BigDecimal homeLast5WinPct) {
		this.homeLast5WinPct = homeLast5WinPct;
	}

	public BigDecimal getHomeLast5WinATSPct() {
		return homeLast5WinATSPct;
	}

	public void setHomeLast5WinATSPct(BigDecimal homeLast5WinATSPct) {
		this.homeLast5WinATSPct = homeLast5WinATSPct;
	}

	public BigDecimal getHomeLast5RushOffYardsAvg() {
		return homeLast5RushOffYardsAvg;
	}

	public void setHomeLast5RushOffYardsAvg(BigDecimal homeLast5RushOffYardsAvg) {
		this.homeLast5RushOffYardsAvg = homeLast5RushOffYardsAvg;
	}

	public BigDecimal getHomeLast5PassOffYardsAvg() {
		return homeLast5PassOffYardsAvg;
	}

	public void setHomeLast5PassOffYardsAvg(BigDecimal homeLast5PassOffYardsAvg) {
		this.homeLast5PassOffYardsAvg = homeLast5PassOffYardsAvg;
	}

	public BigDecimal getHomeLast5ScoringOffPointsAvg() {
		return homeLast5ScoringOffPointsAvg;
	}

	public void setHomeLast5ScoringOffPointsAvg(
			BigDecimal homeLast5ScoringOffPointsAvg) {
		this.homeLast5ScoringOffPointsAvg = homeLast5ScoringOffPointsAvg;
	}

	public BigDecimal getHomeLast5RushDefYardsAvg() {
		return homeLast5RushDefYardsAvg;
	}

	public void setHomeLast5RushDefYardsAvg(BigDecimal homeLast5RushDefYardsAvg) {
		this.homeLast5RushDefYardsAvg = homeLast5RushDefYardsAvg;
	}

	public BigDecimal getHomeLast5PassDefYardsAvg() {
		return homeLast5PassDefYardsAvg;
	}

	public void setHomeLast5PassDefYardsAvg(BigDecimal homeLast5PassDefYardsAvg) {
		this.homeLast5PassDefYardsAvg = homeLast5PassDefYardsAvg;
	}

	public BigDecimal getHomeLast5ScoringDefPointsAvg() {
		return homeLast5ScoringDefPointsAvg;
	}

	public void setHomeLast5ScoringDefPointsAvg(
			BigDecimal homeLast5ScoringDefPointsAvg) {
		this.homeLast5ScoringDefPointsAvg = homeLast5ScoringDefPointsAvg;
	}

	public BigDecimal getHomeLastSeasonWinPct() {
		return homeLastSeasonWinPct;
	}

	public void setHomeLastSeasonWinPct(BigDecimal homeLastSeasonWinPct) {
		this.homeLastSeasonWinPct = homeLastSeasonWinPct;
	}

	public BigDecimal getHomeLastSeasonWinATSPct() {
		return homeLastSeasonWinATSPct;
	}

	public void setHomeLastSeasonWinATSPct(BigDecimal homeLastSeasonWinATSPct) {
		this.homeLastSeasonWinATSPct = homeLastSeasonWinATSPct;
	}

	public BigDecimal getHomeLastSeasonRushOffYardsAvg() {
		return homeLastSeasonRushOffYardsAvg;
	}

	public void setHomeLastSeasonRushOffYardsAvg(
			BigDecimal homeLastSeasonRushOffYardsAvg) {
		this.homeLastSeasonRushOffYardsAvg = homeLastSeasonRushOffYardsAvg;
	}

	public BigDecimal getHomeLastSeasonPassOffYardsAvg() {
		return homeLastSeasonPassOffYardsAvg;
	}

	public void setHomeLastSeasonPassOffYardsAvg(
			BigDecimal homeLastSeasonPassOffYardsAvg) {
		this.homeLastSeasonPassOffYardsAvg = homeLastSeasonPassOffYardsAvg;
	}

	public BigDecimal getHomeLastSeasonScoringOffPointsAvg() {
		return homeLastSeasonScoringOffPointsAvg;
	}

	public void setHomeLastSeasonScoringOffPointsAvg(
			BigDecimal homeLastSeasonScoringOffPointsAvg) {
		this.homeLastSeasonScoringOffPointsAvg = homeLastSeasonScoringOffPointsAvg;
	}

	public BigDecimal getHomeLastSeasonRushDefYardsAvg() {
		return homeLastSeasonRushDefYardsAvg;
	}

	public void setHomeLastSeasonRushDefYardsAvg(
			BigDecimal homeLastSeasonRushDefYardsAvg) {
		this.homeLastSeasonRushDefYardsAvg = homeLastSeasonRushDefYardsAvg;
	}

	public BigDecimal getHomeLastSeasonPassDefYardsAvg() {
		return homeLastSeasonPassDefYardsAvg;
	}

	public void setHomeLastSeasonPassDefYardsAvg(
			BigDecimal homeLastSeasonPassDefYardsAvg) {
		this.homeLastSeasonPassDefYardsAvg = homeLastSeasonPassDefYardsAvg;
	}

	public BigDecimal getHomeLastSeasonScoringDefPointsAvg() {
		return homeLastSeasonScoringDefPointsAvg;
	}

	public void setHomeLastSeasonScoringDefPointsAvg(
			BigDecimal homeLastSeasonScoringDefPointsAvg) {
		this.homeLastSeasonScoringDefPointsAvg = homeLastSeasonScoringDefPointsAvg;
	}

	public BigInteger getAwayGamesPlayed() {
		return awayGamesPlayed;
	}

	public void setAwayGamesPlayed(BigInteger awayGamesPlayed) {
		this.awayGamesPlayed = awayGamesPlayed;
	}

	public BigDecimal getAwayRushOffAttAvg() {
		return awayRushOffAttAvg;
	}

	public void setAwayRushOffAttAvg(BigDecimal awayRushOffAttAvg) {
		this.awayRushOffAttAvg = awayRushOffAttAvg;
	}

	public BigDecimal getAwayRushOffYardsAvg() {
		return awayRushOffYardsAvg;
	}

	public void setAwayRushOffYardsAvg(BigDecimal awayRushOffYardsAvg) {
		this.awayRushOffYardsAvg = awayRushOffYardsAvg;
	}

	public BigDecimal getAwayRushOffYPA() {
		return awayRushOffYPA;
	}

	public void setAwayRushOffYPA(BigDecimal awayRushOffYPA) {
		this.awayRushOffYPA = awayRushOffYPA;
	}

	public BigDecimal getAwayRushOffTDsAvg() {
		return awayRushOffTDsAvg;
	}

	public void setAwayRushOffTDsAvg(BigDecimal awayRushOffTDsAvg) {
		this.awayRushOffTDsAvg = awayRushOffTDsAvg;
	}

	public BigDecimal getAwayRushDefAttAvg() {
		return awayRushDefAttAvg;
	}

	public void setAwayRushDefAttAvg(BigDecimal awayRushDefAttAvg) {
		this.awayRushDefAttAvg = awayRushDefAttAvg;
	}

	public BigDecimal getAwayRushDefYardsAvg() {
		return awayRushDefYardsAvg;
	}

	public void setAwayRushDefYardsAvg(BigDecimal awayRushDefYardsAvg) {
		this.awayRushDefYardsAvg = awayRushDefYardsAvg;
	}

	public BigDecimal getAwayRushDefYPA() {
		return awayRushDefYPA;
	}

	public void setAwayRushDefYPA(BigDecimal awayRushDefYPA) {
		this.awayRushDefYPA = awayRushDefYPA;
	}

	public BigDecimal getAwayRushDefTDsAvg() {
		return awayRushDefTDsAvg;
	}

	public void setAwayRushDefTDsAvg(BigDecimal awayRushDefTDsAvg) {
		this.awayRushDefTDsAvg = awayRushDefTDsAvg;
	}

	public BigDecimal getAwayPassOffAttAvg() {
		return awayPassOffAttAvg;
	}

	public void setAwayPassOffAttAvg(BigDecimal awayPassOffAttAvg) {
		this.awayPassOffAttAvg = awayPassOffAttAvg;
	}

	public BigDecimal getAwayPassOffCompAvg() {
		return awayPassOffCompAvg;
	}

	public void setAwayPassOffCompAvg(BigDecimal awayPassOffCompAvg) {
		this.awayPassOffCompAvg = awayPassOffCompAvg;
	}

	public BigDecimal getAwayPassOffCompPct() {
		return awayPassOffCompPct;
	}

	public void setAwayPassOffCompPct(BigDecimal awayPassOffCompPct) {
		this.awayPassOffCompPct = awayPassOffCompPct;
	}

	public BigDecimal getAwayPassOffYardsAvg() {
		return awayPassOffYardsAvg;
	}

	public void setAwayPassOffYardsAvg(BigDecimal awayPassOffYardsAvg) {
		this.awayPassOffYardsAvg = awayPassOffYardsAvg;
	}

	public BigDecimal getAwayPassOffYPA() {
		return awayPassOffYPA;
	}

	public void setAwayPassOffYPA(BigDecimal awayPassOffYPA) {
		this.awayPassOffYPA = awayPassOffYPA;
	}

	public BigDecimal getAwayPassOffINTsAvg() {
		return awayPassOffINTsAvg;
	}

	public void setAwayPassOffINTsAvg(BigDecimal awayPassOffINTsAvg) {
		this.awayPassOffINTsAvg = awayPassOffINTsAvg;
	}

	public BigDecimal getAwayPassOffTDsAvg() {
		return awayPassOffTDsAvg;
	}

	public void setAwayPassOffTDsAvg(BigDecimal awayPassOffTDsAvg) {
		this.awayPassOffTDsAvg = awayPassOffTDsAvg;
	}

	public Double getAwayPassOffRatingAvg() {
		return awayPassOffRatingAvg;
	}

	public void setAwayPassOffRatingAvg(Double awayPassOffRatingAvg) {
		this.awayPassOffRatingAvg = awayPassOffRatingAvg;
	}

	public BigDecimal getAwayPassOffYPR() {
		return awayPassOffYPR;
	}

	public void setAwayPassOffYPR(BigDecimal awayPassOffYPR) {
		this.awayPassOffYPR = awayPassOffYPR;
	}

	public BigDecimal getAwayPassDefAttAvg() {
		return awayPassDefAttAvg;
	}

	public void setAwayPassDefAttAvg(BigDecimal awayPassDefAttAvg) {
		this.awayPassDefAttAvg = awayPassDefAttAvg;
	}

	public BigDecimal getAwayPassDefCompAvg() {
		return awayPassDefCompAvg;
	}

	public void setAwayPassDefCompAvg(BigDecimal awayPassDefCompAvg) {
		this.awayPassDefCompAvg = awayPassDefCompAvg;
	}

	public BigDecimal getAwayPassDefCompPct() {
		return awayPassDefCompPct;
	}

	public void setAwayPassDefCompPct(BigDecimal awayPassDefCompPct) {
		this.awayPassDefCompPct = awayPassDefCompPct;
	}

	public BigDecimal getAwayPassDefYardsAvg() {
		return awayPassDefYardsAvg;
	}

	public void setAwayPassDefYardsAvg(BigDecimal awayPassDefYardsAvg) {
		this.awayPassDefYardsAvg = awayPassDefYardsAvg;
	}

	public BigDecimal getAwayPassDefYPA() {
		return awayPassDefYPA;
	}

	public void setAwayPassDefYPA(BigDecimal awayPassDefYPA) {
		this.awayPassDefYPA = awayPassDefYPA;
	}

	public BigDecimal getAwayPassDefINTsAvg() {
		return awayPassDefINTsAvg;
	}

	public void setAwayPassDefINTsAvg(BigDecimal awayPassDefINTsAvg) {
		this.awayPassDefINTsAvg = awayPassDefINTsAvg;
	}

	public BigDecimal getAwayPassDefTDsAvg() {
		return awayPassDefTDsAvg;
	}

	public void setAwayPassDefTDsAvg(BigDecimal awayPassDefTDsAvg) {
		this.awayPassDefTDsAvg = awayPassDefTDsAvg;
	}

	public Double getAwayPassDefRatingAvg() {
		return awayPassDefRatingAvg;
	}

	public void setAwayPassDefRatingAvg(Double awayPassDefRatingAvg) {
		this.awayPassDefRatingAvg = awayPassDefRatingAvg;
	}

	public BigDecimal getAwayPassDefYPR() {
		return awayPassDefYPR;
	}

	public void setAwayPassDefYPR(BigDecimal awayPassDefYPR) {
		this.awayPassDefYPR = awayPassDefYPR;
	}

	public BigDecimal getAwayPuntReturnsAvg() {
		return awayPuntReturnsAvg;
	}

	public void setAwayPuntReturnsAvg(BigDecimal awayPuntReturnsAvg) {
		this.awayPuntReturnsAvg = awayPuntReturnsAvg;
	}

	public BigDecimal getAwayPuntReturnYardsAvg() {
		return awayPuntReturnYardsAvg;
	}

	public void setAwayPuntReturnYardsAvg(BigDecimal awayPuntReturnYardsAvg) {
		this.awayPuntReturnYardsAvg = awayPuntReturnYardsAvg;
	}

	public BigDecimal getAwayPuntReturnAverage() {
		return awayPuntReturnAverage;
	}

	public void setAwayPuntReturnAverage(BigDecimal awayPuntReturnAverage) {
		this.awayPuntReturnAverage = awayPuntReturnAverage;
	}

	public BigDecimal getAwayPuntReturnTDsAvg() {
		return awayPuntReturnTDsAvg;
	}

	public void setAwayPuntReturnTDsAvg(BigDecimal awayPuntReturnTDsAvg) {
		this.awayPuntReturnTDsAvg = awayPuntReturnTDsAvg;
	}

	public BigDecimal getAwayPuntReturnsDefAvg() {
		return awayPuntReturnsDefAvg;
	}

	public void setAwayPuntReturnsDefAvg(BigDecimal awayPuntReturnsDefAvg) {
		this.awayPuntReturnsDefAvg = awayPuntReturnsDefAvg;
	}

	public BigDecimal getAwayPuntReturnYardsDefAvg() {
		return awayPuntReturnYardsDefAvg;
	}

	public void setAwayPuntReturnYardsDefAvg(BigDecimal awayPuntReturnYardsDefAvg) {
		this.awayPuntReturnYardsDefAvg = awayPuntReturnYardsDefAvg;
	}

	public BigDecimal getAwayPuntReturnAverageDef() {
		return awayPuntReturnAverageDef;
	}

	public void setAwayPuntReturnAverageDef(BigDecimal awayPuntReturnAverageDef) {
		this.awayPuntReturnAverageDef = awayPuntReturnAverageDef;
	}

	public BigDecimal getAwayPuntReturnTDsDefAvg() {
		return awayPuntReturnTDsDefAvg;
	}

	public void setAwayPuntReturnTDsDefAvg(BigDecimal awayPuntReturnTDsDefAvg) {
		this.awayPuntReturnTDsDefAvg = awayPuntReturnTDsDefAvg;
	}

	public BigDecimal getAwayKickoffReturnsAvg() {
		return awayKickoffReturnsAvg;
	}

	public void setAwayKickoffReturnsAvg(BigDecimal awayKickoffReturnsAvg) {
		this.awayKickoffReturnsAvg = awayKickoffReturnsAvg;
	}

	public BigDecimal getAwayKickoffReturnYardsAvg() {
		return awayKickoffReturnYardsAvg;
	}

	public void setAwayKickoffReturnYardsAvg(BigDecimal awayKickoffReturnYardsAvg) {
		this.awayKickoffReturnYardsAvg = awayKickoffReturnYardsAvg;
	}

	public BigDecimal getAwayKickoffReturnAverage() {
		return awayKickoffReturnAverage;
	}

	public void setAwayKickoffReturnAverage(BigDecimal awayKickoffReturnAverage) {
		this.awayKickoffReturnAverage = awayKickoffReturnAverage;
	}

	public BigDecimal getAwayKickoffReturnTDsAvg() {
		return awayKickoffReturnTDsAvg;
	}

	public void setAwayKickoffReturnTDsAvg(BigDecimal awayKickoffReturnTDsAvg) {
		this.awayKickoffReturnTDsAvg = awayKickoffReturnTDsAvg;
	}

	public BigDecimal getAwayKickoffReturnsDefAvg() {
		return awayKickoffReturnsDefAvg;
	}

	public void setAwayKickoffReturnsDefAvg(BigDecimal awayKickoffReturnsDefAvg) {
		this.awayKickoffReturnsDefAvg = awayKickoffReturnsDefAvg;
	}

	public BigDecimal getAwayKickoffReturnYardsDefAvg() {
		return awayKickoffReturnYardsDefAvg;
	}

	public void setAwayKickoffReturnYardsDefAvg(
			BigDecimal awayKickoffReturnYardsDefAvg) {
		this.awayKickoffReturnYardsDefAvg = awayKickoffReturnYardsDefAvg;
	}

	public BigDecimal getAwayKickoffReturnAverageDef() {
		return awayKickoffReturnAverageDef;
	}

	public void setAwayKickoffReturnAverageDef(
			BigDecimal awayKickoffReturnAverageDef) {
		this.awayKickoffReturnAverageDef = awayKickoffReturnAverageDef;
	}

	public BigDecimal getAwayKickoffReturnTDsDefAvg() {
		return awayKickoffReturnTDsDefAvg;
	}

	public void setAwayKickoffReturnTDsDefAvg(BigDecimal awayKickoffReturnTDsDefAvg) {
		this.awayKickoffReturnTDsDefAvg = awayKickoffReturnTDsDefAvg;
	}

	public BigDecimal getAwayPuntsAvg() {
		return awayPuntsAvg;
	}

	public void setAwayPuntsAvg(BigDecimal awayPuntsAvg) {
		this.awayPuntsAvg = awayPuntsAvg;
	}

	public BigDecimal getAwayPuntYardsAvg() {
		return awayPuntYardsAvg;
	}

	public void setAwayPuntYardsAvg(BigDecimal awayPuntYardsAvg) {
		this.awayPuntYardsAvg = awayPuntYardsAvg;
	}

	public BigDecimal getAwayPuntAverage() {
		return awayPuntAverage;
	}

	public void setAwayPuntAverage(BigDecimal awayPuntAverage) {
		this.awayPuntAverage = awayPuntAverage;
	}

	public BigDecimal getAwayKickoffsAvg() {
		return awayKickoffsAvg;
	}

	public void setAwayKickoffsAvg(BigDecimal awayKickoffsAvg) {
		this.awayKickoffsAvg = awayKickoffsAvg;
	}

	public BigDecimal getAwayKickoffYardsAvg() {
		return awayKickoffYardsAvg;
	}

	public void setAwayKickoffYardsAvg(BigDecimal awayKickoffYardsAvg) {
		this.awayKickoffYardsAvg = awayKickoffYardsAvg;
	}

	public BigDecimal getAwayKickoffAverage() {
		return awayKickoffAverage;
	}

	public void setAwayKickoffAverage(BigDecimal awayKickoffAverage) {
		this.awayKickoffAverage = awayKickoffAverage;
	}

	public BigDecimal getAwayKickoffTouchbackAvg() {
		return awayKickoffTouchbackAvg;
	}

	public void setAwayKickoffTouchbackAvg(BigDecimal awayKickoffTouchbackAvg) {
		this.awayKickoffTouchbackAvg = awayKickoffTouchbackAvg;
	}

	public BigDecimal getAwayKickoffTouchbackPct() {
		return awayKickoffTouchbackPct;
	}

	public void setAwayKickoffTouchbackPct(BigDecimal awayKickoffTouchbackPct) {
		this.awayKickoffTouchbackPct = awayKickoffTouchbackPct;
	}

	public BigDecimal getAwayKickoffOutOfBoundsAvg() {
		return awayKickoffOutOfBoundsAvg;
	}

	public void setAwayKickoffOutOfBoundsAvg(BigDecimal awayKickoffOutOfBoundsAvg) {
		this.awayKickoffOutOfBoundsAvg = awayKickoffOutOfBoundsAvg;
	}

	public BigDecimal getAwayKickoffOnSideAvg() {
		return awayKickoffOnSideAvg;
	}

	public void setAwayKickoffOnSideAvg(BigDecimal awayKickoffOnSideAvg) {
		this.awayKickoffOnSideAvg = awayKickoffOnSideAvg;
	}

	public BigDecimal getAwayFGOffAttAvg() {
		return awayFGOffAttAvg;
	}

	public void setAwayFGOffAttAvg(BigDecimal awayFGOffAttAvg) {
		this.awayFGOffAttAvg = awayFGOffAttAvg;
	}

	public BigDecimal getAwayFGOffMadeAvg() {
		return awayFGOffMadeAvg;
	}

	public void setAwayFGOffMadeAvg(BigDecimal awayFGOffMadeAvg) {
		this.awayFGOffMadeAvg = awayFGOffMadeAvg;
	}

	public BigDecimal getAwayFGOffPct() {
		return awayFGOffPct;
	}

	public void setAwayFGOffPct(BigDecimal awayFGOffPct) {
		this.awayFGOffPct = awayFGOffPct;
	}

	public BigDecimal getAwayFGDefAttAvg() {
		return awayFGDefAttAvg;
	}

	public void setAwayFGDefAttAvg(BigDecimal awayFGDefAttAvg) {
		this.awayFGDefAttAvg = awayFGDefAttAvg;
	}

	public BigDecimal getAwayFGDefMadeAvg() {
		return awayFGDefMadeAvg;
	}

	public void setAwayFGDefMadeAvg(BigDecimal awayFGDefMadeAvg) {
		this.awayFGDefMadeAvg = awayFGDefMadeAvg;
	}

	public BigDecimal getAwayFGDefPct() {
		return awayFGDefPct;
	}

	public void setAwayFGDefPct(BigDecimal awayFGDefPct) {
		this.awayFGDefPct = awayFGDefPct;
	}

	public BigDecimal getAwayScoringOffTDsAvg() {
		return awayScoringOffTDsAvg;
	}

	public void setAwayScoringOffTDsAvg(BigDecimal awayScoringOffTDsAvg) {
		this.awayScoringOffTDsAvg = awayScoringOffTDsAvg;
	}

	public BigDecimal getAwayScoringOff2PtConvAvg() {
		return awayScoringOff2PtConvAvg;
	}

	public void setAwayScoringOff2PtConvAvg(BigDecimal awayScoringOff2PtConvAvg) {
		this.awayScoringOff2PtConvAvg = awayScoringOff2PtConvAvg;
	}

	public BigDecimal getAwayScoringOffSafetiesAvg() {
		return awayScoringOffSafetiesAvg;
	}

	public void setAwayScoringOffSafetiesAvg(BigDecimal awayScoringOffSafetiesAvg) {
		this.awayScoringOffSafetiesAvg = awayScoringOffSafetiesAvg;
	}

	public BigDecimal getAwayScoringOffPointsAvg() {
		return awayScoringOffPointsAvg;
	}

	public void setAwayScoringOffPointsAvg(BigDecimal awayScoringOffPointsAvg) {
		this.awayScoringOffPointsAvg = awayScoringOffPointsAvg;
	}

	public BigDecimal getAwayScoringDefTDsAvg() {
		return awayScoringDefTDsAvg;
	}

	public void setAwayScoringDefTDsAvg(BigDecimal awayScoringDefTDsAvg) {
		this.awayScoringDefTDsAvg = awayScoringDefTDsAvg;
	}

	public BigDecimal getAwayScoringDef2PtConvAvg() {
		return awayScoringDef2PtConvAvg;
	}

	public void setAwayScoringDef2PtConvAvg(BigDecimal awayScoringDef2PtConvAvg) {
		this.awayScoringDef2PtConvAvg = awayScoringDef2PtConvAvg;
	}

	public BigDecimal getAwayScoringDefSafetiesAvg() {
		return awayScoringDefSafetiesAvg;
	}

	public void setAwayScoringDefSafetiesAvg(BigDecimal awayScoringDefSafetiesAvg) {
		this.awayScoringDefSafetiesAvg = awayScoringDefSafetiesAvg;
	}

	public BigDecimal getAwayScoringDefPointsAvg() {
		return awayScoringDefPointsAvg;
	}

	public void setAwayScoringDefPointsAvg(BigDecimal awayScoringDefPointsAvg) {
		this.awayScoringDefPointsAvg = awayScoringDefPointsAvg;
	}

	public BigDecimal getAwayTotalOffPlaysAvg() {
		return awayTotalOffPlaysAvg;
	}

	public void setAwayTotalOffPlaysAvg(BigDecimal awayTotalOffPlaysAvg) {
		this.awayTotalOffPlaysAvg = awayTotalOffPlaysAvg;
	}

	public BigDecimal getAwayTotalOffYardsAvg() {
		return awayTotalOffYardsAvg;
	}

	public void setAwayTotalOffYardsAvg(BigDecimal awayTotalOffYardsAvg) {
		this.awayTotalOffYardsAvg = awayTotalOffYardsAvg;
	}

	public BigDecimal getAwayTotalOffYPP() {
		return awayTotalOffYPP;
	}

	public void setAwayTotalOffYPP(BigDecimal awayTotalOffYPP) {
		this.awayTotalOffYPP = awayTotalOffYPP;
	}

	public BigDecimal getAwayTotalDefPlaysAvg() {
		return awayTotalDefPlaysAvg;
	}

	public void setAwayTotalDefPlaysAvg(BigDecimal awayTotalDefPlaysAvg) {
		this.awayTotalDefPlaysAvg = awayTotalDefPlaysAvg;
	}

	public BigDecimal getAwayTotalDefYardsAvg() {
		return awayTotalDefYardsAvg;
	}

	public void setAwayTotalDefYardsAvg(BigDecimal awayTotalDefYardsAvg) {
		this.awayTotalDefYardsAvg = awayTotalDefYardsAvg;
	}

	public BigDecimal getAwayTotalDefYPP() {
		return awayTotalDefYPP;
	}

	public void setAwayTotalDefYPP(BigDecimal awayTotalDefYPP) {
		this.awayTotalDefYPP = awayTotalDefYPP;
	}

	public BigDecimal getAwayPassDefIntYardsAvg() {
		return awayPassDefIntYardsAvg;
	}

	public void setAwayPassDefIntYardsAvg(BigDecimal awayPassDefIntYardsAvg) {
		this.awayPassDefIntYardsAvg = awayPassDefIntYardsAvg;
	}

	public BigDecimal getAwayPassDefIntTDsAvg() {
		return awayPassDefIntTDsAvg;
	}

	public void setAwayPassDefIntTDsAvg(BigDecimal awayPassDefIntTDsAvg) {
		this.awayPassDefIntTDsAvg = awayPassDefIntTDsAvg;
	}

	public BigDecimal getAwayFumbleReturnsAvg() {
		return awayFumbleReturnsAvg;
	}

	public void setAwayFumbleReturnsAvg(BigDecimal awayFumbleReturnsAvg) {
		this.awayFumbleReturnsAvg = awayFumbleReturnsAvg;
	}

	public BigDecimal getAwayFumbleReturnYardsAvg() {
		return awayFumbleReturnYardsAvg;
	}

	public void setAwayFumbleReturnYardsAvg(BigDecimal awayFumbleReturnYardsAvg) {
		this.awayFumbleReturnYardsAvg = awayFumbleReturnYardsAvg;
	}

	public BigDecimal getAwayFumbleReturnTDsAvg() {
		return awayFumbleReturnTDsAvg;
	}

	public void setAwayFumbleReturnTDsAvg(BigDecimal awayFumbleReturnTDsAvg) {
		this.awayFumbleReturnTDsAvg = awayFumbleReturnTDsAvg;
	}

	public BigDecimal getAwayTotalTacklesAvg() {
		return awayTotalTacklesAvg;
	}

	public void setAwayTotalTacklesAvg(BigDecimal awayTotalTacklesAvg) {
		this.awayTotalTacklesAvg = awayTotalTacklesAvg;
	}

	public BigDecimal getAwayTFLsAvg() {
		return awayTFLsAvg;
	}

	public void setAwayTFLsAvg(BigDecimal awayTFLsAvg) {
		this.awayTFLsAvg = awayTFLsAvg;
	}

	public BigDecimal getAwayTFLYardsAvg() {
		return awayTFLYardsAvg;
	}

	public void setAwayTFLYardsAvg(BigDecimal awayTFLYardsAvg) {
		this.awayTFLYardsAvg = awayTFLYardsAvg;
	}

	public BigDecimal getAwaySacksAvg() {
		return awaySacksAvg;
	}

	public void setAwaySacksAvg(BigDecimal awaySacksAvg) {
		this.awaySacksAvg = awaySacksAvg;
	}

	public BigDecimal getAwaySackYardsAvg() {
		return awaySackYardsAvg;
	}

	public void setAwaySackYardsAvg(BigDecimal awaySackYardsAvg) {
		this.awaySackYardsAvg = awaySackYardsAvg;
	}

	public BigDecimal getAwaySacksAllowedAvg() {
		return awaySacksAllowedAvg;
	}

	public void setAwaySacksAllowedAvg(BigDecimal awaySacksAllowedAvg) {
		this.awaySacksAllowedAvg = awaySacksAllowedAvg;
	}

	public BigDecimal getAwaySackYardsAllowedAvg() {
		return awaySackYardsAllowedAvg;
	}

	public void setAwaySackYardsAllowedAvg(BigDecimal awaySackYardsAllowedAvg) {
		this.awaySackYardsAllowedAvg = awaySackYardsAllowedAvg;
	}

	public BigDecimal getAwayPassesBrokenUpAvg() {
		return awayPassesBrokenUpAvg;
	}

	public void setAwayPassesBrokenUpAvg(BigDecimal awayPassesBrokenUpAvg) {
		this.awayPassesBrokenUpAvg = awayPassesBrokenUpAvg;
	}

	public BigDecimal getAwayQBHurriesAvg() {
		return awayQBHurriesAvg;
	}

	public void setAwayQBHurriesAvg(BigDecimal awayQBHurriesAvg) {
		this.awayQBHurriesAvg = awayQBHurriesAvg;
	}

	public BigDecimal getAwayFumblesForcedAvg() {
		return awayFumblesForcedAvg;
	}

	public void setAwayFumblesForcedAvg(BigDecimal awayFumblesForcedAvg) {
		this.awayFumblesForcedAvg = awayFumblesForcedAvg;
	}

	public BigDecimal getAwayPuntKicksBlockedAvg() {
		return awayPuntKicksBlockedAvg;
	}

	public void setAwayPuntKicksBlockedAvg(BigDecimal awayPuntKicksBlockedAvg) {
		this.awayPuntKicksBlockedAvg = awayPuntKicksBlockedAvg;
	}

	public BigDecimal getAwayQBHurriesAllowedAvg() {
		return awayQBHurriesAllowedAvg;
	}

	public void setAwayQBHurriesAllowedAvg(BigDecimal awayQBHurriesAllowedAvg) {
		this.awayQBHurriesAllowedAvg = awayQBHurriesAllowedAvg;
	}

	public BigDecimal getAwayFirstDownOffRushAvg() {
		return awayFirstDownOffRushAvg;
	}

	public void setAwayFirstDownOffRushAvg(BigDecimal awayFirstDownOffRushAvg) {
		this.awayFirstDownOffRushAvg = awayFirstDownOffRushAvg;
	}

	public BigDecimal getAwayFirstDownOffPassAvg() {
		return awayFirstDownOffPassAvg;
	}

	public void setAwayFirstDownOffPassAvg(BigDecimal awayFirstDownOffPassAvg) {
		this.awayFirstDownOffPassAvg = awayFirstDownOffPassAvg;
	}

	public BigDecimal getAwayFirstDownOffPenaltyAvg() {
		return awayFirstDownOffPenaltyAvg;
	}

	public void setAwayFirstDownOffPenaltyAvg(BigDecimal awayFirstDownOffPenaltyAvg) {
		this.awayFirstDownOffPenaltyAvg = awayFirstDownOffPenaltyAvg;
	}

	public BigDecimal getAwayFirstDownOffTotalAvg() {
		return awayFirstDownOffTotalAvg;
	}

	public void setAwayFirstDownOffTotalAvg(BigDecimal awayFirstDownOffTotalAvg) {
		this.awayFirstDownOffTotalAvg = awayFirstDownOffTotalAvg;
	}

	public BigDecimal getAwayFirstDownDefRushAvg() {
		return awayFirstDownDefRushAvg;
	}

	public void setAwayFirstDownDefRushAvg(BigDecimal awayFirstDownDefRushAvg) {
		this.awayFirstDownDefRushAvg = awayFirstDownDefRushAvg;
	}

	public BigDecimal getAwayFirstDownDefPassAvg() {
		return awayFirstDownDefPassAvg;
	}

	public void setAwayFirstDownDefPassAvg(BigDecimal awayFirstDownDefPassAvg) {
		this.awayFirstDownDefPassAvg = awayFirstDownDefPassAvg;
	}

	public BigDecimal getAwayFirstDownDefPenaltyAvg() {
		return awayFirstDownDefPenaltyAvg;
	}

	public void setAwayFirstDownDefPenaltyAvg(BigDecimal awayFirstDownDefPenaltyAvg) {
		this.awayFirstDownDefPenaltyAvg = awayFirstDownDefPenaltyAvg;
	}

	public BigDecimal getAwayFirstDownDefTotalAvg() {
		return awayFirstDownDefTotalAvg;
	}

	public void setAwayFirstDownDefTotalAvg(BigDecimal awayFirstDownDefTotalAvg) {
		this.awayFirstDownDefTotalAvg = awayFirstDownDefTotalAvg;
	}

	public BigDecimal getAwayPenaltiesAvg() {
		return awayPenaltiesAvg;
	}

	public void setAwayPenaltiesAvg(BigDecimal awayPenaltiesAvg) {
		this.awayPenaltiesAvg = awayPenaltiesAvg;
	}

	public BigDecimal getAwayPenaltyYardsAvg() {
		return awayPenaltyYardsAvg;
	}

	public void setAwayPenaltyYardsAvg(BigDecimal awayPenaltyYardsAvg) {
		this.awayPenaltyYardsAvg = awayPenaltyYardsAvg;
	}

	public BigDecimal getAwayThirdDownOffAttAvg() {
		return awayThirdDownOffAttAvg;
	}

	public void setAwayThirdDownOffAttAvg(BigDecimal awayThirdDownOffAttAvg) {
		this.awayThirdDownOffAttAvg = awayThirdDownOffAttAvg;
	}

	public BigDecimal getAwayThirdDownOffConvAvg() {
		return awayThirdDownOffConvAvg;
	}

	public void setAwayThirdDownOffConvAvg(BigDecimal awayThirdDownOffConvAvg) {
		this.awayThirdDownOffConvAvg = awayThirdDownOffConvAvg;
	}

	public BigDecimal getAwayThirdDownOffConvPct() {
		return awayThirdDownOffConvPct;
	}

	public void setAwayThirdDownOffConvPct(BigDecimal awayThirdDownOffConvPct) {
		this.awayThirdDownOffConvPct = awayThirdDownOffConvPct;
	}

	public BigDecimal getAwayThirdDownDefAttAvg() {
		return awayThirdDownDefAttAvg;
	}

	public void setAwayThirdDownDefAttAvg(BigDecimal awayThirdDownDefAttAvg) {
		this.awayThirdDownDefAttAvg = awayThirdDownDefAttAvg;
	}

	public BigDecimal getAwayThirdDownDefConvAvg() {
		return awayThirdDownDefConvAvg;
	}

	public void setAwayThirdDownDefConvAvg(BigDecimal awayThirdDownDefConvAvg) {
		this.awayThirdDownDefConvAvg = awayThirdDownDefConvAvg;
	}

	public BigDecimal getAwayThirdDownDefConvPct() {
		return awayThirdDownDefConvPct;
	}

	public void setAwayThirdDownDefConvPct(BigDecimal awayThirdDownDefConvPct) {
		this.awayThirdDownDefConvPct = awayThirdDownDefConvPct;
	}

	public BigDecimal getAwayFourthDownOffAttAvg() {
		return awayFourthDownOffAttAvg;
	}

	public void setAwayFourthDownOffAttAvg(BigDecimal awayFourthDownOffAttAvg) {
		this.awayFourthDownOffAttAvg = awayFourthDownOffAttAvg;
	}

	public BigDecimal getAwayFourthDownOffConvAvg() {
		return awayFourthDownOffConvAvg;
	}

	public void setAwayFourthDownOffConvAvg(BigDecimal awayFourthDownOffConvAvg) {
		this.awayFourthDownOffConvAvg = awayFourthDownOffConvAvg;
	}

	public BigDecimal getAwayFourthDownOffConvPct() {
		return awayFourthDownOffConvPct;
	}

	public void setAwayFourthDownOffConvPct(BigDecimal awayFourthDownOffConvPct) {
		this.awayFourthDownOffConvPct = awayFourthDownOffConvPct;
	}

	public BigDecimal getAwayFourthDownDefAttAvg() {
		return awayFourthDownDefAttAvg;
	}

	public void setAwayFourthDownDefAttAvg(BigDecimal awayFourthDownDefAttAvg) {
		this.awayFourthDownDefAttAvg = awayFourthDownDefAttAvg;
	}

	public BigDecimal getAwayFourthDownDefConvAvg() {
		return awayFourthDownDefConvAvg;
	}

	public void setAwayFourthDownDefConvAvg(BigDecimal awayFourthDownDefConvAvg) {
		this.awayFourthDownDefConvAvg = awayFourthDownDefConvAvg;
	}

	public BigDecimal getAwayFourthDownDefConvPct() {
		return awayFourthDownDefConvPct;
	}

	public void setAwayFourthDownDefConvPct(BigDecimal awayFourthDownDefConvPct) {
		this.awayFourthDownDefConvPct = awayFourthDownDefConvPct;
	}

	public BigDecimal getAwayOffRedZoneAttAvg() {
		return awayOffRedZoneAttAvg;
	}

	public void setAwayOffRedZoneAttAvg(BigDecimal awayOffRedZoneAttAvg) {
		this.awayOffRedZoneAttAvg = awayOffRedZoneAttAvg;
	}

	public BigDecimal getAwayOffRedZoneScoresAvg() {
		return awayOffRedZoneScoresAvg;
	}

	public void setAwayOffRedZoneScoresAvg(BigDecimal awayOffRedZoneScoresAvg) {
		this.awayOffRedZoneScoresAvg = awayOffRedZoneScoresAvg;
	}

	public BigDecimal getAwayOffRedZoneScorePct() {
		return awayOffRedZoneScorePct;
	}

	public void setAwayOffRedZoneScorePct(BigDecimal awayOffRedZoneScorePct) {
		this.awayOffRedZoneScorePct = awayOffRedZoneScorePct;
	}

	public BigDecimal getAwayOffRedZoneTDsAvg() {
		return awayOffRedZoneTDsAvg;
	}

	public void setAwayOffRedZoneTDsAvg(BigDecimal awayOffRedZoneTDsAvg) {
		this.awayOffRedZoneTDsAvg = awayOffRedZoneTDsAvg;
	}

	public BigDecimal getAwayOffRedZoneTDPct() {
		return awayOffRedZoneTDPct;
	}

	public void setAwayOffRedZoneTDPct(BigDecimal awayOffRedZoneTDPct) {
		this.awayOffRedZoneTDPct = awayOffRedZoneTDPct;
	}

	public BigDecimal getAwayOffRedZoneFGsAvg() {
		return awayOffRedZoneFGsAvg;
	}

	public void setAwayOffRedZoneFGsAvg(BigDecimal awayOffRedZoneFGsAvg) {
		this.awayOffRedZoneFGsAvg = awayOffRedZoneFGsAvg;
	}

	public BigDecimal getAwayOffRedZoneFGPct() {
		return awayOffRedZoneFGPct;
	}

	public void setAwayOffRedZoneFGPct(BigDecimal awayOffRedZoneFGPct) {
		this.awayOffRedZoneFGPct = awayOffRedZoneFGPct;
	}

	public BigDecimal getAwayDefRedZoneAttAvg() {
		return awayDefRedZoneAttAvg;
	}

	public void setAwayDefRedZoneAttAvg(BigDecimal awayDefRedZoneAttAvg) {
		this.awayDefRedZoneAttAvg = awayDefRedZoneAttAvg;
	}

	public BigDecimal getAwayDefRedZoneScoresAvg() {
		return awayDefRedZoneScoresAvg;
	}

	public void setAwayDefRedZoneScoresAvg(BigDecimal awayDefRedZoneScoresAvg) {
		this.awayDefRedZoneScoresAvg = awayDefRedZoneScoresAvg;
	}

	public BigDecimal getAwayDefRedZoneScorePct() {
		return awayDefRedZoneScorePct;
	}

	public void setAwayDefRedZoneScorePct(BigDecimal awayDefRedZoneScorePct) {
		this.awayDefRedZoneScorePct = awayDefRedZoneScorePct;
	}

	public BigDecimal getAwayDefRedZoneTDsAvg() {
		return awayDefRedZoneTDsAvg;
	}

	public void setAwayDefRedZoneTDsAvg(BigDecimal awayDefRedZoneTDsAvg) {
		this.awayDefRedZoneTDsAvg = awayDefRedZoneTDsAvg;
	}

	public BigDecimal getAwayDefRedZoneTDPct() {
		return awayDefRedZoneTDPct;
	}

	public void setAwayDefRedZoneTDPct(BigDecimal awayDefRedZoneTDPct) {
		this.awayDefRedZoneTDPct = awayDefRedZoneTDPct;
	}

	public BigDecimal getAwayDefRedZoneFGsAvg() {
		return awayDefRedZoneFGsAvg;
	}

	public void setAwayDefRedZoneFGsAvg(BigDecimal awayDefRedZoneFGsAvg) {
		this.awayDefRedZoneFGsAvg = awayDefRedZoneFGsAvg;
	}

	public BigDecimal getAwayDefRedZoneFGPct() {
		return awayDefRedZoneFGPct;
	}

	public void setAwayDefRedZoneFGPct(BigDecimal awayDefRedZoneFGPct) {
		this.awayDefRedZoneFGPct = awayDefRedZoneFGPct;
	}

	public BigDecimal getAwayFumbleGainAvg() {
		return awayFumbleGainAvg;
	}

	public void setAwayFumbleGainAvg(BigDecimal awayFumbleGainAvg) {
		this.awayFumbleGainAvg = awayFumbleGainAvg;
	}

	public BigDecimal getAwayFubmleLostAvg() {
		return awayFubmleLostAvg;
	}

	public void setAwayFubmleLostAvg(BigDecimal awayFubmleLostAvg) {
		this.awayFubmleLostAvg = awayFubmleLostAvg;
	}

	public BigDecimal getAwayTurnoverMarginAvg() {
		return awayTurnoverMarginAvg;
	}

	public void setAwayTurnoverMarginAvg(BigDecimal awayTurnoverMarginAvg) {
		this.awayTurnoverMarginAvg = awayTurnoverMarginAvg;
	}

	public BigDecimal getAwayLast5WinPct() {
		return awayLast5WinPct;
	}

	public void setAwayLast5WinPct(BigDecimal awayLast5WinPct) {
		this.awayLast5WinPct = awayLast5WinPct;
	}

	public BigDecimal getAwayLast5WinATSPct() {
		return awayLast5WinATSPct;
	}

	public void setAwayLast5WinATSPct(BigDecimal awayLast5WinATSPct) {
		this.awayLast5WinATSPct = awayLast5WinATSPct;
	}

	public BigDecimal getAwayLast5RushOffYardsAvg() {
		return awayLast5RushOffYardsAvg;
	}

	public void setAwayLast5RushOffYardsAvg(BigDecimal awayLast5RushOffYardsAvg) {
		this.awayLast5RushOffYardsAvg = awayLast5RushOffYardsAvg;
	}

	public BigDecimal getAwayLast5PassOffYardsAvg() {
		return awayLast5PassOffYardsAvg;
	}

	public void setAwayLast5PassOffYardsAvg(BigDecimal awayLast5PassOffYardsAvg) {
		this.awayLast5PassOffYardsAvg = awayLast5PassOffYardsAvg;
	}

	public BigDecimal getAwayLast5ScoringOffPointsAvg() {
		return awayLast5ScoringOffPointsAvg;
	}

	public void setAwayLast5ScoringOffPointsAvg(
			BigDecimal awayLast5ScoringOffPointsAvg) {
		this.awayLast5ScoringOffPointsAvg = awayLast5ScoringOffPointsAvg;
	}

	public BigDecimal getAwayLast5RushDefYardsAvg() {
		return awayLast5RushDefYardsAvg;
	}

	public void setAwayLast5RushDefYardsAvg(BigDecimal awayLast5RushDefYardsAvg) {
		this.awayLast5RushDefYardsAvg = awayLast5RushDefYardsAvg;
	}

	public BigDecimal getAwayLast5PassDefYardsAvg() {
		return awayLast5PassDefYardsAvg;
	}

	public void setAwayLast5PassDefYardsAvg(BigDecimal awayLast5PassDefYardsAvg) {
		this.awayLast5PassDefYardsAvg = awayLast5PassDefYardsAvg;
	}

	public BigDecimal getAwayLast5ScoringDefPointsAvg() {
		return awayLast5ScoringDefPointsAvg;
	}

	public void setAwayLast5ScoringDefPointsAvg(
			BigDecimal awayLast5ScoringDefPointsAvg) {
		this.awayLast5ScoringDefPointsAvg = awayLast5ScoringDefPointsAvg;
	}

	public BigDecimal getAwayLastSeasonWinPct() {
		return awayLastSeasonWinPct;
	}

	public void setAwayLastSeasonWinPct(BigDecimal awayLastSeasonWinPct) {
		this.awayLastSeasonWinPct = awayLastSeasonWinPct;
	}

	public BigDecimal getAwayLastSeasonWinATSPct() {
		return awayLastSeasonWinATSPct;
	}

	public void setAwayLastSeasonWinATSPct(BigDecimal awayLastSeasonWinATSPct) {
		this.awayLastSeasonWinATSPct = awayLastSeasonWinATSPct;
	}

	public BigDecimal getAwayLastSeasonRushOffYardsAvg() {
		return awayLastSeasonRushOffYardsAvg;
	}

	public void setAwayLastSeasonRushOffYardsAvg(
			BigDecimal awayLastSeasonRushOffYardsAvg) {
		this.awayLastSeasonRushOffYardsAvg = awayLastSeasonRushOffYardsAvg;
	}

	public BigDecimal getAwayLastSeasonPassOffYardsAvg() {
		return awayLastSeasonPassOffYardsAvg;
	}

	public void setAwayLastSeasonPassOffYardsAvg(
			BigDecimal awayLastSeasonPassOffYardsAvg) {
		this.awayLastSeasonPassOffYardsAvg = awayLastSeasonPassOffYardsAvg;
	}

	public BigDecimal getAwayLastSeasonScoringOffPointsAvg() {
		return awayLastSeasonScoringOffPointsAvg;
	}

	public void setAwayLastSeasonScoringOffPointsAvg(
			BigDecimal awayLastSeasonScoringOffPointsAvg) {
		this.awayLastSeasonScoringOffPointsAvg = awayLastSeasonScoringOffPointsAvg;
	}

	public BigDecimal getAwayLastSeasonRushDefYardsAvg() {
		return awayLastSeasonRushDefYardsAvg;
	}

	public void setAwayLastSeasonRushDefYardsAvg(
			BigDecimal awayLastSeasonRushDefYardsAvg) {
		this.awayLastSeasonRushDefYardsAvg = awayLastSeasonRushDefYardsAvg;
	}

	public BigDecimal getAwayLastSeasonPassDefYardsAvg() {
		return awayLastSeasonPassDefYardsAvg;
	}

	public void setAwayLastSeasonPassDefYardsAvg(
			BigDecimal awayLastSeasonPassDefYardsAvg) {
		this.awayLastSeasonPassDefYardsAvg = awayLastSeasonPassDefYardsAvg;
	}

	public BigDecimal getAwayLastSeasonScoringDefPointsAvg() {
		return awayLastSeasonScoringDefPointsAvg;
	}

	public void setAwayLastSeasonScoringDefPointsAvg(
			BigDecimal awayLastSeasonScoringDefPointsAvg) {
		this.awayLastSeasonScoringDefPointsAvg = awayLastSeasonScoringDefPointsAvg;
	}

	public BigDecimal getHomeWinPct() {
		return homeWinPct;
	}

	public void setHomeWinPct(BigDecimal homeWinPct) {
		this.homeWinPct = homeWinPct;
	}

	public BigDecimal getHomeWinATSPct() {
		return homeWinATSPct;
	}

	public void setHomeWinATSPct(BigDecimal homeWinATSPct) {
		this.homeWinATSPct = homeWinATSPct;
	}

	public BigDecimal getAwayWinPct() {
		return awayWinPct;
	}

	public void setAwayWinPct(BigDecimal awayWinPct) {
		this.awayWinPct = awayWinPct;
	}

	public BigDecimal getAwayWinATSPct() {
		return awayWinATSPct;
	}

	public void setAwayWinATSPct(BigDecimal awayWinATSPct) {
		this.awayWinATSPct = awayWinATSPct;
	}

	public BigDecimal getHomeUnderPct() {
		return homeUnderPct;
	}

	public void setHomeUnderPct(BigDecimal homeUnderPct) {
		this.homeUnderPct = homeUnderPct;
	}

	public BigDecimal getHomeLast5UnderPct() {
		return homeLast5UnderPct;
	}

	public void setHomeLast5UnderPct(BigDecimal homeLast5UnderPct) {
		this.homeLast5UnderPct = homeLast5UnderPct;
	}

	public BigDecimal getHomeLastSeasonUnderPct() {
		return homeLastSeasonUnderPct;
	}

	public void setHomeLastSeasonUnderPct(BigDecimal homeLastSeasonUnderPct) {
		this.homeLastSeasonUnderPct = homeLastSeasonUnderPct;
	}

	public BigDecimal getAwayUnderPct() {
		return awayUnderPct;
	}

	public void setAwayUnderPct(BigDecimal awayUnderPct) {
		this.awayUnderPct = awayUnderPct;
	}

	public BigDecimal getAwayLast5UnderPct() {
		return awayLast5UnderPct;
	}

	public void setAwayLast5UnderPct(BigDecimal awayLast5UnderPct) {
		this.awayLast5UnderPct = awayLast5UnderPct;
	}

	public BigDecimal getAwayLastSeasonUnderPct() {
		return awayLastSeasonUnderPct;
	}

	public void setAwayLastSeasonUnderPct(BigDecimal awayLastSeasonUnderPct) {
		this.awayLastSeasonUnderPct = awayLastSeasonUnderPct;
	}

}
