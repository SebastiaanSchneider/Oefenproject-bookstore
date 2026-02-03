package org.bookstore.mappers;

import org.bookstore.dtos.OrderDTO;
import org.bookstore.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDto);
}
