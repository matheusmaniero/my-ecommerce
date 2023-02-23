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
                               @RequestParam(defaultValue = "unsorted") String sortedByPrice,
                               @RequestParam(defaultValue = "any") String relevance, Model model){

        Page<Product> productsPaginated = this.productService.serviceProductHandler(page,max,category,sortedByPrice,relevance);

        if (productsPaginated == null) return "error";

        String sortingType = new String();
        String relevanceName = new String();

        if (sortedByPrice.equals("unsorted")) sortingType = " ";
        else if (sortedByPrice.equals("asc")) sortingType = "Lowest Prices";
        else if (sortedByPrice.equals("desc")) sortingType = "Highest Prices";

        if (relevance.equals("any")) relevanceName = "Any";
        else if (relevance.equals("bestSellers")) relevanceName = "Best Sellers";

        model.addAttribute("productsPaginated",productsPaginated);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",productsPaginated.getTotalPages());
        model.addAttribute("selectedMax",max);
        model.addAttribute("sortedByPrice",sortedByPrice);
        model.addAttribute("relevance",relevance);
        model.addAttribute("sortingType",sortingType);
        model.addAttribute("relevanceName",relevanceName);

        return "store";
    }



}
