package com.example.sweater.service;

import com.example.sweater.model.User;

import java.util.List;

public interface UserService {
    User find(User user);
    void add(User user);
    User remove(String name);
    boolean update(String name);
    List<User> findAll();
}
