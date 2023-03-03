package com.erp_demo.dtos;

import com.erp_demo.entities.ProductEntity;

public class ItemDto {

    private ProductEntity product;
    private String color;
    private Integer productionYear;
    private Float engineCapacity;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public Float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}
