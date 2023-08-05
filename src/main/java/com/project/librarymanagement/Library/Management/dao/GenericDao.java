package com.project.librarymanagement.Library.Management.dao;

import java.util.List;

public interface GenericDao<T> {
	
	T insertEntity(T t);
	
	T findById(int id);
	
	List<T> findAll();
	
	boolean removeById(int id);
	
	public List<T> executeQuery(String query);

}
