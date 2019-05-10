package com.onlineshop.shop.controllers;

import com.onlineshop.shop.model.Product;
import com.onlineshop.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productRepository.getOne(id);
    }
}
