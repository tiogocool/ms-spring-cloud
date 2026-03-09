package com.example.billing_service.mappers;

import org.mapstruct.Mapper;

import com.example.billing_service.dto.InvoiceRequestDTO;
import com.example.billing_service.dto.InvoiceResponseDTO;
import com.example.billing_service.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
	Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
	InvoiceResponseDTO fromInvoice(Invoice invoice);

	
}
