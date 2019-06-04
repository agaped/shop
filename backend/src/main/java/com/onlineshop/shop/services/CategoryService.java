package com.onlineshop.shop.services;

import com.onlineshop.shop.converters.CategoryConverter;
import com.onlineshop.shop.dto.CategoryDto;
import com.onlineshop.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> categoryConverter.convert(category))
                .collect(Collectors.toList());
    }

    public boolean categoryExist(int id) {
        return categoryRepository.findById(id).isPresent();
    }

    public CategoryDto getConvertedCategory(int id) {
        return categoryConverter.convert(categoryRepository.getOne(id));
    }
}
