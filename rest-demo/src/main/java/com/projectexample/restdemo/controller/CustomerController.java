package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.entity.customer;

import com.projectexample.restdemo.service.impl.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")

public class CustomerController {

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    CustomerService customerService;

    public CustomerController() {
    }

    @GetMapping("{customer_id}")

    public ResponseEntity<customer> getCustomerDetails(@Valid @PathVariable("customer_id") Integer customer_id)
    {
        customer customer=customerService.getCustomer(customer_id);
        return  ResponseEntity.status(HttpStatus.OK).
                header("Getting Customer Vendor").body(customer);
    }
    @GetMapping
    public ResponseEntity <List<customer>> getAllCustomerDetails()
    {
        List<customer>list=customerService.getAllCustomer();
        if(list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));


    }
    @PostMapping
    public  ResponseEntity<customer> CreateCustomerDetails(@RequestBody customer customer)
    {
        customerService .createCustomer(customer);
        return  ResponseEntity.status(HttpStatus.CREATED).
                header("The customer was created successfully").body(customer);


    }
    @PutMapping
    public ResponseEntity<customer> updateCustomerDetails(@RequestBody customer customer)
    {
        customerService.updateCustomer(customer);
        return  ResponseEntity.status(HttpStatus.OK).
                header("The Customer was update successfully").body(customer);

    }
    @DeleteMapping
    public  ResponseEntity<customer> DeleteCustomerDetails(@PathVariable("customer_id") Integer customer_id)
    {

        return ResponseEntity.status(HttpStatus.OK).header("The Customer was deleted successfully").build();



    }
}
