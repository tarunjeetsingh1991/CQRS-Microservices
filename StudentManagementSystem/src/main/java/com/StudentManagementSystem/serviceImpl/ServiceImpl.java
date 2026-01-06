package com.StudentManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.StudentRepository;
import com.StudentManagementSystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repo;
	
	@Override
	public List<Student> getAllStudents() 
	{
		List<Student> list = repo.findAll();
		return list;
	}

	@Override
	public Student saveStudent(Student student) 
	{
		return repo.save(student);
	}

	@Override
	public Student getById(int id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public void deleteById(int id) 
	{
		repo.deleteById(id);
	}
	
	

}
