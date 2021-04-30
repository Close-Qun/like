package com.example.demo.mapper;

import com.example.demo.model.Question;

import java.util.List;

/**
 * @author 陈亦铖
 */
public interface QuestionExtMapper {
    List<Question> selectRelated(Question question);
}
