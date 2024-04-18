package com.projectexample.restdemo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;

@Transactional
@Entity

@Positive
@Table(name = "products")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer product_id;
    private  String name;
    private  String description;
    private double price;
    private  boolean quantity_available;
    private  seller seller;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="f.k_seller_id")


    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(boolean quantity_available) {
        this.quantity_available = quantity_available;
    }

    public product(Integer product_id, String name, String description, double price, boolean quantity_available) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity_available = quantity_available;
    }

    public product() {
    }
}
