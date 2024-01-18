//1st- entity
package com.test.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int id;
	@Column(name="c_name")
	private String name;
	private long fees;
	@OneToMany(mappedBy="course",cascade=CascadeType.ALL)
	
	private List<Student>student=new ArrayList<Student>();
	@OneToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(String name, long fees, Teacher teacher) {
		super();
		this.name = name;
		this.fees = fees;
		this.teacher = teacher;
	}

	public Course(int id, String name, long fees, List<Student> student, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
		this.student = student;
		this.teacher = teacher;
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
	public long getFees() {
		return fees;
	}
	public void setFees(long fees) {
		this.fees = fees;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
