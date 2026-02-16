package org.bookstore.mappers;

import org.bookstore.dtos.OrderDTO;
import org.bookstore.dtos.OrderElementDTO;
import org.bookstore.entities.Order;
import org.bookstore.entities.OrderElement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "customer.orders", ignore = true)
    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDto);
}
