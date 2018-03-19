package com.ffssabcloud.myblog.domain.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ffssabcloud.myblog.domain.LocalAuth;
import com.ffssabcloud.myblog.domain.OAuth;
import com.ffssabcloud.myblog.domain.User;

@CacheConfig
@Component
public interface UserRepository {
    @Cacheable(value = "L_A")
    public LocalAuth findLocalAuthByUsername(String username);
    public OAuth findOAuthByUsername(String username);
    @Cacheable(value = "U_")
    public User findUserInfoByUsername(String username);
    public void addAUser(User user);
    public void addALocalAuth(LocalAuth localAuth);
    public Integer getCountOfUser();
}
