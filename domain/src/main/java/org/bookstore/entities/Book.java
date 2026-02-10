package org.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;
import org.bookstore.enums.BookFormat;
import org.bookstore.enums.Genre;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Entity representing a book
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 17)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false, length = 10)
    private String language;

    @Column
    private String publisher;

    @Column
    private LocalDate publicationDate;

    @Column(length = 2000)
    private String description;

    @Column
    private int pageCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookFormat format;
}
