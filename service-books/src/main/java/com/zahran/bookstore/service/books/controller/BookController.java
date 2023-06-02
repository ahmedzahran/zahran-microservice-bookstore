package com.zahran.bookstore.service.books.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zahran.bookstore.service.books.dto.BookDto;
import com.zahran.bookstore.service.books.services.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {
    
    private final BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long bookId){
        log.info("Looking for book {}", bookId);
        return ResponseEntity.ok(bookService.getBook(bookId));
    }
}
