package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.ProductDto;
import com.onlineshop.shop.exceptions.ItemNotFoundException;
import com.onlineshop.shop.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getAllProducts() throws Exception {
        ProductDto product=new ProductDto.Builder()
                .id(1)
                .build();
        List<ProductDto> allProducts=new ArrayList<>();
        allProducts.add(product);

        when(productService.getAllProducts()).thenReturn(allProducts);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/products"))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].id",is(product.getId())));
    }

    @Test
    public void getExistingProduct() throws Exception {
        int id=1;
        String name="Woman bike";
        ProductDto product = new ProductDto.Builder()
                .id(id)
                .name(name)
                .build();

        when(productService.productExists(id)).thenReturn(true);
        when(productService.getConvertedProduct(id)).thenReturn(product);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/products/" + id))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(name)));
    }

    @Test
    @ExceptionHandler(ItemNotFoundException.class)
    public void getNonExistingProduct() throws Exception {
        int id=1;
        ProductDto product = new ProductDto.Builder()
                .id(id)
                .build();

        when(productService.productExists(product.getId())).thenReturn(false);
        when(productService.getConvertedProduct(id)).thenThrow(ItemNotFoundException.class);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/products/" + id))
                .andExpect(status().isNotFound());
    }
}