package com.test.StudentManagement;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import com.test.entity.Attendance;
import com.test.entity.Course;
import com.test.entity.Teacher;
import com.test.entity.Student;
import com.test.repository.AttendanceRepository;
import com.test.repository.CourseRepository;
import com.test.repository.TeacherRepository;
import com.test.repository.StudentRepository;

public class App {
  public static void main(String[] args) {
	  System.out.println("_______Student_Management________");
	  EntityManagerFactory factory = null;
		EntityManager em = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("HibernateDemo");
			em = factory.createEntityManager();
			//Operations of Teacher class and TeacherRepository class 
			TeacherRepository tea=new TeacherRepository(em);
			Teacher t1=new Teacher("Priyanka");
			Teacher t2=new Teacher("Sukhendu");
			Teacher t3=new Teacher("Prosenjit");
			Teacher t4=new Teacher("Prabha");
			Teacher t5=new Teacher("Joy");
			//Saving objects of type teacher to the database
			tea.save(t1);
			tea.save(t2);
			tea.save(t3);
			tea.save(t4);
			tea.save(t5);
			//Operations of Course class and CourseRepository class
			Course c1=new Course("Digital marketing",1000,t1);
			Course c2=new Course("Web development",5000,t2);
			Course c3=new Course("Graphics",4000,t3);
			Course c4=new Course("VFX",7000,t4);
			Course c5=new Course("Excel",1000,t5);
			
			CourseRepository co=new CourseRepository(em);
			//Saving objects of type course to the database
			co.save(c1);
			co.save(c2);
			co.save(c3);
			co.save(c4);
			co.save(c5);
			//Operations of Student class and StudentRepository class
			StudentRepository stu=new StudentRepository(em);
			
			Student s1=new Student("swarnali","female",null,null,c1);
			Student s2=new Student("soumyadip","male",null,null,c2);
			Student s3=new Student("ram","male",null,null,c2);
			Student s4=new Student("sandhya","female",null,null,c3);
			Student s5=new Student("soumili","female",null,null,c5);
			s1.setDob(LocalDate.of(2001,Month.DECEMBER,26));
			s1.setDoa(LocalDate.of(2023,Month.DECEMBER,22));
			s2.setDob(LocalDate.of(2008,Month.JUNE,14));
			s2.setDoa(LocalDate.of(2023,Month.DECEMBER,21));
			s3.setDob(LocalDate.of(1996,Month.OCTOBER,10));
			s3.setDoa(LocalDate.of(2023,Month.DECEMBER,24));
			s4.setDob(LocalDate.of(1998,Month.SEPTEMBER,5));
			s4.setDoa(LocalDate.of(2023,Month.DECEMBER,27));
			s5.setDob(LocalDate.of(2000,Month.AUGUST,5));
			s5.setDoa(LocalDate.of(2023,Month.DECEMBER,28));
			
			List<Student> students=new ArrayList<Student>();
			students.add(s1);
			students.add(s2);
			students.add(s3);
			students.add(s3);
			students.add(s4);
			students.add(s5);
			//Saving objects of type student to the database
			for(Student s:students) {
				stu.save(s);
			}
			//Operations of Attendance class and AttendanceRepository class
			AttendanceRepository at=new AttendanceRepository(em);
			Attendance a1=new Attendance(null,"present",s1);
			Attendance a2=new Attendance(null,"absent",s2);
			Attendance a3=new Attendance(null,"present",s3);
			Attendance a4=new Attendance(null,"absent",s4);
			Attendance a5=new Attendance(null,"present",s5);
			a1.setDate(LocalDate.of(2024, Month.JANUARY, 18));
			a2.setDate(LocalDate.of(2024, Month.JANUARY, 18));
			a3.setDate(LocalDate.of(2024, Month.JANUARY, 18));
			a4.setDate(LocalDate.of(2024, Month.JANUARY, 18));
			a5.setDate(LocalDate.of(2024, Month.JANUARY, 18));
			
			List<Attendance>attendance=new ArrayList<Attendance>();
			attendance.add(a1);
			attendance.add(a2);
			attendance.add(a3);
			attendance.add(a4);
			attendance.add(a5);
			//Saving objects of type attendance to the database
			for(Attendance a:attendance) {
				at.save(a);
			}
			
		}	
		
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Exception Hibernate");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}
		finally {
			 if(factory!= null) {
			 factory.close();
			 }
		}
  }
}