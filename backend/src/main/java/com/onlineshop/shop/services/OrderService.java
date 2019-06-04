package com.onlineshop.shop.services;

import com.onlineshop.shop.converters.OrderConverter;
import com.onlineshop.shop.dto.OrderDto;
import com.onlineshop.shop.model.ClientOrder;
import com.onlineshop.shop.model.User;
import com.onlineshop.shop.repositories.OrderRepository;
import com.onlineshop.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private java.util.Date date;
    private java.sql.Date sqlDate;

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private OrderConverter orderConverter;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderConverter = orderConverter;
    }

    public int makeOrder(OrderDto order) {
        date = new Date();
        sqlDate=new java.sql.Date(date.getTime());
        User user = userRepository.findById(order.getUserId()).get();
        ClientOrder orderToSave = new ClientOrder(sqlDate, order.getPayment(), order.getStatus(),
                order.getDelivery(), order.getTotal(), user);
        orderRepository.save(orderToSave);

        return orderToSave.getId();
    }

    public List<OrderDto> getConvertedOrdersByUserId(int id) {
        return this.orderRepository.findAllByUserId(id).stream()
                .map(order-> orderConverter.convert(order))
                .collect(Collectors.toList());
    }
}
