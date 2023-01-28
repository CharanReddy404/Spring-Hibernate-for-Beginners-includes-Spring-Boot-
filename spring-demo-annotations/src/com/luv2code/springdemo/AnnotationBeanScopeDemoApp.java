package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Coach theCoach = context.getBean("tennisCoach",Coach.class);
//		
//		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
//		
//		boolean result = (theCoach == alphaCoach);
//		
//		System.out.println(result);
//		System.out.println(theCoach);
//		System.out.println(alphaCoach);
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
		
	}

}
