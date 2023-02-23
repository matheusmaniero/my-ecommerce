package com.myecommerce.myecommercesite.builders;

import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.model.SmartPhone;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public List<Product> createGenericProductList(int qty){

        Category cat = new Category(500,"Generic Category");
        double min = 299.99;
        double max = 3999.99;
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i< qty; ++i){
            double randomValue = getRandomPrice();

            Product p = new Product();
            p.setCategory(cat);
            p.setPrice(randomValue);
            this.productList.add(p);

        }

        return this.productList;

    }

    public List<Product> createSmartphonesList(int qty){

        Category cat = new Category(2,"Smartphones");


        for (int i = 0; i< qty; ++i){
            double randomValue = getRandomPrice();
            SmartPhone s = new SmartPhone();
            s.setCategory(cat);
            s.setPrice(randomValue);
            this.productList.add(s);

        }

        return this.productList;

    }

    private Double getRandomPrice(){
        DecimalFormat df = new DecimalFormat("#.##");
        double min = 299.99;
        double max = 3999.99;
        Random rand = new Random();
        double randomValue = Double.parseDouble(df.format(min+(max-min)*rand.nextDouble()));

        return randomValue;
    }



}
