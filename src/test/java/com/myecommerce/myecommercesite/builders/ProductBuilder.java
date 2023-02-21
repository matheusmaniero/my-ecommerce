package com.myecommerce.myecommercesite.builders;

import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {
    private Product product;
    private List<Product> productList;

    public static ProductBuilder createProductBuilder(){
        ProductBuilder builder = new ProductBuilder();
        builder.product = new Product();
        builder.productList = new ArrayList<>();
        return builder;
    }

    public Product newProduct(){
        return this.product;
    }

    public List<Product> createProductList(int qty){
        Category c = new Category();
        c.setId(99);
        c.setName("Generic Category");

        for (int i = 0; i<qty; i++){
           Product p = new Product();
           p.setCategory(c);
           productList.add(p);

        }

        return this.productList;

    }



}
