package io.people.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.people.domain.Course;
import io.people.repository.CourseRepository;



@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getCursos(String id){
		
		
		return courseRepository.getCursos( null, null );
	}
	
	

}
