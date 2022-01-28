package com.abiola.abiola.controller;

import com.abiola.abiola.domain.InvoiceDomain;
import com.abiola.abiola.model.Invoice;
import com.abiola.abiola.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceController {
    InvoiceService invoiceService;
    public InvoiceController(){
    }

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/doinvoice")
    public String addInvoice(Model model){
        model.addAttribute("invoice", new InvoiceDomain());
        return "invoice";
    }

    @GetMapping("/getinvoices")
    public String invoices(Model model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Invoice> invoices = this.invoiceService.getAllInvoices(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("invoices", invoices);
        return "invoices";
    }
    @PostMapping("/newinvoice")
    public String newInvoice(InvoiceDomain invoiceDomain) {
        Invoice invoice=  this.invoiceService.processIncomingInvoice(invoiceDomain);
        return "redirect:/getinvoices";
    }
}
