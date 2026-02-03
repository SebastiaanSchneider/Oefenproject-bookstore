package org.bookstore.controllers;

import lombok.RequiredArgsConstructor;
import org.bookstore.dtos.BookDTO;
import org.bookstore.services.CatalogueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * REST Controller for handling incoming catalogue searches
 */
@RestController
@RequestMapping("/api/v1/catalogue")
@RequiredArgsConstructor
public class CatalogueController {
// get post put delete
    private final CatalogueService catalogueService;

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<BookDTO> getBook(@PathVariable UUID id) {
        return catalogueService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
