package com.example.training.controllers;

import com.example.training.models.Book;
import com.example.training.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/book/{id}")
    Optional<Book> getBook(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @PostMapping("/book")
    Book newBook(@RequestParam String name,
                 @RequestParam String description,
                 @RequestParam String author)
    {
        Book book = new Book(name, description, author);
        return repository.save(book);
    }

    @DeleteMapping("/book/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/books")
    List<Book> getAllBooks()
    {
        return (List<Book>) repository.findAll();
    }
}
