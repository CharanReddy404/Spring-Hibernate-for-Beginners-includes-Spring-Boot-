package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewCoachConfig {
	
	@Bean
	public FortuneService fortuneService() {
		return new NewFortuneService();
	}
	
	@Bean
	public Coach newCoach() {
		return new NewCoach(fortuneService());
	}
}
