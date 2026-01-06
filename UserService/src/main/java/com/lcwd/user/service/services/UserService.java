package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService 
{
	//User operations
	
	//create
	User saveuser(User user);
	
	//get all
	List<User> getAllUser();
	
	//get one
	User getUser(String userId);
	
	
}
