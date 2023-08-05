package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarymanagement.Library.Management.dao.UserDao;
import com.project.librarymanagement.Library.Management.entity.User;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User findUserById(int id) {
		return userDao.findById(id);
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

	@Override
	public boolean removeUser(int id) {
		return userDao.removeById(id);
	}

	@Override
	public boolean updateUser(HttpServletRequest httpReq) {
		String id = httpReq.getParameter("id");
		User user = userDao.findById(Integer.parseInt(id));
		if (user == null) {
			return false;
		}
		String name = httpReq.getParameter("name");
		String address = httpReq.getParameter("address");
		if (StringUtils.isNotBlank(name)) {
			user.setName(name);
		}
		if (StringUtils.isNotBlank(address)) {
			user.setAddress(address);
		}
		userDao.insertEntity(user);
		return true;
	}

	@Override
	public List<User> getAllUsers() {
//		return userDao.findAll();
		String query = getQuery("GET.ALL.USERS");
		return userDao.executeQuery(query);
	}

}
