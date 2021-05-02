package com.example.demo.dto;

import lombok.Data;

/**
 * @author 陈亦铖
 */
@Data
public class HotTagDTO implements Comparable{
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority()-((HotTagDTO) o).getPriority();
    }
}
