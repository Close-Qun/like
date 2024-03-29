package com.example.demo.dto;

import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
