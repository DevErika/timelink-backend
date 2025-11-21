package com.timelink.timelink.service.impl;

import com.timelink.timelink.exceptions.EmailAlreadyExistsException;
import com.timelink.timelink.model.User;
import com.timelink.timelink.repository.UserRepository;
import com.timelink.timelink.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {

        // check email duplication
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
        }

        // encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // default credits
        if (user.getCredits() == null) {
            user.setCredits(0);
        }

        // default role
        if (user.getRole() == null) {
            user.setRole(com.timelink.timelink.model.Role.USER);
        }

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
