package com.erp_demo.contractor;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CounterParty {
    @Id
    @SequenceGenerator(
            name = "counterparty_id_sequence",
            sequenceName = "counterparty_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "counterparty_id_sequence"
    )

    private Integer id;
    private String name;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String bankAccount;

    // constructors
    public CounterParty() {
    }

    public CounterParty(Integer id, String name, String street,
                        String houseNumber, String zipCode, String city,
                        String bankAccount) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.bankAccount = bankAccount;
    }


    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String contractorHouseNumber) {
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
        CounterParty that = (CounterParty) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(street, that.street) && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city) && Objects.equals(bankAccount, that.bankAccount);
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
