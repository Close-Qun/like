package com.example.demo.exception;

/**
 * @author 陈亦铖
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_BOT_FOUND(2001,"页面丢失，找不到了~"),
    TARGET_PARAM_NOT_FOUND(2002,"没找到"),
    NO_LOGIN(2003,"未登录");
    ;



    private Integer code;
    private String message;



    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
