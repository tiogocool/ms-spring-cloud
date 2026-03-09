package com.example.billing_service.web;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billing_service.dto.InvoiceRequestDTO;
import com.example.billing_service.dto.InvoiceResponseDTO;
import com.example.billing_service.services.InvoiceService;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
	private InvoiceService invoiceService;

	public InvoiceRestController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}
	
	@GetMapping(path = "/invoice/{id}")
	public InvoiceResponseDTO getInvoice(@PathVariable(name = "id")String invoiceId) {
		return invoiceService.getInvoice(invoiceId);
	}
	
	@GetMapping(path = "/invoiceByCustomer/{customerId}")
	public List<InvoiceResponseDTO> getInvoiceByCustomer(@PathVariable String customerId){
		return invoiceService.invoicesByCustomerId(customerId);
	}
	
	@PostMapping(path = "/invoices")
	public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
		return invoiceService.save(invoiceRequestDTO);
	}
	
	@GetMapping(path = "/invoices")
	public List<InvoiceResponseDTO> allInvoices(){
		return invoiceService.allInvoices();
	}
	
	
	
}
