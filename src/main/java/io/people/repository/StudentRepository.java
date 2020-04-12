package io.people.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.people.domain.Student;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>  {
	
	public Page<Student> findAll(Pageable pageable);
	
	@Query(value = "CALL getStudent(:rut);", nativeQuery = true)
	public List<Student> getStudent( @Param("rut") String rut);
	
	@Modifying
	@Transactional
	@Query(value = "CALL insertStudent(:#{#student.rut}, "
									+ ":#{#student.name},"
									+ ":#{#student.lastname},"
									+ ":#{#student.age},"
									+ ":#{#student.fk_course});"
											, nativeQuery = true)
	public void insertStudent( 	@Param("student") Student student);
	
	
	@Modifying
	@Transactional
	@Query(value = "CALL updateStudent(:#{#student.rut}, "
									+ ":#{#student.name},"
									+ ":#{#student.lastname},"
									+ ":#{#student.age},"
									+ ":#{#student.fk_course});"
											, nativeQuery = true)
	public List<Student> updateStudent( 	@Param("student") Student student );
	
	
	@Modifying
	@Transactional
	@Query(value = "CALL dropStudent(:rut);", nativeQuery = true)
	public List<Student> dropStudent( 	@Param("rut") String rut);
	
	
	
}













