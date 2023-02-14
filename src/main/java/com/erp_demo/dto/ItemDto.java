package com.erp_demo.dto;

public class ItemDto {

    private String product;
    private double price;

    // constructor
    public ItemDto() {}

    // getters and setters
    public String getProduct() {
        return product;
    }

    public void setProductId(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
