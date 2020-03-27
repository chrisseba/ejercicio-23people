package io.people.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.people.domain.Course;
import io.people.repository.CourseRepository;




@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getCourse(String code){
		
		
		return courseRepository.getCourse( code );
	}
	
	public void insertCourse( Course course) {
		
		courseRepository.insertCourse(course);
	}
	
	
	public void dropCourse(String code) {
		
		courseRepository.dropCourse(code);
	}

	public Page<Course> findAll(Pageable pageable){
		
		return courseRepository.findAll(  pageable );
	}
}




