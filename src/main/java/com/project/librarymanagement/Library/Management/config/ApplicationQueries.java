package com.project.librarymanagement.Library.Management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("native-queries.properties")
public class ApplicationQueries {

	@Autowired
	private Environment env;
	
	public String getQuery(String query) {
		return env.getProperty(query);
	}
	
}
