package io.people.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.people.domain.Course;
import io.people.exception.ClientErrorException;
import io.people.repository.CourseRepository;
import io.people.utils.ValidationUtils;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getCourse(String code){
		
		this.validateCode(code);
			
		List<Course> courseLst = courseRepository.getCourse( code );
		
		if( courseLst.isEmpty() ) {
			throw new ClientErrorException(  "Course not found" );
		}
		
		return courseLst;
	}
	
	public void insertCourse( Course course) {
		
		courseRepository.insertCourse(course);
	}
	
	public void updateCourse( Course course) {
		
		this.validateCode(course.getCode());
		
		List<Course> courseLst = courseRepository.updateCourse(course);
		
		if( courseLst.isEmpty()  ){
			
			throw new ClientErrorException(  "Course not found" );
		}
		
	}
	
	public void dropCourse(String code) {
		
		courseRepository.dropCourse(code);
	}

	public Page<Course> findAll(Pageable pageable){
		
		return courseRepository.findAll(  pageable );
	}
	
	
	private void validateCode( String code ) {
		
		if(  code != null &&  !ValidationUtils.codeValidate(code) ) {  
			throw new IllegalArgumentException("Code lenght must  be smaller than 5");
		}
	}
	
	
	
	
	
}




