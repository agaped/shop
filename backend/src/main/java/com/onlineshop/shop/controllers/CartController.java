package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.CartDto;
import com.onlineshop.shop.dto.CartItemDto;
import com.onlineshop.shop.model.Cart;
import com.onlineshop.shop.model.ClientOrder;
import com.onlineshop.shop.model.Product;
import com.onlineshop.shop.repositories.CartRepository;
import com.onlineshop.shop.repositories.OrderRepository;
import com.onlineshop.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "api/v1/cart")
public class CartController {

    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    public CartController(CartRepository cartRepository, ProductRepository productRepository,
                          OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveCart(@RequestBody @NotNull CartDto cart) {

        for (CartItemDto cartItem: cart.getCartItems()) {
            ClientOrder clientOrder = orderRepository.findById(cart.getOrderId()).get();
            Product product = productRepository.findById(cartItem.getItem().getId()).get();
            cartRepository.save(new Cart(cartItem.getQuantity(), product, clientOrder));
        }

    }
}
