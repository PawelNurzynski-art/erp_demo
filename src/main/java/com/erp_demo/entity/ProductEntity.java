package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String brand;
    private String category;
    private String definitionState; // 1 - new, 2 - approved, 3 - canceled, 4 - archival
    private String measureUnit;
    private String description;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> items = new ArrayList<>();

    // constructors
    public ProductEntity() {}


    public ProductEntity(String brand, String category, String definitionState,
                         String measureUnit, String description) {
        this.brand = brand;
        this.category = category;
        this.definitionState = definitionState;
        this.measureUnit = measureUnit;
        this.description = description;
    }

    public ProductEntity(String id) {
        this.id = UUID.fromString(id);
    }

    // getters and setters
    public UUID getId() {
        return id;
    }

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


    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id.equals(that.id) && brand.equals(that.brand) && category.equals(that.category) && definitionState.equals(that.definitionState) && measureUnit.equals(that.measureUnit) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, category, definitionState, measureUnit, description);
    }


    // toString
    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", definitionState='" + definitionState + '\'' +
                ", measureUnit='" + measureUnit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
