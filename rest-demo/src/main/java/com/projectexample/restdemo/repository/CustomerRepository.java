package com.projectexample.restdemo.repository;

import com.projectexample.restdemo.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<customer,Integer> {
}
