package com.erp_demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "counterparty")
public class CounterpartyEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String street;
    private Integer houseNumber;
    private String zipCode;
    private String city;
    private String bankAccount;
    @OneToMany(mappedBy = "counterparty", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<>();

    // constructors
    public CounterpartyEntity() {
    }

    public CounterpartyEntity(String name, String street, Integer houseNumber, String zipCode, String city,
                              String bankAccount) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.bankAccount = bankAccount;
    }

    public CounterpartyEntity(String id) {
        this.id = UUID.fromString(id);
    }


    // getters and setters
    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer contractorHouseNumber) {
        this.houseNumber = contractorHouseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterpartyEntity that = (CounterpartyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(street, that.street)
                && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(zipCode, that.zipCode)
                && Objects.equals(city, that.city) && Objects.equals(bankAccount, that.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, houseNumber, zipCode, city, bankAccount);
    }

    @Override
    public String toString() {
        return "Kontrahent{" +
                "kontrahent_id=" + id +
                ", nazwaKontrahenta='" + name + '\'' +
                ", ulicaKontrahenta='" + street + '\'' +
                ", numerDomuKontrahenta='" + houseNumber + '\'' +
                ", kodPocztowyKontrahenta='" + zipCode + '\'' +
                ", miejscowoscKontrahenta='" + city + '\'' +
                ", numerRachunkuBankowego='" + bankAccount + '\'' +
                '}';
    }
}
