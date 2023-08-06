package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarymanagement.Library.Management.dao.BookDao;
import com.project.librarymanagement.Library.Management.dao.BookShelfDao;
import com.project.librarymanagement.Library.Management.entity.Book;
import com.project.librarymanagement.Library.Management.entity.BookShelf;

@Service
public class BookServiceImpl extends BaseServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Autowired
	BookShelfDao bookShelfDao;
	
	@Override
	public Book findBookById(int id) {
		return bookDao.findById(id);
	}

	@Override
	public boolean insertBook(Book book) {
		try {
			bookDao.insertEntity(book);
			BookShelf bookInShelf = bookShelfDao.findById(book.getId());
			if (bookInShelf == null) {
				BookShelf bookShelf = new BookShelf();
				bookShelf.setAvailable(1);
				bookShelf.setBorrowed(0);
				bookShelf.setComment("New Book Added to the SHelf");
				bookShelf.setQuantity(1);
				bookShelf.setStatus("Y");
			}
			return true;
		} catch (Exception e){
			return false;

		}
	}

	@Override
	public boolean removeBook(int id) {
		bookShelfDao.removeById(id);
		return bookDao.removeById(id);
	}

	@Override
	public boolean updateBook(Book book) {
		bookDao.insertEntity(book);
		return true;
	}

	@Override
	public List<Book> getAllBooks() {
		String query = getQuery("GET.ALL.BOOKS");
		List<Book> bookList = bookDao.executeQuery(query);
		return bookList;
	}

}
