package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.exceptions.GeneralException;
import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    final private CategoryService categoryService;


    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Page<Product> serviceProductHandler(int page, int max, String category, String sortingType) {

        if (!category.equals("all") && !sortingType.equals("unsorted")){
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategoryAndSorted(page,max,cat,sortingType);
        }else if (!category.equals("all")){
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategory(page,max,cat);

        }else if (category.equals("all") && !sortingType.equals("unsorted")) {
            return getAllProductsSorted(page,max,sortingType);

        }

        return getAllProducts(page,max);

    }

    private Page<Product> getAllProductsSorted(int page, int max, String sortingType) {

        if (sortingType.equals("desc")){
            Pageable pageable = PageRequest.of(page-1,max, Sort.by("price").descending());
            return this.productRepository.findAll(pageable);
        }else if (sortingType.equals("asc")){
            Pageable pageable = PageRequest.of(page-1,max, Sort.by("price").ascending());
            return this.productRepository.findAll(pageable);
        }else if (sortingType.equals("relevance")){
            Pageable pageable = PageRequest.of(page-1,max, Sort.by("sold").descending());
            return this.productRepository.findAll(pageable);
        }

        throw new GeneralException("Sorting Type Unrecognizable.");


    }

    private Page<Product> getAllProducts(int page, int max) {
        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.findAll(pageable);
    }

    private Page<Product> getProductsWithCategory(int page, int max, Category cat) {
        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.findByCategory(pageable,cat);

    }

    private Page<Product> getProductsWithCategoryAndSorted(int page, int max, Category cat, String sortingType) {

        if (sortingType.equals("desc")){
            Pageable pageable = PageRequest.of(page-1,max, Sort.by("price").descending());
            return this.productRepository.findByCategory(pageable,cat);
        }else if (sortingType.equals("asc")){
            Pageable pageable = PageRequest.of(page-1,max, Sort.by("price").ascending());
            return this.productRepository.findByCategory(pageable,cat);
        }else if (sortingType.equals("relevance")){
            Pageable pageable = PageRequest.of(page-1,max, Sort.by("sold").descending());
            return this.productRepository.findByCategory(pageable,cat);
        }

        throw new GeneralException("Sorting Type Unrecognizable.");

    }

}
