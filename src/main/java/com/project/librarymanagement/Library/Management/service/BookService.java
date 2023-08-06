package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import com.project.librarymanagement.Library.Management.entity.Book;

import jakarta.servlet.http.HttpServletRequest;

public interface BookService extends BaseService{

	public Book findBookById(int id);
	
	public boolean insertBook(Book Book);
	
	public boolean removeBook(int id);
	
	public boolean updateBook(HttpServletRequest httpReq);
	
	public List<Book> getAllBooks();
	
}
