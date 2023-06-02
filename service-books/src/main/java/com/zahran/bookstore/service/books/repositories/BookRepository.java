package com.zahran.bookstore.service.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zahran.bookstore.service.books.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    
}
