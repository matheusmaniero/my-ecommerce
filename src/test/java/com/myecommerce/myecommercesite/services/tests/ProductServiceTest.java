package com.myecommerce.myecommercesite.services.tests;

import com.myecommerce.myecommercesite.builders.ProductBuilder;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import com.myecommerce.myecommercesite.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @MockBean
     ProductRepository productRepository;
    @TestConfiguration
    static class ProductServiceTestConfiguration{
        @Bean
        public ProductService productService(){
            return new ProductService();
        }
    }

    @Before
    public void setup(){
        List<Product> productList = ProductBuilder.createProductBuilder().createProductList(38);
        Pageable pageable = PageRequest.of(0, 9);
        Page<Product> pages = new PageImpl<>(productList, pageable, productList.size());
        Mockito.when(productRepository.findAll(pageable)).thenReturn(pages);

    }

    @Test
    public void shouldReturnPageOfProducts() {
        List<Product> productList = ProductBuilder.createProductBuilder().createProductList(38);
        Pageable pageable = PageRequest.of(0, 9);
        Page<Product> pages = new PageImpl<>(productList, pageable, productList.size());


        Page<Product> pageFromService = this.productService.getProductsPaginated(1,9);

        Assert.assertTrue(pageFromService.hasContent());
        Assert.assertEquals(pages.getTotalElements(),pageFromService.getTotalElements());
        Assert.assertNotNull(pageFromService.getContent().get(0));

        Assert.assertEquals(pages.getContent().get(0).getClass(),pageFromService.getContent().get(0).getClass());

    }
}