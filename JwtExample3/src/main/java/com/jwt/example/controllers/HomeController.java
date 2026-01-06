package com.jwt.example.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.models.User;
import com.jwt.example.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController 
{
	//http://localhost:8080/home/user
	@GetMapping("/user")
	public String getUser()
	{
		System.out.println("Getting user!");
		return "users";
	}
	
	@Autowired
	UserService userService;
	
	//http://localhost:8080/home/users
	@GetMapping("/users")
	public List<User> getUsers()
	{
		System.out.println("Getting all users!");
		//return userService.getUsers();
		return this.userService.getUsers();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal)
	{
		return principal.getName();
	}
}
