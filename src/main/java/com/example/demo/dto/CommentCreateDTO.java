package com.example.demo.dto;

import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class CommentCreateDTO {
    private Long parent_Id;
    private String content;
    private Integer type;
}
