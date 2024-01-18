package com.test.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.entity.Course;

public class CourseRepository {
private final EntityManager em;
	
	public CourseRepository(final EntityManager em) {
		this.em=em;
	}
	public Course save(final Course course) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(course);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return course;
	}
	
	//Look for objects in the database of type Course by id
	public Optional<Course> findById(int id) {
		Course course = em.find(Course.class, id);
						
		if(course != null)
			return Optional.of(course);
		else
			return Optional.empty();
	}

	//Searching Course record by tier
	public  Optional<Course> findByTier(int id) {
		Course course = em.createQuery("select c from Course c where c.course_id = :course_id", Course.class)
					.setParameter("course_id", id).getSingleResult();
						
		if(course != null)
			return Optional.of(course);
		else
			return Optional.empty();
	}
	//Returning all Course records	
	public List<Course> findAll(){
				
		List<Course> course = em.createQuery("from Course ", Course.class).getResultList();
							
		return course;
	}
	
	//Removing one Course record from the database.
	public void remove(final Course course) {
		EntityTransaction tx = null;
			
		try {
			tx = em.getTransaction();
				
			if(!tx.isActive()) {
				tx.begin();
			}
				
			em.remove(course);
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