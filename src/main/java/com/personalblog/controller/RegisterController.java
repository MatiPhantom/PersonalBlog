package com.personalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personalblog.exception.RegisterException;
import com.personalblog.persistence.model.User;
import com.personalblog.service.AutheticationService;
import com.personalblog.service.SessionService;
import com.personalblog.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegisterController {
    @Autowired
    private SessionService sessionService;

    @Autowired
    private AutheticationService authService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "register/index"; // Return registration form view
    }

    @PostMapping
    public String saveUser(User user) {
        try {
            userService.registerUser(user);
            sessionService.setUser(user.getId());
            log.info("Registration successful for user: {}", user.getEmail());
            return "redirect:/blog";
        } catch (RegisterException e) {
            log.error("Registration failed: {}", e.getMessage());
        }
        return "redirect:/blog"; // Redirect to login after successful registration
    }

    // Additional methods for handling registration logic can be added here

}
