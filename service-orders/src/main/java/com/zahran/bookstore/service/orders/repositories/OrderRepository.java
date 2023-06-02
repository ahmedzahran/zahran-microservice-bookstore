package com.zahran.bookstore.service.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zahran.bookstore.service.orders.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
