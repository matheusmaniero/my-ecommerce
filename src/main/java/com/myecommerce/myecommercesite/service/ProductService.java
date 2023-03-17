package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.exceptions.GeneralException;
import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    public Page<Product> serviceProductHandler(int page, int max, String category, String sortingType, Double priceMax, Double priceMin) {

        if (!category.equals("all") && !sortingType.equals("unsorted") && priceMax == null && priceMin == null) {
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategoryAndSorted(page, max, cat, sortingType);
        } else if (!category.equals("all") && priceMax == null && priceMin == null) {
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategory(page, max, cat);

        } else if (category.equals("all") && !sortingType.equals("unsorted") && priceMax == null && priceMin == null) {
            return getAllProductsSorted(page, max, sortingType);

        } else if (!category.equals("all") && !sortingType.equals("unsorted") && priceMax != null && priceMin != null) {
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategorySortedAndWithPriceRange(page, max, cat, sortingType, priceMax, priceMin);

        } else if (!category.equals("all") && priceMax != null && priceMin != null) {
            Category cat = this.categoryService.getCategoryByName(category);
            return getProductsWithCategoryAndPriceRange(page, max, cat, priceMax, priceMin);

        } else if (category.equals("all") && !sortingType.equals("unsorted") && priceMax != null && priceMin != null) {

            return getAllProductsWithSortingAndPriceRange(page, max, sortingType, priceMax, priceMin);

        } else if (category.equals("all") && priceMax != null && priceMin != null) {
            return getAllProductsWithPriceRange(page, max, priceMax, priceMin);
        }

        return getAllProducts(page, max);

    }

    private Page<Product> getAllProductsWithPriceRange(int page, int max, Double priceMax, Double priceMin) {

        Pageable pageable = PageRequest.of(page - 1, max);
        return this.productRepository.findByPriceRange(priceMin, priceMax, pageable);

    }

    private Page<Product> getAllProductsWithSortingAndPriceRange(int page, int max, String sortingType, Double priceMax, Double priceMin) {

        if (sortingType.equals("asc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").ascending());
            return this.productRepository.findByPriceRange(priceMin, priceMax, pageable);
        } else if (sortingType.equals("desc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").descending());
            return this.productRepository.findByPriceRange(priceMin, priceMax, pageable);
        } else if (sortingType.equals("relevance")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("sold").descending());
            return this.productRepository.findByPriceRange(priceMin, priceMax, pageable);
        }

        throw new GeneralException("Sorting Type Unrecognizable.");


    }


    private Page<Product> getProductsWithCategoryAndPriceRange(int page, int max, Category cat, Double priceMax, Double priceMin) {
        Pageable pageable = PageRequest.of(page - 1, max);
        return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(), priceMin, priceMax, pageable);
    }


    private Page<Product> getProductsWithCategorySortedAndWithPriceRange(int page, int max, Category cat, String sortingType, Double priceMax, Double priceMin) {
        if (sortingType.equals("desc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").descending());
            return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(), priceMin, priceMax, pageable);
        } else if (sortingType.equals("asc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").ascending());
            return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(), priceMin, priceMax, pageable);
        } else if (sortingType.equals("relevance")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("sold").descending());
            return this.productRepository.findByCategoryIdAndPriceRange(cat.getId(), priceMin, priceMax, pageable);

        }

        throw new GeneralException("Sorting Type Unrecognizable.");


    }

    private Page<Product> getAllProductsSorted(int page, int max, String sortingType) {

        if (sortingType.equals("desc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").descending());
            return this.productRepository.findAll(pageable);
        } else if (sortingType.equals("asc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").ascending());
            return this.productRepository.findAll(pageable);
        } else if (sortingType.equals("relevance")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("sold").descending());
            return this.productRepository.findAll(pageable);
        }

        throw new GeneralException("Sorting Type Unrecognizable.");


    }

    private Page<Product> getAllProducts(int page, int max) {
        Pageable pageable = PageRequest.of(page - 1, max);
        return this.productRepository.findAll(pageable);
    }

    private Page<Product> getProductsWithCategory(int page, int max, Category cat) {
        Pageable pageable = PageRequest.of(page - 1, max);
        return this.productRepository.findByCategory(pageable, cat);

    }

    private Page<Product> getProductsWithCategoryAndSorted(int page, int max, Category cat, String sortingType) {

        if (sortingType.equals("desc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").descending());
            return this.productRepository.findByCategory(pageable, cat);
        } else if (sortingType.equals("asc")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("price").ascending());
            return this.productRepository.findByCategory(pageable, cat);
        } else if (sortingType.equals("relevance")) {
            Pageable pageable = PageRequest.of(page - 1, max, Sort.by("sold").descending());
            return this.productRepository.findByCategory(pageable, cat);
        }

        throw new GeneralException("Sorting Type Unrecognizable.");

    }

    public Page<Product> getProductsByMultipleCategories(int page, int max, List<Category> categories, String sortingType, Double priceMax, Double priceMin) {

        List<Integer> categoryIds = new ArrayList<>();

        for (Category cat : categories) {
            if (cat.isChecked()) categoryIds.add(cat.getId());
        }

        if (categoryIds.size() > 0) {

            if (!sortingType.equals("unsorted") && priceMax != null && priceMin != null){

                return getProductsWithMultipleCategoriesWithSortTypeAndPriceRange(page,max,categoryIds,sortingType,priceMax,priceMin);

            }else if (sortingType.equals("unsorted") && priceMax != null && priceMin != null){

                return getProductsWithMultipleCategoriesAndPriceRange(page,max,categoryIds,priceMax,priceMin);

            }else if (!sortingType.equals("unsorted")){
                return getProductsWithMultipleCategoriesAndSortingType(page,max,categoryIds,sortingType);
            }else if (sortingType.equals("unsorted")){
                return getProductsWithMultipleCategories(page,max,categoryIds);
            }


        }

        return getAllProducts(page,max);




    }

    private Page<Product> getProductsWithMultipleCategories(int page, int max, List<Integer> categoryIds) {

        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);

    }

    private Page<Product> getProductsWithMultipleCategoriesAndSortingType(int page, int max, List<Integer> categoryIds, String sortingType) {

        if (sortingType.equals("asc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
            return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);
        }else if (sortingType.equals("desc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
            return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);
        }else if (sortingType.equals("relevance")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("sold").descending());
            return this.productRepository.findByMultipleCategoryIds(categoryIds,pageable);
        }

        return null;



    }

    private Page<Product> getProductsWithMultipleCategoriesAndPriceRange(int page, int max, List<Integer> categoryIds, Double priceMax, Double priceMin) {

        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,priceMin,priceMax,pageable);

    }

    private Page<Product> getProductsWithMultipleCategoriesWithSortTypeAndPriceRange(int page, int max, List<Integer> categoryIds, String sortingType, Double priceMax, Double priceMin) {

        if (sortingType.equals("asc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").ascending());
            return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,priceMin,priceMax,pageable);
        }else if (sortingType.equals("desc")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("price").descending());
            return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,priceMin,priceMax,pageable);

        }else if (sortingType.equals("relevance")){
            Pageable pageable = PageRequest.of(page-1,max,Sort.by("sold").descending());
            return this.productRepository.findByMultipleCategoryIdsAndPriceRange(categoryIds,priceMin,priceMax,pageable);
        }

        return null;


    }
    @Cacheable("best-sellers")
    public Page<Product> getBestSellers(int page, int max) {
        Pageable pageable = PageRequest.of(page-1,max,Sort.by("sold").descending());
        System.out.println("New Cache");
        return this.productRepository.findAll(pageable);
    }

    public Page<Product> search(String searchTerm, String category, int page, int max, Double priceMax, Double priceMin){
        Pageable pageable = PageRequest.of(page-1,max);
        if (category.equals("all")){
            return this.productRepository.searchAllCategories(searchTerm,pageable);
        }if (priceMax == null && priceMin == null){
            Category cat = this.categoryService.getCategoryByName(category);
            return this.productRepository.searchByCategory(searchTerm,pageable,cat.getId());
        }
        Category cat = this.categoryService.getCategoryByName(category);
        return this.productRepository.searchByCategoryWithPrices(searchTerm,pageable,cat.getId(),priceMin,priceMax);


    }



}
