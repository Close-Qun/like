package com.example.demo.service;

import com.example.demo.dto.PaginationDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.exception.CustomizeErrorCode;
import com.example.demo.exception.CustomizeException;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈亦铖
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public PaginationDTO List(Integer page, Integer size) {
        QuestionDTO questionDTO=new QuestionDTO();
        Integer totalCount=questionMapper.count();
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage,page,size);
        Integer offset=size*(page-1);
        List<Question> questionList= questionMapper.List(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question : questionList) {

            BeanUtils.copyProperties(question,questionDTO);
            User user=userMapper.findById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestion(questionDTOList);


        return  paginationDTO;
    }

    public PaginationDTO ListByUserId(Integer userId, Integer page, Integer size) {
        QuestionDTO questionDTO=new QuestionDTO();
        Integer totalCount=questionMapper.count();
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        paginationDTO.setPagination(totalPage,page,size);
        Integer offset=size*(page-1);
        List<Question> questionList= questionMapper.ListByUserId(userId,page,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question : questionList) {

            BeanUtils.copyProperties(question,questionDTO);
            User user=userMapper.findById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestion(questionDTOList);


        return  paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question= questionMapper.getById(id);
        QuestionDTO questionDTO=new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user=userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId()==null){
            questionMapper.insert(question);
        }else{
            question.setGmtModified(question.getGmtModified());
            questionMapper.update(question);
            throw new CustomizeException(CustomizeErrorCode.QUESTION_BOT_FOUND);
        }
    }

    public void incView(Integer id) {
        Question question = questionMapper.getById(id);
        question.setViewCount(question.getViewCount()+1);
        questionMapper.update(question);
    }
}
