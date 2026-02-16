package org.bookstore.mappers;

import org.bookstore.dtos.BookDTO;
import org.bookstore.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "author.books", ignore = true)  // ignore to avoid recursion
    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDto);
}
