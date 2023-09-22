package com.example.sanstrick.controller;

import com.example.sanstrick.entity.User;
import com.example.sanstrick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }

    // Update user by ID
    @PutMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User user) {
        user.setUserId(userId);
        return userRepository.save(user);
    }

    // Delete user by ID
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}

