package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    private UUID id = UUID.randomUUID();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "item_id")
    private List<ProductEntity> products = new ArrayList<>();
    private double price;


    // constructors
    public ItemEntity() {}


    public ItemEntity(List<ProductEntity> products, double price) {
        this.products = products;
        this.price = price;
    }


    // getters and setters
    public UUID getId() {
        return id;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
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
        return Double.compare(item.price, price) == 0 && id.equals(item.id) && products.equals(item.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, price);
    }

    // toString
    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", products=" + products +
                ", price=" + price +
                '}';
    }
}
