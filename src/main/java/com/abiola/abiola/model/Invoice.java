package com.abiola.abiola.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Invoice {
    private @Id
    @GeneratedValue
    Long id;
    private String invoiceEntity;
    private float invoiceCost;
    private float tax;
    private float invoiceCostAfterTax;

    public Invoice () {

    }

    public Invoice(String invoiceEntity, float invoiceCost){
        this.invoiceEntity = invoiceEntity;
        this.invoiceCost = invoiceCost;
    }

}
