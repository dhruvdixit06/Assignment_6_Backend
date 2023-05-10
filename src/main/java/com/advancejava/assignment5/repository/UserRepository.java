package com.advancejava.assignment5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.advancejava.assignment5.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
