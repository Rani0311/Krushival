package com.projectexample.restdemo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;

@Entity
@Transactional
@Positive
@Table(name="seller")
public class seller {


    private  Integer seller_id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  String name;
    private  String location;
    private  Integer contact_number;


    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getContact_number() {
        return contact_number;
    }

    public void setContact_number(Integer contact_number) {
        this.contact_number = contact_number;
    }


    public seller(Integer seller_id, String name, String location, Integer contact_number) {
        this.seller_id = seller_id;
        this.name = name;
        this.location = location;
        this.contact_number = contact_number;
    }



    public seller() {
    }


}
