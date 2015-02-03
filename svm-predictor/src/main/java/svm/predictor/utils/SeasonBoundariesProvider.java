package svm.predictor.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service("seasonBoundariesProvider")
public class SeasonBoundariesProvider {

	private Calendar calendar;
	
	public SeasonBoundariesProvider() {
		calendar = Calendar.getInstance();
	}
	
	public synchronized Date getSeasonStartDate(int season) {
		calendar.set(season, Calendar.AUGUST, 15);
		Date seasonStart = calendar.getTime();
		return seasonStart;
	}
	
	public synchronized Date getSeasonEndDate(int season) {
		calendar.set(season + 1, Calendar.FEBRUARY, 20);
		Date seasonEnd = calendar.getTime();
		return seasonEnd;
	}
}
