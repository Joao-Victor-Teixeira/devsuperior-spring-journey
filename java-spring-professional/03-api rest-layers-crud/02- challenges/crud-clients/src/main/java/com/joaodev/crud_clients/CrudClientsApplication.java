package com.joaodev.crud_clients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudClientsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudClientsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Olá Mundo!!!");
	}

}
