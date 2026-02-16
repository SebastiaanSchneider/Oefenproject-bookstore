package org.bookstore.mappers;

import org.bookstore.dtos.CustomerDTO;
import org.bookstore.dtos.OrderElementDTO;
import org.bookstore.entities.Customer;
import org.bookstore.entities.OrderElement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "orders.inventoryItems", ignore = true)
    CustomerDTO toCustomerDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDto);
}
