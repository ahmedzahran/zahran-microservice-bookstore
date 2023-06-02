package com.zahran.bookstore.service.prices.services;

import org.springframework.stereotype.Service;

import com.zahran.bookstore.service.prices.dto.PriceDto;
import com.zahran.bookstore.service.prices.exceptions.AppException;
import com.zahran.bookstore.service.prices.mappers.PriceMapper;
import com.zahran.bookstore.service.prices.repositories.PriceRepository;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceService {
    
    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public PriceDto getPrice(long bookId){

        return priceRepository.findByBookId(bookId)
            .map(priceMapper::toPriceDto)
            .orElseThrow(() -> new AppException("No price for book " + bookId, HttpStatus.NOT_FOUND));

    }
}
