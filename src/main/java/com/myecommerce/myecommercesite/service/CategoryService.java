package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.exceptions.CategoryException;
import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public Category getCategoryByName(String category){

        category = StringUtils.capitalize(category);

        Category cat = this.categoryRepository.findByName(category);

        if (cat != null){
            return cat;
        }

        throw new CategoryException("Category Not Found.");

    }
}
