package com.project.librarymanagement.Library.Management.service;

import java.util.List;

import com.project.librarymanagement.Library.Management.entity.UserHistory;

import jakarta.servlet.http.HttpServletRequest;

public interface UserHistoryService extends BaseService{

	public UserHistory findUserHistoryById(int id);
	
	public boolean insertUserHistory(UserHistory user);
				
}
