package com.projectexample.restdemo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;

@Entity
@Transactional
@Positive
@Table(name="categories")
public class categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer categories_id;

    public Integer getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(Integer categories_id) {
        this.categories_id = categories_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;


    public categories(Integer categories_id, String name) {
        this.categories_id = categories_id;
        this.name = name;
    }


    public categories() {
    }


}
