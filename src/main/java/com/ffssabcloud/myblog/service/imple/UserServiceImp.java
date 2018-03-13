package com.ffssabcloud.myblog.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Auth;
import com.ffssabcloud.myblog.domain.LocalAuth;
import com.ffssabcloud.myblog.domain.User;
import com.ffssabcloud.myblog.domain.dao.UserRepository;
import com.ffssabcloud.myblog.service.UserService;

@Service
public class UserServiceImp implements UserService {
    
    @Autowired
    UserRepository userRepository;
    
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
        LocalAuth localAuth = new LocalAuth(Constrants.Roles.AUTHED,
                                        username, password);
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

}
