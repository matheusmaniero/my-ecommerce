package com.myecommerce.myecommercesite.controller;

import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.service.CategoryService;
import com.myecommerce.myecommercesite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {
    final private ProductService productService;
    final private CategoryService categoryService;

    @Autowired
    public StoreController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/store/{category}")
    public String showProducts(@PathVariable String category ,@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "9") int max,
                               @RequestParam(defaultValue = "unsorted") String sortingType, Model model){

        Page<Product> productsPaginated = this.productService.serviceProductHandler(page,max,category,sortingType);

        if (productsPaginated == null) return "error";

        String sortingDisplayName = new String();


        if (sortingType.equals("unsorted")) sortingDisplayName = "Any";
        else if (sortingType.equals("asc")) sortingDisplayName = "Lowest Prices";
        else if (sortingType.equals("desc")) sortingDisplayName = "Highest Prices";
        else if (sortingType.equals("relevance")) sortingDisplayName = "Best Sellers";

        model.addAttribute("productsPaginated",productsPaginated);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",productsPaginated.getTotalPages());
        model.addAttribute("selectedMax",max);
        model.addAttribute("sortingType",sortingType);
        model.addAttribute("sortingDisplayName",sortingDisplayName);


        return "store";
    }



}
