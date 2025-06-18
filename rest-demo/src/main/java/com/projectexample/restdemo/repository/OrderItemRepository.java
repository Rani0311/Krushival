package com.projectexample.restdemo.repository;

import com.projectexample.restdemo.entity.order_Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<order_Items,Integer> {
}
