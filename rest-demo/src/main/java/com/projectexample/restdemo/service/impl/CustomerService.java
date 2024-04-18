package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.customer;


import java.util.List;

public interface CustomerService {
    public String createCustomer(customer customer);
    public  String updateCustomer(customer customer);
    public String deleteCustomer(Integer customer_id);
    public  customer getCustomer(Integer customer_id);
    public List<customer> getAllCustomer();
}
