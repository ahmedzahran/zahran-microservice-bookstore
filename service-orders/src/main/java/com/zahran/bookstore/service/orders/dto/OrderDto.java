package com.zahran.bookstore.service.orders.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {
    
    private BigDecimal price;
    private long bookId;
    private LocalDateTime createdDate;
}
