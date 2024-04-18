package com.projectexample.restdemo.repository;

import com.projectexample.restdemo.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface productrepository extends JpaRepository<product,Integer> {
}
