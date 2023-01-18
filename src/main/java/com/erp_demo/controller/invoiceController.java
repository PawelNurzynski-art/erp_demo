package com.erp_demo.controller;

import com.erp_demo.entity.InvoiceEntity;
import com.erp_demo.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class invoiceController {
    public InvoiceRepository invoiceRepository;

    public invoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // display all invoices
    @GetMapping("")
    public List<InvoiceEntity> getInvoice() {
        return invoiceRepository.findAll();
    }


    // add invoice
    // template
    record InvoiceRequest(
            String invoiceNumber,
            LocalDate operationDate,
            LocalDate issueDate,
            LocalDate accountingDate,
            int counterpartyId, // from CounterpartyEntity
            int currencyId // from CurrencyEntity
    ) {}

    // add invoice to database
    @PostMapping("")
    public InvoiceEntity addInvoice(@RequestBody InvoiceRequest request) {
        InvoiceEntity invoice = new InvoiceEntity();

        invoice.setInvoiceNumber(request.invoiceNumber);
        invoice.setOperationDate(request.operationDate);
        invoice.setIssueDate(request.issueDate);
        invoice.setAccountingDate(request.accountingDate);
        invoice.setCounterpartyId(request.counterpartyId);
        invoice.setCurrencyId(request.currencyId);

        invoiceRepository.save(invoice);
        return invoice;
    }

    // delete the invoice
    @DeleteMapping("/delete/{id}")
    public void deleteInvoice(@PathVariable("id") Integer id) {
        invoiceRepository.deleteById(id);
    }


    // update the invoice
    @PutMapping("/update/{id}")
    public void updateInvoice(@PathVariable("id") Integer id,
                                       @RequestBody InvoiceRequest request) {
        InvoiceEntity invoice = invoiceRepository.getById(id);

        invoice.setInvoiceNumber(request.invoiceNumber);
        invoice.setOperationDate(request.operationDate);
        invoice.setIssueDate(request.issueDate);
        invoice.setAccountingDate(request.accountingDate);
        invoice.setCounterpartyId(request.counterpartyId);
        invoice.setCurrencyId(request.currencyId);

        invoiceRepository.save(invoice);
    }

}
