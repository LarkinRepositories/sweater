package com.example.sweater.controller;

import com.example.sweater.model.Role;
import com.example.sweater.model.Status;
import com.example.sweater.model.User;
import com.example.sweater.repository.UserRepository;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(User user, Map<String, Object> model) {
        System.out.println(user.toString());
        if (userService.find(user) != null) {
            model.put("messages", "Такой пользователь уже есть!");
            return "signup";
        }
        userService.add(user);
        System.out.println(userService.find(user));
        return "redirect:/login";
    }
}
