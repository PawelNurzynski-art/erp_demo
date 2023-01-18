package com.erp_demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class InvoiceEntity {
    @Id
    @SequenceGenerator(
            name = "invoice_id_sequence",
            sequenceName = "invoice_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice_id_sequence"
    )

    private int id;
    private String invoiceNumber;
    private LocalDate operationDate;
    private LocalDate issueDate;
    private LocalDate accountingDate;
    private int counterpartyId; // from CounterpartyEntity
    private int currencyId; // from CurrencyEntity

    // constructors
    public InvoiceEntity() {
    }

    public InvoiceEntity(int id, String invoiceNumber, LocalDate operationDate, LocalDate issueDate,
                         LocalDate accountingDate, int counterpartyId, int currencyId) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.operationDate = operationDate;
        this.issueDate = issueDate;
        this.accountingDate = accountingDate;
        this.counterpartyId = counterpartyId;
        this.currencyId = currencyId;
    }


    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    public int getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(int counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }


    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return id == that.id && counterpartyId == that.counterpartyId && currencyId == that.currencyId && invoiceNumber.equals(that.invoiceNumber) && operationDate.equals(that.operationDate) && issueDate.equals(that.issueDate) && Objects.equals(accountingDate, that.accountingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceNumber, operationDate, issueDate, accountingDate, counterpartyId, currencyId);
    }

    // toString
    @Override
    public String toString() {
        return "InvoiceEntity{" +
                "id=" + id +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", operationDate=" + operationDate +
                ", issueDate=" + issueDate +
                ", accountingDate=" + accountingDate +
                ", counterpartyId=" + counterpartyId +
                ", currencyId=" + currencyId +
                '}';
    }
}
