package org.bookstore.mappers;

import org.bookstore.dtos.CustomerDTO;
import org.bookstore.dtos.OrderElementDTO;
import org.bookstore.entities.Customer;
import org.bookstore.entities.OrderElement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toCustomerDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDto);

    OrderElementDTO toDTO(OrderElement element);

    OrderElement toEntity(OrderElementDTO dto);
}
