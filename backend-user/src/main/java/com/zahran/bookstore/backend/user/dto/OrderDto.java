package com.zahran.bookstore.backend.user.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OrderDto {
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private Long bookId;

    @JsonProperty(access = Access.READ_WRITE)
    private BookDto book;

    private BigDecimal price;
}
