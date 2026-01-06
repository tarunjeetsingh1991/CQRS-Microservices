package com.dailycodebuffer.cab_book_driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookDriverApplication.class, args);
	}

}

//Commands : 

//1. bin/kafka-server-start.sh config/server.properties

// If we have already created a topic, then no need to run command 2, go directly to command 3.

//2. bin/kafka-topics.sh --create --topic cab-location --bootstrap-server localhost:9092

//3. bin/kafka-console-consumer.sh --topic cab-location --from-beginning --bootstrap-server localhost:9092