package com.example.sweater.service;

import com.example.sweater.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User find(User user);
    void add(User user);
    User remove(String name);
    boolean update(String name);
    List<User> findAll();
}
