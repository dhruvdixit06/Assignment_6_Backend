package com.advancejava.assignment5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.advancejava.assignment5.model.Authors;

public interface AuthorsRepository extends JpaRepository<Authors, Integer>{

}
