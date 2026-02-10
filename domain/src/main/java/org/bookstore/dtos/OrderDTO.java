package org.bookstore.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookstore.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @NotNull
    private long id;

    @NotNull
    private CustomerDTO customer;

    @NotNull
    @Valid
    private OrderStatus status;

    @NotNull
    private LocalDate createdAt;

    private List<OrderElementDTO> inventoryItems = new ArrayList<>();
}
