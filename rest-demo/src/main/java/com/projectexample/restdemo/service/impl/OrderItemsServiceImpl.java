package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.order_Items;
import com.projectexample.restdemo.exception.CloudVendorNotFoundException;

import com.projectexample.restdemo.repository.OrderItemRepository;

import java.util.List;

public class OrderItemsServiceImpl implements OrderItemService{
    public OrderItemsServiceImpl() {
    }
    OrderItemRepository orderItemRepository;
    public OrderItemsServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public String createOrderItem(order_Items order_items) {
         orderItemRepository.save(order_items);
        return "success";
    }

    @Override
    public String updateOrderItem(order_Items order_items) {
        orderItemRepository.save(order_items);
        return "success";
    }

    @Override
    public String deleteOrderItem(Integer order_items_id) {
        orderItemRepository.deleteById(order_items_id);
        return "success";
    }

    @Override
    public order_Items getOrderItem(Integer order_items_id) {
        if (orderItemRepository.findById(order_items_id).isEmpty()) {
            throw new CloudVendorNotFoundException("Request Cloud Vendor does not exit");
        }

        return orderItemRepository.findById(order_items_id).get();
    }

    @Override
    public List<order_Items> getAllOrderItem() {
        return orderItemRepository.findAll();
    }
}
