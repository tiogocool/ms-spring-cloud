package com.example.billing_service.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.billing_service.dto.InvoiceRequestDTO;
import com.example.billing_service.dto.InvoiceResponseDTO;
import com.example.billing_service.entities.Customer;
import com.example.billing_service.entities.Invoice;
import com.example.billing_service.exception.CustomerNotFoundException;
import com.example.billing_service.mappers.InvoiceMapper;
import com.example.billing_service.openfeign.CustomerRestClient;
import com.example.billing_service.repositories.InvoiceReepository;

@Service
@Transactional
public class invoiceServiceImpl implements InvoiceService{
	
	private InvoiceReepository invoiceReepository;
	private InvoiceMapper invoiceMapper;
	private CustomerRestClient customerRestClient;
	
	

	public invoiceServiceImpl(InvoiceReepository invoiceReepository, InvoiceMapper invoiceMapper,
			CustomerRestClient customerRestClient) {
		super();
		this.invoiceReepository = invoiceReepository;
		this.invoiceMapper = invoiceMapper;
		this.customerRestClient = customerRestClient;
	}

	@Override
	public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
		
		try {
			Customer customer = customerRestClient.getCustomer(invoiceRequestDTO.getClientId());
		} catch (Exception e) {
			throw new CustomerNotFoundException("customer not found");
		}
		Invoice invoice= invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
		invoice.setId(UUID.randomUUID().toString());
		invoice.setDate(new Date());
		// verification de l integrite referentielle / Customer
		Invoice saveInvoice = invoiceReepository.save(invoice);
		return invoiceMapper.fromInvoice(saveInvoice);
	}

	@Override
	public InvoiceResponseDTO getInvoice(String invoiceId) {
		Invoice invoice  = invoiceReepository.findById(invoiceId).get();
		Customer customer = customerRestClient.getCustomer(invoice.getClientId());
		System.out.println("doni getInvoice :" + invoice + "customer :" + customer);
		invoice.setCustomer(customer);
		return invoiceMapper.fromInvoice(invoice);
	}

	@Override
	public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
		List<Invoice> invoices = invoiceReepository.findByClientId(customerId);
		for (Invoice invoice : invoices) {
			Customer c = customerRestClient.getCustomer(invoice.getClientId());
			invoice.setCustomer(c);
		}
		
		return invoices.stream().map(invoice -> invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
	}

	@Override
	public List<InvoiceResponseDTO> allInvoices() {
		List<Invoice> invoices = invoiceReepository.findAll();
		for (Invoice invoice : invoices) {
			Customer c = customerRestClient.getCustomer(invoice.getClientId());
			invoice.setCustomer(c);
		}
		
		return invoices.stream().map(inv -> invoiceMapper.fromInvoice(inv)).collect(Collectors.toList());
	}

}
