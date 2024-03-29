package com.example.demo.enums;

public enum NotificationEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论")
    ;
    private int status;
    private String name;

    public int getType() {
        return status;
    }

    public String getName() {
        return name;
    }

    NotificationEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }
    public static String nameOfType(int type){
        for (NotificationEnum notificationEnum : NotificationEnum.values()) {
            if (notificationEnum.getType()==type){
                return notificationEnum.getName();
            }
        }
    return "";
    }

}
