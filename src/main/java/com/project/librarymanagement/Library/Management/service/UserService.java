package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import com.project.librarymanagement.Library.Management.entity.User;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService extends BaseService{

	public User findUserById(int id);
	
	public boolean insertUser(User user);
	
	public boolean removeUser(int id);
	
	public boolean updateUser(HttpServletRequest httpReq);
	
	public List<User> getAllUsers();
	
}
