package com.ffssabcloud.myblog.filter.authenticator;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.ffssabcloud.myblog.domain.auth.User;


public interface Authenticator {
    public User authenticate(HttpServletRequest request);
}
