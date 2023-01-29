package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class NewCoachDemo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(NewCoachConfig.class);
		
		NewCoach coach = context.getBean("newCoach", NewCoach.class);
		
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkout());
		
		context.close();

	}

}
