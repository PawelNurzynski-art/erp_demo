package com.erp_demo.dto;

public class ItemDTO {

    private String productId;
    private double price;

    // constructor
    public ItemDTO() {}

    // getters and setters
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
}
