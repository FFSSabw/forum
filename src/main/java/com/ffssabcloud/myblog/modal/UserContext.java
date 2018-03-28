package com.ffssabcloud.myblog.modal;

import com.ffssabcloud.myblog.domain.auth.UserInfo;

public class UserContext implements AutoCloseable{
    
    static final ThreadLocal<UserInfo> current = new ThreadLocal<UserInfo>();
    
    public UserContext(UserInfo userInfo) {
        current.set(userInfo);
    }
    
    public static UserInfo getCurrentUser() {
        return current.get();
    }
    
    @Override
    public void close() throws Exception {
        current.remove();       
    }
    
}
