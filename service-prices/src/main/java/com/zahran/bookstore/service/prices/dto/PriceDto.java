package com.zahran.bookstore.service.prices.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PriceDto {
    
    private BigDecimal price;
    private long bookId;
}
