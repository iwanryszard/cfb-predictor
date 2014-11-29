package svm.predictor.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import svm.predictor.dto.BaseDto;

public interface Service<T extends BaseDto<PK>, PK extends Serializable> {

	T create(T dto);
	List<T> list();
	List<T> list(Map<String, Object> parameters, String orderBy);
	void update(T dto);
}
