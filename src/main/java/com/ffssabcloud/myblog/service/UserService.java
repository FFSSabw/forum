package com.ffssabcloud.myblog.service;

import com.ffssabcloud.myblog.domain.User;

public interface UserService {
    
    public User getUserByUsername(String username);
    public void createAUser(String username, String password);
    /**
     * 检查username是否存在,存在return true, 不存在 return false
     * @param username
     * @return
     */
    public boolean checkUsername(String username);
}
