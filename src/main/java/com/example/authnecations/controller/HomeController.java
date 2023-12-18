package com.example.authnecations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.authnecations.entity.User;
import com.example.authnecations.service.UserService;

// import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String Register() {
        return "register";
    }

    @GetMapping("/signin")
    public String Signin() {
        return "login";
    }

    @GetMapping("/profile")
    public String Profile() {

        return "profile";

    }

    @PostMapping("/register")
    public String RegisterPost(@ModelAttribute User user) {
        System.out.println(user);
        User us = userService.saveUser(user);

        if (us != null) {
            // session.setAttribute("message", "User added successfully");
            System.out.println("User saved");
        } else {
            // session.setAttribute("message", "User not added");
            System.out.println("User not saved");
        }
        return "redirect:/register";
    }
}