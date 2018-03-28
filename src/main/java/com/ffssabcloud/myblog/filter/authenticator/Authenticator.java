package com.ffssabcloud.myblog.filter.authenticator;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.ffssabcloud.myblog.domain.auth.User;
import com.ffssabcloud.myblog.domain.auth.UserInfo;


public interface Authenticator {
    public UserInfo authenticate(HttpServletRequest request);
}
