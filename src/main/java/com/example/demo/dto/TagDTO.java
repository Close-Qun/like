package com.example.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 陈亦铖
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
