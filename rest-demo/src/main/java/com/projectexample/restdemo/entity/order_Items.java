package com.projectexample.restdemo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;

@Entity
@Transactional
@Table(name="order_items")
@Positive
public class order_Items {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO);
    private Integer order_items_id;
    private  Integer quantity;
    private  double unit_price;
    private  order order;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="f.k_order_id")

    private product product;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "f.k_product_id")


    public Integer getOrder_items_id() {
        return order_items_id;
    }

    public void setOrder_items_id(Integer order_items_id) {
        this.order_items_id = order_items_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }



    public order_Items(Integer order_items_id, Integer quantity, double unit_price) {
        this.order_items_id = order_items_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }



    public order_Items() {
    }


}
