package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class GoodEntity {
    @Id
    @SequenceGenerator(
            name = "good_id_sequence",
            sequenceName = "good_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "good_id_sequence"
    )

    private int id;
    private String name;
    private String measureUnit;
    private double purchasePrice;
    private double margin;
    // in future definitionState type change to enum
    private int definitionState; // 1 - new, 2 - approved, 3 - canceled, 4 - archival
    private String description;
    @OneToMany(
            mappedBy = "goodId",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<GoodStorageEntity> goodsInStorage = new ArrayList<>();


    // constructors
    public GoodEntity() {
    }

    public GoodEntity(int id, String name, String measureUnit, double purchasePrice, double margin,
                      int definitionState, String description) {
        this.id = id;
        this.name = name;
        this.measureUnit = measureUnit;
        this.purchasePrice = purchasePrice;
        this.margin = margin;
        this.definitionState = definitionState;
        this.description = description;
    }


    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public int getDefinitionState() {
        return definitionState;
    }

    public void setDefinitionState(int definitionState) {
        this.definitionState = definitionState;
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
        GoodEntity that = (GoodEntity) o;
        return id == that.id && Double.compare(that.purchasePrice, purchasePrice) == 0 && Double.compare(that.margin, margin) == 0 && definitionState == that.definitionState && Objects.equals(name, that.name) && Objects.equals(measureUnit, that.measureUnit) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, measureUnit, purchasePrice, margin, definitionState, description);
    }


    // toString
    @Override
    public String toString() {
        return "GoodEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measureUnit='" + measureUnit + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", margin=" + margin +
                ", definitionState=" + definitionState +
                ", description='" + description + '\'' +
                '}';
    }
}
