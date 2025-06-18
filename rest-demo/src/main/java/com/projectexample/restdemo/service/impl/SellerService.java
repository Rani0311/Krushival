package com.projectexample.restdemo.service.impl;


import com.projectexample.restdemo.entity.seller;

import java.util.List;

public interface SellerService {
    public  String  createSeller(seller seller);
    public  String updateSeller(seller seller);
    public  String deleteSeller(Integer seller_id);
    public  seller getSeller(Integer seller_id);
    public List<seller> getAllSeller();
}
