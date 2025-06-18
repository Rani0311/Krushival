package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.entity.order;

import com.projectexample.restdemo.service.impl.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {
    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }
    OrderService orderService;

    public OrderController() {
    }

    @GetMapping("{order_id}")

    public ResponseEntity<order> getOrderDetails(@Valid @PathVariable("order_id") Integer order_id)
    {
        order order=orderService.getOrder(order_id);
        return  ResponseEntity.status(HttpStatus.OK).
                header("Getting order").body(order);




    }
    @GetMapping
    public ResponseEntity <List<order>> getAllOrderDetails()
    {
        List<order>list=orderService.getAllOrder();
        if(list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));


    }
    @PostMapping
    public  ResponseEntity<order> CreateOrderDetails(@RequestBody order order)
    {
        orderService.createOrder(order);
        return  ResponseEntity.status(HttpStatus.CREATED).
                header("The order was created successfully").body(order);


    }
    @PutMapping
    public ResponseEntity<order> updateOrderDetails(@RequestBody order order)
    {
        orderService.updateOrder(order);
        return  ResponseEntity.status(HttpStatus.OK).
                header("The order was update successfully").body(order);

    }
    @DeleteMapping
    public  ResponseEntity<order> DeleteOrderDetails(@PathVariable("order_id") Integer order_id)
    {

        return ResponseEntity.status(HttpStatus.OK).header("The Order was deleted successfully").build();



    }

}
