package com.test.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.entity.Teacher;

public class TeacherRepository {
private final EntityManager em;
	
	public TeacherRepository(final EntityManager em) {
		this.em=em;
	}
	public Teacher save(final Teacher teacher) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(teacher);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return teacher;
	}
	
	//Look for objects in the database of type Teacher by id
	public  Optional<Teacher> findById(int id) {
		Teacher teacher = em.find(Teacher.class, id);
					
		if(teacher != null)
			return Optional.of(teacher);
		else
			return Optional.empty();
	}
	
	//Searching Teacher record by status
	public  Optional<Teacher> findByStatus(int id) {
		Teacher teacher = em.createQuery("select t from Teacher t where t.teacher_id = :teacher_id", Teacher.class)
					.setParameter("teacher_id", id).getSingleResult();
						
		if(teacher != null)
			return Optional.of(teacher);
		else
			return Optional.empty();
	}
	
	//Returning all Teacher records	
	public List<Teacher> findAll(){
				
		List<Teacher> teacher = em.createQuery("from Teacher ", Teacher.class).getResultList();
							
		return teacher;
	}

	//Removing one Teacher record from the database.
	public void remove(final Teacher teacher) {
		EntityTransaction tx = null;
			
		try {
			tx = em.getTransaction();
				
			if(!tx.isActive()) {
				tx.begin();
			}
				
			em.remove(teacher);
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
