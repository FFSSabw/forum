package com.ffssabcloud.myblog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffssabcloud.myblog.web.BaseController;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{
    
    @GetMapping(value = "/")
    public String index() {
        return "admin/index";
    }
    
}
