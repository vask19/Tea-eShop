package com.example.teashop.service;

import com.example.teashop.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    @Transactional
    void addToUserBucket(Long productId, String username);

    ProductDTO createNewProduct(ProductDTO productDTO);
}
