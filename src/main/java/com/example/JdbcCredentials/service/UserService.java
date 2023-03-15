package com.example.JdbcCredentials.service;

import com.example.JdbcCredentials.entity.User;
import com.example.JdbcCredentials.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        return password.equals(user.getPassword());
    }
}

