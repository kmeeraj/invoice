package com.abiola.abiola.strategy;


import com.abiola.abiola.model.Invoice;

public class TaxCalculator {
    private Invoice invoice;
    private ITax tax;

    public TaxCalculator(Invoice invoice, ITax tax) {
        this.invoice = invoice;
        this.tax = tax;
    }

    public Float calculateTax() {
        return tax.getTax() * this.invoice.getInvoiceCost();
    }
}
