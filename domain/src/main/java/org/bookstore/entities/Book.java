package org.bookstore.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bookstore.enums.BookFormat;
import org.bookstore.enums.Genre;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Entity representing a book
 */
@Data
@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "catalogue")
public class Book {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 17)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = false)
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
