package com.fernandoschimidt.magalusms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MagalusmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagalusmsApplication.class, args);
	}

}
