package com.example.billing_service.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.example.billing_service.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceResponseDTO {
	
	
	public InvoiceResponseDTO() {
		super();
	}
	
	public InvoiceResponseDTO(String id, Date date, Customer customer, BigDecimal amount) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.amount = amount;
	}

	private String id;
	private Date date;
	private Customer customer;
	private BigDecimal amount;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
