package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
					
		// create session
					
		Session session = factory.getCurrentSession();
					
		try {
			//create 3 student objects
			System.out.println("creating 3 student object...");
			Student tempStudent1 = new Student("Charan", "one", "Charan1@spring.com");
			Student tempStudent2 = new Student("Charan", "two", "Charan2@spring.com");
			Student tempStudent3 = new Student("Charan", "three", "Charan3@spring.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student..");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
