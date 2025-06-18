package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.customer;
import com.projectexample.restdemo.exception.CloudVendorNotFoundException;
import com.projectexample.restdemo.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements  CustomerService{
    CustomerRepository customerRepository;
    public CustomerServiceImpl() {
    }
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository =customerRepository;
    }


    @Override
    public String createCustomer(customer customer) {
        customerRepository.save(customer);
        return "success";
    }

    @Override
    public String updateCustomer(customer customer) {
        customerRepository.save(customer);
        return "success";
    }

    @Override
    public String deleteCustomer(Integer customer_id) {
        customerRepository.deleteById(customer_id);
        return "success";
    }

    @Override
    public customer getCustomer(Integer customer_id) {
        if (customerRepository.findById(customer_id).isEmpty()) {
            throw new CloudVendorNotFoundException("Request Cloud Vendor does not exit");
        }

        return customerRepository.findById(customer_id).get();
    }

    @Override
    public List<customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
