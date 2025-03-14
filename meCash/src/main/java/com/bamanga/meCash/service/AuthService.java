package com.bamanga.meCash.service;

import com.bamanga.meCash.dto.LoginDto;
import com.bamanga.meCash.entity.User;
import com.bamanga.meCash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService
{
    private UserRepository userRepository;

    public String authenticate(LoginDto loginDto)
    {
        // Validate user credentials and generate JWT
        User user = userRepository.findByEmail(loginDto.getUser())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordMatches(loginDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return generateToken(user);
    }

    private boolean passwordMatches(String password, String password1)
    {
        return password.equals(password1);
    }

    private String generateToken(User user)
    {
        return null;
//        return Jwts.builder()
//                .setSubject(user.getEmail())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1-day validity
//                .signWith(SignatureAlgorithm.HS256, "secretKey") // Use env variables for secret
//                .compact();
    }
}
