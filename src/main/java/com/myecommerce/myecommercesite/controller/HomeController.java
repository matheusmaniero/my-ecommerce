package com.myecommerce.myecommercesite.controller;

import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String loadHome(Model model){

        List<Product> lastInsertedProducts =  this.productService.getTheFourLastInsertedProducts();
        Page<Product> mostSoldedProducts = this.productService.getBestSellers(1,5);

        model.addAttribute("newProducts",lastInsertedProducts);
        model.addAttribute("mostSolded",mostSoldedProducts);


        return "index";
    }
}
