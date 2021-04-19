package com.example.demo.model;

import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
}
