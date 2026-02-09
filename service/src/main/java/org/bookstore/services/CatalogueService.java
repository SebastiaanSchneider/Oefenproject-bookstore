package org.bookstore.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bookstore.daos.CatalogueRepository;
import org.bookstore.dtos.BookDTO;
import org.bookstore.mappers.BookMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service to handle incoming catalogue searches and forward them to the warehouse api
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogueService {

    private final CatalogueRepository catalogueRepository;
    private final BookMapper bookMapper;

    public Optional<BookDTO> getById(UUID id) {
        return catalogueRepository.findById(id).map(bookMapper::toDTO);
    }
}
