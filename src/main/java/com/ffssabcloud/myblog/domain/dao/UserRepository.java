package com.ffssabcloud.myblog.domain.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ffssabcloud.myblog.domain.LocalAuth;
import com.ffssabcloud.myblog.domain.OAuth;
import com.ffssabcloud.myblog.domain.User;

@Component
public interface UserRepository {
    public LocalAuth findLocalAuthByUsername(String username);
    public OAuth findOAuthByUsername(String username);
    public User findUserInfoByUsername(String username);
    public void addAUser(User user);
    public void addALocalAuth(LocalAuth localAuth);
    public Integer getCountOfUser();
}
