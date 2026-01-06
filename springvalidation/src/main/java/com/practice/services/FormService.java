package com.practice.services;

import java.util.List;

import com.practice.entities.LoginData;

public interface FormService 
{
	public List <LoginData> getall();
	public LoginData getone(String userName);
}
