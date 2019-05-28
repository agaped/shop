package com.onlineshop.shop.controllers;

import com.onlineshop.shop.converters.OrderConverter;
import com.onlineshop.shop.dto.CartDto;
import com.onlineshop.shop.dto.CartItemDto;
import com.onlineshop.shop.dto.OrderDto;
import com.onlineshop.shop.model.Cart;
import com.onlineshop.shop.model.ClientOrder;
import com.onlineshop.shop.model.Product;
import com.onlineshop.shop.model.User;
import com.onlineshop.shop.repositories.CartRepository;
import com.onlineshop.shop.repositories.OrderRepository;
import com.onlineshop.shop.repositories.ProductRepository;
import com.onlineshop.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {

    private java.util.Date date;
    private java.sql.Date sqlDate;

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private OrderConverter orderConverter;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository, CartRepository cartRepository, ProductRepository productRepository, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.orderConverter = orderConverter;
    }

    @RequestMapping(method = RequestMethod.POST)
    public int makeOrder(@RequestBody OrderDto order) {
        if (!userRepository.findById(order.getUserId()).isPresent()) {
            throw new IllegalArgumentException("User does not exist" + order.getUserId());
        }
        date = new Date();
        sqlDate=new java.sql.Date(date.getTime());
        User user = userRepository.findById(order.getUserId()).get();
        ClientOrder orderToSave = new ClientOrder(sqlDate, order.getPayment(), order.getStatus(), order.getDelivery(), order.getTotal(), user);
        orderRepository.save(orderToSave);

        return orderToSave.getId();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/cart")
    public void saveCart(@RequestBody CartDto cart) {

        for (CartItemDto cartItem: cart.getCartItems()) {
            ClientOrder clientOrder = orderRepository.findById(cart.getOrderId()).get();
            Product product = productRepository.findById(cartItem.getItem().getId()).get();
            cartRepository.save(new Cart(cartItem.getQuantity(), product, clientOrder));
        }

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public List<OrderDto> getOrdersByUserId(@PathVariable ("id") int id) {
         return this.orderRepository.findAllByUserId(id).stream()
                 .map(order-> orderConverter.convert(order))
                 .collect(Collectors.toList());
    }

}
