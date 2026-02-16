package org.bookstore.mappers;

import org.bookstore.dtos.AuthorDTO;
import org.bookstore.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
//    @Mapping(target = "books", ignore = true) // todo not sure
    AuthorDTO toDTO(Author author);

    Author toEntity(AuthorDTO authorDto);
}
