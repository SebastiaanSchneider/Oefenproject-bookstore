package org.bookstore.mappers;

import org.bookstore.dtos.OrderElementDTO;
import org.bookstore.entities.OrderElement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderElementMapper {
    @Mapping(target = "order.inventoryItems", ignore = true)
    OrderElementDTO toDTO(OrderElement orderElement);

    OrderElement toEntity(OrderElementDTO orderElementDto);
}
