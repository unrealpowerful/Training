package com.example.training.services;

import com.example.training.models.Book;
import com.example.training.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void create(Book book) {
        bookRepository.save(book);
    }

    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public Book read(Long id) {
        return bookRepository.getById(id);
    }

    public boolean update(Book book, Long id) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
