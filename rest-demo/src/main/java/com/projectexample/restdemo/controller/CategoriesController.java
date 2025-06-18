package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.entity.categories;

import com.projectexample.restdemo.service.impl.CategoriesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Categories")

public class CategoriesController {
    public CategoriesController(CategoriesService categoriesService) {

        this.categoriesService= categoriesService;
    }

    CategoriesService  categoriesService;

    public CategoriesController() {
    }

    @GetMapping("{categories_id}")

    public ResponseEntity<categories> getCategoriesDetails(@Valid @PathVariable("categories_id") Integer categories_id)
    {
        categories  categories=categoriesService.getCategories(categories_id);
        return  ResponseEntity.status(HttpStatus.OK).
                header("Getting Categories").body(categories);




    }
    @GetMapping
    public ResponseEntity <List<categories>> getAllCategoriesDetails()
    {
        List<categories>list=categoriesService.getAllCategories();
        if(list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));


    }
    @PostMapping
    public  ResponseEntity<categories> CreateCategoriesDetails(@RequestBody categories categories)
    {
        categoriesService.createCategories(categories);
        return  ResponseEntity.status(HttpStatus.CREATED).
                header("The Categories was created successfully").body(categories);


    }
    @PutMapping
    public ResponseEntity<categories> updateCategoriesDetails(@RequestBody categories categories)
    {
        categoriesService .updateCategories(categories);
        return  ResponseEntity.status(HttpStatus.OK).
                header("The Categories was update successfully").body(categories);

    }
    @DeleteMapping
    public  ResponseEntity<categories> DeleteCategoriesDetails(@PathVariable("categories_id") Integer categories_id)
    {

        return ResponseEntity.status(HttpStatus.OK).header("The Categories was deleted successfully").build();



    }
}
