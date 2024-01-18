//3rd-entity
package com.test.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	@Column(name="S_name")
	private String name;
	private String gender;
	private LocalDate dob;
	private LocalDate doa;
	
	@OneToOne(mappedBy="student",cascade=CascadeType.ALL)
	private Attendance attendance;
	
	@ManyToOne
	
	@JoinColumn(name="course_id")
	private Course course;
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String name, String gender, LocalDate dob, LocalDate doa, Attendance attendance, Course course) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.doa = doa;
		this.attendance = attendance;
		this.course = course;
	}


	public Student(String name, String gender, LocalDate dob, LocalDate doa, Course course) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.doa = doa;
		this.course = course;
	}

	public Student(int id, String name, String gender, LocalDate dob, LocalDate doa, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.doa = doa;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public LocalDate getDoa() {
		return doa;
	}


	public void setDoa(LocalDate doa) {
		this.doa = doa;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", doa=" + doa
				+ ", course=" + course + "]";
	}
	
}

	