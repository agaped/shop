package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.ProductDto;
import com.onlineshop.shop.model.Product;
import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;

@Component
public class ProductConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto convert(Product source) {

        return new ProductDto.Builder()
                .id(source.getId())
                .name(source.getName())
                .category(source.getCategory().getName())
                .producer(source.getProducer())
                .price(source.getPrice())
                .description(source.getDescription())
                .url(source.getImg().getUrl())
                .build();
    }
}
