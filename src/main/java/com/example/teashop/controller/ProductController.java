package com.example.teashop.controller;

import com.example.teashop.dto.ProductDTO;
import com.example.teashop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> list(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);

    }


    //TODO
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createNewProduct(@RequestBody ProductDTO productDTO){

        return new ResponseEntity<>(productService.createNewProduct(productDTO),HttpStatus.OK);
    }

    @GetMapping("/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        if (principal == null){
            return "redirect:/products";
        }
        productService.addToUserBucket(id,principal.getName());

        return "redirect:/products";
    }
}
