package com.ffssabcloud.myblog.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

public abstract class BaseController {
    
    public BaseController setTitle(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }
}
