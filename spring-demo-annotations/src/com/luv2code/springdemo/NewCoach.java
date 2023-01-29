package com.luv2code.springdemo;

public class NewCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public NewCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run Run Run";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	
}
