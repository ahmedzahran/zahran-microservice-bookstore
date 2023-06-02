package com.zahran.bookstore.service.prices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zahran.bookstore.service.prices.dto.PriceDto;
import com.zahran.bookstore.service.prices.services.PriceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PriceController {
    
    private final PriceService priceService;

    @GetMapping("/books/{bookId}")
    public ResponseEntity<PriceDto> getBookPrice(@PathVariable long bookId){
        log.info("Looking for price of book {}", bookId);
        return ResponseEntity.ok(priceService.getPrice(bookId));
    }
}
