package com.coder.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration(excludeName = "com.coder.spring")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
/*
OAuth2: A widely used authorization framework that allows third-party applications to access user 
data without sharing credentials. It supports various flows (e.g., authorization code, client credentials).

JWT (JSON Web Tokens): A compact, URL-safe means of representing claims to be transferred between two 
parties. It is often used for stateless authentication.

*/	
