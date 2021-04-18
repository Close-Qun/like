package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 陈亦铖
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String hello(@RequestParam(name="name")String name, Model model){

        return "index";
    }
}
