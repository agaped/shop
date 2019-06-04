package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.ProductDto;
import com.onlineshop.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ProductDto getProduct(@PathVariable("id") int id) {
        if(!productService.productExists(id)){
            throw new IllegalArgumentException("Product of given id does not exist");
        }
        return productService.getConvertedProduct(id);
    }
}
