package com.karamanmert.user.service.impl;

import com.karamanmert.user.entity.User;
import com.karamanmert.user.repository.UserRepository;
import com.karamanmert.user.service.spec.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Component
@RequiredArgsConstructor
public class UserValidator implements Validator<User> {

    private final UserRepository userRepository;

    @Override
    public void isValidForCreate(User user) {
        this.checkEmailIsUnique(user.getEmail());
        this.checkUsernameIsUnique(user.getUsername());
    }

    @Override
    public void isValidForUpdate(User user) {
        this.checkEmailExists(user.getEmail());
    }

    private void checkEmailExists(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
    }

    private void checkUsernameIsUnique(String username) {
        boolean exists = userRepository.existsByUsername(username);
        if (exists) {
            throw new RuntimeException("Username already exists");
        }
    }

    private void checkEmailIsUnique(String email) {
        boolean exists = userRepository.existsByEmail(email);
        if (exists) {
            throw new RuntimeException("Email already exists");
        }
    }
}
