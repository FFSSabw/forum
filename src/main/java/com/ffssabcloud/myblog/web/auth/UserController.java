package com.ffssabcloud.myblog.web.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.UserService;
import com.ffssabcloud.myblog.utils.WebUtils;


@Controller
public class UserController {
    
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
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

        try {
            if(!firstPassword.equals(secondPassword)) {
                return RestResponseBo.fail("密码不一致!");
            }
            if(userService.checkUsername(username)) {
                return RestResponseBo.fail("用户名已存在！");
            }
            
            userService.createAUser(username, firstPassword);
        } catch(Exception e) {
            String msg = null;
            if(e instanceof NullPointerException) {
                msg = "字段不能为空";
            } else {
                msg = "未知错误";
            }
            LOGGER.warn("用户注册失败: " + msg);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok("注册成功!");
    }
    
    @GetMapping(value = "/signin")
    public String signin() {
        return "auth/signin";
    }
    
    @PostMapping(value = "/signin")
    @ResponseBody
    public RestResponseBo doSignin(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam(required = false) String rememberMe,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Constrants.Web.SESSION_USERINFO_NAME);
   
        try {
            if(userInfo != null) {
                //重定向
                response.sendRedirect("/");
                return RestResponseBo.fail("已登录!");
            }
            userInfo = userService.signin(session, username, password);
        } catch(Exception e) {
            String msg = null;
            if(e instanceof PromptException) {
                msg = e.getMessage();
            }
            return RestResponseBo.fail(msg);
        }

        return RestResponseBo.ok("登录成功!");        
    }
    
    @RequestMapping(value = "/signout")
    public void logout(HttpServletRequest request,
                        HttpServletResponse response) {
        
        userService.logout(response);
        
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
