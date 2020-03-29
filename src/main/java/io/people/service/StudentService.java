package io.people.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.people.domain.Student;

public interface StudentService {
	
	public List<Student> getStudent(String rut);
	public void insertStudent( Student student);
	public void dropStudent( String rut);
	public Page<Student> findAll(Pageable pageable);
	public void updateStudent( Student student); 
	
	
}
