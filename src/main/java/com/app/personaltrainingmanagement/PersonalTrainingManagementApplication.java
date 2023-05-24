package com.app.personaltrainingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PersonalTrainingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalTrainingManagementApplication.class, args);
	}

}
