package com.project.librarymanagement.Library.Management.dao;

public interface GenericDao<T> {
	
	T insertEntity(T t);
	
	T findById(int id);

}
