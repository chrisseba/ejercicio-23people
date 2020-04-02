package io.people.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
public class Student {
	
	@Id
	@Column
	private String rut;

	@Column
	private String name;
	
	@Column
	private String lastname;
	
	@Column
	private Integer age;
	
	@Column
	private String fk_course;

	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFk_course() {
		return fk_course;
	}

	public void setFk_course(String fk_course) {
		this.fk_course = fk_course;
	}

	
	

}
