package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			//start a transaction
			session.beginTransaction();
			
			int id = 5;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, id);
			
			System.out.println("tempInstructorDetail: "+ tempInstructorDetail);
			
			System.out.println("the associated instructor: "+
								tempInstructorDetail.getInstructor());
			
			//break bi-direction link
			
			tempInstructorDetail.getInstructor().setInstructorDetailId(null);
			
			// delete
			System.out.println("\n Deleting tempInstructorDetail: "
								+tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
