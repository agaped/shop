package com.onlineshop.shop.controllers;

import com.onlineshop.shop.dto.OrderDto;
import com.onlineshop.shop.model.ClientOrder;
import com.onlineshop.shop.model.User;
import com.onlineshop.shop.repositories.OrderRepository;
import com.onlineshop.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {

    private java.util.Date date;
    private java.sql.Date sqlDate;
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping(method = RequestMethod.POST)
    public int makeOrder(@RequestBody OrderDto order) {
        if (!userRepository.findById(order.getUserId()).isPresent()) {
            throw new IllegalArgumentException("User does not exist" + order.getUserId());
        }
        date = new Date();
        sqlDate=new java.sql.Date(date.getTime());
        User user = userRepository.findById(order.getUserId()).get();
        ClientOrder orderToSave = new ClientOrder(sqlDate, order.getPayment(), order.getStatus(), order.getDelivery(), user);
        orderRepository.save(orderToSave);

        return orderToSave.getId();
    }
}
