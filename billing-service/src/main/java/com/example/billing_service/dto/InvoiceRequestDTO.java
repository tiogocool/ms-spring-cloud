package com.example.billing_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceRequestDTO {
	
	
	public InvoiceRequestDTO(String clientId, BigDecimal amount) {
		super();
		this.clientId = clientId;
		this.amount = amount;
	}
	public InvoiceRequestDTO() {
		super();
	}

	private String clientId;
	private BigDecimal amount;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	
}
