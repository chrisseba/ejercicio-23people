package io.people.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.people.domain.Course;

//@Repository
public class CourseRepositoryImpl {// implements CourseRepository{
	
	public List<Course> getCursos(String id){
		
		return getCursos();
	}
	
	
	List<Course> getCursos(){
		
		List<Course> courseLts = new ArrayList<>();
		
		Course course = new Course();
		course.setCode( "inpr" );
		course.setCourse( "Introducción a la Programión" );
		courseLts.add( course );
		
		course = new Course();
		course.setCode( "mat0" );
		course.setCourse( "Matematica 1" );
		courseLts.add( course );
		
		return courseLts;
	}
	
	
	
}
