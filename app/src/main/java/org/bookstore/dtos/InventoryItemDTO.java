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
public class InventoryItemDTO {
    @NotNull
    private UUID id;

    @NotNull
    @Valid
    private BookDTO book;

    @NotNull
    private float price;

    @NotNull
    private int storeStock;

    @NotNull
    private int warehouseStock;
}
