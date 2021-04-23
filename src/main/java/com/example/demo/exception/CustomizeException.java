package com.example.demo.exception;

/**
 * @author 陈亦铖
 */

public class CustomizeException extends RuntimeException{
    private String message;

    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(CustomizeErrorCode questionBotFound) {
        this.message=questionBotFound.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
