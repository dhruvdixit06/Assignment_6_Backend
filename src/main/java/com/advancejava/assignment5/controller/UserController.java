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

import com.advancejava.assignment5.model.User;
import com.advancejava.assignment5.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public ResponseEntity<List<User>> getallUser() {
		List<User> user = userService.getAllUsers();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getLibrarianById(@PathVariable int userId) {
		Optional<User> user = userService.getUserById(userId);
		return (ResponseEntity<User>) user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/*
	 * @GetMapping("/{username}") public ResponseEntity<Librarian>
	 * getLibrarianByUsername(@PathVariable String username) { Optional<Librarian>
	 * librarian = librarianService.getLibrarianByUsername(username); return
	 * (ResponseEntity<Librarian>) librarian.map(value -> new
	 * ResponseEntity<>(value, HttpStatus.OK)) .orElseGet(() -> new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND)); }
	 */

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userService.addUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
	    Optional<User> user = userService.getUserByUsername(username);
	    return (ResponseEntity<User>) user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}



	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUserById(@PathVariable int userId) {
		userService.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}