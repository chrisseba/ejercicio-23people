package io.people.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.people.domain.Course;

public interface CourseService {
	
	
	public List<Course> getCourse(String code);
	public void insertCourse( Course course);
	public void dropCourse( String code);
	public Page<Course> findAll(Pageable pageable);

}
