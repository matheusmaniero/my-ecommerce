package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.exceptions.GeneralException;
import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public Page<Product> search(String searchTerm, String category, int page, int max, Double priceMax, Double priceMin,
                                String sortingType) {

        if (!category.equals("all") && priceMax != null && priceMin != null && !sortingType.equals("unsorted")) {
            return searchWithCategoryPriceRangeAndSortingType(searchTerm, category, page, max, priceMax, priceMin, sortingType);

        } else if (category.equals("all") && priceMax != null && priceMin != null && !sortingType.equals("unsorted")) {

            return searchWithPriceRangeAndSortingType(searchTerm, page, max, priceMax, priceMin, sortingType);

        } else if (!category.equals("all") && !sortingType.equals("unsorted")) {
            return searchWithCategoryAndSortingType(searchTerm, category, page, max, sortingType);
        } else if (!category.equals("all") && priceMax != null && priceMin != null) {
            return searchWithCategoryWithPrices(searchTerm, category, page, max, priceMax, priceMin);
        } else if (category.equals("all") && priceMax != null && priceMin != null) {
            return searchAllCategoriesWithPrices(searchTerm, page, max, priceMax, priceMin);
        }else if (category.equals("all") && !sortingType.equals("unsorted")){

            return searchAllCategoriesWithSortingType(searchTerm, page, max,sortingType);


        }else if (!category.equals("all")){
            return searchWithCategory(searchTerm,category,page,max);
        }
        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.searchAllCategories(searchTerm,pageable);



    }

    private Page<Product> searchAllCategoriesWithSortingType(String searchTerm, int page, int max, String sortingType) {
        Pageable pageable = PageRequest.of(page-1,max);
        Page<Product> productsPaginated = null;

        if (sortingType.equals("desc")){

            productsPaginated = this.productRepository.searchAllCategoriesPriceDesc(searchTerm,pageable);

        }else if (sortingType.equals("asc")){

            productsPaginated = this.productRepository.searchAllCategoriesPriceAsc(searchTerm,pageable);

        }else if (sortingType.equals("relevance")){

            productsPaginated = this.productRepository.searchAllCategoriesRelevance(searchTerm,pageable);


        }

        return productsPaginated;


    }

    private Page<Product> searchWithCategory(String searchTerm, String category, int page, int max) {
        Category cat = this.categoryService.getCategoryByName(category);

        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.searchByCategory(searchTerm,pageable,cat.getId());


    }

    private Page<Product> searchAllCategoriesWithPrices(String searchTerm, int page, int max, Double priceMax, Double priceMin) {
        Pageable pageable = PageRequest.of(page-1,max);
        return this.productRepository.searchAllCategoriesWithPrices(searchTerm,priceMin,priceMax,pageable);
    }

    private Page<Product> searchWithCategoryWithPrices(String searchTerm, String category, int page, int max, Double priceMax, Double priceMin) {
        Category cat = this.categoryService.getCategoryByName(category);
        Pageable pageable = PageRequest.of(page-1,max);

        return this.productRepository.searchByCategoryWithPrices(searchTerm,pageable,cat.getId(),priceMin,priceMax);

    }

    private Page<Product> searchWithCategoryAndSortingType(String searchTerm, String category, int page, int max, String sortingType) {
        Category cat = this.categoryService.getCategoryByName(category);
        Pageable pageable = PageRequest.of(page-1,max);
        Page<Product> productsPaginated = null;

        if (sortingType.equals("desc")){

            productsPaginated = this.productRepository.searchByCategoryPricesDesc(searchTerm,pageable, cat.getId());


        }else if (sortingType.equals("asc")){

            productsPaginated = this.productRepository.searchByCategoryPricesAsc(searchTerm,pageable, cat.getId());

        }else if (sortingType.equals("relevance")){

            productsPaginated = this.productRepository.searchByCategoryRelevance(searchTerm,pageable, cat.getId());

        }

        return productsPaginated;

    }

    private Page<Product> searchWithPriceRangeAndSortingType(String searchTerm, int page, int max, Double priceMax, Double priceMin, String sortingType) {
        Pageable pageable = PageRequest.of(page-1,max);
        Page<Product> productsPaginated = null;

        if (sortingType.equals("desc")){

            productsPaginated = this.productRepository.searchAllCategoriesWithPricesDesc(searchTerm,priceMin,priceMax,pageable);

        }else if (sortingType.equals("asc")){

            productsPaginated = this.productRepository.searchAllCategoriesWithPricesAsc(searchTerm,priceMin,priceMax,pageable);

        }else if (sortingType.equals("relevance")){

            productsPaginated = this.productRepository.searchAllCategoriesWithPricesAndRelevance(searchTerm,priceMin,priceMax,pageable);

        }

        return productsPaginated;

    }

    private Page<Product> searchWithCategoryPriceRangeAndSortingType(String searchTerm, String category, int page, int max, Double priceMax,
                                                                     Double priceMin, String sortingType) {

        Category cat = this.categoryService.getCategoryByName(category);
        Pageable pageable = PageRequest.of(page-1,max);
        Page<Product> productsPaginated = null;


        if (sortingType.equals("desc")){

            productsPaginated = this.productRepository.searchByCategoryWithPricesDesc(searchTerm,pageable, cat.getId(),priceMin,priceMax);

        }else if (sortingType.equals("asc")){

            productsPaginated = this.productRepository.searchByCategoryWithPricesAsc(searchTerm,pageable, cat.getId(),priceMin,priceMax);

        }else if (sortingType.equals("relevance")){

            productsPaginated = this.productRepository.searchByCategoryWithPricesAndRelevance(searchTerm,pageable, cat.getId(),priceMin,priceMax);

        }
        return productsPaginated;
    }

    public Product getProductById(Integer id){
        return this.productRepository.getProductById(id);
    }


    public Page<Product> getRelatedProducts(Category category) {

        Pageable pageable = PageRequest.of(0,4,Sort.by("sold").descending());

        return this.productRepository.findByCategory(pageable,category);

    }

    public List<Product> getTheFourLastInsertedProducts(){
        return this.productRepository.findFirst4ByOrderByIdDesc();
    }


}
