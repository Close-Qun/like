package com.example.demo.exception;

/**
 * @author 陈亦铖
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_BOT_FOUND("页面丢失，找不到了~");


    private String message;
    private String code;



    CustomizeErrorCode(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }
}
