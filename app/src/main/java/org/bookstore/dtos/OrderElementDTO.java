package org.bookstore.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderElementDTO {
    @NotNull
    private UUID id;

    @NotNull
    @Valid
    private OrderDTO order;

    @NotNull
    @Valid
    private BookDTO book;

    @NotNull
    private int quantity;

    @NotNull
    private float price;
}
