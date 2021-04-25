package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
