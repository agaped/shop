package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.CategoryDto;
import com.onlineshop.shop.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<Category, CategoryDto> {
    @Override
    public CategoryDto convert(Category source) {

        return CategoryDto.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
