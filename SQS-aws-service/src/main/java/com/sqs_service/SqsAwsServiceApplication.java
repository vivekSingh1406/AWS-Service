package com.sqs_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
public class SqsAwsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsAwsServiceApplication.class, args);
	}

}
