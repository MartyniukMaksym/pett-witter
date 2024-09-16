package com.petproject.pettwitter.controller;

import com.petproject.pettwitter.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/new")
    public String addMessage(@RequestBody String message) {

        var returnedMessage = messageService.createMessage(message);
        return "Received message Id: " + returnedMessage.getId() + ", and content: " + returnedMessage.getContent() + ".";
    }

    @GetMapping()
    public String getMessageById(@RequestParam Long id) {
        var returnedMessage = messageService.getMessageById(id);
        return returnedMessage.getContent();
    }

    public List<String> getAllMessages() {
        return Collections.emptyList();
    }
}
