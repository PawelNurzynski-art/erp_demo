package com.erp_demo.dto;

import com.erp_demo.enums.DefinitionState;

public class ProductDto {

    private String category;
    private String brand;
    private String model;
    private DefinitionState definitionState;
    private String measureUnit;
    private String description;

    // constructor
    public ProductDto() {}

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

    public DefinitionState getDefinitionState() {
        return definitionState;
    }

    public void setDefinitionState(DefinitionState definitionState) {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
