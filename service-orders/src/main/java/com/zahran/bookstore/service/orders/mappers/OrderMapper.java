package com.zahran.bookstore.service.orders.mappers;

import org.mapstruct.Mapper;

import com.zahran.bookstore.service.orders.dto.OrderDto;
import com.zahran.bookstore.service.orders.entities.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto tOrderDto(Order order);
}
