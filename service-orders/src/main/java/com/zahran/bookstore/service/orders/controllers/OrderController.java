package com.zahran.bookstore.service.orders.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zahran.bookstore.service.orders.dto.OrderDto;
import com.zahran.bookstore.service.orders.services.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController {
    

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable long orderId){
        log.info("Looking for order {}", orderId);
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }
}
