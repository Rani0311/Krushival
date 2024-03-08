package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.model.CloudVendor;
import com.projectexample.restdemo.response.ResponseHandler;
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

    public ResponseEntity<Object> getCloudVendorDetails( @Valid @PathVariable("VendorId") String VendorId)
    {
        return  ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK,cloudVendorService.getCloudVendor(VendorId));



    }
    @GetMapping
    public ResponseEntity <List<CloudVendor>> getAllCloudVendorDetails()
    {
        List<CloudVendor>list=cloudVendorService.getAllCloudVendor();
        if(list.size()<=0)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));
       // return ResponseHandler.responseBuilder("All Vendor Details are given here",HttpStatus.OK,cloudVendorService.getAllCloudVendor());

    }
    @PostMapping
    public  ResponseEntity<Object> CreateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
       return ResponseHandler.responseBuilder("cloud vendor created",HttpStatus.CREATED,cloudVendorService.createCloudVendor( cloudVendor));



    }
    @PutMapping
    public ResponseEntity<Object> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        return ResponseHandler.responseBuilder("cloud vendor updated",HttpStatus.OK,cloudVendorService.updateCloudVendor( cloudVendor));

    }
    @DeleteMapping
    public  ResponseEntity<Object> DeleteCloudVendorDetails(@PathVariable("VendorId") String VendorId)
    {
        return  ResponseHandler.responseBuilder("cloud vendor Deleted", HttpStatus.OK,cloudVendorService.deleteCloudVendor(VendorId));
    }
}