package com.erp_demo.entity;

import com.erp_demo.enums.DefinitionState;
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
    private String category;
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    private DefinitionState definitionState; // 1 - new, 2 - approved, 3 - canceled, 4 - archival
    private String measureUnit;
    private String description;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> items = new ArrayList<>();

    // constructors
    public ProductEntity() {
    }

    public ProductEntity(String category, String brand, String model, DefinitionState definitionState,
                         String measureUnit, String description) {
        this.category = category;
        this.brand = brand;
        this.model = model;
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

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return id.equals(product.id) && category.equals(product.category) && brand.equals(product.brand) && model.equals(product.model) && definitionState == product.definitionState && measureUnit.equals(product.measureUnit) && description.equals(product.description) && Objects.equals(items, product.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, brand, model, definitionState, measureUnit, description, items);
    }

    // toString
    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", definitionState=" + definitionState +
                ", measureUnit='" + measureUnit + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }
}
