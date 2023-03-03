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

import java.util.ArrayList;
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

    public Page<Product> serviceProductHandler(int page, int max, String category, String sortingType,Integer priceMax, Integer priceMin) {

        if (!category.equals("all") && !sortingType.equals("unsorted") && priceMax == null && priceMin == null){
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategoryAndSorted(page,max,cat,sortingType);
        }else if (!category.equals("all") && priceMax == null && priceMin == null){
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategory(page,max,cat);

        }else if (category.equals("all") && !sortingType.equals("unsorted") && priceMax == null && priceMin == null) {
            return getAllProductsSorted(page,max,sortingType);

        }else if (!category.equals("all") && !sortingType.equals("unsorted") && priceMax != null && priceMin != null){
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategorySortedAndWithPriceRange(page,max,cat,sortingType,priceMax,priceMin);
        
        }else if (!category.equals("all") && priceMax != null && priceMin != null ) {
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategoryAndPriceRange(page,max,cat,priceMax,priceMin);            
            
        }else if (category.equals("all") && !sortingType.equals("unsorted") && priceMax != null && priceMin != null){

            return getAllProductsWithSortingAndPriceRange(page,max,sortingType,priceMax,priceMin);

        }else if (category.equals("all") && priceMax != null && priceMin != null){
            return getAllProductsWithPriceRange(page,max,priceMax,priceMin);
        }

        return getAllProducts(page,max);

    }

    private Page<Product> getAllProductsWithPriceRange(int page, int max, Integer priceMax, Integer priceMin) {

        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.findByPriceRange(priceMin,priceMax,pageable);

    }

    private Page<Product> getAllProductsWithSortingAndPriceRange(int page, int max, String sortingType, Integer priceMax, Integer priceMin) {

        if (sortingType.equals("asc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
            return this.productRepository.findByPriceRange(priceMin,priceMax,pageable);
        }else if (sortingType.equals("desc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
            return this.productRepository.findByPriceRange(priceMin,priceMax,pageable);
        }else if (sortingType.equals("relevance")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("sold").descending());
            return this.productRepository.findByPriceRange(priceMin,priceMax,pageable);
        }

        throw new GeneralException("Sorting Type Unrecognizable.");


    }


    private Page<Product> getProductsWithCategoryAndPriceRange(int page, int max, Category cat, Integer priceMax, Integer priceMin) {
        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(),priceMin,priceMax,pageable);  
    }


    private Page<Product> getProductsWithCategorySortedAndWithPriceRange(int page, int max, Category cat, String sortingType, Integer priceMax, Integer priceMin) {
        if (sortingType.equals("desc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
            return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(),priceMin,priceMax,pageable);
        }else if (sortingType.equals("asc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
            return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(),priceMin,priceMax,pageable);
        }else if (sortingType.equals("relevance")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("sold").descending());
            return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(),priceMin,priceMax,pageable);

        }

        throw new GeneralException("Sorting Type Unrecognizable.");



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

    public Page<Product> getProductsByMultipleCategories(int page, int max, List<Category> categories, String sortingType,Integer priceMax, Integer priceMin){

        List<Integer> categoryIds = new ArrayList<>();

        for (Category cat : categories){
            if (cat.isChecked()) categoryIds.add(cat.getId());
        }

        if (categoryIds.size() > 0){

            if (sortingType.equals("asc")){
                Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
                return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);
            }else if (sortingType.equals("desc")){
                Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
                return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);
            }else if (sortingType.equals("relevance")){
                Pageable pageable = PageRequest.of(page-1,max,Sort.by("sold").descending());
                return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);
            }else if (sortingType.equals("unsorted")){
                Pageable pageable = PageRequest.of(page-1,max);
                return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);
            }

        }

        return serviceProductHandler(page,max,"all","unsorted", priceMax, priceMin);


    }

    /*

    public Page<Product> getProductsByMultipleCategoriesAndPriceRange(int page, int max, List<Category> categories,
                                                                      String sortingType, Integer minPrice, Integer maxPrice){
        List<Integer> categoryIds = new ArrayList<>();

        for (Category cat : categories){
            if (cat.isChecked()) categoryIds.add(cat.getId());
        }

        if (categoryIds.size() > 0){

            if (sortingType.equals("asc")){
                Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
                return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,minPrice,maxPrice,pageable);
            }else if (sortingType.equals("desc")){
                Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
                return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,minPrice,maxPrice,pageable);
            }else if (sortingType.equals("relevance")){
                Pageable pageable = PageRequest.of(page-1,max,Sort.by("sold").descending());
                return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,minPrice,maxPrice,pageable);
            }else if (sortingType.equals("unsorted")){
                Pageable pageable = PageRequest.of(page-1,max);
                return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,minPrice,maxPrice,pageable);
            }
        }



        return this.productRepository.findByPriceRange(minPrice,maxPrice,pageable);

    }


     */

}
