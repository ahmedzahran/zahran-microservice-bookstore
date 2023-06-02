package com.zahran.bookstore.service.books.mappers;

import org.mapstruct.Mapper;

import com.zahran.bookstore.service.books.dto.BookDto;
import com.zahran.bookstore.service.books.entities.Book;

@Mapper(
    componentModel = "spring",
    uses = {AuthorMapper.class}
)
public interface BookMapper {
    
    BookDto toBookDto(Book book);
}
