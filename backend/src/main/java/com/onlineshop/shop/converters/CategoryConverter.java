package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.CategoryDto;
import com.onlineshop.shop.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<Category, CategoryDto> {
    @Override
    public CategoryDto convert(Category source) {

        CategoryDto category=new CategoryDto();
        category.setId(source.getId());
        category.setName(source.getName());

        return category;
    }
}
