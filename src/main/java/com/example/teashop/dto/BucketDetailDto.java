package com.example.teashop.dto;


import com.example.teashop.entitty.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketDetailDto {
    private String title;
    private Long productId;
    private Double price;
    private Double amount;
    private Double sum;

    public BucketDetailDto(Product product){
        this.title = product.getDetails().getTitle();
        this.productId = product.getId();
        this.price = product.getDetails().getPrice();
        this.amount = 1.0;
        this.sum = product.getDetails().getPrice();
    }
}
