package com.onlineshop.shop.services;

import com.onlineshop.shop.dto.CartDto;
import com.onlineshop.shop.dto.CartItemDto;
import com.onlineshop.shop.model.Cart;
import com.onlineshop.shop.model.ClientOrder;
import com.onlineshop.shop.model.Product;
import com.onlineshop.shop.repositories.CartRepository;
import com.onlineshop.shop.repositories.OrderRepository;
import com.onlineshop.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;

    @Autowired
    public CartService(OrderRepository orderRepository, ProductRepository productRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public void saveCart(CartDto cart) {
        for (CartItemDto cartItem : cart.getCartItems()) {
            ClientOrder clientOrder = orderRepository.findById(cart.getOrderId()).get();
            Product product = productRepository.findById(cartItem.getItem().getId()).get();
            cartRepository.save(new Cart(cartItem.getQuantity(), product, clientOrder));
        }
    }
}
