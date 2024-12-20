package com.petproject.pettwitter.controller;

import com.petproject.pettwitter.dto.MessageDto;
import com.petproject.pettwitter.entity.Message;
import com.petproject.pettwitter.mapper.MessageMapper;
import com.petproject.pettwitter.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Autowired
    public MessageController(MessageService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @PostMapping("/new")
    public MessageDto addMessage(@Valid @RequestBody MessageDto message) {
        var returnedMessage = messageService.createMessage(message);
        return messageMapper.toDto(returnedMessage);
    }

    @GetMapping("/{id}")
    public MessageDto getMessageById(@PathVariable Long id) {
        var returnedMessage = messageService.getMessageById(id);
        return messageMapper.toDto(returnedMessage);
    }

    @PutMapping("/{id}")
    public MessageDto editMessage(@PathVariable Long id, @Valid @RequestBody MessageDto messageDto) {
        var editMessage = messageService.editMessage(id, messageDto);
        return messageMapper.toDto(editMessage);
    }

    @DeleteMapping("/{id}")
    public MessageDto deleteMessage(@PathVariable Long id) {
        return messageMapper.toDto(messageService.deleteMessage(id));

    }

    @GetMapping("/all")
    public List<MessageDto> getAllMessages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Message> messagePage = messageService.getAllMessages(page, size);
        return messagePage.stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList());
    }
}
