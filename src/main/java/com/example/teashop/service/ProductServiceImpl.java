package com.example.teashop.service;

import com.example.teashop.dto.ProductDTO;
import com.example.teashop.entitty.Bucket;
import com.example.teashop.entitty.User;
import com.example.teashop.entitty.product.Product;
import com.example.teashop.mapper.ProductMapper;
import com.example.teashop.repository.ProductRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper mapper = ProductMapper.MAPPER;

    private final ProductRepository productRepository;
    private final BucketService bucketService;
    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository, BucketService bucketService, UserService userService) {
        this.productRepository = productRepository;
        this.bucketService = bucketService;
        this.userService = userService;
    }


    @Override
    public List<ProductDTO> getAll() {
        return mapper.fromProductList(productRepository.findAll());

    }

    @Override
    @Transactional
    public void addToUserBucket(Long productId, String username) {
        User user = userService.findUserByUsername((username));
        if (user == null){
            throw new RuntimeException("User not found "+ username);

        }

        Bucket bucket = user.getBucket();
        if (bucket == null){
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);

        }
        else {
            bucketService.addProducts(bucket,Collections.singletonList(productId));
        }
    }

    @Override
    public ProductDTO createNewProduct(ProductDTO productDTO) {
        productRepository.save(mapper.toProduct(productDTO));
        return productDTO;
    }
}
