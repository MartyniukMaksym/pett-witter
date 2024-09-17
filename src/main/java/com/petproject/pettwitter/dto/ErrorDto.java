package com.petproject.pettwitter.dto;

import lombok.Data;

@Data
public class ErrorDto {

    private int statusCode;
    private String message;
}
