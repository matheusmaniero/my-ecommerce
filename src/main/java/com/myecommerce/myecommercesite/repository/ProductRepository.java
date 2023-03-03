package com.myecommerce.myecommercesite.repository;

import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByCategory(Pageable pageable, Category category);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryIds")
    Page<Product> findByMultipleCategoryIds(@Param("categoryIds") List<Integer> categoryIds, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryIds AND p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByMultipleCategoryIdsAndPriceRange(@Param("categoryIds") List<Integer> categoryIds, @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer  maxPrice, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByPriceRange(@Param("minPrice") Integer minPrice, @Param("maxPrice") Integer  maxPrice, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryIds AND p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByCategoryIdAndPriceRange(@Param("categoryIds") Integer categoryId, @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer  maxPrice, Pageable pageable);



}
