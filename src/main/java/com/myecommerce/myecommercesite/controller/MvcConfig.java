package com.myecommerce.myecommercesite.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("about").setViewName("pages/about");
        registry.addViewController("contact").setViewName("pages/contact");
        registry.addViewController("privacy").setViewName("pages/privacy");
        registry.addViewController("orders-and-returns").setViewName("pages/orders-and-returns");
        registry.addViewController("terms").setViewName("pages/terms");
        registry.addViewController("login").setViewName("pages/login");

    }



}
