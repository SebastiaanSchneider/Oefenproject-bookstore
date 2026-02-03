package org.bookstore.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class OrderElement {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private float price;

    public float getElementPrice() {
        return price * quantity;
    }
}
