package com.codedecode.aopdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.aopdemo.entity.Employee;
import com.codedecode.aopdemo.repo.EmployeeRepo;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepo repo;
	
	public List<Employee> getAll()
	{
		return repo.findAll();
	}
	
	public Employee addEmployee(Employee e) throws Exception
	{
		if(e.getName().length()>10)
			throw new Exception("Please reduce name length.");
		return repo.save(e);
	}
}
