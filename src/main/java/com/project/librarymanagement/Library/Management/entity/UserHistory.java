package com.project.librarymanagement.Library.Management.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_history")
public class UserHistory implements Serializable {

	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="library_id")
	private int libraryId;
	
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="date_borrowed")
	private Date dateBorrowed;
	
	@Column(name="date_returned")
	private Date dateReturned;
	
	@Column(name="tranx_active")
	private String transactionActive;
	
	public UserHistory(int libraryId, int bookId, Date dateBorrowed, Date dateReturned, String transactionActive) {
		super();
		this.libraryId = libraryId;
		this.bookId = bookId;
		this.dateBorrowed = dateBorrowed;
		this.dateReturned = dateReturned;
		this.transactionActive = transactionActive;
	}

	public UserHistory() {}
	
	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public String getTransactionActive() {
		return transactionActive;
	}

	public void setTransactionActive(String transactionActive) {
		this.transactionActive = transactionActive;
	}
	
	
	
}
