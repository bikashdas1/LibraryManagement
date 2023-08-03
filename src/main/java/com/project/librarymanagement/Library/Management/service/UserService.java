package com.project.librarymanagement.Library.Management.service;

import com.project.librarymanagement.Library.Management.entity.User;

public interface UserService {

	public User findUserById();
	
	public boolean insertUser(User user);
	
}
