package com.project.librarymanagement.Library.Management.service;

import com.project.librarymanagement.Library.Management.entity.User;

public interface UserService {

	public User findUserById(int id);
	
	public boolean insertUser(User user);
	
}
