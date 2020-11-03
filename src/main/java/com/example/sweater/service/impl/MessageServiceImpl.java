package com.example.sweater.service.impl;

import com.example.sweater.model.Message;
import com.example.sweater.model.Status;
import com.example.sweater.repository.MessageRepository;
import com.example.sweater.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message addMessage(Message message) {
        message.setCreated(LocalDateTime.now());
        message.setUpdated(LocalDateTime.now());
        message.setStatus(Status.ACTIVE);
        return messageRepository.save(message);
    }

    @Override
    public boolean update(Message message) {
        return false;
    }

    @Override
    public boolean delete(Message message) {
        return false;
    }

    @Override
    public Message getMessage(Message message) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> filterByText(String text) {
        return messageRepository.findAllByTextContains(text);
    }
}
