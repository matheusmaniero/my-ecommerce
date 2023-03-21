package com.myecommerce.myecommercesite.controller;

import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import com.myecommerce.myecommercesite.service.CategoryService;
import com.myecommerce.myecommercesite.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/good")
public class ProductPageController {

    final private ProductService productService;
    final private CategoryService categoryService;

    public ProductPageController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model){

        Product product = this.productService.getProductById(id);

        Page<Product> relatedProducts = this.productService.getRelatedProducts(product.getCategory());

        model.addAttribute("product",product);
        model.addAttribute("relatedProducts",relatedProducts);


        return "product.html";





    }




}
