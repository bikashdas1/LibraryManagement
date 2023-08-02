package com.project.librarymanagement.Library.Management.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {

	private static final double serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="publication")
	private String publication;
	
	@Column(name="year")
	private int year;

	public Book(String name, String author, String genre, String publication, int year) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.publication = publication;
		this.year = year;
	}
	
	public Book() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getId() {
		return this.id;
	}
	
}
