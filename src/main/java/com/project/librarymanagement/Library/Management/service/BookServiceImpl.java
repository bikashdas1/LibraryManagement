package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarymanagement.Library.Management.dao.BookDao;
import com.project.librarymanagement.Library.Management.entity.Book;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class BookServiceImpl extends BaseServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Override
	public Book findBookById(int id) {
		return bookDao.findById(id);
	}

	@Override
	public boolean insertBook(Book book) {
		try {
			bookDao.insertEntity(book);
			return true;
		} catch (Exception e){
			return false;

		}
	}

	@Override
	public boolean removeBook(int id) {
		return bookDao.removeById(id);
	}

	@Override
	public boolean updateBook(HttpServletRequest httpReq) {
		String id = httpReq.getParameter("id");
		Book book = bookDao.findById(Integer.parseInt(id));
		if (book == null) {
			return false;
		}
		String name = httpReq.getParameter("name");
		String author = httpReq.getParameter("address");
		String genre = httpReq.getParameter("genre");
		String publication = httpReq.getParameter("publication");
		String year = httpReq.getParameter("year");
		
		if (StringUtils.isNotBlank(name)) {
			book.setName(name);
		}
		if (StringUtils.isNotBlank(author)) {
			book.setAuthor(author);
		}
		if (StringUtils.isNotBlank(genre)) {
			book.setGenre(genre);
		}
		if (StringUtils.isNotBlank(publication)) {
			book.setPublication(publication);
		}
		if (StringUtils.isNotBlank(year)) {
			book.setYear(Integer.parseInt(year));
		}
		bookDao.insertEntity(book);
		return true;
	}

	@Override
	public List<Book> getAllBooks() {
		String query = getQuery("GET.ALL.BOOKS");
		return bookDao.executeQuery(query);
	}

}
