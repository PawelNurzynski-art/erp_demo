package com.erp_demo.dto;

import com.erp_demo.entity.ProductEntity;

public class ItemDto {

    private ProductEntity product;
    private Float price;

    // constructor
    public ItemDto() {}

    // getters and setters
    public ProductEntity getProduct() {
        return product;
    }

    public void setProductId(ProductEntity product) {
        this.product = product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
