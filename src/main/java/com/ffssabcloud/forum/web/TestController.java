package com.ffssabcloud.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ffssabcloud.forum.domain.DB1.UserRepository;
import com.ffssabcloud.forum.domain.DB2.PostRepository;
import com.ffssabcloud.forum.service.TestService;

@Controller
public class TestController {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TestService testService;
    
    @RequestMapping(value = "/")
    @ResponseBody
    public String helloTest() {
        return "wellcom to test";
    }
    
    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("login");
        
        return "login/login";
    }
    
    
}
