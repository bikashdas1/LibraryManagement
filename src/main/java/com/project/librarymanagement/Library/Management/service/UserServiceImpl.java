package com.project.librarymanagement.Library.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarymanagement.Library.Management.dao.UserDao;
import com.project.librarymanagement.Library.Management.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User findUserById() {
		return userDao.findById(2);
	}

	@Override
	public boolean insertUser(User user) {
		try {
			userDao.insertEntity(user);
			return true;
		} catch (Exception e){
			return false;

		}
	}

}
