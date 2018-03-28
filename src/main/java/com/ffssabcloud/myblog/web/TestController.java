package com.ffssabcloud.myblog.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffssabcloud.myblog.domain.auth.Localauth;
import com.ffssabcloud.myblog.domain.auth.User;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.modal.UserContext;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    
    @GetMapping(value = "/login")
    public String loginTest(Model model) {

        UserInfo user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        
        return "test/test";
    }
    
    @GetMapping(value = "/session")
    public String sessionTest(HttpSession session, Model model) {
        
        UserInfo u = (UserInfo)session.getAttribute("userInfo");
        if(u == null) {
            UserInfo userInfo = new UserInfo();
            User user = new User();
            user.setUsername("nihao");
            user.setId(1);
            user.setLocation("new york");
            user.setRegisterby("LOCAL");
            Localauth localauth = new Localauth();
            localauth.setId(2);
            localauth.setPassword("123456");
            userInfo.setUser(user);
            userInfo.setAuth(localauth);
            session.setAttribute("userInfo", userInfo);
        }
        model.addAttribute("userInfo", u);

        
        return "test/test";
    }
}
