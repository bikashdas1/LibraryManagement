package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarymanagement.Library.Management.dao.BookShelfDao;
import com.project.librarymanagement.Library.Management.entity.Book;
import com.project.librarymanagement.Library.Management.entity.BookShelf;

@Service
public class BookShelfServiceImpl extends BaseServiceImpl implements BookShelfService {

	@Autowired
	BookShelfDao bsDao;

	@Override
	public List<BookShelf> displayBookShelf() {
		String query = getQuery("DISPLAY.BOOK.SHELF");
		List<BookShelf> bookShelf = bsDao.executeQuery(query);
		return bookShelf;
	}

	@Override
	public void addBook(Book book) {
		BookShelf shelf = bsDao.findById(book.getId());
		if (shelf != null) {
			shelf.setQuantity(shelf.getQuantity() + 1);			
		} else {
			shelf.setQuantity(1);
			shelf.setBorrowed(0);
			shelf.setAvailable(1);
			shelf.setComment("Insertion of new book");
			shelf.setStatus("Y");
		}
		bsDao.insertEntity(shelf);
	}

	@Override
	public void removeBook(Book book) {
		bsDao.removeById(book.getId());
	}
	
	
}
