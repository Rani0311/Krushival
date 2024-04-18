package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.categories;


import java.util.List;

public interface CategoriesService {
    public String createCategories(categories categories);
    public  String updateCategories(categories categories);
    public String deleteCategories(Integer categories_id);
    public  categories getCategories(Integer categories_id);
    public List<categories> getAllCategories();
}
