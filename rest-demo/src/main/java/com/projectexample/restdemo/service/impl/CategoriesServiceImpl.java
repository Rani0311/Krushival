package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.categories;
import com.projectexample.restdemo.exception.CloudVendorNotFoundException;
import com.projectexample.restdemo.repository.CategoriesRepository;

import java.util.List;

public class CategoriesServiceImpl  implements  CategoriesService{
    CategoriesRepository categoriesRepository;
    public CategoriesServiceImpl(CategoriesRepository  categoriesRepository) {
        this.categoriesRepository=categoriesRepository;
    }

    @Override
    public String createCategories(categories categories) {
        categoriesRepository.save(categories);
        return "success";
    }

    @Override
    public String updateCategories(categories categories) {
        categoriesRepository.save(categories);
        return "success";
    }

    @Override
    public String deleteCategories(Integer categories_id) {
        categoriesRepository.deleteById(categories_id);
        return "success";
    }

    @Override
    public categories getCategories(Integer categories_id) {
        if (categoriesRepository.findById(categories_id).isEmpty()) {
            throw new CloudVendorNotFoundException("Request Cloud Vendor does not exit");
        }

        return categoriesRepository.findById(categories_id).get();
    }

    @Override
    public List<categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
}
