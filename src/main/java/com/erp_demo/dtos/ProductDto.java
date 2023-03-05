package com.erp_demo.dtos;

import com.erp_demo.enums.DefinitionState;
import com.erp_demo.enums.MeasureUnit;

import java.util.Objects;

public class ProductDto {

    private String category;
    private String brand;
    private String model;
    private DefinitionState definitionState;
    private MeasureUnit measureUnit;
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

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = Objects.requireNonNullElse(measureUnit, MeasureUnit.SZT);
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
