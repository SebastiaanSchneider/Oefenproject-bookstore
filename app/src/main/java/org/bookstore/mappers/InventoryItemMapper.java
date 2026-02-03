package org.bookstore.mappers;

import org.bookstore.dtos.InventoryItemDTO;
import org.bookstore.entities.InventoryItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryItemMapper {
    InventoryItemDTO toDTO(InventoryItem inventoryItem);

    InventoryItem toEntity(InventoryItemDTO inventoryItemDto);
}
