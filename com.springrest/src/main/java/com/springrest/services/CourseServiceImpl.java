package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
/*
	List<Course> list;
	
	public CourseServiceImpl()
	{
		list = new ArrayList<>();
		list.add(new Course(123,"Java","Object oriented programming"));
		list.add(new Course(246,"Springboot","Creating Rest Api's"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return list;
	}
	
	@Override
	public Course getCourse(long courseId) {
	
		Course c = null;
		for(Course course : list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}
	
	@Override
	public Course addCourse(Course course) 
	{
		list.add(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) 
	{
		list.forEach(e->{
		if(e.getId() == course.getId())
		{
			e.setTitle(course.getTitle());
			e.setDescription(course.getDescription());
		}
		});
		return course;
	}
	
	@Override
	public void deleteCourse(long parseLong) 
	{
		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}

	*/
	
	@Autowired
	CourseDao courseDao;
	
	@Override
	public List<Course> getCourses() 
	{
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId)
	{
		return courseDao.findById(courseId).get();
	}
	
	@Override
	public Course addCourse(Course course) 
	{
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) 
	{
		courseDao.save(course);
		return course;
	}
	
	@Override
	public void deleteCourse(long parseLong) 
	{
		Course entity = courseDao.getReferenceById(parseLong);
		courseDao.delete(entity);
	}
}
