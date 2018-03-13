package com.ffssabcloud.myblog.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ffssabcloud.myblog.utils.Commons;

@Component
public class BaseInterceptor implements HandlerInterceptor{
    
    @Resource
    Commons commons;
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object o, ModelAndView modelAndView) throws Exception {
        request.setAttribute("commons", commons);
    }
}
