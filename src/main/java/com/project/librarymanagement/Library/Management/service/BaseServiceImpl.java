package com.project.librarymanagement.Library.Management.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.librarymanagement.Library.Management.config.ApplicationQueries;

public class BaseServiceImpl implements BaseService {

	@Autowired
	ApplicationQueries queries;
	
	public String getQuery(String query) {
		return queries.getQuery(query);
	}
	
}
