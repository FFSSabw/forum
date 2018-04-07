package com.ffssabcloud.myblog.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ffssabcloud.myblog.exception.NotFoundException;
import com.ffssabcloud.myblog.exception.PromptException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = NotFoundException.class)
    public String notFoundException(Exception e) {
        e.printStackTrace();
        return "comm/error_404";
    }
    
    @ExceptionHandler(value = PromptException.class)
    public String promptException(Exception e) {
        e.printStackTrace();
        return "comm/error_500";
    }
}
