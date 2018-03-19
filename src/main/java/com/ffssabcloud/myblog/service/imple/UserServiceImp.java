package com.ffssabcloud.myblog.service.imple;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Auth;
import com.ffssabcloud.myblog.domain.LocalAuth;
import com.ffssabcloud.myblog.domain.User;
import com.ffssabcloud.myblog.domain.dao.UserRepository;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.service.UserService;
import com.ffssabcloud.myblog.utils.RedisUtils;
import com.ffssabcloud.myblog.utils.WebUtils;

@Service
public class UserServiceImp implements UserService {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RedisUtils redisUtils;
    
    @Autowired
    WebUtils webUtils;
    
    @Override
    public User getUserByUsername(String username) {
        Auth auth;
        
        User user = userRepository.findUserInfoByUsername(username);
        if(Constrants.Register.LOCAL.equals(user.getRegisterBy())) {
            auth = userRepository.findLocalAuthByUsername(username);
        } else {
            auth = userRepository.findOAuthByUsername(username);
        }
       
        user.setAuth(auth);
        
        return user;
    }

    @Override
    @Transactional
    public void createAUser(String username, String password) {
        User user = new User(username, Constrants.Register.LOCAL);
        String hashed = webUtils.hashWithSalt(password);
        LocalAuth localAuth = new LocalAuth(Constrants.Roles.AUTHED,
                                        username, hashed);
        userRepository.addAUser(user);
        userRepository.addALocalAuth(localAuth);
    }

    @Override
    public boolean checkUsername(String username) {
        if(userRepository.findUserInfoByUsername(username) != null) {
            return true;
        }      
        return false;
    }

    @Override
    public User login(String username, String password) {
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new PromptException("用户名或密码不能为空!");
        }
        User user = getUserByUsername(username);
        
        if(user == null) {
            throw new PromptException("用户名不存在!");
        }
        
        if(!(webUtils.hashVertify(((LocalAuth)user.getAuth()).getPassword(), password))) {
            redisUtils.remove(Constrants.Web.LOCAL_AUTH_CACHE_PREFIX + user.getUsername());
            redisUtils.remove(Constrants.Web.USER_CACHE_PREFIX + user.getUsername());
            throw new PromptException("密码错误!");
        }
              
        return user;
    }

    @Override
    public void logout(HttpServletResponse response, String username) {
        redisUtils.remove(Constrants.Web.LOCAL_AUTH_CACHE_PREFIX + username);
        redisUtils.remove(Constrants.Web.USER_CACHE_PREFIX + username);
        
        webUtils.removeLoginCookie(response);
    }

}
