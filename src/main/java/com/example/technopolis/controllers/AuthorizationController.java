package com.example.technopolis.controllers;

import com.example.technopolis.model.User;
import com.example.technopolis.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * @author Aleksey Antufev
 */
@RestController
@RequestMapping("/")
public class AuthorizationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public ModelAndView signUp() {
        return new ModelAndView("signup");
    }

    @GetMapping("/signin")
    public ModelAndView signIn() {
        return new ModelAndView("signin");
    }

    @PutMapping
    public User registration(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping
    public boolean login(@RequestBody User user) {
        User checkUser = userRepository.findOne(user.getEmail());
        return Objects.equals(user, checkUser);
    }
}