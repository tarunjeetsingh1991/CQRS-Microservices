package com.telusko.student_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerStudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerStudentAppApplication.class, args);
	}

	//Important commands:
	//docker-compose down
	//mvn clean package -DskipTests
	//docker-compose up -d --build
	
	//docker logs docker-student-app-postgres-1
	//docker logs docker-student-app-app-1



}
