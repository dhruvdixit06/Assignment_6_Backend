package com.advancejava.assignment5.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancejava.assignment5.model.Books;
import com.advancejava.assignment5.repository.BooksRepository;

@Service
public class BookServices {
    @Autowired
    private BooksRepository booksRepository;

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Books> getBookById(int bookId) {
        return booksRepository.findById(bookId);
    }

    public Books addBook(Books book) {
        return booksRepository.save(book);
    }

    public void deleteBookById(int bookId) {
        booksRepository.deleteById(bookId);
    }

	/*
	 * public Book updateBookById(int bookId, Book book) { return bookRepository. }
	 */
}
