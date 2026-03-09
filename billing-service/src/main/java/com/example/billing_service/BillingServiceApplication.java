package com.example.billing_service;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.billing_service.dto.InvoiceRequestDTO;
import com.example.billing_service.services.InvoiceService;

@SpringBootApplication
@EnableFeignClients
@ComponentScan("com.example.billing_service")
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(InvoiceService invoiceService) {
		return args -> {
			invoiceService.save(new InvoiceRequestDTO("C01", BigDecimal.valueOf(8200)));
			invoiceService.save(new InvoiceRequestDTO("C02", BigDecimal.valueOf(2000)));
		};
		
	}

}
