package com.petproject.pettwitter.mapper;

import com.petproject.pettwitter.dto.MessageDto;
import com.petproject.pettwitter.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDto toDto(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setContent(message.getContent());
        return messageDto;
    }

//    public Message toEntity(MessageDto messageDto) {
//        Message message = new Message();
//        message.setId(messageDto.getId());
//        message.setContent(messageDto.getContent());
//        return message;
//    }
}
