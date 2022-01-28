package com.abiola.abiola.service;

import com.abiola.abiola.adapter.InvoiceAdapter;
import com.abiola.abiola.domain.InvoiceDomain;
import com.abiola.abiola.model.Invoice;
import com.abiola.abiola.repository.InvoiceRepository;
import com.abiola.abiola.strategy.DefaultTax;
import com.abiola.abiola.strategy.TaxCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    InvoiceRepository invoiceRepository;

    public InvoiceService(){}

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice processIncomingInvoice(InvoiceDomain invoiceDomain) {
        InvoiceAdapter invoiceAdapter  = new InvoiceAdapter(invoiceDomain);
        Invoice invoice = invoiceAdapter.getInvoice();
        TaxCalculator taxCalculator = new TaxCalculator(invoice, new DefaultTax());
        float tax = taxCalculator.calculateTax();
        invoice.setTax(tax);
        invoice.setInvoiceCostAfterTax(invoice.getInvoiceCost() + tax);
        this.invoiceRepository.save(invoice);
        return invoice;
    }

    public Page<Invoice> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }
}
