package com.projectexample.restdemo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;

import java.util.Date;
@Transactional
@Entity
@Positive
@Table(name="order")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer order_id;
    private Date order_date;
    private  double total_amount;

    private  customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "f.k_customer_id")


    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public order(Integer order_id, Date order_date, double total_amount) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
    }



    public order() {
    }



}
