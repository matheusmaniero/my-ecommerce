package com.myecommerce.myecommercesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyEcommerceSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEcommerceSiteApplication.class, args);
	}

}
