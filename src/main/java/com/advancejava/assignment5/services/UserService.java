package com.advancejava.assignment5.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancejava.assignment5.model.User;
import com.advancejava.assignment5.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(int Id) {
		return userRepository.findById(Id);
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserByUsername(String username) {
	    return userRepository.findByUsername(username);
	}


	public void deleteUserById(int UserID) {
		userRepository.deleteById(UserID);
	}

}