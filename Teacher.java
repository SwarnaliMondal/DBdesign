//4th-entity
package com.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private int id;
	private String name;
	@OneToOne(mappedBy="teacher",cascade=CascadeType.ALL)
	private Course course;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(String name) {
		super();
		this.name = name;
	}

	public Teacher(String name, Course course) {
		super();
		this.name = name;
		this.course = course;
	}

	public Teacher(int id, String name, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	

}
