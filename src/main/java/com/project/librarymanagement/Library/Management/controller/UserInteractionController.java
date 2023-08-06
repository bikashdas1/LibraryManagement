package com.project.librarymanagement.Library.Management.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.project.librarymanagement.Library.Management.entity.UserHistory;
import com.project.librarymanagement.Library.Management.service.UserHistoryService;
import com.project.librarymanagement.Library.Management.service.UserInteractionService;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path="/action", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserInteractionController {

	@Autowired
	private UserInteractionService service;
	
	@Autowired
	private UserHistoryService userHist;
	
	@PostMapping("/borrow")
	public String borrowBook(HttpServletRequest request) {
		StringBuilder body = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			String buffer = "";
			while (buffer != null) {
				buffer = reader.readLine();
				if (buffer != null) {
					body.append(buffer);					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JsonObject jsonObj = (JsonObject) JsonParser.parseString(body.toString());
		String bookId = jsonObj.get("bookId") != null ? jsonObj.get("bookId").toString() : "";
		String userId = jsonObj.get("userId") != null ? jsonObj.get("userId").toString() : "";
		if (StringUtils.isBlank(bookId) || StringUtils.isBlank(userId))  {
			return "bookId and userId are requrired params to borrow a book.";
		}
		
		service.borrowBook(Integer.parseInt(bookId), Integer.parseInt(userId));
		UserHistory hist = new UserHistory();
		hist.setBookId(Integer.parseInt(bookId));
		hist.setDateBorrowed(new Date());
		hist.setLibraryId(Integer.parseInt(userId));
		hist.setTransactionActive("Y");
		userHist.insertUserHistory(hist);
		return "Book " + bookId + " borrowed by userId: " + userId;
		
	}
	
	@PostMapping("/return")
	public String returnBook(HttpServletRequest request) {
		StringBuilder body = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			String buffer = "";
			while (buffer != null) {
				buffer = reader.readLine();
				if (buffer != null) {
					body.append(buffer);					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JsonObject jsonObj = (JsonObject) JsonParser.parseString(body.toString());
		String bookId = jsonObj.get("bookId") != null ? jsonObj.get("bookId").toString() : "";
		String userId = jsonObj.get("userId") != null ? jsonObj.get("userId").toString() : "";
		if (StringUtils.isBlank(bookId) || StringUtils.isBlank(userId))  {
			return "bookId and userId are requrired params to return a book.";
		}
		UserHistory hist = new UserHistory();
		hist.setBookId(Integer.parseInt(bookId));
		hist.setDateReturned(new Date());
		hist.setLibraryId(Integer.parseInt(userId));
		hist.setTransactionActive("N");
		userHist.insertUserHistory(hist);
		service.returnBook(Integer.parseInt(bookId), Integer.parseInt(userId));
		return "Book " + bookId + " returned by userId: " + userId;
		
	}
		
}
