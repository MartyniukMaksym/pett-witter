package com.petproject.pettwitter;

import com.petproject.pettwitter.dto.MessageDto;
import com.petproject.pettwitter.entity.Message;
import com.petproject.pettwitter.repository.MessageRepository;
import com.petproject.pettwitter.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    void createMessage_ShouldSaveMessage() {
        var testContent = "test content";

        MessageDto testMessageDto = new MessageDto();
        testMessageDto.setContent(testContent);

        Message createdMessage = new Message();
        createdMessage.setId(1L);
        createdMessage.setContent(testContent);

        when(messageRepository.save(any(Message.class))).thenReturn(createdMessage);

        var resultMessage = messageService.createMessage(testMessageDto);

        assertEquals(createdMessage.getId(), resultMessage.getId(), "Created id mismatch expectations.");
        assertEquals(createdMessage.getContent(), resultMessage.getContent(), "Created content mismatch expectations.");

    }

    @Test
    void findMessage_ShouldThrowException_WhenNotFound() {
        var id = 3L;

        when(messageRepository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException resultException  = Assertions.assertThrows(EntityNotFoundException.class, () -> messageService.getMessageById(id));
        assertEquals("Message not found with id " + id, resultException.getMessage());
    }
}
