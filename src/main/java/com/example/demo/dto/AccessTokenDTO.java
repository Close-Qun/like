package com.example.demo.dto;

import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
