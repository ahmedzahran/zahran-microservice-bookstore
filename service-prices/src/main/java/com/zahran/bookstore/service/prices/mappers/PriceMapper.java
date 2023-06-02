package com.zahran.bookstore.service.prices.mappers;

import org.mapstruct.Mapper;

import com.zahran.bookstore.service.prices.dto.PriceDto;
import com.zahran.bookstore.service.prices.entities.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper  {
    PriceDto toPriceDto(Price price);
}
