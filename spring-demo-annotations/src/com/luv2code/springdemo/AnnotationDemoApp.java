package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//get the bean from spring container
//		Coach tennisCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach swimCoach = context.getBean("swimCoach",Coach.class);
		
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
//		swimCoach.printInfo();
		
		//call a method on the bean
//		System.out.println(tennisCoach.getDailyWorkout());
//		
//		System.out.println(tennisCoach.getDailyFortune());
		
		//close
		context.close();
	}

}
