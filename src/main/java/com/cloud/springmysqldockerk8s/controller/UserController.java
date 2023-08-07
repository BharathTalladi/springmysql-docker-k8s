package com.cloud.springmysqldockerk8s.controller;

import com.cloud.springmysqldockerk8s.entity.User;
import com.cloud.springmysqldockerk8s.exception.ResourceNotFoundException;
import com.cloud.springmysqldockerk8s.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get all Users
    @GetMapping
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    //get User by Id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id:" + userId));
    }

    //create User
    @PostMapping
    public User createUser(@RequestBody  User user) {
        return this.userRepository.save(user);
    }

    //update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") long userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id:" + userId));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return this.userRepository.save(existingUser);
    }

    //delete User by Id
    @DeleteMapping("/{id}")
    public ResponseEntity deleterUserById(@PathVariable(value = "id") long userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id:" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}