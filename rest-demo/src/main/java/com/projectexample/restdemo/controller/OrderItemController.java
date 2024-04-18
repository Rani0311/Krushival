package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.entity.order_Items;

import com.projectexample.restdemo.service.impl.OrderItemService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderItem")

public class OrderItemController {
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService= orderItemService;
    }

    OrderItemService orderItemService;

    public OrderItemController() {
    }

    @GetMapping("{order_items_id}")

    public ResponseEntity<order_Items> getOrderItemDetails(@Valid @PathVariable("order_items_id") Integer order_items_id)
    {
        order_Items order_items=orderItemService.getOrderItem(order_items_id);
        return  ResponseEntity.status(HttpStatus.OK).
                header("Getting Ordered Items").body(order_items);

    }
    @GetMapping
    public ResponseEntity <List<order_Items>> getAllOrderItemDetails()
    {
        List<order_Items>list=orderItemService.getAllOrderItem();
        if(list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));


    }
    @PostMapping
    public  ResponseEntity<order_Items> CreateOrderItemDetails(@RequestBody order_Items order_items)
    {
        orderItemService.createOrderItem(order_items);
        return  ResponseEntity.status(HttpStatus.CREATED).
                header("The Item was created successfully").body(order_items);


    }
    @PutMapping
    public ResponseEntity<order_Items> updateOrderItemDetails(@RequestBody order_Items order_items)
    {
        orderItemService.updateOrderItem(order_items);
        return  ResponseEntity.status(HttpStatus.OK).
                header("The Items was update successfully").body(order_items);

    }
    @DeleteMapping
    public  ResponseEntity<order_Items> DeleteOrderItemDetails(@PathVariable("order_items_id") Integer order_items_id)
    {

        return ResponseEntity.status(HttpStatus.OK).header("The Item was deleted successfully").build();



    }
}
