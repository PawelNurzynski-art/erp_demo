package com.erp_demo.contractor;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Contractor {
    @Id
    @SequenceGenerator(
            name = "constructor_id_sequence",
            sequenceName = "constructor_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "constructor_id_sequence"
    )

    private Integer contractorId;
    private String contractorName;
    private String contractorStreet;
    private String contractorHouseNumber;
    private String contractorZipCode;
    private String contractorCity;
    private String contractorBankAccount;

    // constructors
    public Contractor() {
    }

    public Contractor(Integer contractorId, String contractorName, String contractorStreet,
                      String contractorHouseNumber, String contractorZipCode, String contractorCity,
                      String contractorBankAccount) {
        this.contractorId = contractorId;
        this.contractorName = contractorName;
        this.contractorStreet = contractorStreet;
        this.contractorHouseNumber = contractorHouseNumber;
        this.contractorZipCode = contractorZipCode;
        this.contractorCity = contractorCity;
        this.contractorBankAccount = contractorBankAccount;
    }


    // getters and setters
    public Integer getContractorId() {
        return contractorId;
    }

    public void setContractorId(Integer contractorId) {
        this.contractorId = contractorId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorStreet() {
        return contractorStreet;
    }

    public void setContractorStreet(String contractorStreet) {
        this.contractorStreet = contractorStreet;
    }

    public String getContractorHouseNumber() {
        return contractorHouseNumber;
    }

    public void setContractorHouseNumber(String contractorHouseNumber) {
        this.contractorHouseNumber = contractorHouseNumber;
    }

    public String getContractorZipCode() {
        return contractorZipCode;
    }

    public void setContractorZipCode(String contractorZipCode) {
        this.contractorZipCode = contractorZipCode;
    }

    public String getContractorCity() {
        return contractorCity;
    }

    public void setContractorCity(String contractorCity) {
        this.contractorCity = contractorCity;
    }

    public String getContractorBankAccount() {
        return contractorBankAccount;
    }

    public void setContractorBankAccount(String contractorBankAccount) {
        this.contractorBankAccount = contractorBankAccount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contractor that = (Contractor) o;
        return Objects.equals(contractorId, that.contractorId) && Objects.equals(contractorName, that.contractorName) && Objects.equals(contractorStreet, that.contractorStreet) && Objects.equals(contractorHouseNumber, that.contractorHouseNumber) && Objects.equals(contractorZipCode, that.contractorZipCode) && Objects.equals(contractorCity, that.contractorCity) && Objects.equals(contractorBankAccount, that.contractorBankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractorId, contractorName, contractorStreet, contractorHouseNumber, contractorZipCode, contractorCity, contractorBankAccount);
    }

    @Override
    public String toString() {
        return "Kontrahent{" +
                "kontrahent_id=" + contractorId +
                ", nazwaKontrahenta='" + contractorName + '\'' +
                ", ulicaKontrahenta='" + contractorStreet + '\'' +
                ", numerDomuKontrahenta='" + contractorHouseNumber + '\'' +
                ", kodPocztowyKontrahenta='" + contractorZipCode + '\'' +
                ", miejscowoscKontrahenta='" + contractorCity + '\'' +
                ", numerRachunkuBankowego='" + contractorBankAccount + '\'' +
                '}';
    }
}
