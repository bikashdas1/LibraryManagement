package com.project.librarymanagement.Library.Management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.librarymanagement.Library.Management.entity.BookShelf;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		// The main starting point of the application
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
		System.out.println("\n\nThe application have been started!");
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner(UserDAO appdao) {
//		return runner-> {
//
//			BookShelf shelf = new BookShelf(1003, 5, 3, 2, "Y", "Book Shelf updated.");
//			appdao.save(shelf);
//		};
//	};

}
