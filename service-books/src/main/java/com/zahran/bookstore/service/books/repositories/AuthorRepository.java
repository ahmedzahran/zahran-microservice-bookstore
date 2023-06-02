package com.zahran.bookstore.service.books.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zahran.bookstore.service.books.entities.Author;


public interface AuthorRepository extends JpaRepository<Author,Long>{
    
    Optional<Author> findByBooksId(long bookId);
}
