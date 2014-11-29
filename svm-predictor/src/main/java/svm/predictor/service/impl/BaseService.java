package svm.predictor.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import svm.predictor.assembler.BaseAssembler;
import svm.predictor.dao.Dao;
import svm.predictor.domain.BaseEntity;
import svm.predictor.dto.BaseDto;
import svm.predictor.service.Service;

@Transactional
public abstract class BaseService<T extends BaseDto<PK>, D extends Dao<E, PK>, E extends BaseEntity<PK>, PK extends Serializable> implements Service<T, PK> {

	private D dao;
	
	private BaseAssembler<T, E, PK> assembler;
	
	@Override
	public T create(T dto) {
		E entity = getAssembler().convertToEntity(dto);
		entity = getDao().create(entity);
		T result = getAssembler().convertToDto(entity);
		return result;
	}

	@Override
	public List<T> list() {
		List<E> entities = getDao().list();
		List<T> result = getAssembler().convertToDtos(entities);
		return result;
	}
	
	@Override
	public List<T> list(Map<String, Object> parameters, String orderBy) {
		List<E> entities = getDao().list(parameters, orderBy);
		List<T> result = getAssembler().convertToDtos(entities);
		return result;
	}
	
	@Override
	public void update(T dto) {
		E entity = getAssembler().convertToEntity(dto);
		getDao().update(entity);
	}

	public D getDao() {
		return dao;
	}

	public void setDao(D dao) {
		this.dao = dao;
	}

	public BaseAssembler<T, E, PK> getAssembler() {
		return assembler;
	}

	public void setAssembler(BaseAssembler<T, E, PK> assembler) {
		this.assembler = assembler;
	}

}
