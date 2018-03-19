package com.ffssabcloud.myblog.web.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.domain.User;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.modal.UserContext;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.UserService;
import com.ffssabcloud.myblog.utils.WebUtils;


@Controller
public class UserController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    WebUtils webUtils;
    
    @GetMapping(value = "/register")
    public String register() {
        return "auth/register";
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
    
    @GetMapping(value = "/login")
    public String login() {
        return "auth/login";
    }
    
    @PostMapping(value = "/login")
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam(required = false) String rememberMe,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        User user = UserContext.getCurrentUser();
              
        try {
            if(user != null) {
                //重定向
                response.sendRedirect("/");
                return RestResponseBo.fail("已登录!");
            }
            user = userService.login(username, password);
            webUtils.setLoginCookie(response, user.getUsername());
        } catch(Exception e) {
            String msg = null;
            if(e instanceof PromptException) {
                msg = e.getMessage();
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok("登录成功!");        
    }
    
    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request,
                        HttpServletResponse response) {
        
        String username = webUtils.getLoginValuesByCookie(request).get(0);
        userService.logout(response, username);
        
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
