package com.example.alutecSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AlutecSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlutecSpringApplication.class, args);

	}

}
