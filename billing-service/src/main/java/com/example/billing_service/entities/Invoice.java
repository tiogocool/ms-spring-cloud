package com.example.billing_service.entities;

import java.math.BigDecimal;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data @AllArgsConstructor @NoArgsConstructor
public class Invoice {
	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private Date date;
	private BigDecimal amount;
	private String clientId;
	@Transient
	private Customer customer;
	
	
	public Invoice(String id, Date date, BigDecimal amount, String clientId, Customer customer) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.clientId = clientId;
		this.customer = customer;
	}
	
	
	
	public Invoice() {
		super();
	}



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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@Override
	public String toString() {
		return "Invoice [id=" + id + ", date=" + date + ", amount=" + amount + ", clientId=" + clientId + ", customer="
				+ customer + "]";
	}
	
	
	
}
