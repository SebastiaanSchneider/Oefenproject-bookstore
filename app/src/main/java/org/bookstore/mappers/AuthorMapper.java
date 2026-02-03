package org.bookstore.mappers;

import org.bookstore.dtos.AuthorDTO;
import org.bookstore.entities.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO toDTO(Author author);

    Author toEntity(AuthorDTO authorDto);
}
