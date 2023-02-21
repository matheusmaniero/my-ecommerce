package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(){};

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getProductsPaginated(int page, int max){

        Pageable pageable = PageRequest.of(page-1,max);
        Page<Product> pages = this.productRepository.findAll(pageable);
        return pages;

    }

}
