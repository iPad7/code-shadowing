package com.code_shadowing.the_first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TheFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheFirstApplication.class, args);
	}

}
