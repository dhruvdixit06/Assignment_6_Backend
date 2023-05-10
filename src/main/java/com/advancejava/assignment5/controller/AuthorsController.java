package com.advancejava.assignment5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advancejava.assignment5.model.Authors;
import com.advancejava.assignment5.services.AuthorServices;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {

    @Autowired
    private AuthorServices authorService;

    @GetMapping
    public List<Authors> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable("id") int authorId) {
        Optional<Authors> author = authorService.getAuthorById(authorId);
        return (ResponseEntity<Authors>) author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Authors> addAuthor(@RequestBody Authors author) {
        Authors savedAuthor = authorService.addAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAuthorById(@PathVariable("id") int authorId) {
        authorService.deleteAuthorById(authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}