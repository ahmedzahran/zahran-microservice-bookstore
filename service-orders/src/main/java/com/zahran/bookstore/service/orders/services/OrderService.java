package com.zahran.bookstore.service.orders.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zahran.bookstore.service.orders.Exceptions.AppException;
import com.zahran.bookstore.service.orders.dto.OrderDto;
import com.zahran.bookstore.service.orders.mappers.OrderMapper;
import com.zahran.bookstore.service.orders.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDto getOrder(long orderId){

        return orderRepository.findById(orderId)
                                .map(orderMapper::tOrderDto)
                                .orElseThrow(() -> new AppException("no order with id" + orderId, HttpStatus.INTERNAL_SERVER_ERROR));

    }
}
