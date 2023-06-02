package com.zahran.bookstore.backend.user.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zahran.bookstore.backend.user.dto.BookDto;
import com.zahran.bookstore.backend.user.dto.OrderDto;
import com.zahran.bookstore.backend.user.exceptions.AppException;
import com.zahran.bookstore.backend.user.retrofit.ServiceBooks;
import com.zahran.bookstore.backend.user.retrofit.ServiceOrders;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    
    private final ServiceOrders serviceOrders;
    private final ServiceBooks serviceBooks;

    public OrderDto getOrder(long orderId){

        OrderDto orderDto;

        try {
            Response<OrderDto> response = serviceOrders.getOrder(orderId).execute();
            orderDto = response.body();
        } catch (Exception e) {
            log.error("Unable to request service-orders for order {}", orderId, e);
            throw new AppException("Unable to request service-orders", HttpStatus.INTERNAL_SERVER_ERROR);       
        }

        BookDto bookDto;

        try {
            Response<BookDto> responseBook = serviceBooks.getBook(orderDto.getBookId()).execute();
            bookDto = responseBook.body();
        } catch (Exception e) {
            log.error("Unable to request service-orders for order {}", orderId, e);
            throw new AppException("Unable to request service-books", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info(orderDto.toString());
        log.info(bookDto.toString());

        orderDto.setBook(bookDto);
        return orderDto;
    }
}
