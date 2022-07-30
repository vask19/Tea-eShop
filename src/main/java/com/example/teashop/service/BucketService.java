package com.example.teashop.service;


import com.example.teashop.dto.BucketDto;
import com.example.teashop.entitty.Bucket;
import com.example.teashop.entitty.User;

import java.util.List;

public interface BucketService {

    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket,List<Long> productIds);

     BucketDto getBucketByUser(String name);
}
