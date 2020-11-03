package com.example.sweater.service;

import com.example.sweater.model.Message;

import java.util.List;

public interface MessageService {
    Message addMessage(String text, String tag);
    boolean update(Message message);
    boolean delete(Message message);
    Message getMessage(Message message);
    List<Message> findAll();
    List<Message> filterByText(String text);
}
