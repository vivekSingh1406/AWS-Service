package com.sqs_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SqsAwsConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsAwsConsumerServiceApplication.class, args);
	}

}
