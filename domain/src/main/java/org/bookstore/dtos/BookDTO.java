package org.bookstore.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookstore.enums.BookFormat;
import org.bookstore.enums.Genre;


import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    @NotNull
    private UUID id;

    @NotNull
    private String isbn;

    @NotNull
    private String title;

    @NotNull
    @Valid
    private AuthorDTO author;

    @NotNull
    @Valid
    private Genre genre;

    @NotNull
    private String language;

    private String publisher;

    private LocalDate publicationDate;

    @Size(max = 2000)
    private String description;

    private int pageCount;

    @NotNull
    @Valid
    private BookFormat format;
}
