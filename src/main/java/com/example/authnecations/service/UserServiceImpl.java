package com.example.authnecations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authnecations.repo.UserRepo;
import com.example.authnecations.entity.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepo.save(user);
    }

}