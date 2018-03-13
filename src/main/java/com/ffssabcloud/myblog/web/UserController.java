package com.ffssabcloud.myblog.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.User;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.UserService;


@Controller
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }
    
    @PostMapping(value = "/register")
    @ResponseBody
    public RestResponseBo doRegister(@RequestParam String username,
                                @RequestParam String firstPassword,
                                @RequestParam String secondPassword,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        String msg;

        try {
            if(!firstPassword.equals(secondPassword)) {
                return RestResponseBo.fail("密码不一致!");
            }
            if(userService.checkUsername(username)) {
                return RestResponseBo.fail("用户名已存在！");
            }
            
            userService.createAUser(username, firstPassword);
        } catch(Exception e) {
            e.printStackTrace();
            if(e instanceof NullPointerException) {
                msg = "字段不能为空";
            } else {
                msg = "未知错误";
            }
            
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok("注册成功!");
    }
}
