package com.example.customer_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer_service.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String>{

}
