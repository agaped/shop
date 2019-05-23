package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.ProductDto;
import com.onlineshop.shop.model.Product;
import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;

@Component
public class ProductConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto convert(Product source) {

        ProductDto productDto = new ProductDto();
        productDto.setId(source.getId());
        productDto.setName(source.getName());
        productDto.setPrice(source.getPrice());
        productDto.setProducer(source.getProducer());
        productDto.setDescription(source.getDescription());
        productDto.setCategory(source.getCategory().getName());
        productDto.setUrl(source.getImg().getUrl());

        return productDto;
    }
}
