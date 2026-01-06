package com.practice.services;

import java.util.List;

import com.practice.model.Student;

public interface StudentService 
{
	public List<Student> getStudents();
	
	Student getStudent(int rollNo);
	
	public Student addStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public void deleteStudent(int rollNo);
}
