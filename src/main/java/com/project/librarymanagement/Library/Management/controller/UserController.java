package com.project.librarymanagement.Library.Management.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarymanagement.Library.Management.entity.User;
import com.project.librarymanagement.Library.Management.service.UserService;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path="/users", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping({"", "/"})
	public User getUsers(@RequestParam int id) {
		return userService.findUserById(id);
	}
	
	@PostMapping(path={"", "/"}, consumes="application/json")
	public String insertUser(@RequestBody User member) {
		if (StringUtils.isBlank(member.getAddress()) || StringUtils.isBlank(member.getName())) {
			return "Name and Address are required params";
		}
		return userService.insertUser(member) ? "Member inserted successfully : " + member.toString() : "Member couldn't be added successfully";
	}
	
	@DeleteMapping(path={"/", ""}, consumes="application/json")
	public String removeUser(HttpServletRequest httpReq) {
		String id = httpReq.getParameter("id");
		if (StringUtils.isBlank(id)) {
			return "Id is required to remove a user";
		}
		if (userService.removeUser(Integer.parseInt(id))) {
			return "User removed successfully";
		}
		return "User couldn't be removed";
	}
	
	@PostMapping(path= {"/update", "/update/"}, consumes="application/json")
	public String updateUser(HttpServletRequest httpReq) {
		String id = httpReq.getParameter("id");
		String body = "";
		try {
			BufferedReader reader = httpReq.getReader();
			body = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (StringUtils.isBlank(id)) {
			return "Id is required to update a user";
		}
		if (userService.updateUser(httpReq)) {
			return "User details updated successfully!";
		}
		return "User not found in database";
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
		
	}
	
}
