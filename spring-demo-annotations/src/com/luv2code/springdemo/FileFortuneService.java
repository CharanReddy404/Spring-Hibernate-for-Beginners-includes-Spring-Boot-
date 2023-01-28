package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName="C:\\Users\\Chara\\Desktop\\JAVA\\Spring & Hibernate for Beginners (includes Spring Boot)\\spring-demo-annotations\\src\\fortune-data.txt";
	private List<String> theFortunes;
	
	private Random random = new Random();
	
	public FileFortuneService() {
		File theFile = new File(fileName);
		
		System.out.println(theFile);
		System.out.println(theFile.exists());
		
		theFortunes = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(theFile))){
			String tempLine;
			while((tempLine=br.readLine())!=null) {
				theFortunes.add(tempLine);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getFortune() {
		int index = random.nextInt(theFortunes.size());
		return theFortunes.get(index);
	}

}
