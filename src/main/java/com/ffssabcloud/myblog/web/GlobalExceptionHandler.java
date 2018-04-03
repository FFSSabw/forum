package com.ffssabcloud.myblog.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ffssabcloud.myblog.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = NotFoundException.class)
    public String notFoundException(Exception e) {
        e.printStackTrace();
        return "comm/error_404";
    }
}
