package com.ffssabcloud.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffssabcloud.myblog.domain.auth.User;
import com.ffssabcloud.myblog.modal.UserContext;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    
    @GetMapping(value = "/login")
    public String loginTest(Model model) {

        User user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        
        return "test/test";
    }
}
