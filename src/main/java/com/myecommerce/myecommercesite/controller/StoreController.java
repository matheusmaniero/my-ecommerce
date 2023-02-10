package com.myecommerce.myecommercesite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    @GetMapping("/store")
    public String showProducts(){
        return "store";
    }
}