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
    Page<Product> findByMultipleCategoryIdsAndPriceRange(@Param("categoryIds") List<Integer> categoryIds, @Param("minPrice") Double minPrice, @Param("maxPrice") Double  maxPrice, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryIds AND p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByCategoryIdAndPriceRange(@Param("categoryIds") Integer categoryId, @Param("minPrice")  Double minPrice, @Param("maxPrice") Double maxPrice, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE fts(:searchTerm) = true order by rank(:searchTerm) desc")
    Page<Product> searchAllCategories(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND fts(:searchTerm) = true order by rank(:searchTerm) desc")
    Page<Product> searchByCategory(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc")
    Page<Product> searchByCategoryWithPrices(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId,
                                             @Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc")
    Page<Product> searchAllCategoriesWithPrices(@Param("searchTerm") String searchTerm,@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price desc")
    Page<Product> searchByCategoryPricesDesc(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price asc")
    Page<Product> searchByCategoryPricesAsc(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.sold desc")
    Page<Product> searchByCategoryRelevance(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId);

    @Query("SELECT p FROM Product p WHERE fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price desc")
    Page<Product> searchAllCategoriesPriceDesc(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price asc")
    Page<Product> searchAllCategoriesPriceAsc(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE fts(:searchTerm) = true order by rank(:searchTerm) desc, p.sold desc")
    Page<Product> searchAllCategoriesRelevance(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price desc")
    Page<Product> searchAllCategoriesWithPricesDesc(@Param("searchTerm") String searchTerm,@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price asc")
    Page<Product> searchAllCategoriesWithPricesAsc(@Param("searchTerm") String searchTerm,@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.sold desc")
    Page<Product> searchAllCategoriesWithPricesAndRelevance(@Param("searchTerm") String searchTerm,@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price desc")
    Page<Product> searchByCategoryWithPricesDesc(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId,
                                             @Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);


    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.price asc")
    Page<Product> searchByCategoryWithPricesAsc(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId,
                                             @Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);


    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id IN :categoryId AND p.price BETWEEN :priceMin AND :priceMax AND fts(:searchTerm) = true order by rank(:searchTerm) desc, p.sold desc")
    Page<Product> searchByCategoryWithPricesAndRelevance(@Param("searchTerm") String searchTerm, Pageable pageable, Integer categoryId,
                                             @Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);


    Product getProductById(Integer id);



}





