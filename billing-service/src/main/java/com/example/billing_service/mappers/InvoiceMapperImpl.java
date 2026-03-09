package com.example.billing_service.mappers;

import org.springframework.stereotype.Component;

import com.example.billing_service.dto.InvoiceRequestDTO;
import com.example.billing_service.dto.InvoiceResponseDTO;
import com.example.billing_service.entities.Invoice;

@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO) {
        if (invoiceRequestDTO == null) {
            return null;
        }

        Invoice invoice = new Invoice();
        invoice.setClientId(invoiceRequestDTO.getClientId());
        invoice.setAmount(invoiceRequestDTO.getAmount());
        return invoice;
    }

    @Override
    public InvoiceResponseDTO fromInvoice(Invoice invoice) {
        if (invoice == null) {
            return null;
        }

        InvoiceResponseDTO dto = new InvoiceResponseDTO();
        dto.setId(invoice.getId());
        dto.setDate(invoice.getDate());
        dto.setAmount(invoice.getAmount());
        dto.setCustomer(invoice.getCustomer());
        return dto;
    }
}
