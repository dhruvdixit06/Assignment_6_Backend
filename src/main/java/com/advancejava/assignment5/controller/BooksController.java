package com.advancejava.assignment5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.advancejava.assignment5.model.Authors;
import com.advancejava.assignment5.model.Books;
import com.advancejava.assignment5.services.AuthorServices;
import com.advancejava.assignment5.services.BookServices;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired
	private BookServices bookService;

	@Autowired
	private AuthorServices authorService;

	@GetMapping("")
	public ResponseEntity<List<Books>> getAllBooks() {
		List<Books> books = bookService.getAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<Books> getBookById(@PathVariable int bookId) {
		Optional<Books> book = bookService.getBookById(bookId);
		return (ResponseEntity<Books>) book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public Books addBook(@RequestBody Books book) {
		try {
			Authors author = authorService.getAuthorById(book.getAuthor().getAuthorid())
					.orElseThrow(() -> new AttributeNotFoundException("Author not found with id " + book.getAuthor().getAuthorid()));book.setAuthor(author);
					} catch (AttributeNotFoundException e) {
						e.printStackTrace();
						}
		return bookService.addBook(book);
		}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Books updatedBook) {
		Optional<Books> optionalBook = bookService.getBookById(id);
		if (!optionalBook.isPresent()) {
			return ResponseEntity.notFound().build();
			}
		Books book = optionalBook.get();
		book.setName(updatedBook.getName());
		book.setAuthor(updatedBook.getAuthor());
		bookService.addBook(book);
		return ResponseEntity.ok(book);
		}

	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
		bookService.deleteBookById(bookId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
