package com.example.demo.service;

import com.example.demo.dto.CommentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.dom.core.Comment;

import java.util.List;

/**
 * @author 陈亦铖
 */
@Service
public class CommentService {
    @Transactional//事务注解
    public void insert(Comment comment){

    }

    public List<CommentDTO> listByQuestionId(Integer id) {
        return null;
    }
}
