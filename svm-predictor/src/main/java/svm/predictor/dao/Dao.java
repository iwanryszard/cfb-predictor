package svm.predictor.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import svm.predictor.domain.BaseEntity;

public interface Dao<T extends BaseEntity<PK>, PK extends Serializable> {
	T create(T entity);
	List<T> list();
	void update(T entity);
	List<T> list(Map<String, Object> parameters, String orderBy);
}
