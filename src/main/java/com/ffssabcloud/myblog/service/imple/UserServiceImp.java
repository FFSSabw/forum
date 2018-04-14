package com.ffssabcloud.myblog.service.imple;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.auth.LocalAuth;
import com.ffssabcloud.myblog.domain.auth.LocalAuthExample;
import com.ffssabcloud.myblog.domain.auth.User;
import com.ffssabcloud.myblog.domain.auth.UserExample;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.domain.dao.LocalAuthMapper;
import com.ffssabcloud.myblog.domain.dao.UserMapper;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.service.UserService;
import com.ffssabcloud.myblog.utils.WebUtils;

@Service
public class UserServiceImp implements UserService {
    
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    LocalAuthMapper localauthMapper;
    
    @Override
    public UserInfo getUserInfoByUsername(String username) {
        List<LocalAuth> auth = null;
        
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        
        if(users.isEmpty()) {
            return null;
        }
        User user = users.get(0);
        
        LocalAuthExample localauthExample = new LocalAuthExample();
        
        if(Constrants.Register.LOCAL.equals(user.getRegisterby())) {
            localauthExample.createCriteria().andUsernameEqualTo(username);
            auth = localauthMapper.selectByExample(localauthExample);
        } else {
            //其他登录方式
        }
        
        if(auth.isEmpty()) {
            return null;
        }
        
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfo.setAuth(auth.get(0));
        
        return userInfo;
    }

    @Override
    @Transactional
    public void createAUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setRegisterby(Constrants.Register.LOCAL);
        
        String hashed = WebUtils.hashWithSalt(password);
        LocalAuth localauth = new LocalAuth();
        localauth.setRoleid(Constrants.Roles.AUTHED);
        localauth.setUsername(username);
        localauth.setPassword(hashed);
        
        userMapper.insert(user);
        localauthMapper.insert(localauth);
    }

    @Override
    public boolean checkExist(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        
        if(userMapper.selectByExample(userExample).isEmpty()) {
            return false;
        }      
        return true;
    }

    @Override
    public UserInfo signin(HttpSession session, String username, String password) {
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new PromptException("用户名或密码不能为空!");
        }
        UserInfo userInfo = getUserInfoByUsername(username);
        
        if(userInfo == null) {
            throw new PromptException("用户名不存在!");
        }
        
        if(!(WebUtils.hashVertify(((LocalAuth)userInfo.getAuth()).getPassword(), password))) {
            throw new PromptException("密码错误!");
        }
        
        session.setAttribute(Constrants.Web.SESSION_USERINFO_NAME, userInfo);
        
        return userInfo;
    }

    @Override
    public void logout(HttpServletResponse response) {       
        WebUtils.removeLoginCookie(response);
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) {
        LocalAuthExample example = new LocalAuthExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<LocalAuth> users = localauthMapper.selectByExample(example);
        
    }

}
