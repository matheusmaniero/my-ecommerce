package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    final private CategoryService categoryService;


    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Page<Product> serviceProductHandler(int page, int max, String category, String sortedPrice, String relevance){

        if (category.equals("all") && sortedPrice.equals("unsorted") && relevance.equals("any")){
            return getAllProductsPaginated(page,max);
        }else if (category.equals("all") && sortedPrice.equals("asc") && relevance.equals("any")){
            return getAllProductsSortedByPriceAsc(page,max);
        }else if (!category.equals("all") && sortedPrice.equals("unsorted") && relevance.equals("any")){
            List<Category> availableCategories = this.categoryService.getAllCategories();
            for (Category cat : availableCategories){
                if (cat.getName().toLowerCase().equals(category.toLowerCase())){
                    return getProductsByCategory(page,max,cat);
                }
            }

        }else if (category.equals("all") && sortedPrice.equals("desc") && relevance.equals("any")){
            return getAllProductsSortedByPriceDesc(page,max);
        }else if (!category.equals("all") && sortedPrice.equals("asc") && relevance.equals("any")){
            List<Category> availableCategories = this.categoryService.getAllCategories();
            for (Category cat : availableCategories){
                if (cat.getName().toLowerCase().equals(category.toLowerCase())){
                    return getProductByCategorySortedByPriceAsc(page,max,cat);
                }
            }

        }else if (!category.equals("all") && sortedPrice.equals("desc") && relevance.equals("any")){
            List<Category> availableCategories = this.categoryService.getAllCategories();
            for (Category cat : availableCategories){
                if (cat.getName().toLowerCase().equals(category.toLowerCase())){
                    return getProductByCategorySortedByPriceDesc(page,max,cat);
                }
            }
        }

        return null;

    }

    public Page<Product> getAllProductsPaginated(int page, int max){
        Pageable pageable = PageRequest.of(page-1,max);
        Page<Product> pages = this.productRepository.findAll(pageable);
        return pages;

    }

    public Page<Product> getProductsByCategory(int page, int max, Category category){
        Pageable pageable = PageRequest.of(page-1,max);
        Page<Product> pages = this.productRepository.findByCategory(pageable,category);
        return pages;
    }
    public Page<Product> getAllProductsSortedByPriceDesc(int page, int max){
        Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
        return this.productRepository.findAll(pageable);
    }

    public Page<Product> getAllProductsSortedByPriceAsc(int page, int max){
        Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
        return this.productRepository.findAll(pageable);
    }

    public Page<Product> getProductByCategorySortedByPriceAsc(int page, int max, Category category){
        Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
        return this.productRepository.findByCategory(pageable,category);
    }

    public Page<Product> getProductByCategorySortedByPriceDesc(int page, int max, Category category){
        Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
        return this.productRepository.findByCategory(pageable,category);
    }

}
