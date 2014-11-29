package svm.predictor.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import svm.predictor.dao.GameInfoDao;
import svm.predictor.domain.GameInfo;

public class GameInfoDaoImpl extends BaseDao<GameInfo, Integer> implements GameInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Date> getAllGameDates() {
		Session session = getSessionFactory().getCurrentSession();
		List<Date> result = session.createQuery("select distinct g.gameDate from GameInfo g order by g.gameDate").list();
		return result;
	}


}
