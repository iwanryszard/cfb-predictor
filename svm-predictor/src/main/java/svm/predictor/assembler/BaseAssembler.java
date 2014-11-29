package svm.predictor.assembler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import svm.predictor.domain.BaseEntity;
import svm.predictor.dto.BaseDto;

public abstract class BaseAssembler<T extends BaseDto<PK>, E extends BaseEntity<PK>, PK extends Serializable> {

	public abstract E createEntity();
	
	public abstract T createDto();
	
	public T convertToDto(E entity) {
		T dto = createDto();
		dto.setId(entity.getId());
		doConvertToDto(entity, dto);
		return dto;
	}
	
	public E convertToEntity(T dto) {
		E entity = createEntity();
		entity.setId(dto.getId());
		doConvertToEntity(dto, entity);
		return entity;
	}
	
	public List<T> convertToDtos(List<E> entities) {
		List<T> dtos = new ArrayList<T>();
		for(E entity : entities) {
			T dto = convertToDto(entity);
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public List<E> convertToEntities(List<T> dtos) {
		List<E> entities = new ArrayList<E>();
		for(T dto : dtos) {
			E entity = convertToEntity(dto);
			entities.add(entity);
		}
		
		return entities;
	}
	
	protected abstract void doConvertToDto(E entity, T dto);
	
	protected abstract void doConvertToEntity(T dto, E entity);
}
