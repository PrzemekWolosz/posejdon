package com.przemyslawwolosz.module.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    private static final List<BooksEntity> BOOKS_ENTITIES = List.of(
            new BooksEntity().setId(1L).setTitle("Lorem 1").setAuthor("Author 1"),
            new BooksEntity().setId(2L).setTitle("Lorem 2").setAuthor("Author 2"),
            new BooksEntity().setId(3L).setTitle("Lorem 3").setAuthor("Author 3")
    );

    @GetMapping(value = "/rest/books/{id}")
    public BooksEntity getBook(@PathVariable Long id) {
        return booksRepository.findById(id).get();
    }

    @GetMapping("/rest/books")
    public List<BooksEntity> getBooks() {
        return booksRepository.findAll();
    }

    @PostMapping("/rest/books")
    public BooksEntity newBooks(@RequestBody BooksEntity booksEntity) {
        return booksRepository.saveAndFlush(booksEntity);
    }

    @DeleteMapping("/rest/books/{id}")
    public void deleteBooks(@PathVariable Long id) {
        booksRepository.deleteById(id);
    }

    @PutMapping("/rest/books/{id}")
    public BooksEntity updateBooks(@PathVariable Long id, @RequestBody BooksEntity booksEntity) {
        return booksRepository.saveAndFlush(booksEntity.setId(id));
    }
}
