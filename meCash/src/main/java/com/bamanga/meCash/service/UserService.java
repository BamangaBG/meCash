package com.bamanga.meCash.service;

import com.bamanga.meCash.dto.UserDto;
import com.bamanga.meCash.entity.User;
import com.bamanga.meCash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use.");
        }

        User user = new User();
        user.setAccountHolderName(userDto.getAccountHolderName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encodePassword(userDto.getPassword())); // Encrypt the password
        return userRepository.save(user);
    }

    private String encodePassword(String password) {
        // Use a password encoder (e.g., BCryptPasswordEncoder)
        return new BCryptPasswordEncoder().encode(password);
    }
}
