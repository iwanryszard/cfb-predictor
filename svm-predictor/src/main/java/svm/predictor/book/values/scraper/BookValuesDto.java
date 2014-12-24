package svm.predictor.book.values.scraper;

public class BookValuesDto {

	private Double pointSpread;
	private Double pointTotal;
	private Double homeStraightOdds;
	private Double awayStraightOdds;
	
	public Double getPointSpread() {
		return pointSpread;
	}
	public void setPointSpread(Double pointSpread) {
		this.pointSpread = pointSpread;
	}
	public Double getPointTotal() {
		return pointTotal;
	}
	public void setPointTotal(Double pointTotal) {
		this.pointTotal = pointTotal;
	}
	public Double getHomeStraightOdds() {
		return homeStraightOdds;
	}
	public void setHomeStraightOdds(Double homeStraightOdds) {
		this.homeStraightOdds = homeStraightOdds;
	}
	public Double getAwayStraightOdds() {
		return awayStraightOdds;
	}
	public void setAwayStraightOdds(Double awayStraightOdds) {
		this.awayStraightOdds = awayStraightOdds;
	}
	@Override
	public String toString() {
		return "BookValuesDto [pointSpread=" + pointSpread + ", pointTotal="
				+ pointTotal + ", homeStraightOdds=" + homeStraightOdds
				+ ", awayStraightOdds=" + awayStraightOdds + "]";
	}
}
