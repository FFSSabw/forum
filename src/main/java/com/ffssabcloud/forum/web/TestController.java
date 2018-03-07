package com.ffssabcloud.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ffssabcloud.forum.domain.DB1.UserRepository;
import com.ffssabcloud.forum.domain.DB2.PostRepository;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PostRepository postRepository;
    
    @RequestMapping(value = "/")
    @ResponseBody
    public String helloTest() {
        return "wellcom to test";
    }
    
    @RequestMapping(value = "/test_db_config")
    @ResponseBody
    public String testDbConfig() {
        for(int i = 0; i < 10; i++) {
            userRepository.addAUser("User_" + i);
        }
        
        for(int i = 0; i < 10; i++) {
            postRepository.addAPost("Post_" + i);
        }
        
        return "success";
        
    }
}
