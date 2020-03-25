package io.people.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.people.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	

	@Query(value = "CALL getCourse(:code, :name);", nativeQuery = true)
	public List<Course> getCursos( 	@Param("code") String code,
									@Param("name") String name);
    
	
}
