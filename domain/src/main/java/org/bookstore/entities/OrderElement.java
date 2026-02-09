package org.bookstore.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderElement {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private float price;

    public float getElementPrice() {
        return price * quantity;
    }
}
