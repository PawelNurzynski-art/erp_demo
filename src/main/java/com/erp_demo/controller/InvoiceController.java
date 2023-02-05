package com.erp_demo.controller;

import com.erp_demo.entity.InvoiceEntity;
import com.erp_demo.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    public InvoiceRepository invoiceRepository;

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

    // add invoice
    // template
    record InvoiceRequest(
            String invoiceNumber,
            LocalDate operationDate,
            LocalDate issueDate,
            LocalDate accountingDate,
            String counterpartyId, // from CounterpartyEntity
            String currencyId, // from CurrencyEntity
            String itemsId
    ) {}

    // generate invoice (add)
    @PostMapping("")
    public InvoiceEntity addInvoice(@RequestBody InvoiceRequest request) {
        InvoiceEntity invoice = new InvoiceEntity();

        invoice.setInvoiceNumber(request.invoiceNumber);
        invoice.setOperationDate(request.operationDate);
        invoice.setIssueDate(request.issueDate);
        invoice.setAccountingDate(request.accountingDate);
        invoice.setCounterpartyId(request.counterpartyId);
        invoice.setCurrencyId(request.currencyId);
        invoice.setItemsId(request.itemsId);

        invoiceRepository.save(invoice);
        return invoice;
    }

    // delete the invoice
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable("id") UUID id) {
        invoiceRepository.deleteById(id);
    }


}
