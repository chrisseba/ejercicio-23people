package io.people.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@Column
	private String code;
	
	@Column
	private String name;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCourse() {
		return name;
	}
	public void setCourse(String name) {
		this.name = name;
	}
	
	
	
	
	
}
