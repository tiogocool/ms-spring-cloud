package com.example.billing_service.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.billing_service.entities.Customer;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
	
	@GetMapping(path = "/api/customers/{id}")
	Customer getCustomer(@PathVariable String id);
	
	@GetMapping(path = "/api/customers")
	List<Customer> allCustomers();
}
