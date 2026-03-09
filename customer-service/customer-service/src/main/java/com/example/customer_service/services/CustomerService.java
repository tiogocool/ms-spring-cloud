package com.example.customer_service.services;

import java.util.List;

import com.example.customer_service.dto.CustomerRequestDTO;
import com.example.customer_service.dto.CustomerResponseDTO;

public interface CustomerService {
	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO getcustomer(String id);
	List<CustomerResponseDTO> listCustomer();
}
