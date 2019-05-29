package com.onlineshop.shop.controllers;

import com.onlineshop.shop.converters.CategoryConverter;
import com.onlineshop.shop.dto.CategoryDto;
import com.onlineshop.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> categoryConverter.convert(category))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public CategoryDto getCategory(@PathVariable("id") int id) {
        if(!categoryRepository.findById(id).isPresent()){
            throw new IllegalArgumentException("Category of given id does not exist "+id);
        }
        return categoryConverter.convert(categoryRepository.getOne(id));
    }
}
