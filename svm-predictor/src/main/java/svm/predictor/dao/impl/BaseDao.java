package svm.predictor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.GenericTypeResolver;

import svm.predictor.dao.Dao;
import svm.predictor.domain.BaseEntity;

public abstract class BaseDao<T extends BaseEntity<PK>, PK extends Serializable> implements Dao<T, PK> {

	private SessionFactory sessionFactory;
	
	private Class<?> entityClass = GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[0];
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public T create(T entity) {
		Session session = sessionFactory.getCurrentSession();
        PK id = (PK)session.save(entity);
        T result = (T)session.load(entityClass, id);
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		Session session = sessionFactory.getCurrentSession();
		List<T> result = session.createQuery("from " + entityClass.getSimpleName()).list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(Map<String, Object> parameters, String orderBy) {
		Session session = sessionFactory.getCurrentSession();
		String whereClause = buildWhereClause(parameters);
		if(orderBy == null) {
			orderBy = "";
		}
		Query query = session.createQuery("from " + entityClass.getSimpleName() + " " + whereClause + " " + orderBy);
		parameters = getParametersWithoutOperatorsAndNulls(parameters);
		setQueryParameters(query, parameters);
		List<T> result = query.list();
		return result;
	}
	
	private String buildWhereClause(Map<String, Object> parameters) {
		StringBuilder result = new StringBuilder();
		for(Map.Entry<String, Object>  entry : parameters.entrySet()) {
			if(result.length() > 0) {
				result.append(" AND ");
			}
			String fieldName = getFieldName(entry.getKey());
			String operator = getOperator(entry.getKey());
			String binding = getBinding(fieldName, entry.getValue());
			result.append(fieldName + " " + operator + " " + binding);
		}
		
		return "where " + result.toString();
	}
	
	private String getFieldName(String fieldName) {
		String[] result = fieldName.split(":");
		return result[0];
	}
	
	private String getOperator(String fieldName) {
		String operator = "=";
		String[] split = fieldName.split(":");
		if(split.length == 2) {
			operator = split[1];
		}
		
		return operator;
	}
	
	private String getBinding(String fieldName, Object value) {
		String result = null;
		if(value != null) {
			result = ":" + fieldName;
		} else {
			result = "NULL";
		}
		
		return result;
	}
	
	private Map<String, Object> getParametersWithoutOperatorsAndNulls(Map<String, Object> parameters) {
		Map<String, Object> result = new HashMap<String, Object>();
		for(Map.Entry<String, Object>  entry : parameters.entrySet()) {
			if(entry.getValue() != null) {
				String fieldName = getFieldName(entry.getKey());
				result.put(fieldName, entry.getValue());
			}
		}
		
		return result;
	}
	
	private void setQueryParameters(Query query, Map<String, Object> parameters) {
		for(Map.Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
	
	public void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}
}
