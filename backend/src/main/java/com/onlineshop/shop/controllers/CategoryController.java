package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.CategoryDto;
import com.onlineshop.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public CategoryDto getCategory(@PathVariable("id") int id) {
        if(!categoryService.categoryExist(id)){
            throw new IllegalArgumentException("Category of given id does not exist "+id);
        }
        return categoryService.getConvertedCategory(id);
    }
}
