package com.erp_demo.dto;

public class ProductDTO {

    private String brand;
    private String category;
    private String definitionState;
    private String measureUnit;
    private String description;

    // constructor
    public ProductDTO() {}

    // getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDefinitionState() {
        return definitionState;
    }

    public void setDefinitionState(String definitionState) {
        this.definitionState = definitionState;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
