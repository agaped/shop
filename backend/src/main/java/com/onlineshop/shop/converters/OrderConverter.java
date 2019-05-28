package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.OrderDto;
import com.onlineshop.shop.model.ClientOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter implements Converter<ClientOrder, OrderDto> {
    @Override
    public OrderDto convert(ClientOrder source) {

        OrderDto order = new OrderDto();
        order.setDelivery(source.getDelivery());
        order.setUserId(source.getUser().getId());
        order.setPayment(source.getPayment());
        order.setStatus(source.getStatus());
        order.setTotal(source.getTotal());
        order.setDate(source.getDate());

        return order;
    }
}
