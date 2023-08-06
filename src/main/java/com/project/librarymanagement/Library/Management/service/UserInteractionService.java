package com.project.librarymanagement.Library.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarymanagement.Library.Management.dao.BookShelfDao;
import com.project.librarymanagement.Library.Management.dao.UserDao;
import com.project.librarymanagement.Library.Management.dao.UserHistoryDao;
import com.project.librarymanagement.Library.Management.entity.BookShelf;
import com.project.librarymanagement.Library.Management.entity.User;

@Service
public class UserInteractionService extends BaseServiceImpl {

	@Autowired
	BookShelfDao bookShelfDao;
	
	@Autowired
	UserHistoryDao userHistDao;
	
	@Autowired
	UserDao userDao;
	
	public void borrowBook(int bookId, int userId) {
		BookShelf books = bookShelfDao.findById(bookId);
		User user = userDao.findById(userId);
		if (user == null || books == null) {
			return;
		}
		if (books != null) {
			books.setComment("Last borrowed by " + userId);
			books.setBorrowed(books.getBorrowed() + 1);
			books.setAvailable(books.getAvailable() - 1);
			if (books.getAvailable() - 1 == 0) {
				books.setStatus("N");
			}
		}
		bookShelfDao.insertEntity(books);
	}
	
	public void returnBook(int bookId, int userId) {
		BookShelf books = bookShelfDao.findById(bookId);
		User user = userDao.findById(userId);
		if (user == null || books == null) {
			return;
		}
		if (books != null) {
			books.setComment("Last returned by " + userId);
			books.setBorrowed(books.getBorrowed() - 1);
			books.setAvailable(books.getAvailable() + 1);
		}
		bookShelfDao.insertEntity(books);
	}
	
}
