package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class GoodStorageEntity {
    @Id
    @SequenceGenerator(
            name = "storage_id_sequence",
            sequenceName = "storage_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_id_sequence"
    )

    private int id;
    private int goodId; // from GoodEntity
    private int supplierId; // from CounterpartyEntity
    private double quantity;
    private String goodBatch;


    // constructors
    public GoodStorageEntity() {
    }


    public GoodStorageEntity(int id, int goodId, int supplierId, double quantity, String goodBatch) {
        this.id = id;
        this.goodId = goodId;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.goodBatch = goodBatch;
    }


    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getGoodBatch() {
        return goodBatch;
    }

    public void setGoodBatch(String goodBatch) {
        this.goodBatch = goodBatch;
    }


    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodStorageEntity that = (GoodStorageEntity) o;
        return id == that.id && goodId == that.goodId && supplierId == that.supplierId && Double.compare(that.quantity, quantity) == 0 && goodBatch.equals(that.goodBatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodId, supplierId, quantity, goodBatch);
    }


    // toString
    @Override
    public String toString() {
        return "GoodStorageEntity{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", supplierId=" + supplierId +
                ", quantity=" + quantity +
                ", goodBatch='" + goodBatch + '\'' +
                '}';
    }
}
