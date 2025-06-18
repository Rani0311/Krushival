package com.projectexample.restdemo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;

@Entity
@Transactional
@Table(name="customer")
@Positive

public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Integer customer_id;
    private  String name;
    private  String Email;
    private  String address;
    private  Integer contact_number;


    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact_number() {
        return contact_number;
    }

    public void setContact_number(Integer contact_number) {
        this.contact_number = contact_number;
    }


    public customer(Integer customer_id, String name, String email, String address, Integer contact_number) {
        this.customer_id = customer_id;
        this.name = name;
        Email = email;
        this.address = address;
        this.contact_number = contact_number;
    }



    public customer() {
    }



}
