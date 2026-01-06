package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CqrsProductQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsProductQueryServiceApplication.class, args);
	}

}
