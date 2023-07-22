package com.project.librarymanagement.Library.Management.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.librarymanagement.Library.Management.dao.AppDAO;
import com.project.librarymanagement.Library.Management.entity.User;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		// The main starting point of the application
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
		System.out.println("\nSpring application started!");
		//		createNewUser(dao);
	}
	
	public static void createNewUser(AppDAO dao) {
		User user1 = new User("Bikash");
		dao.save(user1);
	}

	
	
}
