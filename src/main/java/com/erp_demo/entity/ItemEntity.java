package com.erp_demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    private UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private String color;
    private Integer productionYear;
    private Float engineCapacity;
    private Float price;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<>();


    // constructors
    public ItemEntity() {}


    public ItemEntity(ProductEntity product, Float price, String color, Integer productionYear, Float engineCapacity) {
        this.product = product;
        this.price = price;
        this.color = color;
        this.productionYear = productionYear;
        this.engineCapacity = engineCapacity;
    }

    public ItemEntity(String id) {
        this.id = UUID.fromString(id);
    }


    // getters and setters
    public UUID getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity item = (ItemEntity) o;
        return id.equals(item.id) && product.equals(item.product) && color.equals(item.color) && productionYear.equals(item.productionYear) && engineCapacity.equals(item.engineCapacity) && price.equals(item.price) && Objects.equals(invoices, item.invoices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, color, productionYear, engineCapacity, price, invoices);
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", product=" + product +
                ", color='" + color + '\'' +
                ", productionYear=" + productionYear +
                ", engineCapacity=" + engineCapacity +
                ", price=" + price +
                '}';
    }

}
