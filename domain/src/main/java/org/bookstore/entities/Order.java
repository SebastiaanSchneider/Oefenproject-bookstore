package org.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;
import org.bookstore.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity representing an order
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderElement> inventoryItems = new ArrayList<>();

    @Transient
    private float getTotalPrice() {
        return  inventoryItems.stream().map(OrderElement::getElementPrice).reduce(0.0f, Float::sum);
    }
}
