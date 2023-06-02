package com.zahran.bookstore.service.prices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zahran.bookstore.service.prices.entities.Price;

public interface PriceRepository extends JpaRepository<Price,Long>{
    
    Optional<Price> findByBookId(long bookId);
}
