package org.bookstore.mappers;

import org.bookstore.dtos.BookDTO;
import org.bookstore.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDto);
}
