package com.zahran.bookstore.service.books.services;

import org.springframework.stereotype.Service;

import com.zahran.bookstore.service.books.dto.BookDto;
import com.zahran.bookstore.service.books.exceptions.AppException;
import com.zahran.bookstore.service.books.mappers.BookMapper;
import com.zahran.bookstore.service.books.repositories.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {
    
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDto getBook(Long bookId){

        log.info("inside service books with book id" + bookId);
        BookDto bookDto = bookRepository.findById(bookId)
                            .map(bookMapper::toBookDto)
                            .orElseThrow(() -> new AppException("no nook found with id" + bookId,HttpStatus.NOT_FOUND));
        
        log.info(bookDto.toString());                  
        log.info("after find book" + bookId);
        
        return bookDto;
    }

}
