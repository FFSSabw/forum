package com.ffssabcloud.myblog.filter.authenticator;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.auth.User;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.service.UserService;
import com.ffssabcloud.myblog.utils.Commons;
import com.ffssabcloud.myblog.utils.RedisUtils;
import com.ffssabcloud.myblog.utils.WebUtils;

//@Component
public class LocalAuthenticator implements Authenticator{
    
    @Autowired
    UserService userService;
    
    @Autowired
    WebUtils webUtils;
    
    @Override
    public UserInfo authenticate(HttpServletRequest request) {
        ArrayList<String> cookieValues = webUtils.getLoginValuesByCookie(request);
        if(cookieValues == null ) {
            return null;
        }
        
        String username = cookieValues.get(0);
        String timeStamp = cookieValues.get(1);
        String hash = cookieValues.get(2);
        
        if("".equals(username)) {
            return null;
        }
        if(System.currentTimeMillis() > Long.parseLong(timeStamp)) {
            return null;
        }
        if(!webUtils.hashVertify(hash, username)) {
            return null;
        }
        
        return userService.getUserInfoByUsername(username);
    }

}
