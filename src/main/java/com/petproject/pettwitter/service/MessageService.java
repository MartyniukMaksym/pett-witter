package com.petproject.pettwitter.service;

import com.petproject.pettwitter.dto.MessageDto;
import com.petproject.pettwitter.entity.Message;
import com.petproject.pettwitter.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    public Message createMessage(MessageDto messageDto) {
        log.info("Started creating a new message.");
        Message message = new Message();
        message.setContent(messageDto.getContent());
        return messageRepository.save(message);
    }

    @Transactional
    public Message getMessageById(Long id) {
        log.info("Getting message by message Id.");
        return messageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Message not found with id " + id));
    }

    @Transactional
    public Message editMessage(Long id, MessageDto messageDto) {
        log.info("Editing message by message Id.");
        var existingMessage = getMessageById(id);
        existingMessage.setContent(messageDto.getContent());
        return messageRepository.save(existingMessage);
    }

    @Transactional
    public Message deleteMessage(Long id) {
        log.info("Deleting message by message Id.");
        Message existingMessage = getMessageById(id);
        messageRepository.deleteById(id);
        return existingMessage;
    }
}
