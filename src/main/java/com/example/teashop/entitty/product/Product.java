package com.example.teashop.entitty.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public  class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long id;

   @OneToOne
   private ProductDetails details;
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "products_categories",
           joinColumns = @JoinColumn(name = "product_id"),
           inverseJoinColumns = @JoinColumn(name = "category_id"))
   private List<Category> categories;


}
