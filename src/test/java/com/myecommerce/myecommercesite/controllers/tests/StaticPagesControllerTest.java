package com.myecommerce.myecommercesite.controllers.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class StaticPagesControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    public void shouldReturnStaticPages() throws Exception {

        String[][] pages = {{"/about","pages/about"},{"/contact","pages/contact"},
                {"/privacy","pages/privacy"},{"/orders-and-returns","pages/orders-and-returns"},
                {"/terms","pages/terms"},{"/login","pages/login"}};

        for (String[] page : pages){
            mockMvc.perform(get(page[0]))
                    .andExpect(status().isOk())
                    .andExpect(view().name(page[1]));

        }

    }
}
