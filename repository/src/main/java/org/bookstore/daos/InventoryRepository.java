package org.bookstore.daos;

import org.bookstore.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<InventoryItem, UUID> {
}
