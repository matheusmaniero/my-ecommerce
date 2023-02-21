package com.myecommerce.myecommercesite.controllers.tests;

import com.myecommerce.myecommercesite.builders.ProductBuilder;
import com.myecommerce.myecommercesite.controller.StoreController;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.service.ProductService;
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

import java.util.List;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(StoreController.class)
@AutoConfigureMockMvc(addFilters = false)
public class StoreControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;


    @Test
    public void shouldReturnStorePageUsingDefaultParameters() throws Exception {

        List<Product> productList = ProductBuilder.createProductBuilder().createProductList(38);
        Pageable pageable = PageRequest.of(0, 9);
        Page<Product> pages = new PageImpl<>(productList, pageable, productList.size());

        Mockito.when(this.productService.getProductsPaginated(Mockito.anyInt(),Mockito.anyInt())).thenReturn(pages);

        mockMvc.perform(get("/store"))
                .andExpect(status().isOk())
                .andExpect(view().name("store"))
                .andExpect(model().attribute("productsPaginated", instanceOf(Page.class)))
                .andExpect(model().attribute("currentPage",1))
                .andExpect(model().attribute("totalPages",pages.getTotalPages()));

    }
}
