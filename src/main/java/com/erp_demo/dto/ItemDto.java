package com.erp_demo.dto;

import com.erp_demo.entity.ProductEntity;

public class ItemDto {

    private ProductEntity product;
    private double price;

    // constructor
    public ItemDto() {}

    // getters and setters
    public ProductEntity getProduct() {
        return product;
    }

    public void setProductId(ProductEntity product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
