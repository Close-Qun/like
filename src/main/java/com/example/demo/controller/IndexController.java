package com.example.demo.controller;

import com.example.demo.cache.HotTagCache;
import com.example.demo.dto.PaginationDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author 陈亦铖
 */
@Controller
public class IndexController {
    @Autowired
    private HotTagCache hotTagCache;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hello(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page",defaultValue = "1")Integer page,
                        @RequestParam(name="size",defaultValue = "5")Integer size){


        PaginationDTO pagination=questionService.List(page,size);
        List<String> hots = hotTagCache.getHots();
        model.addAttribute("questions",pagination);
        model.addAttribute("tags",hots);
        return "index";
    }
}
