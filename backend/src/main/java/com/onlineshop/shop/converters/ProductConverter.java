package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.ProductDto;
import com.onlineshop.shop.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ProductConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto convert(Product source) {

        return ProductDto.builder()
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
