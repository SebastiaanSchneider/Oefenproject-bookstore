package org.bookstore.mappers;

import org.bookstore.dtos.InventoryItemDTO;
import org.bookstore.entities.InventoryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryItemMapper {
    @Mapping(target = "book.id", source = "book.id")
    @Mapping(target = "book.title", source = "book.title")
    InventoryItemDTO toDTO(InventoryItem inventoryItem);

    InventoryItem toEntity(InventoryItemDTO inventoryItemDto);
}
