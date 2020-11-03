package com.example.sweater.repository;

import com.example.sweater.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    /**
     * Returns all messages created at a specific date time
     * @param created Time and date when message was created
     * @return list of all messages created at a specific date time
     */
    List<Message> findAllByCreated(LocalDateTime created);

    /**
     * Searches database to find all messages text contains @text
     * @param text phrase to search
     * @return list of all messages text contains @text
     */
    List<Message> findAllByTextContains(String text);
}
