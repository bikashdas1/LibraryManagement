package com.project.librarymanagement.Library.Management.service;

import com.project.librarymanagement.Library.Management.entity.User;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

	public User findUserById(int id);
	
	public boolean insertUser(User user);
	
	public boolean removeUser(int id);
	
	public boolean updateUser(HttpServletRequest httpReq);
	
}
