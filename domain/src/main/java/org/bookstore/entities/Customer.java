package org.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private LocalDate birthDate;

    @Column
    private String email;

    @Column
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
}
