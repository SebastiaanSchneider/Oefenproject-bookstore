package org.bookstore.mappers;

import org.bookstore.dtos.OrderDTO;
import org.bookstore.dtos.OrderElementDTO;
import org.bookstore.entities.Order;
import org.bookstore.entities.OrderElement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDto);

    OrderElementDTO toDTO(OrderElement element);

    OrderElement toEntity(OrderElementDTO dto);

    List<OrderElementDTO> toDTO(List<OrderElement> elements);

    List<OrderElement> toEntity(List<OrderElementDTO> dtos);
}
