package com.ffssabcloud.myblog.domain.auth;

import java.io.Serializable;

public class UserInfo implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    User user;
    Auth auth;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Auth getAuth() {
        return auth;
    }
    
    public void setAuth(Auth auth) {
        this.auth = auth;
    }
}
