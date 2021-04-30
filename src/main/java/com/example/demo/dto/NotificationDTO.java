package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private User notifier;
    private String outerTitle;
    private String type;
}
