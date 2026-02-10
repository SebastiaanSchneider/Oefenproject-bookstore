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
@Table(name = "authors")
public class Author {
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

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
