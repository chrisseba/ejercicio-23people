package io.people.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.people.domain.Student;
import io.people.exception.ClientErrorException;
import io.people.repository.StudentRepository;
import io.people.utils.ValidationUtils;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudent(String rut){
		
		if(  	rut != null 
			&&  !ValidationUtils.rutValidate(rut) ) {  
			throw new IllegalArgumentException("Invalid rut");
		}
			
		List<Student> studentLst = studentRepository.getStudent(rut);
		
		if( studentLst.isEmpty() ) {
			throw new ClientErrorException(  "Student not found" );
		}
		
		return studentLst;
	}
	
	@Override
	public void insertStudent( Student student ) {
		
		this.validateStudent( student);
		this.studentRepository.insertStudent(student);
	}
	
	@Override
	public void updateStudent(Student student) {
		
		this.validateStudent( student);
		List<Student> studentLst = this.studentRepository.updateStudent(student);
		
		if( studentLst.isEmpty()  ){
			
			throw new ClientErrorException(  "Student not found" );
		}
		
	}
	
	@Override
	public void dropStudent(String rut) {
		
		this.studentRepository.dropStudent(rut);
	}

	@Override
	public Page<Student> findAll(Pageable pageable){
		
		return this.studentRepository.findAll(  pageable );
	}
	
	
	private void validateStudent( Student student) {
		
		if( 	student != null
				&&	student.getRut() != null 
				&&  !ValidationUtils.rutValidate(student.getRut() ) ) { 
				
				throw new IllegalArgumentException("Invalid rut");
		}
			
		if( 	student != null
			&&	student.getAge() != null 
			&&  !ValidationUtils.ageValidate( student.getAge() ) )    { 
				
			throw new IllegalArgumentException("Age must be greater than 18 ");
		}
		
	}
	
	
	

}
