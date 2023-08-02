package com.project.librarymanagement.Library.Management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarymanagement.Library.Management.entity.User;
import com.project.librarymanagement.Library.Management.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping({"", "/"})
	public User getUsers() {
		return userService.findUserById();
	}
	
}
