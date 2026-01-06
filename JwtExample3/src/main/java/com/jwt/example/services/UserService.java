package com.jwt.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.models.User;

@Service
public class UserService 
{
	List<User> store = new ArrayList<>();

	public UserService() 
	{
		store.add(new User(UUID.randomUUID().toString(),"Tarunjeet","tarunjeetsingh.91@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Gurchintan","gurchintankaur@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Inderjit","sudanbolina@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Rajinder","tarunrajinder13@gmail.com"));
	}
	
	public List<User> getUsers()
	{
		return this.store;
	}
}
