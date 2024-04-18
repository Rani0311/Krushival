package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.order_Items;


import java.util.List;

public interface OrderItemService {
    public String createOrderItem(order_Items order_items);
    public  String updateOrderItem(order_Items order_items);
    public String deleteOrderItem(Integer order_items_id);
    public  order_Items getOrderItem(Integer order_items_id);
    public List<order_Items> getAllOrderItem();
}
