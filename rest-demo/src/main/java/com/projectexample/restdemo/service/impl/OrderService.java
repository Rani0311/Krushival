package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.order;


import java.util.List;

public interface OrderService {
    public  String  createOrder(order order);
    public  String updateOrder(order order);
    public  String deleteOrder(Integer order_id);
    public  order getOrder(Integer order_id);
    public List<order> getAllOrder();
}
