package com.example.bookstore.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    private BookRepository repository;

    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId).orElse(null);
    }
}