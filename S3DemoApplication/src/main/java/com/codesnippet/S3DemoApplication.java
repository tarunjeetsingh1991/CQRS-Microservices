package com.codesnippet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S3DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3DemoApplication.class, args);
	}

}

/*
 * Commands : 
 *to change permissions, we need to run this one first
 * chmod 400 springboot-s3-key.pem
 * then this one : 
 * scp -i "springboot-s3-key.pem" S3DemoApplication-0.0.1-SNAPSHOT.jar ec2-user@ec2-3-145-195-184.us-east-2.compute.amazonaws.com:/home/ec2-user/
 * 
 * finally to login to our ec2 instance, use :
 * 
 * 
 * to install java:
 * 	sudo yum update -y
	sudo amazon-linux-extras enable corretto17
	sudo yum install java-17-amazon-corretto -y
	java -version
	
	After this, we will use : 
	nohup java -Dspring.profiles.active=dev -jar S3DemoApplication-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
 */
