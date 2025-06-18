package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.order;
import com.projectexample.restdemo.exception.CloudVendorNotFoundException;

import com.projectexample.restdemo.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements  OrderService{
    OrderRepository  orderRepository;

    public OrderServiceImpl() {
    }

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public String createOrder(order order) {
        orderRepository.save(order);
        return "success";
    }

    @Override
    public String updateOrder(order order) {
        orderRepository.save(order);
        return "success";
    }

    @Override
    public String deleteOrder(Integer order_id) {
        orderRepository.deleteById(order_id);
        return "success";
    }

    @Override
    public order getOrder(Integer order_id) {
        if (orderRepository .findById(order_id).isEmpty()) {
            throw new CloudVendorNotFoundException("Request Order does not exit");
        }

        return orderRepository.findById(order_id).get();
    }

    @Override
    public List<order> getAllOrder() {
       return orderRepository.findAll();
    }
}
