package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import com.project.librarymanagement.Library.Management.entity.Book;
import com.project.librarymanagement.Library.Management.entity.BookShelf;

public interface BookShelfService extends BaseService{
	
	public List<BookShelf> displayBookShelf();
	
	public void addBook(Book book);
	
	public void removeBook(Book book);
	
}
