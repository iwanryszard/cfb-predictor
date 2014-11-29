package svm.predictor.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name="game_info")
public class GameInfo implements BaseEntity<Integer> {

    private Integer id;
    
    private int homeTeamId;
	private int awayTeamId;
	private Date gameDate;
	private Integer distanceBetweenTeamsKm;
	private boolean isNeutralVenue;
	private int homeTeamPoints;
	private int awayTeamPoints;
	private Double pointSpread;
	private int attendance;
	
	//home stats
	private int homeRushOffAtt;
	private int homeRushOffYards;
	private Double homeRushOffYPA;
	private int homeRushOffTDs;
	
	private int homePassOffAtt;
	private int homePassOffComp;
	private Double homePassOffCompPct;
	private int homePassOffYards;
	private Double homePassOffYPA;
	private int homePassOffINTs;
	private int homePassOffTDs;
	private Double homePassOffRating;
	private Double homePassOffYPR;
	
	private int homePuntReturns;
	private int homePuntReturnYards;
	private Double homePuntReturnAverage;
	private int homePuntReturnTDs;
	
	private int homeKickoffReturns;
	private int homeKickoffReturnYards;
	private Double homeKickoffReturnAverage;
	private int homeKickoffReturnTDs;
	
	private int homePunts;
	private int homePuntYards;
	private Double homePuntAverage;
	
	private int homeKickoffs;
	private int homeKickoffYards;
	private Double homeKickoffAverage;
	private int homeKickoffTouchback;
	private Double homeKickoffTouchbackPct;
	private int homeKickoffOutOfBounds;
	private int homeKickoffOnSide;
	
	private int homeFGOffAtt;
	private int homeFGOffMade;
	private Double homeFGOffPct;

	private int homeScoringOffTDs;
	private int homeScoringOff2PtConv;
	private int homeScoringOffSafeties;
	private int homeScoringOffPoints;
	
	private int homeTotalOffPlays;
	private int homeTotalOffYards;
	private Double homeTotalOffYPP;
	
	private Integer homePassDefInts;
	private Integer homePassDefIntYards;
	private Integer homePassDefIntTDs;
	
	private Integer homeFumbleReturns;
	private Integer homeFumbleReturnYards;
	private Integer homeFumbleReturnTDs;
	
	private Integer homeTotalTackles;
	
	private Integer homeTFLs;
	private Integer homeTFLYards;
	
	private Integer homeSacks;
	private Integer homeSackYards;
	
	private Integer homePassesBrokenUp;
	private Integer homeQBHurries;
	private Integer homeFumblesForced;
	private Integer homePuntKicksBlocked;
	
	private int homeFirstDownOffRush;
	private int homeFirstDownOffPass;
	private int homeFirstDownOffPenalty;
	private int homeFirstDownOffTotal;

	private int homePenalties;
	private int homePenaltyYards;
	
	private int homeThirdDownOffAtt;
	private int homeThirdDownOffConv;
	private Double homeThirdDownOffConvPct;

	private int homeFourthDownOffAtt;
	private int homeFourthDownOffConv;
	private Double homeFourthDownOffConvPct;

	private int homeOffRedZoneAtt;
	private int homeOffRedZoneScores;
	private Double homeOffRedZoneScorePct;
	private int homeOffRedZoneTDs;
	private Double homeOffRedZoneTDPct;
	private int homeOffRedZoneFGs;
	private Double homeOffRedZoneFGPct;
	
	private Integer homeFumbleGain;
	private Integer homeFumbleLost;
	private Integer homeTurnoverMargin;
	
	//away stats
	private int awayRushOffAtt;
	private int awayRushOffYards;
	private Double awayRushOffYPA;
	private int awayRushOffTDs;
	
	private int awayPassOffAtt;
	private int awayPassOffComp;
	private Double awayPassOffCompPct;
	private int awayPassOffYards;
	private Double awayPassOffYPA;
	private int awayPassOffINTs;
	private int awayPassOffTDs;
	private Double awayPassOffRating;
	private Double awayPassOffYPR;
	
	private int awayPuntReturns;
	private int awayPuntReturnYards;
	private Double awayPuntReturnAverage;
	private int awayPuntReturnTDs;
	
	private int awayKickoffReturns;
	private int awayKickoffReturnYards;
	private Double awayKickoffReturnAverage;
	private int awayKickoffReturnTDs;
	
	private int awayPunts;
	private int awayPuntYards;
	private Double awayPuntAverage;
	
	private int awayKickoffs;
	private int awayKickoffYards;
	private Double awayKickoffAverage;
	private int awayKickoffTouchback;
	private Double awayKickoffTouchbackPct;
	private int awayKickoffOutOfBounds;
	private int awayKickoffOnSide;
	
	private int awayFGOffAtt;
	private int awayFGOffMade;
	private Double awayFGOffPct;

	private int awayScoringOffTDs;
	private int awayScoringOff2PtConv;
	private int awayScoringOffSafeties;
	private int awayScoringOffPoints;
	
	private int awayTotalOffPlays;
	private int awayTotalOffYards;
	private Double awayTotalOffYPP;
	
	private Integer awayPassDefInts;
	private Integer awayPassDefIntYards;
	private Integer awayPassDefIntTDs;
	
	private Integer awayFumbleReturns;
	private Integer awayFumbleReturnYards;
	private Integer awayFumbleReturnTDs;
	
	private Integer awayTotalTackles;
	
	private Integer awayTFLs;
	private Integer awayTFLYards;
	
	private Integer awaySacks;
	private Integer awaySackYards;
	
	private Integer awayPassesBrokenUp;
	private Integer awayQBHurries;
	private Integer awayFumblesForced;
	private Integer awayPuntKicksBlocked;
	
	private int awayFirstDownOffRush;
	private int awayFirstDownOffPass;
	private int awayFirstDownOffPenalty;
	private int awayFirstDownOffTotal;

	private int awayPenalties;
	private int awayPenaltyYards;
	
	private int awayThirdDownOffAtt;
	private int awayThirdDownOffConv;
	private Double awayThirdDownOffConvPct;

	private int awayFourthDownOffAtt;
	private int awayFourthDownOffConv;
	private Double awayFourthDownOffConvPct;

	private int awayOffRedZoneAtt;
	private int awayOffRedZoneScores;
	private Double awayOffRedZoneScorePct;
	private int awayOffRedZoneTDs;
	private Double awayOffRedZoneTDPct;
	private int awayOffRedZoneFGs;
	private Double awayOffRedZoneFGPct;
	
	private Integer awayFumbleGain;
	private Integer awayFumbleLost;
	private Integer awayTurnoverMargin;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="home_team_id")
	public int getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	@Column(name="away_team_id")
	public int getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	@Column(name="game_date")
	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	 @Column(name="distance_between_teams_km")
	public Integer getDistanceBetweenTeamsKm() {
		return distanceBetweenTeamsKm;
	}

	public void setDistanceBetweenTeamsKm(Integer distanceBetweenTeamsKm) {
		this.distanceBetweenTeamsKm = distanceBetweenTeamsKm;
	}

	@Column(name="is_neutral_venue")
	public boolean isNeutralVenue() {
		return isNeutralVenue;
	}

	public void setNeutralVenue(boolean isNeutralVenue) {
		this.isNeutralVenue = isNeutralVenue;
	}

	@Column(name="home_team_points")
	public int getHomeTeamPoints() {
		return homeTeamPoints;
	}

	public void setHomeTeamPoints(int homeTeamPoints) {
		this.homeTeamPoints = homeTeamPoints;
	}

	@Column(name="away_team_points")
	public int getAwayTeamPoints() {
		return awayTeamPoints;
	}

	public void setAwayTeamPoints(int awayTeamPoints) {
		this.awayTeamPoints = awayTeamPoints;
	}

	@Column(name="point_spread")
	public Double getPointSpread() {
		return pointSpread;
	}

	public void setPointSpread(Double pointSpread) {
		this.pointSpread = pointSpread;
	}

	@Column(name="attendance")
	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	//home setters and getters
	@Column(name="home_rush_off_att")
	public int getHomeRushOffAtt() {
		return homeRushOffAtt;
	}

	public void setHomeRushOffAtt(int homeRushOffAtt) {
		this.homeRushOffAtt = homeRushOffAtt;
	}

	@Column(name="home_rush_off_yards")
	public int getHomeRushOffYards() {
		return homeRushOffYards;
	}

	public void setHomeRushOffYards(int homeRushOffYards) {
		this.homeRushOffYards = homeRushOffYards;
	}

	@Column(name="home_rush_off_ypa")
	public Double getHomeRushOffYPA() {
		return homeRushOffYPA;
	}

	public void setHomeRushOffYPA(Double homeRushOffYPA) {
		this.homeRushOffYPA = homeRushOffYPA;
	}

	@Column(name="home_rush_off_tds")
	public int getHomeRushOffTDs() {
		return homeRushOffTDs;
	}

	public void setHomeRushOffTDs(int homeRushOffTDs) {
		this.homeRushOffTDs = homeRushOffTDs;
	}

	@Column(name="home_pass_off_att")
	public int getHomePassOffAtt() {
		return homePassOffAtt;
	}

	public void setHomePassOffAtt(int homePassOffAtt) {
		this.homePassOffAtt = homePassOffAtt;
	}

	@Column(name="home_pass_off_comp")
	public int getHomePassOffComp() {
		return homePassOffComp;
	}

	public void setHomePassOffComp(int homePassOffComp) {
		this.homePassOffComp = homePassOffComp;
	}

	@Column(name="home_pass_off_comp_pct")
	public Double getHomePassOffCompPct() {
		return homePassOffCompPct;
	}

	public void setHomePassOffCompPct(Double homePassOffCompPct) {
		this.homePassOffCompPct = homePassOffCompPct;
	}

	@Column(name="home_pass_off_yards")
	public int getHomePassOffYards() {
		return homePassOffYards;
	}

	public void setHomePassOffYards(int homePassOffYards) {
		this.homePassOffYards = homePassOffYards;
	}

	@Column(name="home_pass_off_ypa")
	public Double getHomePassOffYPA() {
		return homePassOffYPA;
	}

	public void setHomePassOffYPA(Double homePassOffYPA) {
		this.homePassOffYPA = homePassOffYPA;
	}

	@Column(name="home_pass_off_ints")
	public int getHomePassOffINTs() {
		return homePassOffINTs;
	}

	public void setHomePassOffINTs(int homePassOffINTs) {
		this.homePassOffINTs = homePassOffINTs;
	}

	@Column(name="home_pass_off_tds")
	public int getHomePassOffTDs() {
		return homePassOffTDs;
	}

	public void setHomePassOffTDs(int homePassOffTDs) {
		this.homePassOffTDs = homePassOffTDs;
	}

	@Column(name="home_pass_off_rating")
	public Double getHomePassOffRating() {
		return homePassOffRating;
	}

	public void setHomePassOffRating(Double homePassOffRating) {
		this.homePassOffRating = homePassOffRating;
	}

	@Column(name="home_pass_off_ypr")
	public Double getHomePassOffYPR() {
		return homePassOffYPR;
	}

	public void setHomePassOffYPR(Double homePassOffYPR) {
		this.homePassOffYPR = homePassOffYPR;
	}

	@Column(name="home_punt_returns")
	public int getHomePuntReturns() {
		return homePuntReturns;
	}

	public void setHomePuntReturns(int homePuntReturns) {
		this.homePuntReturns = homePuntReturns;
	}

	@Column(name="home_punt_return_yards")
	public int getHomePuntReturnYards() {
		return homePuntReturnYards;
	}

	public void setHomePuntReturnYards(int homePuntReturnYards) {
		this.homePuntReturnYards = homePuntReturnYards;
	}

	@Column(name="home_punt_return_average")
	public Double getHomePuntReturnAverage() {
		return homePuntReturnAverage;
	}

	public void setHomePuntReturnAverage(Double homePuntReturnAverage) {
		this.homePuntReturnAverage = homePuntReturnAverage;
	}

	@Column(name="home_punt_return_tds")
	public int getHomePuntReturnTDs() {
		return homePuntReturnTDs;
	}

	public void setHomePuntReturnTDs(int homePuntReturnTDs) {
		this.homePuntReturnTDs = homePuntReturnTDs;
	}

	@Column(name="home_kickoff_returns")
	public int getHomeKickoffReturns() {
		return homeKickoffReturns;
	}

	public void setHomeKickoffReturns(int homeKickoffReturns) {
		this.homeKickoffReturns = homeKickoffReturns;
	}

	@Column(name="home_kickoff_return_yards")
	public int getHomeKickoffReturnYards() {
		return homeKickoffReturnYards;
	}

	public void setHomeKickoffReturnYards(int homeKickoffReturnYards) {
		this.homeKickoffReturnYards = homeKickoffReturnYards;
	}

	@Column(name="home_kickoff_return_average")
	public Double getHomeKickoffReturnAverage() {
		return homeKickoffReturnAverage;
	}

	public void setHomeKickoffReturnAverage(Double homeKickoffReturnAverage) {
		this.homeKickoffReturnAverage = homeKickoffReturnAverage;
	}

	@Column(name="home_kickoff_return_tds")
	public int getHomeKickoffReturnTDs() {
		return homeKickoffReturnTDs;
	}

	public void setHomeKickoffReturnTDs(int homeKickoffReturnTDs) {
		this.homeKickoffReturnTDs = homeKickoffReturnTDs;
	}

	@Column(name="home_punts")
	public int getHomePunts() {
		return homePunts;
	}

	public void setHomePunts(int homePunts) {
		this.homePunts = homePunts;
	}

	@Column(name="home_punt_yards")
	public int getHomePuntYards() {
		return homePuntYards;
	}

	public void setHomePuntYards(int homePuntYards) {
		this.homePuntYards = homePuntYards;
	}

	@Column(name="home_punt_average")
	public Double getHomePuntAverage() {
		return homePuntAverage;
	}

	public void setHomePuntAverage(Double homePuntAverage) {
		this.homePuntAverage = homePuntAverage;
	}

	@Column(name="home_kickoffs")
	public int getHomeKickoffs() {
		return homeKickoffs;
	}

	public void setHomeKickoffs(int homeKickoffs) {
		this.homeKickoffs = homeKickoffs;
	}

	@Column(name="home_kickoff_yards")
	public int getHomeKickoffYards() {
		return homeKickoffYards;
	}

	public void setHomeKickoffYards(int homeKickoffYards) {
		this.homeKickoffYards = homeKickoffYards;
	}

	@Column(name="home_kickoff_average")
	public Double getHomeKickoffAverage() {
		return homeKickoffAverage;
	}

	public void setHomeKickoffAverage(Double homeKickoffAverage) {
		this.homeKickoffAverage = homeKickoffAverage;
	}

	@Column(name="home_kickoff_touchback")
	public int getHomeKickoffTouchback() {
		return homeKickoffTouchback;
	}

	public void setHomeKickoffTouchback(int homeKickoffTouchback) {
		this.homeKickoffTouchback = homeKickoffTouchback;
	}

	@Column(name="home_kickoff_touchback_pct")
	public Double getHomeKickoffTouchbackPct() {
		return homeKickoffTouchbackPct;
	}

	public void setHomeKickoffTouchbackPct(Double homeKickoffTouchbackPct) {
		this.homeKickoffTouchbackPct = homeKickoffTouchbackPct;
	}

	@Column(name="home_kickoff_out_of_bounds")
	public int getHomeKickoffOutOfBounds() {
		return homeKickoffOutOfBounds;
	}

	public void setHomeKickoffOutOfBounds(int homeKickoffOutOfBounds) {
		this.homeKickoffOutOfBounds = homeKickoffOutOfBounds;
	}

	@Column(name="home_kickoff_onside")
	public int getHomeKickoffOnSide() {
		return homeKickoffOnSide;
	}

	public void setHomeKickoffOnSide(int homeKickoffOnSide) {
		this.homeKickoffOnSide = homeKickoffOnSide;
	}

	@Column(name="home_fg_off_att")
	public int getHomeFGOffAtt() {
		return homeFGOffAtt;
	}

	public void setHomeFGOffAtt(int homeFGOffAtt) {
		this.homeFGOffAtt = homeFGOffAtt;
	}

	@Column(name="home_fg_off_made")
	public int getHomeFGOffMade() {
		return homeFGOffMade;
	}

	public void setHomeFGOffMade(int homeFGOffMade) {
		this.homeFGOffMade = homeFGOffMade;
	}

	@Column(name="home_fg_off_pct")
	public Double getHomeFGOffPct() {
		return homeFGOffPct;
	}

	public void setHomeFGOffPct(Double homeFGOffPct) {
		this.homeFGOffPct = homeFGOffPct;
	}

	@Column(name="home_scoring_off_tds")
	public int getHomeScoringOffTDs() {
		return homeScoringOffTDs;
	}

	public void setHomeScoringOffTDs(int homeScoringOffTDs) {
		this.homeScoringOffTDs = homeScoringOffTDs;
	}

	@Column(name="home_scoring_off_2pt_conv")
	public int getHomeScoringOff2PtConv() {
		return homeScoringOff2PtConv;
	}

	public void setHomeScoringOff2PtConv(int homeScoringOff2PtConv) {
		this.homeScoringOff2PtConv = homeScoringOff2PtConv;
	}

	@Column(name="home_scoring_off_safeties")
	public int getHomeScoringOffSafeties() {
		return homeScoringOffSafeties;
	}

	public void setHomeScoringOffSafeties(int homeScoringOffSafeties) {
		this.homeScoringOffSafeties = homeScoringOffSafeties;
	}

	@Column(name="home_scoring_off_points")
	public int getHomeScoringOffPoints() {
		return homeScoringOffPoints;
	}

	public void setHomeScoringOffPoints(int homeScoringOffPoints) {
		this.homeScoringOffPoints = homeScoringOffPoints;
	}

	@Column(name="home_total_off_plays")
	public int getHomeTotalOffPlays() {
		return homeTotalOffPlays;
	}

	public void setHomeTotalOffPlays(int homeTotalOffPlays) {
		this.homeTotalOffPlays = homeTotalOffPlays;
	}

	@Column(name="home_scoring_off_yards")
	public int getHomeTotalOffYards() {
		return homeTotalOffYards;
	}

	public void setHomeTotalOffYards(int homeTotalOffYards) {
		this.homeTotalOffYards = homeTotalOffYards;
	}

	@Column(name="home_scoring_off_ypp")
	public Double getHomeTotalOffYPP() {
		return homeTotalOffYPP;
	}

	public void setHomeTotalOffYPP(Double homeTotalOffYPP) {
		this.homeTotalOffYPP = homeTotalOffYPP;
	}

	@Column(name="home_pass_def_ints")
	public Integer getHomePassDefInts() {
		return homePassDefInts;
	}

	public void setHomePassDefInts(Integer homePassDefInts) {
		this.homePassDefInts = homePassDefInts;
	}

	@Column(name="home_pass_def_int_yards")
	public Integer getHomePassDefIntYards() {
		return homePassDefIntYards;
	}

	public void setHomePassDefIntYards(Integer homePassDefIntYards) {
		this.homePassDefIntYards = homePassDefIntYards;
	}

	@Column(name="home_pass_def_int_tds")
	public Integer getHomePassDefIntTDs() {
		return homePassDefIntTDs;
	}

	public void setHomePassDefIntTDs(Integer homePassDefIntTDs) {
		this.homePassDefIntTDs = homePassDefIntTDs;
	}

	@Column(name="home_fumble_returns")
	public Integer getHomeFumbleReturns() {
		return homeFumbleReturns;
	}

	public void setHomeFumbleReturns(Integer homeFumbleReturns) {
		this.homeFumbleReturns = homeFumbleReturns;
	}

	@Column(name="home_fumble_return_yards")
	public Integer getHomeFumbleReturnYards() {
		return homeFumbleReturnYards;
	}

	public void setHomeFumbleReturnYards(Integer homeFumbleReturnYards) {
		this.homeFumbleReturnYards = homeFumbleReturnYards;
	}

	@Column(name="home_fumble_return_tds")
	public Integer getHomeFumbleReturnTDs() {
		return homeFumbleReturnTDs;
	}

	public void setHomeFumbleReturnTDs(Integer homeFumbleReturnTDs) {
		this.homeFumbleReturnTDs = homeFumbleReturnTDs;
	}

	@Column(name="home_total_tackles")
	public Integer getHomeTotalTackles() {
		return homeTotalTackles;
	}

	public void setHomeTotalTackles(Integer homeTotalTackles) {
		this.homeTotalTackles = homeTotalTackles;
	}

	@Column(name="home_tfls")
	public Integer getHomeTFLs() {
		return homeTFLs;
	}

	public void setHomeTFLs(Integer homeTFLs) {
		this.homeTFLs = homeTFLs;
	}
	
	@Column(name="home_tfl_yards")
	public Integer getHomeTFLYards() {
		return homeTFLYards;
	}

	public void setHomeTFLYards(Integer homeTFLYards) {
		this.homeTFLYards = homeTFLYards;
	}

	@Column(name="home_sacks")
	public Integer getHomeSacks() {
		return homeSacks;
	}

	public void setHomeSacks(Integer homeSacks) {
		this.homeSacks = homeSacks;
	}

	@Column(name="home_sack_yards")
	public Integer getHomeSackYards() {
		return homeSackYards;
	}

	public void setHomeSackYards(Integer homeSackYards) {
		this.homeSackYards = homeSackYards;
	}

	@Column(name="home_passes_broken_up")
	public Integer getHomePassesBrokenUp() {
		return homePassesBrokenUp;
	}

	public void setHomePassesBrokenUp(Integer homePassesBrokenUp) {
		this.homePassesBrokenUp = homePassesBrokenUp;
	}

	@Column(name="home_qb_hurries")
	public Integer getHomeQBHurries() {
		return homeQBHurries;
	}

	public void setHomeQBHurries(Integer homeQBHurries) {
		this.homeQBHurries = homeQBHurries;
	}

	@Column(name="home_fumbles_forced")
	public Integer getHomeFumblesForced() {
		return homeFumblesForced;
	}

	public void setHomeFumblesForced(Integer homeFumblesForced) {
		this.homeFumblesForced = homeFumblesForced;
	}

	@Column(name="home_punt_kicks_blocked")
	public Integer getHomePuntKicksBlocked() {
		return homePuntKicksBlocked;
	}

	public void setHomePuntKicksBlocked(Integer homePuntKicksBlocked) {
		this.homePuntKicksBlocked = homePuntKicksBlocked;
	}

	@Column(name="home_first_down_off_rush")
	public int getHomeFirstDownOffRush() {
		return homeFirstDownOffRush;
	}

	public void setHomeFirstDownOffRush(int homeFirstDownOffRush) {
		this.homeFirstDownOffRush = homeFirstDownOffRush;
	}

	@Column(name="home_first_down_off_pass")
	public int getHomeFirstDownOffPass() {
		return homeFirstDownOffPass;
	}

	public void setHomeFirstDownOffPass(int homeFirstDownOffPass) {
		this.homeFirstDownOffPass = homeFirstDownOffPass;
	}

	@Column(name="home_first_down_off_penalty")
	public int getHomeFirstDownOffPenalty() {
		return homeFirstDownOffPenalty;
	}

	public void setHomeFirstDownOffPenalty(int homeFirstDownOffPenalty) {
		this.homeFirstDownOffPenalty = homeFirstDownOffPenalty;
	}

	@Column(name="home_first_down_off_total")
	public int getHomeFirstDownOffTotal() {
		return homeFirstDownOffTotal;
	}

	public void setHomeFirstDownOffTotal(int homeFirstDownOffTotal) {
		this.homeFirstDownOffTotal = homeFirstDownOffTotal;
	}

	@Column(name="home_penalties")
	public int getHomePenalties() {
		return homePenalties;
	}

	public void setHomePenalties(int homePenalties) {
		this.homePenalties = homePenalties;
	}

	@Column(name="home_penalty_yards")
	public int getHomePenaltyYards() {
		return homePenaltyYards;
	}

	public void setHomePenaltyYards(int homePenaltyYards) {
		this.homePenaltyYards = homePenaltyYards;
	}

	@Column(name="home_third_down_off_att")
	public int getHomeThirdDownOffAtt() {
		return homeThirdDownOffAtt;
	}

	public void setHomeThirdDownOffAtt(int homeThirdDownOffAtt) {
		this.homeThirdDownOffAtt = homeThirdDownOffAtt;
	}

	@Column(name="home_third_down_off_conv")
	public int getHomeThirdDownOffConv() {
		return homeThirdDownOffConv;
	}

	public void setHomeThirdDownOffConv(int homeThirdDownOffConv) {
		this.homeThirdDownOffConv = homeThirdDownOffConv;
	}

	@Column(name="home_third_down_off_conv_pct")
	public Double getHomeThirdDownOffConvPct() {
		return homeThirdDownOffConvPct;
	}

	public void setHomeThirdDownOffConvPct(Double homeThirdDownOffConvPct) {
		this.homeThirdDownOffConvPct = homeThirdDownOffConvPct;
	}

	@Column(name="home_fourth_down_off_att")
	public int getHomeFourthDownOffAtt() {
		return homeFourthDownOffAtt;
	}

	public void setHomeFourthDownOffAtt(int homeFourthDownOffAtt) {
		this.homeFourthDownOffAtt = homeFourthDownOffAtt;
	}

	@Column(name="home_fourth_down_off_conv")
	public int getHomeFourthDownOffConv() {
		return homeFourthDownOffConv;
	}

	public void setHomeFourthDownOffConv(int homeFourthDownOffConv) {
		this.homeFourthDownOffConv = homeFourthDownOffConv;
	}

	@Column(name="home_fourth_down_off_conv_pct")
	public Double getHomeFourthDownOffConvPct() {
		return homeFourthDownOffConvPct;
	}

	public void setHomeFourthDownOffConvPct(Double homeFourthDownOffConvPct) {
		this.homeFourthDownOffConvPct = homeFourthDownOffConvPct;
	}

	@Column(name="home_off_red_zone_att")
	public int getHomeOffRedZoneAtt() {
		return homeOffRedZoneAtt;
	}

	public void setHomeOffRedZoneAtt(int homeOffRedZoneAtt) {
		this.homeOffRedZoneAtt = homeOffRedZoneAtt;
	}

	@Column(name="home_off_red_zone_scores")
	public int getHomeOffRedZoneScores() {
		return homeOffRedZoneScores;
	}

	public void setHomeOffRedZoneScores(int homeOffRedZoneScores) {
		this.homeOffRedZoneScores = homeOffRedZoneScores;
	}

	@Column(name="home_off_red_zone_score_pct")
	public Double getHomeOffRedZoneScorePct() {
		return homeOffRedZoneScorePct;
	}

	public void setHomeOffRedZoneScorePct(Double homeOffRedZoneScorePct) {
		this.homeOffRedZoneScorePct = homeOffRedZoneScorePct;
	}

	@Column(name="home_off_red_zone_tds")
	public int getHomeOffRedZoneTDs() {
		return homeOffRedZoneTDs;
	}

	public void setHomeOffRedZoneTDs(int homeOffRedZoneTDs) {
		this.homeOffRedZoneTDs = homeOffRedZoneTDs;
	}

	@Column(name="home_off_red_zone_td_pct")
	public Double getHomeOffRedZoneTDPct() {
		return homeOffRedZoneTDPct;
	}

	public void setHomeOffRedZoneTDPct(Double homeOffRedZoneTDPct) {
		this.homeOffRedZoneTDPct = homeOffRedZoneTDPct;
	}

	@Column(name="home_off_red_zone_fgs")
	public int getHomeOffRedZoneFGs() {
		return homeOffRedZoneFGs;
	}

	public void setHomeOffRedZoneFGs(int homeOffRedZoneFGs) {
		this.homeOffRedZoneFGs = homeOffRedZoneFGs;
	}

	@Column(name="home_off_red_zone_fg_pct")
	public Double getHomeOffRedZoneFGPct() {
		return homeOffRedZoneFGPct;
	}

	public void setHomeOffRedZoneFGPct(Double homeOffRedZoneFGPct) {
		this.homeOffRedZoneFGPct = homeOffRedZoneFGPct;
	}

	@Column(name="home_fumble_gain")
	public Integer getHomeFumbleGain() {
		return homeFumbleGain;
	}

	public void setHomeFumbleGain(Integer homeFumbleGain) {
		this.homeFumbleGain = homeFumbleGain;
	}

	@Column(name="home_fumble_lost")
	public Integer getHomeFumbleLost() {
		return homeFumbleLost;
	}

	public void setHomeFumbleLost(Integer homeFumbleLost) {
		this.homeFumbleLost = homeFumbleLost;
	}

	@Column(name="home_turnover_margin")
	public Integer getHomeTurnoverMargin() {
		return homeTurnoverMargin;
	}

	public void setHomeTurnoverMargin(Integer homeTurnoverMargin) {
		this.homeTurnoverMargin = homeTurnoverMargin;
	}
	
	// away setters and getters
	@Column(name = "away_rush_off_att")
	public int getAwayRushOffAtt() {
		return awayRushOffAtt;
	}

	public void setAwayRushOffAtt(int awayRushOffAtt) {
		this.awayRushOffAtt = awayRushOffAtt;
	}

	@Column(name = "away_rush_off_yards")
	public int getAwayRushOffYards() {
		return awayRushOffYards;
	}

	public void setAwayRushOffYards(int awayRushOffYards) {
		this.awayRushOffYards = awayRushOffYards;
	}

	@Column(name = "away_rush_off_ypa")
	public Double getAwayRushOffYPA() {
		return awayRushOffYPA;
	}

	public void setAwayRushOffYPA(Double awayRushOffYPA) {
		this.awayRushOffYPA = awayRushOffYPA;
	}

	@Column(name = "away_rush_off_tds")
	public int getAwayRushOffTDs() {
		return awayRushOffTDs;
	}

	public void setAwayRushOffTDs(int awayRushOffTDs) {
		this.awayRushOffTDs = awayRushOffTDs;
	}

	@Column(name = "away_pass_off_att")
	public int getAwayPassOffAtt() {
		return awayPassOffAtt;
	}

	public void setAwayPassOffAtt(int awayPassOffAtt) {
		this.awayPassOffAtt = awayPassOffAtt;
	}

	@Column(name = "away_pass_off_comp")
	public int getAwayPassOffComp() {
		return awayPassOffComp;
	}

	public void setAwayPassOffComp(int awayPassOffComp) {
		this.awayPassOffComp = awayPassOffComp;
	}

	@Column(name = "away_pass_off_comp_pct")
	public Double getAwayPassOffCompPct() {
		return awayPassOffCompPct;
	}

	public void setAwayPassOffCompPct(Double awayPassOffCompPct) {
		this.awayPassOffCompPct = awayPassOffCompPct;
	}

	@Column(name = "away_pass_off_yards")
	public int getAwayPassOffYards() {
		return awayPassOffYards;
	}

	public void setAwayPassOffYards(int awayPassOffYards) {
		this.awayPassOffYards = awayPassOffYards;
	}

	@Column(name = "away_pass_off_ypa")
	public Double getAwayPassOffYPA() {
		return awayPassOffYPA;
	}

	public void setAwayPassOffYPA(Double awayPassOffYPA) {
		this.awayPassOffYPA = awayPassOffYPA;
	}

	@Column(name = "away_pass_off_ints")
	public int getAwayPassOffINTs() {
		return awayPassOffINTs;
	}

	public void setAwayPassOffINTs(int awayPassOffINTs) {
		this.awayPassOffINTs = awayPassOffINTs;
	}

	@Column(name = "away_pass_off_tds")
	public int getAwayPassOffTDs() {
		return awayPassOffTDs;
	}

	public void setAwayPassOffTDs(int awayPassOffTDs) {
		this.awayPassOffTDs = awayPassOffTDs;
	}

	@Column(name = "away_pass_off_rating")
	public Double getAwayPassOffRating() {
		return awayPassOffRating;
	}

	public void setAwayPassOffRating(Double awayPassOffRating) {
		this.awayPassOffRating = awayPassOffRating;
	}

	@Column(name = "away_pass_off_ypr")
	public Double getAwayPassOffYPR() {
		return awayPassOffYPR;
	}

	public void setAwayPassOffYPR(Double awayPassOffYPR) {
		this.awayPassOffYPR = awayPassOffYPR;
	}

	@Column(name = "away_punt_returns")
	public int getAwayPuntReturns() {
		return awayPuntReturns;
	}

	public void setAwayPuntReturns(int awayPuntReturns) {
		this.awayPuntReturns = awayPuntReturns;
	}

	@Column(name = "away_punt_return_yards")
	public int getAwayPuntReturnYards() {
		return awayPuntReturnYards;
	}

	public void setAwayPuntReturnYards(int awayPuntReturnYards) {
		this.awayPuntReturnYards = awayPuntReturnYards;
	}

	@Column(name = "away_punt_return_average")
	public Double getAwayPuntReturnAverage() {
		return awayPuntReturnAverage;
	}

	public void setAwayPuntReturnAverage(Double awayPuntReturnAverage) {
		this.awayPuntReturnAverage = awayPuntReturnAverage;
	}

	@Column(name = "away_punt_return_tds")
	public int getAwayPuntReturnTDs() {
		return awayPuntReturnTDs;
	}

	public void setAwayPuntReturnTDs(int awayPuntReturnTDs) {
		this.awayPuntReturnTDs = awayPuntReturnTDs;
	}

	@Column(name = "away_kickoff_returns")
	public int getAwayKickoffReturns() {
		return awayKickoffReturns;
	}

	public void setAwayKickoffReturns(int awayKickoffReturns) {
		this.awayKickoffReturns = awayKickoffReturns;
	}

	@Column(name = "away_kickoff_return_yards")
	public int getAwayKickoffReturnYards() {
		return awayKickoffReturnYards;
	}

	public void setAwayKickoffReturnYards(int awayKickoffReturnYards) {
		this.awayKickoffReturnYards = awayKickoffReturnYards;
	}

	@Column(name = "away_kickoff_return_average")
	public Double getAwayKickoffReturnAverage() {
		return awayKickoffReturnAverage;
	}

	public void setAwayKickoffReturnAverage(Double awayKickoffReturnAverage) {
		this.awayKickoffReturnAverage = awayKickoffReturnAverage;
	}

	@Column(name = "away_kickoff_return_tds")
	public int getAwayKickoffReturnTDs() {
		return awayKickoffReturnTDs;
	}

	public void setAwayKickoffReturnTDs(int awayKickoffReturnTDs) {
		this.awayKickoffReturnTDs = awayKickoffReturnTDs;
	}

	@Column(name = "away_punts")
	public int getAwayPunts() {
		return awayPunts;
	}

	public void setAwayPunts(int awayPunts) {
		this.awayPunts = awayPunts;
	}

	@Column(name = "away_punt_yards")
	public int getAwayPuntYards() {
		return awayPuntYards;
	}

	public void setAwayPuntYards(int awayPuntYards) {
		this.awayPuntYards = awayPuntYards;
	}

	@Column(name = "away_punt_average")
	public Double getAwayPuntAverage() {
		return awayPuntAverage;
	}

	public void setAwayPuntAverage(Double awayPuntAverage) {
		this.awayPuntAverage = awayPuntAverage;
	}

	@Column(name = "away_kickoffs")
	public int getAwayKickoffs() {
		return awayKickoffs;
	}

	public void setAwayKickoffs(int awayKickoffs) {
		this.awayKickoffs = awayKickoffs;
	}

	@Column(name = "away_kickoff_yards")
	public int getAwayKickoffYards() {
		return awayKickoffYards;
	}

	public void setAwayKickoffYards(int awayKickoffYards) {
		this.awayKickoffYards = awayKickoffYards;
	}

	@Column(name = "away_kickoff_average")
	public Double getAwayKickoffAverage() {
		return awayKickoffAverage;
	}

	public void setAwayKickoffAverage(Double awayKickoffAverage) {
		this.awayKickoffAverage = awayKickoffAverage;
	}

	@Column(name = "away_kickoff_touchback")
	public int getAwayKickoffTouchback() {
		return awayKickoffTouchback;
	}

	public void setAwayKickoffTouchback(int awayKickoffTouchback) {
		this.awayKickoffTouchback = awayKickoffTouchback;
	}

	@Column(name = "away_kickoff_touchback_pct")
	public Double getAwayKickoffTouchbackPct() {
		return awayKickoffTouchbackPct;
	}

	public void setAwayKickoffTouchbackPct(Double awayKickoffTouchbackPct) {
		this.awayKickoffTouchbackPct = awayKickoffTouchbackPct;
	}

	@Column(name = "away_kickoff_out_of_bounds")
	public int getAwayKickoffOutOfBounds() {
		return awayKickoffOutOfBounds;
	}

	public void setAwayKickoffOutOfBounds(int awayKickoffOutOfBounds) {
		this.awayKickoffOutOfBounds = awayKickoffOutOfBounds;
	}

	@Column(name = "away_kickoff_onside")
	public int getAwayKickoffOnSide() {
		return awayKickoffOnSide;
	}

	public void setAwayKickoffOnSide(int awayKickoffOnSide) {
		this.awayKickoffOnSide = awayKickoffOnSide;
	}

	@Column(name = "away_fg_off_att")
	public int getAwayFGOffAtt() {
		return awayFGOffAtt;
	}

	public void setAwayFGOffAtt(int awayFGOffAtt) {
		this.awayFGOffAtt = awayFGOffAtt;
	}

	@Column(name = "away_fg_off_made")
	public int getAwayFGOffMade() {
		return awayFGOffMade;
	}

	public void setAwayFGOffMade(int awayFGOffMade) {
		this.awayFGOffMade = awayFGOffMade;
	}

	@Column(name = "away_fg_off_pct")
	public Double getAwayFGOffPct() {
		return awayFGOffPct;
	}

	public void setAwayFGOffPct(Double awayFGOffPct) {
		this.awayFGOffPct = awayFGOffPct;
	}

	@Column(name = "away_scoring_off_tds")
	public int getAwayScoringOffTDs() {
		return awayScoringOffTDs;
	}

	public void setAwayScoringOffTDs(int awayScoringOffTDs) {
		this.awayScoringOffTDs = awayScoringOffTDs;
	}

	@Column(name = "away_scoring_off_2pt_conv")
	public int getAwayScoringOff2PtConv() {
		return awayScoringOff2PtConv;
	}

	public void setAwayScoringOff2PtConv(int awayScoringOff2PtConv) {
		this.awayScoringOff2PtConv = awayScoringOff2PtConv;
	}

	@Column(name = "away_scoring_off_safeties")
	public int getAwayScoringOffSafeties() {
		return awayScoringOffSafeties;
	}

	public void setAwayScoringOffSafeties(int awayScoringOffSafeties) {
		this.awayScoringOffSafeties = awayScoringOffSafeties;
	}

	@Column(name = "away_scoring_off_points")
	public int getAwayScoringOffPoints() {
		return awayScoringOffPoints;
	}

	public void setAwayScoringOffPoints(int awayScoringOffPoints) {
		this.awayScoringOffPoints = awayScoringOffPoints;
	}

	@Column(name = "away_total_off_plays")
	public int getAwayTotalOffPlays() {
		return awayTotalOffPlays;
	}

	public void setAwayTotalOffPlays(int awayTotalOffPlays) {
		this.awayTotalOffPlays = awayTotalOffPlays;
	}

	@Column(name = "away_scoring_off_yards")
	public int getAwayTotalOffYards() {
		return awayTotalOffYards;
	}

	public void setAwayTotalOffYards(int awayTotalOffYards) {
		this.awayTotalOffYards = awayTotalOffYards;
	}

	@Column(name = "away_scoring_off_ypp")
	public Double getAwayTotalOffYPP() {
		return awayTotalOffYPP;
	}

	public void setAwayTotalOffYPP(Double awayTotalOffYPP) {
		this.awayTotalOffYPP = awayTotalOffYPP;
	}

	@Column(name = "away_pass_def_ints")
	public Integer getAwayPassDefInts() {
		return awayPassDefInts;
	}

	public void setAwayPassDefInts(Integer awayPassDefInts) {
		this.awayPassDefInts = awayPassDefInts;
	}

	@Column(name = "away_pass_def_int_yards")
	public Integer getAwayPassDefIntYards() {
		return awayPassDefIntYards;
	}

	public void setAwayPassDefIntYards(Integer awayPassDefIntYards) {
		this.awayPassDefIntYards = awayPassDefIntYards;
	}

	@Column(name = "away_pass_def_int_tds")
	public Integer getAwayPassDefIntTDs() {
		return awayPassDefIntTDs;
	}

	public void setAwayPassDefIntTDs(Integer awayPassDefIntTDs) {
		this.awayPassDefIntTDs = awayPassDefIntTDs;
	}

	@Column(name = "away_fumble_returns")
	public Integer getAwayFumbleReturns() {
		return awayFumbleReturns;
	}

	public void setAwayFumbleReturns(Integer awayFumbleReturns) {
		this.awayFumbleReturns = awayFumbleReturns;
	}

	@Column(name = "away_fumble_return_yards")
	public Integer getAwayFumbleReturnYards() {
		return awayFumbleReturnYards;
	}

	public void setAwayFumbleReturnYards(Integer awayFumbleReturnYards) {
		this.awayFumbleReturnYards = awayFumbleReturnYards;
	}

	@Column(name = "away_fumble_return_tds")
	public Integer getAwayFumbleReturnTDs() {
		return awayFumbleReturnTDs;
	}

	public void setAwayFumbleReturnTDs(Integer awayFumbleReturnTDs) {
		this.awayFumbleReturnTDs = awayFumbleReturnTDs;
	}

	@Column(name = "away_total_tackles")
	public Integer getAwayTotalTackles() {
		return awayTotalTackles;
	}

	public void setAwayTotalTackles(Integer awayTotalTackles) {
		this.awayTotalTackles = awayTotalTackles;
	}

	@Column(name = "away_tfls")
	public Integer getAwayTFLs() {
		return awayTFLs;
	}

	public void setAwayTFLs(Integer awayTFLs) {
		this.awayTFLs = awayTFLs;
	}

	@Column(name = "away_tfl_yards")
	public Integer getAwayTFLYards() {
		return awayTFLYards;
	}

	public void setAwayTFLYards(Integer awayTFLYards) {
		this.awayTFLYards = awayTFLYards;
	}

	@Column(name = "away_sacks")
	public Integer getAwaySacks() {
		return awaySacks;
	}

	public void setAwaySacks(Integer awaySacks) {
		this.awaySacks = awaySacks;
	}

	@Column(name = "away_sack_yards")
	public Integer getAwaySackYards() {
		return awaySackYards;
	}

	public void setAwaySackYards(Integer awaySackYards) {
		this.awaySackYards = awaySackYards;
	}

	@Column(name = "away_passes_broken_up")
	public Integer getAwayPassesBrokenUp() {
		return awayPassesBrokenUp;
	}

	public void setAwayPassesBrokenUp(Integer awayPassesBrokenUp) {
		this.awayPassesBrokenUp = awayPassesBrokenUp;
	}

	@Column(name = "away_qb_hurries")
	public Integer getAwayQBHurries() {
		return awayQBHurries;
	}

	public void setAwayQBHurries(Integer awayQBHurries) {
		this.awayQBHurries = awayQBHurries;
	}

	@Column(name = "away_fumbles_forced")
	public Integer getAwayFumblesForced() {
		return awayFumblesForced;
	}

	public void setAwayFumblesForced(Integer awayFumblesForced) {
		this.awayFumblesForced = awayFumblesForced;
	}

	@Column(name = "away_punt_kicks_blocked")
	public Integer getAwayPuntKicksBlocked() {
		return awayPuntKicksBlocked;
	}

	public void setAwayPuntKicksBlocked(Integer awayPuntKicksBlocked) {
		this.awayPuntKicksBlocked = awayPuntKicksBlocked;
	}

	@Column(name = "away_first_down_off_rush")
	public int getAwayFirstDownOffRush() {
		return awayFirstDownOffRush;
	}

	public void setAwayFirstDownOffRush(int awayFirstDownOffRush) {
		this.awayFirstDownOffRush = awayFirstDownOffRush;
	}

	@Column(name = "away_first_down_off_pass")
	public int getAwayFirstDownOffPass() {
		return awayFirstDownOffPass;
	}

	public void setAwayFirstDownOffPass(int awayFirstDownOffPass) {
		this.awayFirstDownOffPass = awayFirstDownOffPass;
	}

	@Column(name = "away_first_down_off_penalty")
	public int getAwayFirstDownOffPenalty() {
		return awayFirstDownOffPenalty;
	}

	public void setAwayFirstDownOffPenalty(int awayFirstDownOffPenalty) {
		this.awayFirstDownOffPenalty = awayFirstDownOffPenalty;
	}

	@Column(name = "away_first_down_off_total")
	public int getAwayFirstDownOffTotal() {
		return awayFirstDownOffTotal;
	}

	public void setAwayFirstDownOffTotal(int awayFirstDownOffTotal) {
		this.awayFirstDownOffTotal = awayFirstDownOffTotal;
	}

	@Column(name = "away_penalties")
	public int getAwayPenalties() {
		return awayPenalties;
	}

	public void setAwayPenalties(int awayPenalties) {
		this.awayPenalties = awayPenalties;
	}

	@Column(name = "away_penalty_yards")
	public int getAwayPenaltyYards() {
		return awayPenaltyYards;
	}

	public void setAwayPenaltyYards(int awayPenaltyYards) {
		this.awayPenaltyYards = awayPenaltyYards;
	}

	@Column(name = "away_third_down_off_att")
	public int getAwayThirdDownOffAtt() {
		return awayThirdDownOffAtt;
	}

	public void setAwayThirdDownOffAtt(int awayThirdDownOffAtt) {
		this.awayThirdDownOffAtt = awayThirdDownOffAtt;
	}

	@Column(name = "away_third_down_off_conv")
	public int getAwayThirdDownOffConv() {
		return awayThirdDownOffConv;
	}

	public void setAwayThirdDownOffConv(int awayThirdDownOffConv) {
		this.awayThirdDownOffConv = awayThirdDownOffConv;
	}

	@Column(name = "away_third_down_off_conv_pct")
	public Double getAwayThirdDownOffConvPct() {
		return awayThirdDownOffConvPct;
	}

	public void setAwayThirdDownOffConvPct(Double awayThirdDownOffConvPct) {
		this.awayThirdDownOffConvPct = awayThirdDownOffConvPct;
	}

	@Column(name = "away_fourth_down_off_att")
	public int getAwayFourthDownOffAtt() {
		return awayFourthDownOffAtt;
	}

	public void setAwayFourthDownOffAtt(int awayFourthDownOffAtt) {
		this.awayFourthDownOffAtt = awayFourthDownOffAtt;
	}

	@Column(name = "away_fourth_down_off_conv")
	public int getAwayFourthDownOffConv() {
		return awayFourthDownOffConv;
	}

	public void setAwayFourthDownOffConv(int awayFourthDownOffConv) {
		this.awayFourthDownOffConv = awayFourthDownOffConv;
	}

	@Column(name = "away_fourth_down_off_conv_pct")
	public Double getAwayFourthDownOffConvPct() {
		return awayFourthDownOffConvPct;
	}

	public void setAwayFourthDownOffConvPct(Double awayFourthDownOffConvPct) {
		this.awayFourthDownOffConvPct = awayFourthDownOffConvPct;
	}

	@Column(name = "away_off_red_zone_att")
	public int getAwayOffRedZoneAtt() {
		return awayOffRedZoneAtt;
	}

	public void setAwayOffRedZoneAtt(int awayOffRedZoneAtt) {
		this.awayOffRedZoneAtt = awayOffRedZoneAtt;
	}

	@Column(name = "away_off_red_zone_scores")
	public int getAwayOffRedZoneScores() {
		return awayOffRedZoneScores;
	}

	public void setAwayOffRedZoneScores(int awayOffRedZoneScores) {
		this.awayOffRedZoneScores = awayOffRedZoneScores;
	}

	@Column(name = "away_off_red_zone_score_pct")
	public Double getAwayOffRedZoneScorePct() {
		return awayOffRedZoneScorePct;
	}

	public void setAwayOffRedZoneScorePct(Double awayOffRedZoneScorePct) {
		this.awayOffRedZoneScorePct = awayOffRedZoneScorePct;
	}

	@Column(name = "away_off_red_zone_tds")
	public int getAwayOffRedZoneTDs() {
		return awayOffRedZoneTDs;
	}

	public void setAwayOffRedZoneTDs(int awayOffRedZoneTDs) {
		this.awayOffRedZoneTDs = awayOffRedZoneTDs;
	}

	@Column(name = "away_off_red_zone_td_pct")
	public Double getAwayOffRedZoneTDPct() {
		return awayOffRedZoneTDPct;
	}

	public void setAwayOffRedZoneTDPct(Double awayOffRedZoneTDPct) {
		this.awayOffRedZoneTDPct = awayOffRedZoneTDPct;
	}

	@Column(name = "away_off_red_zone_fgs")
	public int getAwayOffRedZoneFGs() {
		return awayOffRedZoneFGs;
	}

	public void setAwayOffRedZoneFGs(int awayOffRedZoneFGs) {
		this.awayOffRedZoneFGs = awayOffRedZoneFGs;
	}

	@Column(name = "away_off_red_zone_fg_pct")
	public Double getAwayOffRedZoneFGPct() {
		return awayOffRedZoneFGPct;
	}

	public void setAwayOffRedZoneFGPct(Double awayOffRedZoneFGPct) {
		this.awayOffRedZoneFGPct = awayOffRedZoneFGPct;
	}

	@Column(name = "away_fumble_gain")
	public Integer getAwayFumbleGain() {
		return awayFumbleGain;
	}

	public void setAwayFumbleGain(Integer awayFumbleGain) {
		this.awayFumbleGain = awayFumbleGain;
	}

	@Column(name = "away_fumble_lost")
	public Integer getAwayFumbleLost() {
		return awayFumbleLost;
	}

	public void setAwayFumbleLost(Integer awayFumbleLost) {
		this.awayFumbleLost = awayFumbleLost;
	}

	@Column(name = "away_turnover_margin")
	public Integer getAwayTurnoverMargin() {
		return awayTurnoverMargin;
	}

	public void setAwayTurnoverMargin(Integer awayTurnoverMargin) {
		this.awayTurnoverMargin = awayTurnoverMargin;
	}
 
}
