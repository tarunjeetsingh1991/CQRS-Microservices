package com.telusko.student_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController
public class StudentController 
{
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/getStudents")
	public List<Student> getStudents()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/addStudent")
	public void addStudent()
	{
		Student s = new Student();
		s.setName("Rajinder");
		s.setAge(60);
	}
}
*/

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepo repo;

    // Get all students
    @GetMapping
    public List<Student> getStudents() {
        return repo.findAll();
    }

    // Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return repo.save(s);
    }
}
