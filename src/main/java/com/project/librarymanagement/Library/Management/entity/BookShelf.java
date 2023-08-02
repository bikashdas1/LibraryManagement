package com.project.librarymanagement.Library.Management.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book_shelf")
public class BookShelf implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="borrowed")
	private int borrowed;
	
	@Column(name="available")
	private int available;
	
	@Column(name="status")
	private String status;
	
	@Column(name="comment")
	private String comment;
	
	public BookShelf(int book_id, int quantity, int borrowed, int available, String status, String comment) {
		this.bookId = book_id;
		this.quantity = quantity;
		this.borrowed = borrowed;
		this.available = available;
		this.status = status;
		this.comment = comment;
	}
	
	public BookShelf() {}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int book_id) {
		this.bookId = book_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(int borrowed) {
		this.borrowed = borrowed;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
