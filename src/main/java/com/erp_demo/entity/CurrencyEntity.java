package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CurrencyEntity {
    @Id
    @SequenceGenerator(
            name = "currency_id_sequence",
            sequenceName = "currency_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "currency_id_sequence"
    )

    private int id;
    private String currencyName;
    private String currencyAbbreviation;
    private int currencyState; // change to enum in future


    // constructors
    public CurrencyEntity() {
    }

    public CurrencyEntity(int id, String currencyName, String currencyAbbreviation, int currencyState) {
        this.id = id;
        this.currencyName = currencyName;
        this.currencyAbbreviation = currencyAbbreviation;
        this.currencyState = currencyState;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }

    public int getCurrencyState() {
        return currencyState;
    }

    public void setCurrencyState(int currencyState) {
        this.currencyState = currencyState;
    }

    // equals and hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyEntity that = (CurrencyEntity) o;
        return id == that.id && currencyState == that.currencyState && currencyName.equals(that.currencyName) && currencyAbbreviation.equals(that.currencyAbbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyName, currencyAbbreviation, currencyState);
    }

    // toString
    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "id=" + id +
                ", currencyName='" + currencyName + '\'' +
                ", currencyAbbreviation='" + currencyAbbreviation + '\'' +
                ", currencyState=" + currencyState +
                '}';
    }
}
