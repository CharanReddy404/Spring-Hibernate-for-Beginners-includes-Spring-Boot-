package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreatDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
//			Instructor tempInstructor = 
//					new Instructor("Charan","Reddy","charan@gmail.com");
//			
//			InstructorDetail tempInstructorDetail = 
//					new InstructorDetail("youtube.com/charan", "Coding");
//			
//			tempInstructor.setInstructorDetailId(tempInstructorDetail);
//			
			
			Instructor tempInstructor = 
					new Instructor("Luffy","Monkey D","luffy@monkey.d");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("youtube.com/MonkeyDLuffy", "Pirate");
			
			tempInstructor.setInstructorDetailId(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
