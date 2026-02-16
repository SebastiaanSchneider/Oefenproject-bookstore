package org.bookstore.daos;

import org.bookstore.entities.OrderElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderElementRepository extends JpaRepository<OrderElement, Long> {
}
