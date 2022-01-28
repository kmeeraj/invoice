package com.abiola.abiola.adapter;


import com.abiola.abiola.domain.InvoiceDomain;
import com.abiola.abiola.model.Invoice;

public class InvoiceAdapter {
    private InvoiceDomain invoiceDomain;
    public InvoiceAdapter(InvoiceDomain invoiceDomain) {
        this.invoiceDomain = invoiceDomain;
    }
    public Invoice getInvoice() {
        return new Invoice(this.invoiceDomain.getInvoiceEntity(), this.invoiceDomain.getInvoiceCost());
    }

}
