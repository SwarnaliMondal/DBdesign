package com.test.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.entity.Attendance;

public class AttendanceRepository {
private final EntityManager em;
	
	public AttendanceRepository(final EntityManager em) {
		this.em=em;
	}
	public Attendance save(final Attendance attendance) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(attendance);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return attendance;
	}
	
	//Look for objects in the database of type Customer by id
	public Optional<Attendance> findById(int id) {
		Attendance attendance = em.find(Attendance.class, id);
						
		if(attendance != null)
			return Optional.of(attendance);
		else
			return Optional.empty();
	}

	//Searching Attendance record by tier
	public  Optional<Attendance> findByTier(int id) {
		Attendance attendance = em.createQuery("select a from Attendance a where a.serial_no= :serial_no", Attendance.class)
					.setParameter("serial_no", id).getSingleResult();
						
		if(attendance != null)
			return Optional.of(attendance);
		else
			return Optional.empty();
	}
	//Returning all Attendance records	
	public List<Attendance> findAll(){
				
		List<Attendance> attendance = em.createQuery("from Course ", Attendance.class).getResultList();
							
		return attendance;
	}
	
	//Removing one Attendance record from the database.
	public void remove(final Attendance attendance) {
		EntityTransaction tx = null;
			
		try {
			tx = em.getTransaction();
				
			if(!tx.isActive()) {
				tx.begin();
			}
				
			em.remove(attendance);
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