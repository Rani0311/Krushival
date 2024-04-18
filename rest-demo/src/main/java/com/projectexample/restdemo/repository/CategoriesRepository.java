package com.projectexample.restdemo.repository;

import com.projectexample.restdemo.entity.categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository  extends JpaRepository<categories,Integer> {
}
