package com.example.training.services;

import com.example.training.models.Author;
import com.example.training.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public void create(Author author) {
        authorRepository.save(author);
    }

    public List<Author> readAll() {
        return authorRepository.findAll();
    }

    public Author read(Long id) {
        return authorRepository.getById(id);
    }

    public boolean update(Author author, Long id) {
        if (authorRepository.existsById(id)) {
            author.setId(id);
            authorRepository.save(author);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
