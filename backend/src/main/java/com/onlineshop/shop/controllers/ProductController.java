package com.onlineshop.shop.controllers;

import com.onlineshop.shop.converters.ProductConverter;
import com.onlineshop.shop.dto.ProductDto;
import com.onlineshop.shop.model.Product;
import com.onlineshop.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> productConverter.convert(product))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ProductDto getProduct(@PathVariable("id") int id) {
        if(!productRepository.findById(id).isPresent()){
            throw new IllegalArgumentException("Product of given id does not exist");
        }
        Product one = productRepository.getOne(id);
        return productConverter.convert(one);
    }
}
