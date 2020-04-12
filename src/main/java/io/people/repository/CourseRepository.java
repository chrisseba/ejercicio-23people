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

import io.people.domain.Course;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {
	
	
	public Page<Course> findAll(Pageable pageable);
	
	
	@Query(value = "CALL getCourse(:code);", nativeQuery = true)
	public List<Course> getCourse( @Param("code") String code);
	
	@Modifying
	@Transactional
	@Query(value = "CALL insertCourse(:#{#course.code}, "
									+ ":#{#course.name});", nativeQuery = true)
	public void insertCourse( 	@Param("course") Course course);
	
	@Modifying
	@Transactional
	@Query(value = "CALL updateCourse(:#{#course.code}, "
									+ ":#{#course.name});", nativeQuery = true)
	public List<Course> updateCourse( 	@Param("course") Course course);
	
	
    
	
	@Modifying
	@Transactional
	@Query(value = "CALL dropCourse(:code);", nativeQuery = true)
	public List<Course> dropCourse( 	@Param("code") String code);
	
	
	
	
	
	
}
