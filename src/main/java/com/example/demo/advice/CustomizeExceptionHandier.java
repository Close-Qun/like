package com.example.demo.advice;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.ResultDTO;
import com.example.demo.exception.CustomizeErrorCode;
import com.example.demo.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 陈亦铖
 */
@ControllerAdvice
public class CustomizeExceptionHandier {
    @ExceptionHandler(Exception.class)
    Object handle(Throwable ex, Model model, HttpServletRequest request, HttpServletResponse response) {
        String contextPath = request.getContextPath();
        if ("application/json".equals(contextPath)){
            ResultDTO resultDTO;
            if (ex instanceof CustomizeException) {
                resultDTO= ResultDTO.errorOf((CustomizeException)ex);
            } else {
                resultDTO= ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
            }

            try {
                response.setContentType("application/JSON");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else {


            if (ex instanceof CustomizeException) {

                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCode.NO_LOGIN.getMessage());
            }


            return new ModelAndView("error");
        }
    }

}
