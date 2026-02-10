package org.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Represents the data of a Book in the inventory
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "inventory")
public class InventoryItem {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int storeStock;

    @Column(nullable = false)
    private int warehouseStock;

    public void removeStoreStock(int amount) {
        if (amount <= 0 || amount > storeStock) {
            throw new IllegalArgumentException("Invalid removal amount");
        }
        this.storeStock -= amount;
    }

    public void removeWarehouseStock(int amount) {
        if (amount <= 0 || amount > warehouseStock) {
            throw new IllegalArgumentException("Invalid removal amount");
        }
        this.warehouseStock -= amount;
    }
}
