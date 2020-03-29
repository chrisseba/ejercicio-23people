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

import io.people.domain.Student;
import io.people.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping( method = RequestMethod.GET)
	public Page<Student> getPageableStudent( @PageableDefault(page=0, size=5) Pageable pageable)  {
		
		return  studentService.findAll(pageable);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Student> getStudent( ) {
		
		return studentService.getStudent(null);
	}
	
	@RequestMapping(value = "/{rut}", method = RequestMethod.GET)
	public List<Student> getStudent( @PathVariable("rut") String rut ) {
		
		return  studentService.getStudent(rut);
	}
	
	@RequestMapping(method = RequestMethod.POST,headers = {"Content-type=application/json"})
    public ResponseEntity insertStudent( @RequestBody Student student) {

		studentService.insertStudent(student);
		
		return  ResponseEntity.status( HttpStatus.CREATED ).build();
    }
	
	@RequestMapping(value ="/{rut}",method = RequestMethod.PUT,headers = {"Content-type=application/json"})
    public void update( @RequestBody Student student,
    					@PathVariable("rut") String rut) {

		student.setRut(rut);
		studentService.updateStudent(student);
    }
	
	
	@RequestMapping(value ="/{rut}", method = RequestMethod.DELETE)
	public void dropCourse( @PathVariable("rut") String rut ){

		studentService.dropStudent(rut);
	}
	
	
	
	
}
