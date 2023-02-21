package com.myecommerce.myecommercesite.controller;

import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {
    final private ProductService productService;
    @Autowired
    public StoreController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/store")
    public String showProducts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "9") int max, Model model){

        Page<Product> productsPaginated = this.productService.getProductsPaginated(page,max);

        model.addAttribute("productsPaginated",productsPaginated);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",productsPaginated.getTotalPages());


        return "store";
    }
}
