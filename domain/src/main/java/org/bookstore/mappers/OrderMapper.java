package org.bookstore.mappers;

import org.bookstore.dtos.OrderDTO;
import org.bookstore.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "customer.orders", ignore = true)
    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDto);
}
