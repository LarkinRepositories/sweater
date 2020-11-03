package com.example.sweater.service.impl;

import com.example.sweater.model.Status;
import com.example.sweater.model.User;
import com.example.sweater.repository.UserRepository;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
    }

    @Override
    public User add(String name, String password) {
        User user = new User(name, password);
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public User remove(String name) {
        return null;
    }

    @Override
    public boolean update(String name) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
