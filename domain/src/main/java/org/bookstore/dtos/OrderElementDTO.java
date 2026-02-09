package org.bookstore.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderElementDTO {
    @NotNull
    private long id;

    @NotNull
    @Valid
    private org.bookstore.dtos.OrderDTO order;

    @NotNull
    @Valid
    private BookDTO book;

    @NotNull
    private int quantity;

    @NotNull
    private float price;
}
