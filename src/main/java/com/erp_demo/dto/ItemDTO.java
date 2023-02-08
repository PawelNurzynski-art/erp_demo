package com.erp_demo.dto;

import com.erp_demo.entity.ProductEntity;

public class ItemDTO {

    private ProductEntity products;
    private double price;

    // constructor
    public ItemDTO() {}

    // getters and setters
    public ProductEntity getProducts() {
        return products;
    }

    public void setProductId(ProductEntity products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
