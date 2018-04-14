package com.ffssabcloud.myblog.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ffssabcloud.myblog.domain.auth.UserInfo;


public interface UserService {
    
    public UserInfo getUserInfoByUsername(String username);
    public void createAUser(String username, String password);
    public UserInfo signin(HttpSession session, String username, String password);
    /**
     * 检查username是否存在,存在return true, 不存在 return false
     * @param username
     * @return
     */
    public boolean checkExist(String username);
    public void logout(HttpServletResponse response);
    public void updatePassword(String username, String oldPassword, String newPassword);
}
