package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarymanagement.Library.Management.dao.UserHistoryDao;
import com.project.librarymanagement.Library.Management.entity.UserHistory;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserHistoryServiceImpl extends BaseServiceImpl implements UserHistoryService {

	@Autowired
	UserHistoryDao userHistoryDao;
	
	@Override
	public UserHistory findUserHistoryById(int id) {
		return userHistoryDao.findById(id);
	}

	@Override
	public boolean insertUserHistory(UserHistory userHistory) {
		try {
			userHistoryDao.insertEntity(userHistory);
			return true;
		} catch (Exception e){
			return false;

		}
	}

}
