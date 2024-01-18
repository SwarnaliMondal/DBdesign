//2nd-entity
package com.test.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serial_no")
	private int id;
	private LocalDate date;
	private String status;
	
	@OneToOne
	@JoinColumn(name="student_id")
	
	private Student student;
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attendance(int id, LocalDate date, String status, Student student) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.student = student;
	}
	public Attendance(LocalDate date, String status, Student student) {
		super();
		this.date = date;
		this.status = status;
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", date=" + date + ", status=" + status + ", student=" + student + "]";
	}
	
	
	
	
	}
