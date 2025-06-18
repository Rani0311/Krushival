package com.projectexample.restdemo.repository;

import com.projectexample.restdemo.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<order,Integer> {
}
