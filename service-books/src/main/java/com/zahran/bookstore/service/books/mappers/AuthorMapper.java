package com.zahran.bookstore.service.books.mappers;

import org.mapstruct.Mapper;

import com.zahran.bookstore.service.books.dto.AuthorDto;
import com.zahran.bookstore.service.books.entities.Author;

@Mapper(
    componentModel = "spring"
)
public interface AuthorMapper {
    
    AuthorDto toAuthorDto(Author author);
}
