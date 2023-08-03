package com.project.librarymanagement.Library.Management.controller;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarymanagement.Library.Management.entity.User;
import com.project.librarymanagement.Library.Management.service.UserService;

@RestController
@RequestMapping(path="/users", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping({"", "/"})
	public User getUsers() {
		return userService.findUserById();
	}
	
	@PostMapping(path={"", "/"}, consumes="application/json")
	public void insertUser(@RequestBody Member member) {
		System.out.println("Something random to debug");
	}
	
	
}
