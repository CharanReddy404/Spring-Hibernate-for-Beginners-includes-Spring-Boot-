package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreatEmployeeDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			Employee theEmployee1 = new Employee("Charan", "Reddy", "eMoment.in");
//			Employee theEmployee2 = new Employee("Luffy", "Monkey D", "Onepiece");
//			Employee theEmployee3 = new Employee("Naruto", "UZumaki", "Naruto");
//			
//			System.out.println("Adding Employees to DB");
//			session.beginTransaction();
//			session.save(theEmployee1);
//			session.save(theEmployee2);
//			session.save(theEmployee3);
//			System.out.println("Added Emplyee's");
//			session.getTransaction().commit();
//			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n Getting a employee from DB");
			
			List<Employee> employeesList = session.createQuery("from Employee").getResultList();
			
			printEmployeeList(employeesList);
			
			Employee theEmployee = session.get(Employee.class, 1);
			
			System.out.println("\n Updating Company");
			theEmployee.setCompany("eMoment.in");
			
			printEmployeeList(employeesList);
			
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			employeesList = session.createQuery("from Employee").getResultList();
			
			printEmployeeList(employeesList);
			
		} finally {
			
		}
		
		
	}

	private static void printEmployeeList(List<Employee> employeesList) {
		for(Employee employee : employeesList) {
			System.out.println("\n");
			System.out.println(employee);
		}
	}

}
