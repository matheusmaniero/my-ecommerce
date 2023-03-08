package com.myecommerce.myecommercesite.controllers.tests;

import com.myecommerce.myecommercesite.builders.ProductBuilder;
import com.myecommerce.myecommercesite.controller.StoreController;
import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.model.SmartPhone;
import com.myecommerce.myecommercesite.service.CategoryService;
import com.myecommerce.myecommercesite.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(StoreController.class)
@AutoConfigureMockMvc(addFilters = false)
public class StoreControllerTest {
    /*
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    CategoryService categoryService;

    @Before
    public void setup(){
        List<Product> allProductList = ProductBuilder.createProductBuilder().createGenericProductList(38);
        List<Product> onlySmartphonesList = ProductBuilder.createProductBuilder().createSmartphonesList(38);
        Pageable pageable = PageRequest.of(0, 9);
        Page<Product> allProductsPage = new PageImpl<>(allProductList, pageable, allProductList.size());
        Page<Product> onlySmartPhonesPage = new PageImpl<>(onlySmartphonesList,pageable,onlySmartphonesList.size());

        Mockito.when(this.productService.getAllProductsPaginated(Mockito.anyInt(),Mockito.anyInt())).thenReturn(allProductsPage);

        List<Category> categories = Arrays.asList(new Category(1,"Laptops"), new Category(2,"Smartphones")
        ,new Category(3,"Headsets"), new Category(4,"Cameras"));

        Mockito.when(this.categoryService.getAllCategories()).thenReturn(categories);

        Mockito.when(this.productService.getProductsByCategory(Mockito.anyInt(),Mockito.anyInt(),Mockito.eq(new Category(2, "Smartphones"))))
                .thenReturn(onlySmartPhonesPage);



    }


    @Test
    public void shouldReturnStorePageWithAllProductsUsingDefaultParameters() throws Exception {

        mockMvc.perform(get("/store/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("store"))
                .andExpect(model().attribute("productsPaginated", instanceOf(Page.class)))
                .andExpect(model().attribute("currentPage",1))
                .andExpect(model().attribute("selectedMax",9))
                .andExpect(model().attribute("totalPages",5));

    }

    @Test
    public void shouldReturnStorePageWithSpecificCategoryAndDefaultParameters() throws Exception {

        mockMvc.perform(get("/store/smartphones"))
                .andExpect(status().isOk())
                .andExpect(view().name("store"))
                .andExpect(model().attribute("productsPaginated", instanceOf(Page.class)))
                .andExpect(model().attribute("productsPaginated", hasProperty("content",everyItem(isA(SmartPhone.class)))))
                .andExpect(model().attribute("currentPage",1))
                .andExpect(model().attribute("selectedMax",9))
                .andExpect(model().attribute("totalPages",5));

    }







*/


}
