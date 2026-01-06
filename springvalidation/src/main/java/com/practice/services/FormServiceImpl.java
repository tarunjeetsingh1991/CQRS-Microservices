package com.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practice.entities.LoginData;
import com.practice.repository.FormRepository;

@Service
public class FormServiceImpl implements FormService 
{
	@Autowired
	FormRepository repo;

	@Override
	public List<LoginData> getall() 
	{
		List<LoginData> data = repo.findAll();
		return data;
	}

	@Override
	public LoginData getone(String userName) 
	{
		return repo.findById(userName).get();
	}
	
}
