package com.petproject.pettwitter.service;

import com.petproject.pettwitter.entity.Message;
import com.petproject.pettwitter.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    public Message createMessage(String userInput) {
        log.info("Started creating a new message.");
        Message message = new Message();
        message.setContent(userInput);
        return messageRepository.save(message);
    }

    public Message getMessageById(Long id) {
        log.info("Getting message by message Id.");
        return messageRepository.getReferenceById(id);
    }
}
