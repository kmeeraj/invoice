package com.abiola.abiola.api;

import com.abiola.abiola.domain.InvoiceDomain;
import com.abiola.abiola.model.Invoice;
import com.abiola.abiola.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceAPIController {
    private InvoiceService invoiceService;
    public InvoiceAPIController(){}

    @Autowired
    public InvoiceAPIController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;

    }
    @GetMapping("/invoices/")
    Page<Invoice> getAllInvoices(Pageable pageable){
        return this.invoiceService.getAllInvoices(pageable);
    }
    @PutMapping("/invoice")
    Invoice newInvoice(@RequestBody InvoiceDomain invoiceDomain) {
        return this.invoiceService.processIncomingInvoice(invoiceDomain);
    }
}
