package org.bookstore.mappers;

import org.bookstore.dtos.OrderElementDTO;
import org.bookstore.entities.OrderElement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderElementMapper {
    OrderElementDTO toDTO(OrderElement orderElement);

    OrderElement toEntity(OrderElementDTO orderElementDto);
}
