package com.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.dao.UserReopsitory;
import com.quiz.entities.User;

@Controller
public class SignupController {
     @Autowired
    UserReopsitory userReopsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/save-user")
    public String saveUser(
            @RequestParam String username,
            @RequestParam String password) {

        User user = new User();

        user.setUsername(username);

        user.setPassword(passwordEncoder.encode(password));

        user.setRole("USER");

        userReopsitory.save(user);

        return "redirect:/login";
    }
}
