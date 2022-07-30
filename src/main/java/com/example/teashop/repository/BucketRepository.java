package com.example.teashop.repository;

import com.example.teashop.entitty.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket,Long>{
    public Bucket save(Bucket bucket);

}
