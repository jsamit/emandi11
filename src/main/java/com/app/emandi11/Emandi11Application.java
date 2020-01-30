package com.app.emandi11;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
@Transactional
public class Emandi11Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Emandi11Application.class, args);
	}

}
