package com.advancejava.assignment5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advancejava.assignment5.model.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
