package com.onlineshop.shop.services;

import com.onlineshop.shop.converters.ProductConverter;
import com.onlineshop.shop.dto.ProductDto;
import com.onlineshop.shop.model.Product;
import com.onlineshop.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    private ProductRepository productRepository;
    private ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> productConverter.convert(product))
                .collect(Collectors.toList());
    }

    public boolean productExists(int id) {
        return productRepository.findById(id).isPresent();
    }

    public ProductDto getConvertedProduct(int id) {
        Product one = productRepository.getOne(id);
        return productConverter.convert(one);
    }
}
