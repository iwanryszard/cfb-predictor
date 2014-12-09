package svm.predictor.dto;

public class AggregatedGameStatsDto extends BaseDto<Integer> {

	private GameInfoDto game;
	
	private TeamAggregatedGameStatsDto homeTeamStats;
	private TeamSimpleAggregatedStats homeTeamLastFive;
	private TeamSimpleAggregatedStats homeTeamLastSeason;
	
	private TeamAggregatedGameStatsDto awayTeamStats;
	private TeamSimpleAggregatedStats awayTeamLastFive;
	private TeamSimpleAggregatedStats awayTeamLastSeason;
	
	public GameInfoDto getGame() {
		return game;
	}
	public void setGame(GameInfoDto game) {
		this.game = game;
	}
	public TeamAggregatedGameStatsDto getHomeTeamStats() {
		return homeTeamStats;
	}
	public void setHomeTeamStats(TeamAggregatedGameStatsDto homeTeamStats) {
		this.homeTeamStats = homeTeamStats;
	}
	public TeamSimpleAggregatedStats getHomeTeamLastFive() {
		return homeTeamLastFive;
	}
	public void setHomeTeamLastFive(TeamSimpleAggregatedStats homeTeamLastFive) {
		this.homeTeamLastFive = homeTeamLastFive;
	}
	public TeamSimpleAggregatedStats getHomeTeamLastSeason() {
		return homeTeamLastSeason;
	}
	public void setHomeTeamLastSeason(TeamSimpleAggregatedStats homeTeamLastSeason) {
		this.homeTeamLastSeason = homeTeamLastSeason;
	}
	public TeamAggregatedGameStatsDto getAwayTeamStats() {
		return awayTeamStats;
	}
	public void setAwayTeamStats(TeamAggregatedGameStatsDto awayTeamStats) {
		this.awayTeamStats = awayTeamStats;
	}
	public TeamSimpleAggregatedStats getAwayTeamLastFive() {
		return awayTeamLastFive;
	}
	public void setAwayTeamLastFive(TeamSimpleAggregatedStats awayTeamLastFive) {
		this.awayTeamLastFive = awayTeamLastFive;
	}
	public TeamSimpleAggregatedStats getAwayTeamLastSeason() {
		return awayTeamLastSeason;
	}
	public void setAwayTeamLastSeason(TeamSimpleAggregatedStats awayTeamLastSeason) {
		this.awayTeamLastSeason = awayTeamLastSeason;
	}
	
	
}
