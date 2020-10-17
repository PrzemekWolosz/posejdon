package com.przemyslawwolosz.module.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BooksController {

    private static final List<BooksEntity> BOOKS_ENTITIES = List.of(
            new BooksEntity().setId(1L).setTitle("Lorem 1").setAuthor("Author 1"),
            new BooksEntity().setId(2L).setTitle("Lorem 2").setAuthor("Author 2"),
            new BooksEntity().setId(3L).setTitle("Lorem 3").setAuthor("Author 3")
    );

    @GetMapping(value = "/rest/books/{id}")
    public BooksEntity getBook(@PathVariable Long id) {
        return BOOKS_ENTITIES
                .stream().filter(book -> book.getId().equals(id)).findFirst().get();
    }

    @GetMapping("/rest/books")
    public List<BooksEntity> getBooks() {
        return BOOKS_ENTITIES;
    }
}
