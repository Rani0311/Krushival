package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.entity.seller;
import com.projectexample.restdemo.exception.CloudVendorNotFoundException;

import com.projectexample.restdemo.repository.sellerrepository;

import java.util.List;

public class SellerServiceImpl implements SellerService{
        sellerrepository  sellerrepository;

    public SellerServiceImpl() {
    }

    public SellerServiceImpl(sellerrepository sellerrepository) {
        this.sellerrepository= sellerrepository;
    }

    @Override
    public String createSeller(seller seller) {
        sellerrepository.save(seller);
        return "success";
    }

    @Override
    public String updateSeller(seller seller) {
        sellerrepository.save(seller);
        return "success";
    }

    @Override
    public String deleteSeller(Integer seller_id) {
        sellerrepository.deleteById(seller_id);
        return "success";
    }

    @Override
    public seller getSeller(Integer seller_id) {
        if(sellerrepository.findById(seller_id).isEmpty())
        {
            throw new CloudVendorNotFoundException("Request Cloud Vendor does not exit");
        }

        return sellerrepository.findById(seller_id).get();
    }

    @Override
    public List<seller> getAllSeller() {
        return sellerrepository.findAll();
    }
}
