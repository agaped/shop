package com.onlineshop.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product")
    private int id;

    private String name;
    private String producer;
    private BigDecimal price;

    private String description;

    @Column(name = "category_id_category")
    private int categoryId;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int idProduct) {
        this.id = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
