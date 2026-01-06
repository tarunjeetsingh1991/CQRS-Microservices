package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirststsprojectApplication 
{

	public static void main(String[] args) 
	{
		/*
		SpringApplication.run(FirststsprojectApplication.class, args);
		Alien obj = new Alien();
		obj.code();
		*/
		
		/*
		Alien obj1 = context.getBean(Alien.class);
		obj1.code();
		*/
		
		ApplicationContext context = SpringApplication.run(FirststsprojectApplication.class, args);
		
		Alien obj = context.getBean(Alien.class);
		obj.code();
		
		
	}

}
