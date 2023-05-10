package com.advancejava.assignment5.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancejava.assignment5.model.Authors;
import com.advancejava.assignment5.model.Books;
import com.advancejava.assignment5.repository.AuthorsRepository;

@Service
@Transactional
public class AuthorServices {

	@Autowired
	private AuthorsRepository authorsRepository;

	public List<Authors> getAllAuthors() {
		return authorsRepository.findAll();
	}

	
	 public Optional<Authors> getAuthorById(int authorId) { 
		 return authorsRepository.findById(authorId); 
	 }


	public Authors addAuthor(Authors author) {
		return authorsRepository.save(author);
	}

	public void deleteAuthorById(int authorId) {
		authorsRepository.deleteById(authorId);
	}


	public Optional<Books> findById(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}
}
