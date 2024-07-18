package org.example.ticketzserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	CommandLineRunner commandLineRunner(OrganizersRepository organizersRepository
//	){
//		return args -> {
//			Organizers helpingHand = new Organizers();
//			organizersRepository.save(helpingHand);
//		};
//	}

}
