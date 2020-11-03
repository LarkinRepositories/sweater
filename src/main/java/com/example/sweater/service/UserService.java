package com.example.sweater.service;

import com.example.sweater.model.User;

import java.util.List;

public interface UserService {
    User add(String name, String password);
    User remove(String name);
    boolean update(String name);
    List<User> findAll();
}
