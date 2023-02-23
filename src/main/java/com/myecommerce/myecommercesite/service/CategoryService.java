package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    final private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }
}
