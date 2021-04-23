package com.example.demo.model;

import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreat;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
