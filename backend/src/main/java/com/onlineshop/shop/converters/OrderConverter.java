package com.onlineshop.shop.converters;

import com.onlineshop.shop.dto.OrderDto;
import com.onlineshop.shop.model.ClientOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter implements Converter<ClientOrder, OrderDto> {
    @Override
    public OrderDto convert(ClientOrder source) {

        return new OrderDto.Builder()
                .date(source.getDate())
                .payment(source.getPayment())
                .delivery(source.getDelivery())
                .status(source.getStatus())
                .total(source.getTotal())
                .userId(source.getUser().getId())
                .build();
    }
}
