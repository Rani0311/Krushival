package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.product;
import com.projectexample.restdemo.exception.CloudVendorNotFoundException;

import com.projectexample.restdemo.repository.productrepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {
        productrepository  productrepository;
    public ProductServiceImpl() {
    }

    public ProductServiceImpl(productrepository productrepository) {
        this.productrepository= productrepository;
    }
    @Override
    public String createProduct(product product) {
        productrepository.save(product);
        return "success";
    }

    @Override
    public String updateProduct(product product) {
        productrepository.save(product);
        return "success";
    }

    @Override
    public String deleteProduct(Integer product_id) {
        productrepository.deleteById(product_id);
        return "success";
    }

    @Override
    public product getProduct(Integer product_id) {
        if(productrepository.findById(product_id).isEmpty())
        {
            throw new CloudVendorNotFoundException("Request product does not exit");
        }

        return productrepository.findById(product_id).get();
    }

    @Override
    public List<product> getAllProduct() {

        return productrepository.findAll();
    }
}
