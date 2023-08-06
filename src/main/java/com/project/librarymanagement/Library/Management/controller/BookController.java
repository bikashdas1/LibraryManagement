package com.project.librarymanagement.Library.Management.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarymanagement.Library.Management.entity.Book;
import com.project.librarymanagement.Library.Management.service.BookService;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path="/book", produces=MediaType.APPLICATION_JSON_VALUE)
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping({"", "/"})
	public Book getBooks(@RequestParam int id) {
		return bookService.findBookById(id);
	}
	
	@PostMapping(path={"", "/"}, consumes="application/json")
	public String insertBook(@RequestBody Book member) {
		if (StringUtils.isBlank(member.getAuthor()) || StringUtils.isBlank(member.getName()) ||
				StringUtils.isBlank(member.getGenre()) || StringUtils.isBlank(member.getPublication()) ||
				StringUtils.isBlank(Integer.toString(member.getYear()))) {
			return "Name, Author, Genre, Publication and Published year are required fields.";
		}
		return bookService.insertBook(member) ? "Book inserted successfully : " + member.toString() : "Book couldn't be added successfully";
	}
	
	@DeleteMapping(path={"/", ""}, consumes="application/json")
	public String removeBook(HttpServletRequest httpReq) {
		String id = httpReq.getParameter("id");
		if (StringUtils.isBlank(id)) {
			return "Id is required to remove a book.";
		}
		if (bookService.removeBook(Integer.parseInt(id))) {
			return "Book removed successfully";
		}
		return "Book couldn't be removed";
	}
	
	@PostMapping(path= {"/update", "/update/"}, consumes="application/json")
	public String updateBook(HttpServletRequest httpReq) {
		String id = httpReq.getParameter("id");
		String body = "";
		try {
			BufferedReader reader = httpReq.getReader();
			body = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (StringUtils.isBlank(id)) {
			return "Id is required to update a book";
		}
		if (bookService.updateBook(httpReq)) {
			return "Book details updated successfully!";
		}
		return "Book not found in database";
	}
	
	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
}
