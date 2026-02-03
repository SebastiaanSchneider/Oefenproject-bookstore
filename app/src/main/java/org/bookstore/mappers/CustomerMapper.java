package org.bookstore.mappers;

import org.bookstore.dtos.CustomerDTO;
import org.bookstore.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toCustomerDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDto);
}
