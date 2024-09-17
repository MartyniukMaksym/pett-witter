package com.petproject.pettwitter.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class MessageDto {

    private Long id;
    @NotBlank(message = "Message can't be empty.")
    @Size(max = 250)
    private String content;
}
