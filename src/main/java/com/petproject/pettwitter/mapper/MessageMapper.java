package com.petproject.pettwitter.mapper;

import com.petproject.pettwitter.dto.MessageDto;
import com.petproject.pettwitter.entity.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageMapper {

    public MessageDto toDto(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setContent(message.getContent());
        messageDto.setCreatedAt(message.getCreatedAt());
        return messageDto;
    }

    public List<MessageDto> toDto(List<Message> messages) {
        return messages.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
