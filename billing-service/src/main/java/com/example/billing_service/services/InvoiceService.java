package com.example.billing_service.services;

import java.util.List;

import com.example.billing_service.dto.InvoiceRequestDTO;
import com.example.billing_service.dto.InvoiceResponseDTO;

public interface InvoiceService {
	InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
	InvoiceResponseDTO getInvoice(String invoiceId);
	List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);
	List<InvoiceResponseDTO> allInvoices();
}
