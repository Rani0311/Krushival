package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.model.CloudVendor;

import com.projectexample.restdemo.service.CloudVendorService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    CloudVendorService cloudVendorService;
    @GetMapping("{VendorId}")

    public ResponseEntity<CloudVendor> getCloudVendorDetails( @Valid @PathVariable("VendorId") String VendorId)
    {
        CloudVendor cloudVendor=cloudVendorService.getCloudVendor(VendorId);
         return  ResponseEntity.status(HttpStatus.OK).
                 header("Getting Cloud Vendor").body(cloudVendor);




    }
    @GetMapping
    public ResponseEntity <List<CloudVendor>> getAllCloudendorDetails()
    {
        List<CloudVendor>list=cloudVendorService.getAllCloudVendor();
        if(list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));


    }
    @PostMapping
    public  ResponseEntity<CloudVendor> CreateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);
        return  ResponseEntity.status(HttpStatus.CREATED).
                header("The Vendor was created successfully").body(cloudVendor);


    }
    @PutMapping
    public ResponseEntity<CloudVendor> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return  ResponseEntity.status(HttpStatus.OK).
                header("The Vendor was update successfully").body(cloudVendor);

    }
    @DeleteMapping
    public  ResponseEntity<CloudVendor> DeleteCloudVendorDetails(@PathVariable("VendorId") String VendorId)
    {

        return ResponseEntity.status(HttpStatus.OK).header("The Vendor was deleted successfully").build();



    }
}