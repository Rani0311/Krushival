package com.projectexample.restdemo.controller;


import com.projectexample.restdemo.entity.seller;

import com.projectexample.restdemo.service.impl.SellerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")


public class SellerController {
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    SellerService sellerService;

    public SellerController() {
    }

    @GetMapping("{seller_id}")

    public ResponseEntity<seller> getSellerDetails(@Valid @PathVariable("seller_id") Integer seller_id)
    {
        seller seller=sellerService.getSeller(seller_id);
        return  ResponseEntity.status(HttpStatus.OK).
                header("Getting seller").body(seller);




    }
    @GetMapping
    public ResponseEntity <List<seller>> getAllSellerDetails()
    {
        List<seller>list=sellerService.getAllSeller();
        if(list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));


    }
    @PostMapping
    public  ResponseEntity<seller> CreateSellerDetails(@RequestBody seller seller)
    {
        sellerService.createSeller(seller);
        return  ResponseEntity.status(HttpStatus.CREATED).
                header("The Seller was created successfully").body(seller);


    }
    @PutMapping
    public ResponseEntity<seller> updateSellerDetails(@RequestBody seller seller)
    {
        sellerService.updateSeller(seller);
        return  ResponseEntity.status(HttpStatus.OK).
                header("The Seller was update successfully").body(seller);

    }
    @DeleteMapping
    public  ResponseEntity<seller> DeleteSellerDetails(@PathVariable("seller_id") Integer seller_id)
    {

        return ResponseEntity.status(HttpStatus.OK).header("The Seller was deleted successfully").build();



    }
}
