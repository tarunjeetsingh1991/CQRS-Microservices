package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.practice.model.Student;
import com.practice.services.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is home page!";
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return this.studentservice.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id)
	{
		return this.studentservice.getStudent(id);
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student)
	{
		return this.studentservice.addStudent(student);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student)
	{
		return this.studentservice.updateStudent(student);
	}
	
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) 
	{
		try
		{
			this.studentservice.deleteStudent(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
