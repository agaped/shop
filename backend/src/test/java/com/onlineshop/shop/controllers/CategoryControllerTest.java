package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.CategoryDto;
import com.onlineshop.shop.exceptions.ItemNotFoundException;
import com.onlineshop.shop.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void getAllCategories() throws Exception {
        CategoryDto gorskie = CategoryDto.builder()
                .id(3)
                .name("gorskie")
                .build();
        CategoryDto damskie = CategoryDto.builder()
                .id(4)
                .name("damskie")
                .build();
        List<CategoryDto> categories= Arrays.asList(gorskie, damskie);

        when(categoryService.getAllCategories()).thenReturn(categories);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/categories"))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(gorskie.getId())))
                .andExpect(jsonPath("$[1].name",is(damskie.getName())));

        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    public void getExistingCategory() throws Exception {
        int categoryId=1;
        CategoryDto category = CategoryDto.builder()
                .id(categoryId)
                .name("gorskie")
                .build();

        when(categoryService.categoryExist(categoryId)).thenReturn(true);
        when(categoryService.getConvertedCategory(categoryId)).thenReturn(category);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/categories/" + categoryId))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(category.getId())));

        verify(categoryService, times(1)).categoryExist(categoryId);
        verify(categoryService, times(1)).getConvertedCategory(categoryId);
    }

    @Test
    @ExceptionHandler(ItemNotFoundException.class)
    public void getNonExistingCategory() throws Exception {
        int categoryId=1;

        when(categoryService.categoryExist(categoryId)).thenReturn(false);

        this.mockMvc.perform(get("http://localhost:8081/api/v1/categories/" + categoryId))
                .andExpect(status().isNotFound());

        verify(categoryService, times(1)).categoryExist(categoryId);
        verify(categoryService, times(0)).getConvertedCategory(categoryId);
    }
}