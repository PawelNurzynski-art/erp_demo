package com.erp_demo.dto;

import com.erp_demo.entity.ProductEntity;

import java.util.List;

public class ItemDTO {

    private List<ProductEntity> products;
    private double price;

    // constructor
    public ItemDTO() {}

    // getters and setters
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProductId(List<ProductEntity> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
