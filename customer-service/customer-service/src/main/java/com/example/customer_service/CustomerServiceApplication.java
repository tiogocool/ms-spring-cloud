package com.example.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.customer_service.dto.CustomerRequestDTO;
import com.example.customer_service.services.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args -> {
			customerService.save(new CustomerRequestDTO("C01","Adrien","adrien@gmail.com"));
			customerService.save(new CustomerRequestDTO("C02","Gibu","gibu@gmail.com"));
		};
		
	}
}
