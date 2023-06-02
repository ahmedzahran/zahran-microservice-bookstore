package com.zahran.bookstore.backend.user.services;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zahran.bookstore.backend.user.dto.BookDto;
import com.zahran.bookstore.backend.user.dto.PriceDto;
import com.zahran.bookstore.backend.user.exceptions.AppException;
import com.zahran.bookstore.backend.user.retrofit.ServiceBooks;
import com.zahran.bookstore.backend.user.retrofit.ServicePrices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

@RequiredArgsConstructor
@Slf4j
@Service
public class BookService {
    
    private final ServiceBooks serviceBooks;
    private final ServicePrices servicePrices;


    public PriceDto getBookWithPrice(long bookId){
        
        BookDto book;
        try {
            Response<BookDto> bookResponse = serviceBooks.getBook(bookId).execute();
            log.info("response" + bookResponse.toString());

            log.info("before get book");
            book = bookResponse.body();
            log.info("after get book");
            log.info(book.toString());
        } catch (IOException e) {
            log.error("Unable to request service-books for book {}", e);
            throw new AppException("Unable to request service-books", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        PriceDto price;
        try {
            Response<PriceDto> priceResponse = servicePrices.getPrice(bookId).execute();
            log.info("response" + priceResponse.toString());
            log.info("before get price");
            price = priceResponse.body();
            log.info("after get price");
            log.info(price.toString());
        } catch (IOException e) {
            log.error("Unable to request service-prices for book {}", e);
            throw new AppException("Unable to request service-prices", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        price.setBook(book);
        return price;
    }
}
