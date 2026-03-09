package com.example.billing_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.billing_service.entities.Invoice;

public interface InvoiceReepository extends JpaRepository<Invoice, String>{
	List<Invoice> findByClientId(String clientId);
}
