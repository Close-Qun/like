package com.example.demo.exception;

/**
 * @author 陈亦铖
 */

public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;

    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(CustomizeErrorCode questionBotFound) {
        this.message=questionBotFound.getMessage();
        this.code=questionBotFound.getCode();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
