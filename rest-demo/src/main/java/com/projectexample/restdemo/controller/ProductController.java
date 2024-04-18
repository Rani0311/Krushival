package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.entity.product;

import com.projectexample.restdemo.service.impl.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")


public class ProductController {
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    ProductService productService;

    public ProductController() {
    }

    @GetMapping("{Product_id}")

    public ResponseEntity<product> getProductDetails( @Valid @PathVariable("product_id") Integer product_id)
    {
        product product=productService.getProduct(product_id);
        return  ResponseEntity.status(HttpStatus.OK).
                header("Getting product").body(product);

    }
    @GetMapping
    public ResponseEntity <List<product>> getAllProductDetails()
    {
        List<product>list=productService.getAllProduct();
        if(list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));


    }
    @PostMapping
    public  ResponseEntity<product> CreateProductDetails(@RequestBody product product)
    {
        productService.createProduct(product);
        return  ResponseEntity.status(HttpStatus.CREATED).
                header("The Product was created successfully").body(product);


    }
    @PutMapping
    public ResponseEntity<product> updateProductDetails(@RequestBody product product)
    {
        productService.updateProduct(product);
        return  ResponseEntity.status(HttpStatus.OK).
                header("The Product was update successfully").body(product);

    }
    @DeleteMapping
    public  ResponseEntity<product> DeleteProductDetails(@PathVariable("product_id") Integer product_id)
    {

        return ResponseEntity.status(HttpStatus.OK).header("The product was deleted successfully").build();



    }

}




