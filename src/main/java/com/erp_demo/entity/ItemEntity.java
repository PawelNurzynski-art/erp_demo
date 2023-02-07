package com.erp_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    private UUID id = UUID.randomUUID();
    private String productId;
    private double price;


    // constructors
    public ItemEntity() {}


    public ItemEntity(String productId, double price) {
        this.productId = productId;
        this.price = price;
    }


    // getters and setters
    public UUID getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return Double.compare(that.price, price) == 0 && id.equals(that.id) && productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, price);
    }


    // toString
    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", price=" + price +
                '}';
    }
}
