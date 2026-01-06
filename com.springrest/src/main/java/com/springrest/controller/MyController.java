/*
package com.springrest.controller;

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
import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@RestController
public class MyController 
{
	@Autowired
	CourseService courseService;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is home page!";
	}
	
	//Get the courses
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	//Get a single course
	
		@GetMapping("/courses/{courseId}")
		public Course getCourse(@PathVariable String courseId)
		{
			return this.courseService.getCourse(Long.parseLong(courseId));
		}
		
	//Add a course
		@PostMapping("/courses")
		public Course addCourse(@RequestBody Course course)
		{
			return this.courseService.addCourse(course);
		}
		
	//Update a course
		@PutMapping("/courses")
		public Course updateCourse(@RequestBody Course course)
		{
			return this.courseService.updateCourse(course);
		}
		
	//Delete a course
		@DeleteMapping("/courses/{courseId}")
		public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
		{
			try
			{
				this.courseService.deleteCourse(Long.parseLong(courseId));
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch(Exception e)
			{
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
}
*/

package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@RestController
public class MyController 
{
    @Autowired
    CourseService courseService;
    
    @GetMapping("/home")
    public ResponseEntity<String> home() 
    {
        return new ResponseEntity<>("This is home page!", HttpStatus.OK);
    }
    
    // Get all courses
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() 
    {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }
    
    // Get a single course
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable String courseId) 
    {
        Course course = courseService.getCourse(Long.parseLong(courseId));
        return course != null ? new ResponseEntity<>(course, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    // Add a course
    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) 
    {
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
    
    // Update a course
    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) 
    {
        Course updatedCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }
    
    // Delete a course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) 
    {
        try 
        {
            courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

