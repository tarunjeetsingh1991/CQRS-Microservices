package com.banking.service;

import com.banking.dto.LoginRequest;
import com.banking.dto.RegisterRequest;
import com.banking.entity.User;
import com.banking.repository.UserRepository;
import com.banking.config.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.banking.entity.Role;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void registerUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    public String authenticateUser(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent() && passwordEncoder.matches(request.getPassword(), userOptional.get().getPassword())) {
            return jwtUtil.generateToken(userOptional.get().getEmail());
        }
        throw new RuntimeException("Invalid credentials");
    }
}