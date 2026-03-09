package com.example.customer_service.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.customer_service.dto.CustomerRequestDTO;
import com.example.customer_service.dto.CustomerResponseDTO;
import com.example.customer_service.entities.Customer;
import com.example.customer_service.mappers.CustomerMapper;
import com.example.customer_service.repositories.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
		if(customer.getId()== null)
		customer.setId(UUID.randomUUID().toString());
		Customer saveCustomer = customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = customerMapper.customerToCostomerResponseDTO(saveCustomer);
		return customerResponseDTO;
	}

	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
		Customer saveCustomer = customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = customerMapper.customerToCostomerResponseDTO(saveCustomer);
		return customerResponseDTO;
	}

	public CustomerResponseDTO getcustomer(String id) {
		Customer customer = customerRepository.findById(id).get();
		System.out.println("doni getcustomer : "+ customer.toString());
		CustomerResponseDTO customerResponseDTO = customerMapper.customerToCostomerResponseDTO(customer);
		return customerResponseDTO;
	}

	public List<CustomerResponseDTO> listCustomer() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTO = customers.stream()
								.map(entry -> customerMapper.customerToCostomerResponseDTO(entry))
								.collect(Collectors.toList());
		return customerResponseDTO;
	}

}
