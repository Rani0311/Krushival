package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.product;

import java.util.List;

public interface ProductService {
    public  String  createProduct(product product);
    public  String updateProduct(product product);
    public  String deleteProduct(Integer product_id);
    public  product getProduct(Integer product_id);
    public List<product> getAllProduct();
}
