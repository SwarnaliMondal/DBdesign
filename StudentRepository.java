package com.test.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.entity.Student;



public class StudentRepository {
private final EntityManager em;
	
	public StudentRepository(final EntityManager em) {
		this.em=em;
	}
	public Student save(final Student student) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(student);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}
	
	//Look for objects in the database of type Student by id
	public  Optional<Student> findById(int id) {
		Student student = em.find(Student.class, id);
				
		if(student != null)
			return Optional.of(student);
		else
			return Optional.empty();
	}
	
	
	//Searching Student record by title
	public  Optional<Student> findByName(String name) {
		Student student = em.createQuery("select s from Student s where s.name = :name", Student.class)
					.setParameter("name", name).getSingleResult();
					
		if(student != null)
			return Optional.of(student);
		else
			return Optional.empty();
	}
	
	//Returning all Student records	
	public List<Student> findAll(){
				
		List<Student> students = em.createQuery("from Product ", Student.class).getResultList();
							
		return students;
	}
	
	//Removing one Student from the database.
	public void remove(final Student student) {
		EntityTransaction tx = null;
			
		try {
			tx = em.getTransaction();
				
			if(!tx.isActive()) {
				tx.begin();
			}
				
			em.remove(student);
				tx.commit();
				
		} 
		catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
		
}


