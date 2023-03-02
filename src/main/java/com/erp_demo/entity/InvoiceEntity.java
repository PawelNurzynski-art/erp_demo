package com.erp_demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "invoice")
public class InvoiceEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String invoiceNumber;
    private LocalDate saleDate;
    private LocalDate operationDate;
    private LocalDate issueDate;
    private LocalDate accountingDate;
    @ManyToOne
    @JoinColumn(name = "counterparty_id")
    private CounterpartyEntity counterparty; // from CounterpartyEntity
    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item; // form ItemEntity

    // constructors
    public InvoiceEntity() {
    }

    public InvoiceEntity(String invoiceNumber, LocalDate saleDate, LocalDate operationDate, LocalDate issueDate,
                         LocalDate accountingDate, CounterpartyEntity counterparty, ItemEntity item) {
        this.invoiceNumber = invoiceNumber;
        this.saleDate = saleDate;
        this.operationDate = operationDate;
        this.issueDate = issueDate;
        this.accountingDate = accountingDate;
        this.counterparty = counterparty;
        this.item = item;
    }


    // getters and setters
    public UUID getId() {
        return id;
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

    public CounterpartyEntity getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(CounterpartyEntity counterparty) {
        this.counterparty = counterparty;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return id.equals(that.id) && invoiceNumber.equals(that.invoiceNumber) && saleDate.equals(that.saleDate) && operationDate.equals(that.operationDate) && issueDate.equals(that.issueDate) && accountingDate.equals(that.accountingDate) && counterparty.equals(that.counterparty) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceNumber, saleDate, operationDate, issueDate, accountingDate, counterparty, item);
    }

    @Override
    public String toString() {
        return "InvoiceEntity{" +
                "id=" + id +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", saleDate=" + saleDate +
                ", operationDate=" + operationDate +
                ", issueDate=" + issueDate +
                ", accountingDate=" + accountingDate +
                ", counterparty=" + counterparty +
                '}';
    }
}
