package com.project.librarymanagement.Library.Management.dao;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
public class GenericDaoImpl<T> implements GenericDao<T> {

	private Class<T> type;
	
	@Autowired
	private EntityManager entityManager;
	
	GenericDaoImpl() {
		this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public T insertEntity(T t) {
		entityManager.merge(t);
		return null;
	}

	@Override
	public T findById(int id) {
		return entityManager.find(type, id);
	}

	@Override
	public boolean removeById(int id) {
		T object = findById(id);
		if (object != null) {			
			entityManager.remove(object);
			return true;
		}
		return false;
	}	

}
