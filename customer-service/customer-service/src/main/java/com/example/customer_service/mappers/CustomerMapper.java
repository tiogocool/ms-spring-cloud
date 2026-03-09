package com.example.customer_service.mappers;

import org.mapstruct.*;
import org.springframework.stereotype.Component;

import com.example.customer_service.dto.CustomerRequestDTO;
import com.example.customer_service.dto.CustomerResponseDTO;
import com.example.customer_service.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO customerToCostomerResponseDTO(Customer customer);
}
