package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
//			int studentId = 1;
//			
//			//now get a new session and start transaction
////			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			//retrieve student based on the id: primary key
//			
//			System.out.println("\nGetting student with id: "+ studentId);
//			
//			Student myStudent = session.get(Student.class, studentId);
//			
//			myStudent.setEmail("charan@spring.com");
//			
//			System.out.println("Get complete: "+ myStudent);
			
			// update all emails
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating all emails");
			
			session.createQuery("update Student set email='foo@gmail.com'")
					.executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
