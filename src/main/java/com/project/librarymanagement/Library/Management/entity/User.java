package com.project.librarymanagement.Library.Management.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	@Id
	@Column(name="library_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libraryId;
	
	@Column(name="phone")
	private int phone;
	
	@Column(name="address")
	private String address;

	public User(String name, int phone, String address) {
		this.phone = phone;
		this.address = address;
		this.name = name;
	}
	
	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
}
