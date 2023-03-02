package com.erp_demo.controller;

import com.erp_demo.dto.InvoiceDto;
import com.erp_demo.entity.InvoiceEntity;
import com.erp_demo.repository.CounterpartyRepository;
import com.erp_demo.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    public InvoiceRepository invoiceRepository;
    public CounterpartyRepository counterpartyRepository;
    public InvoiceDto newInvoice = new InvoiceDto();

    // constructor
    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // display all invoices
    @GetMapping("")
    public List<InvoiceEntity> getAllInvoice() {
        return invoiceRepository.findAll();
    }


    // display invoice chosen by id
    @GetMapping("/{id}")
    public Optional<InvoiceEntity> getInvoice(@PathVariable("id") UUID id) {
        return invoiceRepository.findById(id);
    }

    // generate invoice (add)
    @PostMapping("")
    public InvoiceEntity addInvoice(@RequestBody InvoiceDto newInvoice) {
        InvoiceEntity invoice = new InvoiceEntity();

        invoice.setInvoiceNumber(newInvoice.getInvoiceNumber());
        invoice.setOperationDate(newInvoice.getOperationDate());
        invoice.setIssueDate(newInvoice.getIssueDate());
        invoice.setAccountingDate(newInvoice.getAccountingDate());
        invoice.setCounterparty(newInvoice.getCounterparty());
        invoice.setItem(newInvoice.getItem());

        invoiceRepository.save(invoice);
        return invoice;
    }

    // delete the invoice
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable("id") UUID id) {
        invoiceRepository.deleteById(id);
    }


}
