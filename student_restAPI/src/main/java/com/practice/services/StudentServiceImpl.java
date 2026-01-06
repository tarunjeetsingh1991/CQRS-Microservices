package com.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.Student;
import com.practice.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repo;

	@Override
	public List<Student> getStudents() {
		
		return repo.findAll();
	}

	@Override
	public Student getStudent(int rollNo) {
		
		return repo.findById(rollNo).get();
	}

	@Override
	public Student addStudent(Student student) {
		repo.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		repo.save(student);
		return student;
	}

	@Override
	public void deleteStudent(int rollNo) {
		Student entity = repo.getReferenceById(rollNo);
		repo.delete(entity);
	}
	
	
}
