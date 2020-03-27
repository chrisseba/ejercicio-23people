package io.people;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.people.domain.Course;
import io.people.service.CourseService;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping( method = RequestMethod.GET)
	public Page<Course> getCursos( @PageableDefault(page=0, size=5) Pageable pageable)  {
		
		return  courseService.findAll(pageable);
	}
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getCursos( ) {
		
		return new ResponseEntity<>( courseService.getCourse(null), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public List<Course> getCursos( @PathVariable("code") String code ) {
		
		return  courseService.getCourse(code);
	}
	
	@RequestMapping(method = RequestMethod.POST,headers = {"Content-type=application/json"})
    public void insert( @RequestBody Course course ) {

		courseService.insertCourse(course);
    }
	
	@RequestMapping(value ="/{code}",method = RequestMethod.PUT,headers = {"Content-type=application/json"})
    public ResponseEntity<String> update( @RequestBody Course course ) {

		return ResponseEntity.status(HttpStatus.CREATED).body( "Succes update!!") ;
    }
	
	
	@RequestMapping(value ="/{code}", method = RequestMethod.DELETE)
	public void dropCourse( @PathVariable("code") String code ){

		courseService.dropCourse(code);
	}
	
	

}
