package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private double price;


    // constructors
    public ItemEntity() {}


    public ItemEntity(ProductEntity product, double price) {
        this.product = product;
        this.price = price;
    }


    // getters and setters
    public UUID getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity item = (ItemEntity) o;
        return Double.compare(item.price, price) == 0 && id.equals(item.id) && product.equals(item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, price);
    }

    // toString
    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", products=" + product +
                ", price=" + price +
                '}';
    }
}
