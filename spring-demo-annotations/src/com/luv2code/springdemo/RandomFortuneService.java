package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create a array of string
	
	private String[] data = {
			"Work Hard",
			"Good Luck",
			"Lucky Day"
	};
	
	//create a random number generator
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		//pick a random string from the array
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
