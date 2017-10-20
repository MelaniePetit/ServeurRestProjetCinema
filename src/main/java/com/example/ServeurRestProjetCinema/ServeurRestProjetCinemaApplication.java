package com.example.ServeurRestProjetCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ServeurRestProjetCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeurRestProjetCinemaApplication.class, args);
	}
}
