package com.petproject.pettwitter.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MessageDto {

    private Long id;
    @NotBlank(message = "Message can't be empty.")
    @Size(max = 250)
    private String content;
    private LocalDateTime createdAt;
}
