package com.example.customer_service.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_service.dto.CustomerRequestDTO;
import com.example.customer_service.dto.CustomerResponseDTO;
import com.example.customer_service.services.CustomerService;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
	private CustomerService customerService;

	public CustomerRestAPI(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(path = "/customers")
	public List<CustomerResponseDTO> allCustomers(){
		return customerService.listCustomer();
	}
	
	@PostMapping(path = "/save")
	public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
		return customerService.save(customerRequestDTO);
	}
	
	@GetMapping(path = "/customers/{id}")
	public CustomerResponseDTO getCustomer(@PathVariable String id){
		return customerService.getcustomer(id);
	}
	
}
